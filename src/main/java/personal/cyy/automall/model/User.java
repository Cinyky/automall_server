package personal.cyy.automall.model;

import lombok.Data;


/**
 * @Author Cinyky
 * @Date 14:52 2019-05-10
 */

@Data
public class User {
    /**
     * 商品ID
     */
    private String uuid;

    /**
     * 微信的ID
     */
    private String wxId;

}
