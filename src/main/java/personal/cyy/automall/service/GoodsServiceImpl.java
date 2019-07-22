package personal.cyy.automall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.jpa.CarJPA;
import personal.cyy.automall.model.Car;
import personal.cyy.automall.service.inter.ICacheService;
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
public class GoodsServiceImpl implements IService, IGoodsService, ICacheService<Car> {

    @Autowired
    private CarJPA carJPA;

    private Map<String, Car> id2CarMap;


    private GoodsServiceImpl() {

    }

    @Override
    public void init() {
        id2CarMap = new ConcurrentHashMap<>();
        List<Car> allCars = carJPA.findAll();
        allCars.stream().forEach(
                car -> {
                    putIntoCache(car);
                }
        );
    }

    @Override
    public Car putIntoCache(Car car) {
        id2CarMap.put(car.getId(), car);
        return car;
    }

    @Override
    public Car getFromCache(String id) {
        if (id2CarMap.containsKey(id)) {
            return id2CarMap.get(id);
        }
        return null;
    }

    @Override
    public Car removeFromCache(String id) {
        if (id2CarMap.containsKey(id)) {
            return id2CarMap.remove(id);
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
            removeFromCache(goodsId);
        }

    }

    /**
     * 更新
     *
     * @param car
     */
    @Override
    public void update(Car car) {

    }


}
