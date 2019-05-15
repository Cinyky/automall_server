package personal.cyy.automall.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


/**
 * 商品 api
 *
 * @Author Cinyky
 * @Date 10:57 2019-05-10
 */

@Controller
@RequestMapping("/api/goods")
public class GoodsApi extends IApi {

    /**
     * test api
     *
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public JSONObject goodsList() throws Exception {
        JSONObject obj = new JSONObject();
        obj.put("msg", "HelloWorld");
        return obj;
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
