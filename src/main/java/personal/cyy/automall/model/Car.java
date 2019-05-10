package personal.cyy.automall.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 商品列表
 * @Author Cinyky
 * @Date 13:39 2019-05-10
 */

@Data
public class Car implements Serializable {

    /**
     * 商品ID
     */
    private String uuid;

    /**
     * 商品名称
     */
    private int title;

    /**
     * 商品描述
     */
    private int description;

    /**
     * 品牌 宝马
     */
    private String band;

    /**
     * 型号 系列
     */
    private String mark;

    /**
     * 上牌时间
     */
    private Long regTime;

    /**
     * 过户次数
     */
    private int transferNum;

    /**
     * 汽车排量
     */
    private float outputVolume;

    /**
     * 汽车排放标准
     */
    private float outputStandard;
    /**
     * 行驶里程
     */
    private int distance;

    /**
     * 车身颜色
     */
    private String color;

    /**
     * 价格
     */
    private int price;

    /**
     * 手动自动
     */
    private int model;

    /**
     * 状态
     */
    private int status;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 更新时间
     */
    private long updateTime;





}
