package cn.ppfix.common.entity;

import java.util.Date;

/**
 * TeamDayData entity. @author MyEclipse Persistence Tools
 */

public class TeamDayData implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer teamId;
	private Integer receiveNum;
	private Integer finishNum;
	private Integer cancelNum;
	private Float success;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public TeamDayData() {
	}

	/** full constructor */
	public TeamDayData(Integer teamId, Integer receiveNum, Integer finishNum,
			Integer cancelNum, Float success, Date createTime, Integer isDelete) {
		this.teamId = teamId;
		this.receiveNum = receiveNum;
		this.finishNum = finishNum;
		this.cancelNum = cancelNum;
		this.success = success;
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

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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