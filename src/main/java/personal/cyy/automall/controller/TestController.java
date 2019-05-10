package personal.cyy.automall.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * 测试controller
 * @Author Cinyky
 * @Date 10:57 2019-05-10
 */

@Controller
public class TestController {

    /**
     * test api
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    @ResponseBody
    public JSONObject login() throws Exception
    {
        JSONObject obj = new JSONObject();
        obj.put("msg","HelloWorld");
        return obj;
    }
}
