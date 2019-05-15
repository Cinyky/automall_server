package personal.cyy.automall.model;

import lombok.Data;

/**
 * 汽车配置或者亮点
 *
 * @Author Cinyky
 * @Date 17:38 2019-05-10
 */
@Data
public class CarConfiguration {
    /**
     * 商品ID
     */
    private String id;

    /**
     * 汽车ID
     */
    private String carId;

    /**
     * 信息
     */
    private String info;
}
