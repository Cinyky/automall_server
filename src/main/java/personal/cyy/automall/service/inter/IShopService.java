package personal.cyy.automall.service.inter;

import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.model.Shop;

import java.util.Collection;

/**
 * 商家服务类
 *
 * @Author Cinyky
 * @Date 14:53 2019-07-13
 */
public interface IShopService {

    /**
     * 增加新商店
     *
     * @param shop
     */
    CommonResult addNewShop(Shop shop);

    /**
     * 根据 shopId 获取对应的商品
     *
     * @param shopId
     */
    Shop getShopById(String shopId);

    /**
     * 获取所有的商店
     *
     * @return
     */
    Collection<Shop> getAllShops();

    /**
     * 根据 shopId 删除
     *
     * @param shopId
     */
    void deleteShopById(String shopId);

    /**
     * 更新
     *
     * @param shop
     */
    void update(Shop shop);

}
