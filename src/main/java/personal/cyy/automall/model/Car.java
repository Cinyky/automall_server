package personal.cyy.automall.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * 商品列表
 *
 * @Author Cinyky
 * @Date 13:39 2019-05-10
 */

@Entity
@Table(name = "car")
@Data
public class Car extends AbstractModel implements Serializable {

    /**
     * 商品ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 商品名称
     */
    @Column(name = "title")
    private String title;

    /**
     * 商品描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 品牌 宝马
     */
    @Column(name = "band")
    private String band;

    /**
     * 型号 系列
     */
    @Column(name = "mark")
    private String mark;

    /**
     * 配置
     */
    @Column(name = "config")
    private String config;

    /**
     * 上牌时间
     */
    @Column(name = "reg_time")
    private String regTime;

    /**
     * 保险时间
     */
    @Column(name = "insurance_time")
    private String insuranceTime;

    /**
     * 验车时间
     */
    @Column(name = "check_time")
    private String checkTime;

    /**
     * 过户次数
     */
    @Column(name = "transfer_num")
    private int transferNum;

    /**
     * 汽车排量
     */
    @Column(name = "output_volume")
    private float outputVolume;

    /**
     * 行驶里程
     */
    @Column(name = "distance")
    private int distance;

    /**
     * 价格
     */
    @Column(name = "price")
    private float price;

    /**
     * 汽车排放标准
     */
    @Column(name = "output_standard")
    private String outputStandard;


    /**
     * 车身颜色
     */
    @Column(name = "color")
    private String color;


    /**
     * 手动自动
     */
    @Column(name = "model")
    private int model;

    /**
     * 状态
     */
    @Column(name = "status")
    private int status;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private long createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private long updateTime;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    private List<CarImage> carImages;


}
