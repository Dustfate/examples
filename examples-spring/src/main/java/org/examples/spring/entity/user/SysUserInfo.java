package org.examples.spring.entity.user;

import java.util.Date;

import com.dexcoder.commons.pager.Pageable;

/**
 * 用户信息
 * 
 * @author Dusf
 *
 */
public class SysUserInfo extends Pageable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userId; 			// 用户编码
	private String userName; 		// 用户名
	private String passWord; 		// 密码
	private String emailAddress;	// 邮箱地址
	private String phoneNumber; 	// 手机号
	private String cardId; 			// 身份证号
	private String realName; 		// 真实姓名
	private Integer status; 		// 状态
	private String ip; 				// 用户登录IP地址
	private String skin; 			// 皮肤
	private Date createDate; 		// 创建时间
	private Date updateDate; 		// 更新时间
	private Date loginDate; 		// 最后登录时间

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
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

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getSkin() {
		return skin;
	}

	public void setSkin(String skin) {
		this.skin = skin;
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

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

}
