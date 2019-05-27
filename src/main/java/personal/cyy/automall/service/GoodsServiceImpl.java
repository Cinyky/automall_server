package personal.cyy.automall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.cyy.automall.jpa.CarJPA;
import personal.cyy.automall.model.Car;
import personal.cyy.automall.model.tmp.JSONResult;
import personal.cyy.automall.service.inter.IGoodsService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 商品服务管理类
 * 单例
 */

@Service
public class GoodsServiceImpl implements IGoodsService {

    @Autowired
    private CarJPA carJPA;

    private Map<String, Car> id2CarMap;


    private GoodsServiceImpl() {

    }

    private void checkNull() {
        if (id2CarMap == null) {
            id2CarMap = new ConcurrentHashMap<>();
        }
    }

    private void putIntoCache(Car car) {
        checkNull();
        id2CarMap.put(car.getId(), car);
    }

    private Car getFromCache(String carId) {
        checkNull();
        if (id2CarMap.containsKey(carId)) {
            return id2CarMap.get(carId);
        }
        return null;
    }


    /**
     * 增加新商品
     *
     * @param car
     */
    @Override
    public JSONResult addNewCar(Car car) {
        JSONResult jsonResult = null;
        if (car == null) {
            return jsonResult;
        }
        carJPA.save(car);
        return JSONResult.build(200, "添加成功", car.getId());
    }

    @Override
    public Car getGoodsById(String carId) {
        Car car = getFromCache(carId);
        if (car == null) {
            Optional<Car> carOptional = carJPA.findById(carId);
            if (carOptional.isPresent()) {
                car = carOptional.get();
                putIntoCache(car);
            }
        }
        return car;

    }

    @Override
    public List<Car> getAllGoods() {
        List<Car> allCars = carJPA.findAll();
        allCars.stream().forEach(
                car -> {
                    putIntoCache(car);
                }
        );

        return allCars;
    }
}
