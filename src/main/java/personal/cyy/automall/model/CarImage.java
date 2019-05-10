package personal.cyy.automall.model;

import lombok.Data;


/**
 * 存储车图片
 * @Author Cinyky
 * @Date 16:41 2019-05-10
 */

@Data
public class CarImage {

    /**
     * 图片ID
     */
    private String uuid;


    /**
     * 汽车ID
     */
    private String carId;

    /**
     * 图片
     */
    private String image;


}
