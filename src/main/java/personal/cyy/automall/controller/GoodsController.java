package personal.cyy.automall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 商品模块
 *
 * @Author Cinyky
 * @Date 11:53 2019-05-15
 */

@Controller
public class GoodsController extends IController {


    @RequestMapping("/goods/goods_add")
    public String template(Model model) {
        return "/goods/goods_add";
    }


    @RequestMapping("/goods/goods_list")
    public String goodsList(Model model) {
        return "/goods/goods_list";
    }


}
