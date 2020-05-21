package com.dto;

import java.util.Date;



public class ProjectDto  {

	// Fields

	private String no;
	private String name;
	private String introduction;
	private Integer studentsNum;
	private String companyUsername;
	private String companyTeacher;
	private String companyTeacherTitle;
	private Date releaseDate;
	private Date auditDate;
	private Date endDate;
	private String summary;
	private Integer grade;
	private String category;
	private String major;

	

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public Integer getStudentsNum() {
		return this.studentsNum;
	}

	public void setStudentsNum(Integer studentsNum) {
		this.studentsNum = studentsNum;
	}

	public String getCompanyUsername() {
		return this.companyUsername;
	}

	public void setCompanyUsername(String companyUsername) {
		this.companyUsername = companyUsername;
	}

	public String getCompanyTeacher() {
		return this.companyTeacher;
	}

	public void setCompanyTeacher(String companyTeacher) {
		this.companyTeacher = companyTeacher;
	}

	public String getCompanyTeacherTitle() {
		return this.companyTeacherTitle;
	}

	public void setCompanyTeacherTitle(String companyTeacherTitle) {
		this.companyTeacherTitle = companyTeacherTitle;
	}

	public Date getReleaseDate() {
		return this.releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getAuditDate() {
		return this.auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public Date getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getSummary() {
		return this.summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Integer getGrade() {
		return this.grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

}