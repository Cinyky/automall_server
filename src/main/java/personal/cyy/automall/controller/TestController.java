package personal.cyy.automall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import personal.cyy.automall.constant.TemplateNameConstant;

/**
 * @Author Cinyky
 * @Date 11:53 2019-05-15
 */

@Controller
public class TestController extends IController {


    @RequestMapping("/test")
    public String template(Model model) {
        return TemplateNameConstant.TEST;
    }

}
