package personal.cyy.automall.model;

import lombok.Data;

/**
 * 用户收藏
 *
 * @Author Cinyky
 * @Date 16:42 2019-05-10
 */

@Data
public class UserFavouriteCar extends AbstractModel {

    /**
     * 收藏ID
     */
    private String id;

    /**
     * userID
     */
    private String userId;

    /**
     * carID
     */
    private String carId;

}
