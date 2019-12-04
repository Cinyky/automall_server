package personal.cyy.automall.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import personal.cyy.automall.model.Car;
import personal.cyy.automall.service.GoodsServiceImpl;

import java.util.Collection;


/**
 * 商品 api
 *
 * @Author Cinyky
 * @Date 10:57 2019-05-10
 */

@Controller
@RequestMapping("/api/goods")
@CrossOrigin
public class GoodsApi extends IApi {
    @Autowired
    GoodsServiceImpl goodsService;


    /**
     * 获取所有的商品
     * @return
     */
    @GetMapping(value = "/list")
    @ResponseBody
    public Collection<Car> getGoodsList() {
        Collection<Car> allGoods = goodsService.getAllGoods();
        return allGoods;
    }

    @GetMapping(value = "/detail/{goodsId}")
    @ResponseBody
    public Car getSuchGoods(@PathVariable("goodsId") String goodsId) {
        Car car = goodsService.getGoodsById(goodsId);
        return car;
    }




    @PostMapping(value = "/add")
    public JSONObject goodsAdd(@RequestParam(value = "images") MultipartFile[] images
            , @RequestParam(value = "images") String name
    ) throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("msg", "HelloWorld");
        return obj;
    }


}
