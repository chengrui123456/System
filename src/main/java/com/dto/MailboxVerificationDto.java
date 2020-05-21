package com.dto;



public class MailboxVerificationDto  {

	

	private String mailbox;
	private Integer type;
	private String verificationCode;

	
	public MailboxVerificationDto() {
	}

	/** full constructor */
	public MailboxVerificationDto(String mailbox, Integer type, String verificationCode) {
		this.mailbox = mailbox;
		this.type = type;
		this.verificationCode = verificationCode;
	}

	// Property accessors

	public String getMailbox() {
		return this.mailbox;
	}

	public void setMailbox(String mailbox) {
		this.mailbox = mailbox;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getVerificationCode() {
		return this.verificationCode;
	}

	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}

}