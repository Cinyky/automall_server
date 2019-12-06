package personal.cyy.automall.constant;

/**
 * cyy
 */
public enum ExcludeUri {

    /**
     * 登录
     */
    LOGIN(SessionCheckType.EQUAL.getValue(), "/user/login"),
    /**
     * 登录
     */
    LOGIN_VIEW(SessionCheckType.EQUAL.getValue(), "/user/login_view"),
    /**
     * 应用管理监控
     */
    ACTUATOR(SessionCheckType.CONTAIN.getValue(), "/actuator"),
    /**
     * druid 连接池
     */
    DRUID(SessionCheckType.CONTAIN.getValue(), "/druid"),
    /**
     * 网页资源目录
     */
    WEB_RESOURCES(SessionCheckType.CONTAIN.getValue(), "/web/resources");


    private int type;
    private String value;

    ExcludeUri(int type, String value) {
        this.type = type;
        this.value = value;
    }

    public static ExcludeUri[] getAll() {
        return values();
    }

    public int getType() {
        return type;
    }

    public String getValue() {
        return value;
    }
}
