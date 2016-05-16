package cn.ppfix.common.entity;

import java.util.Date;

/**
 * TeamMember entity. @author MyEclipse Persistence Tools
 */

public class TeamMember implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userName;
	private Integer teamId;
	private String teamName;
	private Integer isApply;
	private Integer receiveNum;
	private Integer cancelNum;
	private Integer successNum;
	private Float attitude;
	private Float efficiency;
	private Float credit;
	private Float level;
	private Float customerScore;
	private Float success;
	private Integer isLeader;
	private Date createTime;
	private Date logoffTime;
	private Integer isLogoff;

	// Constructors

	/** default constructor */
	public TeamMember() {
	}

	/** minimal constructor */
	public TeamMember(Integer userId, String userName, Integer teamId,
			String teamName, Integer isApply, Integer receiveNum,
			Integer cancelNum, Integer successNum, Float attitude,
			Float efficiency, Float credit, Float level, Float customerScore,
			Float success, Integer isLeader, Date createTime, Integer isLogoff) {
		this.userId = userId;
		this.userName = userName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.isApply = isApply;
		this.receiveNum = receiveNum;
		this.cancelNum = cancelNum;
		this.successNum = successNum;
		this.attitude = attitude;
		this.efficiency = efficiency;
		this.credit = credit;
		this.level = level;
		this.customerScore = customerScore;
		this.success = success;
		this.isLeader = isLeader;
		this.createTime = createTime;
		this.isLogoff = isLogoff;
	}

	/** full constructor */
	public TeamMember(Integer userId, String userName, Integer teamId,
			String teamName, Integer isApply, Integer receiveNum,
			Integer cancelNum, Integer successNum, Float attitude,
			Float efficiency, Float credit, Float level, Float customerScore,
			Float success, Integer isLeader, Date createTime, Date logoffTime,
			Integer isLogoff) {
		this.userId = userId;
		this.userName = userName;
		this.teamId = teamId;
		this.teamName = teamName;
		this.isApply = isApply;
		this.receiveNum = receiveNum;
		this.cancelNum = cancelNum;
		this.successNum = successNum;
		this.attitude = attitude;
		this.efficiency = efficiency;
		this.credit = credit;
		this.level = level;
		this.customerScore = customerScore;
		this.success = success;
		this.isLeader = isLeader;
		this.createTime = createTime;
		this.logoffTime = logoffTime;
		this.isLogoff = isLogoff;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getIsApply() {
		return this.isApply;
	}

	public void setIsApply(Integer isApply) {
		this.isApply = isApply;
	}

	public Integer getReceiveNum() {
		return this.receiveNum;
	}

	public void setReceiveNum(Integer receiveNum) {
		this.receiveNum = receiveNum;
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

	public Float getAttitude() {
		return this.attitude;
	}

	public void setAttitude(Float attitude) {
		this.attitude = attitude;
	}

	public Float getEfficiency() {
		return this.efficiency;
	}

	public void setEfficiency(Float efficiency) {
		this.efficiency = efficiency;
	}

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public Float getLevel() {
		return this.level;
	}

	public void setLevel(Float level) {
		this.level = level;
	}

	public Float getCustomerScore() {
		return this.customerScore;
	}

	public void setCustomerScore(Float customerScore) {
		this.customerScore = customerScore;
	}

	public Float getSuccess() {
		return this.success;
	}

	public void setSuccess(Float success) {
		this.success = success;
	}

	public Integer getIsLeader() {
		return this.isLeader;
	}

	public void setIsLeader(Integer isLeader) {
		this.isLeader = isLeader;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLogoffTime() {
		return this.logoffTime;
	}

	public void setLogoffTime(Date logoffTime) {
		this.logoffTime = logoffTime;
	}

	public Integer getIsLogoff() {
		return this.isLogoff;
	}

	public void setIsLogoff(Integer isLogoff) {
		this.isLogoff = isLogoff;
	}

}