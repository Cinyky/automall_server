package personal.cyy.automall.service.inter;

import org.springframework.stereotype.Service;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.model.Car;

import java.util.Collection;

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
    CommonResult addNewCar(Car car);

    /**
     * 根据goodsId 获取对应的商品
     *
     * @param goodsId
     */
    Car getGoodsById(String goodsId);

    /**
     * @return
     */
    Collection<Car> getAllGoods();

    /**
     * 删除
     *
     * @param goodsId
     */
    void deleteGoods(String goodsId);
}
