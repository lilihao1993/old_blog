package system.model;

import java.util.Date;

public class Article {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.ID
     *
     * @mbggenerated
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_LABEL_ID
     *
     * @mbggenerated
     */
    private String labelId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_TITLE
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_SUMMARY
     *
     * @mbggenerated
     */
    private String summary;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_CONTENT
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_HOT
     *
     * @mbggenerated
     */
    private String hot;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column blog_article.BA_OPERATE_TIME
     *
     * @mbggenerated
     */
    private Date operateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.ID
     *
     * @return the value of blog_article.ID
     *
     * @mbggenerated
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.ID
     *
     * @param id the value for blog_article.ID
     *
     * @mbggenerated
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_LABEL_ID
     *
     * @return the value of blog_article.BA_LABEL_ID
     *
     * @mbggenerated
     */
    public String getLabelId() {
        return labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_LABEL_ID
     *
     * @param labelId the value for blog_article.BA_LABEL_ID
     *
     * @mbggenerated
     */
    public void setLabelId(String labelId) {
        this.labelId = labelId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_TITLE
     *
     * @return the value of blog_article.BA_TITLE
     *
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_TITLE
     *
     * @param title the value for blog_article.BA_TITLE
     *
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_SUMMARY
     *
     * @return the value of blog_article.BA_SUMMARY
     *
     * @mbggenerated
     */
    public String getSummary() {
        return summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_SUMMARY
     *
     * @param summary the value for blog_article.BA_SUMMARY
     *
     * @mbggenerated
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_CONTENT
     *
     * @return the value of blog_article.BA_CONTENT
     *
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_CONTENT
     *
     * @param content the value for blog_article.BA_CONTENT
     *
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_HOT
     *
     * @return the value of blog_article.BA_HOT
     *
     * @mbggenerated
     */
    public String getHot() {
        return hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_HOT
     *
     * @param hot the value for blog_article.BA_HOT
     *
     * @mbggenerated
     */
    public void setHot(String hot) {
        this.hot = hot;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_CREATE_TIME
     *
     * @return the value of blog_article.BA_CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_CREATE_TIME
     *
     * @param createTime the value for blog_article.BA_CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column blog_article.BA_OPERATE_TIME
     *
     * @return the value of blog_article.BA_OPERATE_TIME
     *
     * @mbggenerated
     */
    public Date getOperateTime() {
        return operateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column blog_article.BA_OPERATE_TIME
     *
     * @param operateTime the value for blog_article.BA_OPERATE_TIME
     *
     * @mbggenerated
     */
    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }
}