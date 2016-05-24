package org.examples.ssh.entity.user;

import javax.persistence.*;
import java.util.Date;

/**
 * 用户信息
 */
@Entity
@Table(name = "USERS", uniqueConstraints = @UniqueConstraint(columnNames = "USERNAME"))
public class Users {

	public Users() {
	}

	public Users(String pkid, String realName, String userName,
			String passWords, String emailAddress, String phoneNumber,
			Date createDate, Date updateDate) {
		this.pkid = pkid;
		this.realName = realName;
		this.userName = userName;
		this.passWords = passWords;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	public Users(String realName, String userName, String passWords,
			String emailAddress, String phoneNumber, Date createDate,
			Date updateDate) {
		this.realName = realName;
		this.userName = userName;
		this.passWords = passWords;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.createDate = createDate;
		this.updateDate = updateDate;
	}

	/**
	 * 主键
	 */
	private String pkid; 			// 主键
	private String realName; 		// 真实姓名
	private String userName; 		// 账号
	private String passWords; 		// 密码
	private String emailAddress; 	// 邮件地址
	private String phoneNumber;		// 手机号
	private Date createDate; 		// 注册时间
	private Date updateDate; 		// 修改时间

	@Id
	@Column(name = "ID", unique = true, nullable = false, length = 36)
	public String getPkid() {
		return pkid;
	}

	public void setPkid(String pkid) {
		this.pkid = pkid;
	}

	@Column(name = "REALNAME", nullable = false, length = 100)
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	@Column(name = "USERNAME", unique = true, nullable = false, length = 100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name = "PASSWORDS", nullable = false, length = 50)
	public String getPassWords() {
		return passWords;
	}

	public void setPassWords(String passWords) {
		this.passWords = passWords;
	}

	@Column(name = "EMAILADDRESS", length = 100)
	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "PHONENUMBER", length = 15)
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATEDATE", length = 17)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATEDATE", length = 17)
	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
}
