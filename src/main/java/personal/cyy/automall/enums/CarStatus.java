package personal.cyy.automall.enums;

/**
 * 商品状态
 */
public enum CarStatus {
    /**
     * 不展示
     */
    INIT(1),
    /**
     * 在售
     */
    ONSELL(3),
    /**
     * 已售
     */
    SOLD(4),

    ;
    private int value;

    CarStatus(int value) {
        this.value = value;
    }

    /**
     * 获取对应的数据
     *
     * @param value
     * @return
     */
    public static CarStatus getByValue(int value) {
        for (CarStatus carStatus : CarStatus.values()) {
            if (value == carStatus.getValue()) {
                return carStatus;
            }
        }
        return null;
    }

    public int getValue() {
        return value;
    }
}
