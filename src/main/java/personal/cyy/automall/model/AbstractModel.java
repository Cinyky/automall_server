package personal.cyy.automall.model;

import com.alibaba.fastjson.JSON;

/**
 * @Author Cinyky
 * @Date 17:27 2019-05-16
 */


public class AbstractModel {

    public String toJson() {
        return JSON.toJSONString(this);
    }
}
