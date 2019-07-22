package personal.cyy.automall.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.cyy.automall.common.CommonResult;
import personal.cyy.automall.jpa.ShopJPA;
import personal.cyy.automall.model.Shop;
import personal.cyy.automall.service.inter.ICacheService;
import personal.cyy.automall.service.inter.IService;
import personal.cyy.automall.service.inter.IShopService;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 商家服务
 *
 * @Author Cinyky
 * @Date 15:20 2019-07-13
 */

@Service
public class ShopServiceImpl implements IService, IShopService, ICacheService<Shop> {

    @Autowired
    private ShopJPA shopJPA;

    private Map<String, Shop> id2ShopMap;


    @Override
    public void init() {
        id2ShopMap = new ConcurrentHashMap<>();
        List<Shop> allShops = shopJPA.findAll();
        allShops.stream().forEach(
                car -> {
                    putIntoCache(car);
                }
        );
    }

    @Override
    public Shop putIntoCache(Shop car) {
        id2ShopMap.put(car.getId(), car);
        return car;
    }

    @Override
    public Shop getFromCache(String id) {
        if (id2ShopMap.containsKey(id)) {
            return id2ShopMap.get(id);
        }
        return null;
    }

    @Override
    public Shop removeFromCache(String id) {
        if (id2ShopMap.containsKey(id)) {
            return id2ShopMap.remove(id);
        }
        return null;
    }

    /**
     * 增加新商店
     *
     * @param shop
     */
    @Override
    public CommonResult addNewShop(Shop shop) {
        return null;
    }

    /**
     * 根据 shopId 获取对应的商品
     *
     * @param shopId
     */
    @Override
    public Shop getShopById(String shopId) {
        Shop shop = getFromCache(shopId);
        if (shop != null) {
            return shop;
        }
        Optional<Shop> shopOptional = shopJPA.findById(shopId);
        if (shopOptional.isPresent()) {
            shop = shopOptional.get();
            putIntoCache(shop);
            return shop;
        }
        return null;
    }

    /**
     * 获取所有的商店
     *
     * @return
     */
    @Override
    public Collection<Shop> getAllShops() {
        if (id2ShopMap == null || id2ShopMap.isEmpty()) {
            this.init();
        }
        return id2ShopMap.values();
    }

    /**
     * 根据 shopId 删除
     *
     * @param shopId
     */
    @Override
    public void deleteShopById(String shopId) {
        Shop shop = getShopById(shopId);
        if (shop != null) {
            shopJPA.deleteById(shopId);
            removeFromCache(shopId);
        }
    }

    /**
     * 更新
     *
     * @param shop
     */
    @Override
    public void update(Shop shop) {

    }
}
