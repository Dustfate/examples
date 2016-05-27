package org.examples.spring.entity.user;

import java.util.Date;

import org.examples.spring.util.page.Pageable;

public class UserInfo extends Pageable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String usreId;
	private String userName;
	private String passWord;
	private String emailAddress;
	private String phoneNumber;
	private String realName;
	private Date createDate;
	private Date updateDate;

	public String getUsreId() {
		return usreId;
	}

	public void setUsreId(String usreId) {
		this.usreId = usreId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

}
