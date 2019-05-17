package personal.cyy.automall.model.tmp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import personal.cyy.automall.model.AbstractModel;

/**
 * 结果返回
 *
 * @Author Cinyky
 * @Date 15:04 2019-05-15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JSONResult extends AbstractModel {
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


}
