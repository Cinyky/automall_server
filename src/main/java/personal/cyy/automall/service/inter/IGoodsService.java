package personal.cyy.automall.service.inter;

import org.springframework.stereotype.Service;
import personal.cyy.automall.model.Car;
import personal.cyy.automall.model.tmp.JSONResult;

import java.util.List;

/**
 * @Author Cinyky
 * @Date 17:41 2019-05-16
 */

@Service
public interface IGoodsService {

    /**
     * 增加新商品
     *
     * @param car
     */
    JSONResult addNewCar(Car car);

    /**
     * 根据goodsId 获取对应的商品
     *
     * @param goodsId
     */
    Car getGoodsById(String goodsId);

    /**
     * @return
     */
    List<Car> getAllGoods();
}
