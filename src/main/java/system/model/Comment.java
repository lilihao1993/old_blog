package system.model;

import java.util.Date;

public class Comment {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_comment.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_comment.BC_USER_ID
     *
     * @mbggenerated
     */
    private String userId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_comment.BC_ABEL_ID
     *
     * @mbggenerated
     */
    private String abelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_comment.BC_CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_comment.BC_OPERATE_TIME
     *
     * @mbggenerated
     */
    private Date operateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_comment.ID
     *
     * @return the value of blog_comment.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_comment.ID
     *
     * @param id the value for blog_comment.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_comment.BC_USER_ID
     *
     * @return the value of blog_comment.BC_USER_ID
     *
     * @mbggenerated
     */
    public String getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_comment.BC_USER_ID
     *
     * @param userId the value for blog_comment.BC_USER_ID
     *
     * @mbggenerated
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_comment.BC_ABEL_ID
     *
     * @return the value of blog_comment.BC_ABEL_ID
     *
     * @mbggenerated
     */
    public String getAbelId() {
        return abelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_comment.BC_ABEL_ID
     *
     * @param abelId the value for blog_comment.BC_ABEL_ID
     *
     * @mbggenerated
     */
    public void setAbelId(String abelId) {
        this.abelId = abelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_comment.BC_CREATE_TIME
     *
     * @return the value of blog_comment.BC_CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_comment.BC_CREATE_TIME
     *
     * @param createTime the value for blog_comment.BC_CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_comment.BC_OPERATE_TIME
     *
     * @return the value of blog_comment.BC_OPERATE_TIME
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_comment.BC_OPERATE_TIME
     *
     * @param operateTime the value for blog_comment.BC_OPERATE_TIME
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}