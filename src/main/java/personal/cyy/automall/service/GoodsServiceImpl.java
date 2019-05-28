package personal.cyy.automall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.jpa.CarJPA;
import personal.cyy.automall.model.Car;
import personal.cyy.automall.service.inter.IGoodsService;
import personal.cyy.automall.service.inter.IService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 商品服务管理类
 * 单例
 */

@Service
public class GoodsServiceImpl implements IGoodsService, IService {

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
    public CommonResult addNewCar(Car car) {
        CommonResult commonResult = null;
        if (car == null) {
            return commonResult;
        }
        carJPA.save(car);
        putIntoCache(car);
        return CommonResult.success(car.getId(), "添加成功");
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
    public Collection<Car> getAllGoods() {
        return id2CarMap.values();
    }

    /**
     * 删除
     *
     * @param goodsId
     */
    @Override
    public void deleteGoods(String goodsId) {
        Car car = getGoodsById(goodsId);
        if (car != null) {
            carJPA.deleteById(goodsId);
        }
    }

    @Override
    public void init() {
        List<Car> allCars = carJPA.findAll();
        allCars.stream().forEach(
                car -> {
                    putIntoCache(car);
                }
        );
    }
}
