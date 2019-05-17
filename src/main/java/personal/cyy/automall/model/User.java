package personal.cyy.automall.model;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @Author Cinyky
 * @Date 14:52 2019-05-10
 */

@Data
@AllArgsConstructor
public class User extends AbstractModel {
    /**
     * 商品ID
     */
    private String id;

    /**
     * 微信的ID
     */
    private String wxId;

    /**
     * 角色 管理员之类
     */
    private int role;


}
