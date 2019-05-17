package personal.cyy.automall.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * 存储车图片
 *
 * @Author Cinyky
 * @Date 16:41 2019-05-10
 */

@Entity
@Table(name = "car_image")
@Data
public class CarImage extends AbstractModel {

    /**
     * 图片ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 汽车ID
     */
    @Column(name = "car_id")
    private String carId;

    /**
     * 存储在mongo中的文件名
     */
    @Column(name = "image_id")
    private String imageId;


}
