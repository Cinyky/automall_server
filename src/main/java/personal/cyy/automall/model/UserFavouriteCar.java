package personal.cyy.automall.model;

import lombok.Data;

/**
 * 用户收藏
 * @Author Cinyky
 * @Date 16:42 2019-05-10
 */

@Data
public class UserFavouriteCar {

    /**
     * 收藏ID
     */
    private String uuid;

    /**
     * userID
     */
    private String userId;

    /**
     * carID
     */
    private String carId;

}
