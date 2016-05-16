package cn.ppfix.common.entity;

/**
 * MemberMonthData entity. @author MyEclipse Persistence Tools
 */

public class MemberMonthData implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String userName;
	private Integer receiveNum;
	private Integer finishNum;
	private Integer cancelNum;
	private Float success;
	private Integer teamId;
	private Integer year;
	private Integer month;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public MemberMonthData() {
	}

	/** full constructor */
	public MemberMonthData(Integer userId, String userName, Integer receiveNum,
			Integer finishNum, Integer cancelNum, Float success,
			Integer teamId, Integer year, Integer month, Integer isDelete) {
		this.userId = userId;
		this.userName = userName;
		this.receiveNum = receiveNum;
		this.finishNum = finishNum;
		this.cancelNum = cancelNum;
		this.success = success;
		this.teamId = teamId;
		this.year = year;
		this.month = month;
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

	public Integer getYear() {
		return this.year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getMonth() {
		return this.month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}