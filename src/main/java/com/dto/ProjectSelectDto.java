package com.dto;

import java.util.Date;



public class ProjectSelectDto  {

	// Fields

	// private ProjectSelectId id;
	private String studentNo;
	private String projectNo;
	private String selReason;
	private Date companySelDate;
	private String score;
	private String companyName;

	// Constructors

	/** default constructor */
	public ProjectSelectDto() {
	}

	

	public String getStudentNo() {
		return studentNo;
	}

	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}

	public String getProjectNo() {
		return projectNo;
	}

	public void setProjectNo(String projectNo) {
		this.projectNo = projectNo;
	}

	

	public String getSelReason() {
		return this.selReason;
	}

	public void setSelReason(String selReason) {
		this.selReason = selReason;
	}

	public Date getCompanySelDate() {
		return this.companySelDate;
	}

	public void setCompanySelDate(Date companySelDate) {
		this.companySelDate = companySelDate;
	}

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}