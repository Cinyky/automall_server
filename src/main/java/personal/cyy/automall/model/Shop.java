package personal.cyy.automall.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * 商家信息
 *
 * @Author Cinyky
 * @Date 14:36 2019-07-13
 */

@Entity
@Table(name = "shop")
@Data
public class Shop extends AbstractModel implements Serializable {

    /**
     * 商家ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 商家名称
     */
    @Column(name = "name")
    private String name;

    /**
     * 商家描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 电话
     */
    @Column(name = "tel")
    private String tel;

    /**
     * 微信
     */
    @Column(name = "wechat")
    private String wechat;

    /**
     * 商家广告图
     */
    @Column(name = "banner")
    private String banner;

    /**
     * 商家地理位置
     */
    @Column(name = "location")
    private String location;

    /**
     * 商家地理位置 经度
     */
    @Column(name = "longitude")
    private String longitude;

    /**
     * 商家地理位置 纬度
     */
    @Column(name = "latitude")
    private String latitude;


}
