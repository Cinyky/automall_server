package personal.cyy.automall.model.tmp;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author Cinyky
 * @Date 15:04 2019-05-15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResult {
    /**
     * 错误码
     */
    private int code;

    /**
     * 内容
     */
    private String content;

    /**
     * 链接
     */
    private String url;

    public static JSONResult build(int code, String content, String url) {
        return new JSONResult(code, content, url);
    }

    public String toJson() {
        return JSON.toJSONString(this);
    }

}
