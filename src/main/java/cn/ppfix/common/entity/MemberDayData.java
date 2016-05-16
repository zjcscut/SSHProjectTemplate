package cn.ppfix.common.entity;

import java.util.Date;

/**
 * MemberDayData entity. @author MyEclipse Persistence Tools
 */

public class MemberDayData implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userName;
	private Integer receiveNum;
	private Integer finishNum;
	private Integer cancelNum;
	private Float success;
	private Integer teamId;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public MemberDayData() {
	}

	/** full constructor */
	public MemberDayData(Integer userId, String userName, Integer receiveNum,
			Integer finishNum, Integer cancelNum, Float success,
			Integer teamId, Date createTime, Integer isDelete) {
		this.userId = userId;
		this.userName = userName;
		this.receiveNum = receiveNum;
		this.finishNum = finishNum;
		this.cancelNum = cancelNum;
		this.success = success;
		this.teamId = teamId;
		this.createTime = createTime;
		this.isDelete = isDelete;
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

	public Integer getReceiveNum() {
		return this.receiveNum;
	}

	public void setReceiveNum(Integer receiveNum) {
		this.receiveNum = receiveNum;
	}

	public Integer getFinishNum() {
		return this.finishNum;
	}

	public void setFinishNum(Integer finishNum) {
		this.finishNum = finishNum;
	}

	public Integer getCancelNum() {
		return this.cancelNum;
	}

	public void setCancelNum(Integer cancelNum) {
		this.cancelNum = cancelNum;
	}

	public Float getSuccess() {
		return this.success;
	}

	public void setSuccess(Float success) {
		this.success = success;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}