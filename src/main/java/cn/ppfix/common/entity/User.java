package cn.ppfix.common.entity;

import java.util.Date;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private Long ppNum;
	private String gender;
	private String picMini;
	private String picBig;
	private String nickname;
	private String password;
	private String cellphone;
	private Integer addressId;
	private String addressDetail;
	private String qq;
	private String email;
	private Date registrTime;
	private String deviceToken;
	private Integer deviceType;
	private Integer isApply;
	private Integer sendNum;
	private Integer cancelNum;
	private Integer successNum;
	private Float success;
	private Float credit;
	private Float cooperation;
	private Integer isLogoff;
	private Date logoffTime;
	private String token;
	private Date tokenRefreshed;
	private Integer roleId;
	private String roleName;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String picBig, String nickname, Date registrTime,
			Integer isApply, Integer sendNum, Integer cancelNum,
			Integer successNum, Float success, Float credit, Float cooperation,
			Integer isLogoff, String token, Date tokenRefreshed,
			Integer roleId, String roleName) {
		this.picBig = picBig;
		this.nickname = nickname;
		this.registrTime = registrTime;
		this.isApply = isApply;
		this.sendNum = sendNum;
		this.cancelNum = cancelNum;
		this.successNum = successNum;
		this.success = success;
		this.credit = credit;
		this.cooperation = cooperation;
		this.isLogoff = isLogoff;
		this.token = token;
		this.tokenRefreshed = tokenRefreshed;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	/** full constructor */
	public User(Long ppNum, String gender, String picMini, String picBig,
			String nickname, String password, String cellphone,
			Integer addressId, String addressDetail, String qq, String email,
			Date registrTime, String deviceToken, Integer deviceType,
			Integer isApply, Integer sendNum, Integer cancelNum,
			Integer successNum, Float success, Float credit, Float cooperation,
			Integer isLogoff, Date logoffTime, String token,
			Date tokenRefreshed, Integer roleId, String roleName) {
		this.ppNum = ppNum;
		this.gender = gender;
		this.picMini = picMini;
		this.picBig = picBig;
		this.nickname = nickname;
		this.password = password;
		this.cellphone = cellphone;
		this.addressId = addressId;
		this.addressDetail = addressDetail;
		this.qq = qq;
		this.email = email;
		this.registrTime = registrTime;
		this.deviceToken = deviceToken;
		this.deviceType = deviceType;
		this.isApply = isApply;
		this.sendNum = sendNum;
		this.cancelNum = cancelNum;
		this.successNum = successNum;
		this.success = success;
		this.credit = credit;
		this.cooperation = cooperation;
		this.isLogoff = isLogoff;
		this.logoffTime = logoffTime;
		this.token = token;
		this.tokenRefreshed = tokenRefreshed;
		this.roleId = roleId;
		this.roleName = roleName;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getPpNum() {
		return this.ppNum;
	}

	public void setPpNum(Long ppNum) {
		this.ppNum = ppNum;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPicMini() {
		return this.picMini;
	}

	public void setPicMini(String picMini) {
		this.picMini = picMini;
	}

	public String getPicBig() {
		return this.picBig;
	}

	public void setPicBig(String picBig) {
		this.picBig = picBig;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCellphone() {
		return this.cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getRegistrTime() {
		return this.registrTime;
	}

	public void setRegistrTime(Date registrTime) {
		this.registrTime = registrTime;
	}

	public String getDeviceToken() {
		return this.deviceToken;
	}

	public void setDeviceToken(String deviceToken) {
		this.deviceToken = deviceToken;
	}

	public Integer getDeviceType() {
		return this.deviceType;
	}

	public void setDeviceType(Integer deviceType) {
		this.deviceType = deviceType;
	}

	public Integer getIsApply() {
		return this.isApply;
	}

	public void setIsApply(Integer isApply) {
		this.isApply = isApply;
	}

	public Integer getSendNum() {
		return this.sendNum;
	}

	public void setSendNum(Integer sendNum) {
		this.sendNum = sendNum;
	}

	public Integer getCancelNum() {
		return this.cancelNum;
	}

	public void setCancelNum(Integer cancelNum) {
		this.cancelNum = cancelNum;
	}

	public Integer getSuccessNum() {
		return this.successNum;
	}

	public void setSuccessNum(Integer successNum) {
		this.successNum = successNum;
	}

	public Float getSuccess() {
		return this.success;
	}

	public void setSuccess(Float success) {
		this.success = success;
	}

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public Float getCooperation() {
		return this.cooperation;
	}

	public void setCooperation(Float cooperation) {
		this.cooperation = cooperation;
	}

	public Integer getIsLogoff() {
		return this.isLogoff;
	}

	public void setIsLogoff(Integer isLogoff) {
		this.isLogoff = isLogoff;
	}

	public Date getLogoffTime() {
		return this.logoffTime;
	}

	public void setLogoffTime(Date logoffTime) {
		this.logoffTime = logoffTime;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getTokenRefreshed() {
		return this.tokenRefreshed;
	}

	public void setTokenRefreshed(Date tokenRefreshed) {
		this.tokenRefreshed = tokenRefreshed;
	}

	public Integer getRoleId() {
		return this.roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}