package com.dto;

import java.util.Date;



public class NoticeAdminDto  {

	// Fields
	private String title;
	private Integer id;
	private Date releaseDate;
	private String content;

	// Constructors

	/** default constructor */
	public NoticeAdminDto() {
	}

	/** full constructor */
	public NoticeAdminDto(Date releaseDate, String content) {
		this.releaseDate = releaseDate;
		this.content = content;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date date) {
		this.releaseDate = date;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
}