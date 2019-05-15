package personal.cyy.automall.enums;

/**
 * 角色type
 */
public enum Role {
    /**
     * 正常用户
     */
    NORMAL(1),

    /**
     * 管理员
     */
    ADMIN(2),
    ;

    private int value;

    Role(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Role getByValue(int value) {
        for (Role role : Role.values()) {
            if (value == role.getValue()) {
                return role;
            }
        }
        return null;
    }

}
