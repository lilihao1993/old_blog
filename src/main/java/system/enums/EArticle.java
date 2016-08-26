package system.enums;

/**
 * 描述：文章枚举类
 */
public enum EArticle {


    /**
     * 文章类型
     */
    Article_Type_Other("other", "综合"),
    Article_Type_Url("url", "技术连接"),
    Article_Type_Database("database", "数据库开发"),
    Article_Type_Wechat("wechat", "微信开发"),
    Article_Type_Language("language", "编程语言"),
    Article_Type_Web("web", "web前端"),
    Article_Type_Move("move", "移动开发");

    private String value;

    private String desc;

    EArticle(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    /**
     * 描述：获取枚举的描述信息
     *
     * @param value
     * @return
     */
    public static String getDesc(String value) {
        EArticle[] values = EArticle.values();
        for (EArticle e : values) {
            if (e.getValue().equals(value)) {
                return e.getDesc();
            }
        }
        return "未知";
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
