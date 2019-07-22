package personal.cyy.automall.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import personal.cyy.automall.model.Shop;
import personal.cyy.automall.service.ShopServiceImpl;

import java.util.Collection;

/**
 * 商家 api
 *
 * @Author Cinyky
 * @Date 15:36 2019-07-13
 */
@Controller
@RequestMapping("/api/shop")
public class ShopApi extends IApi {

    @Autowired
    ShopServiceImpl shopService;

    /**
     * 获取所有的商家
     *
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public String getGoodsList() {
        Collection<Shop> shops = shopService.getAllShops();
        return JSONObject.toJSONString(shops);
    }


}
