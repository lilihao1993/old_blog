package system.model;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Label {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.BL_NAME
     *
     * @mbggenerated
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.BL_CREATE_TIME
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_label.BL_OPERATE_TIME
     *
     * @mbggenerated
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date operateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.ID
     *
     * @return the value of blog_label.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.ID
     *
     * @param id the value for blog_label.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.BL_NAME
     *
     * @return the value of blog_label.BL_NAME
     *
     * @mbggenerated
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.BL_NAME
     *
     * @param name the value for blog_label.BL_NAME
     *
     * @mbggenerated
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.BL_CREATE_TIME
     *
     * @return the value of blog_label.BL_CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.BL_CREATE_TIME
     *
     * @param createTime the value for blog_label.BL_CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_label.BL_OPERATE_TIME
     *
     * @return the value of blog_label.BL_OPERATE_TIME
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_label.BL_OPERATE_TIME
     *
     * @param operateTime the value for blog_label.BL_OPERATE_TIME
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}