package com.entity;

import java.util.Date;

public class NoticeAdmin {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice_admin.ID
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    private Integer ID;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice_admin.release_date
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    private Date release_date;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice_admin.title
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice_admin.content
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice_admin.ID
     *
     * @return the value of notice_admin.ID
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public Integer getID() {
        return ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice_admin.ID
     *
     * @param ID the value for notice_admin.ID
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setID(Integer ID) {
        this.ID = ID;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice_admin.release_date
     *
     * @return the value of notice_admin.release_date
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public Date getRelease_date() {
        return release_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice_admin.release_date
     *
     * @param release_date the value for notice_admin.release_date
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice_admin.title
     *
     * @return the value of notice_admin.title
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice_admin.title
     *
     * @param title the value for notice_admin.title
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice_admin.content
     *
     * @return the value of notice_admin.content
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice_admin.content
     *
     * @param content the value for notice_admin.content
     *
     * @mbg.generated Tue Sep 10 16:29:23 CST 2019
     */
    public void setContent(String content) {
        this.content = content;
    }
}