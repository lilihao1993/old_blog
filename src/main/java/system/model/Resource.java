package system.model;

public class Resource {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_resource.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_resource.BR_NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_resource.BR_URL
     *
     * @mbggenerated
     */
    private String url;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_resource.BR_STATUS
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_resource.BR_LEVEL
     *
     * @mbggenerated
     */
    private String level;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_resource.BR_PARENT_ID
     *
     * @mbggenerated
     */
    private String parentId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_resource.ID
     *
     * @return the value of blog_resource.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_resource.ID
     *
     * @param id the value for blog_resource.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_resource.BR_NAME
     *
     * @return the value of blog_resource.BR_NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_resource.BR_NAME
     *
     * @param name the value for blog_resource.BR_NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_resource.BR_URL
     *
     * @return the value of blog_resource.BR_URL
     *
     * @mbggenerated
     */
    public String getUrl() {
        return url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_resource.BR_URL
     *
     * @param url the value for blog_resource.BR_URL
     *
     * @mbggenerated
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_resource.BR_STATUS
     *
     * @return the value of blog_resource.BR_STATUS
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_resource.BR_STATUS
     *
     * @param status the value for blog_resource.BR_STATUS
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_resource.BR_LEVEL
     *
     * @return the value of blog_resource.BR_LEVEL
     *
     * @mbggenerated
     */
    public String getLevel() {
        return level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_resource.BR_LEVEL
     *
     * @param level the value for blog_resource.BR_LEVEL
     *
     * @mbggenerated
     */
    public void setLevel(String level) {
        this.level = level;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_resource.BR_PARENT_ID
     *
     * @return the value of blog_resource.BR_PARENT_ID
     *
     * @mbggenerated
     */
    public String getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_resource.BR_PARENT_ID
     *
     * @param parentId the value for blog_resource.BR_PARENT_ID
     *
     * @mbggenerated
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", status='" + status + '\'' +
                ", level='" + level + '\'' +
                ", parentId='" + parentId + '\'' +
                '}';
    }
}