package cn.ppfix.common.entity;

import java.util.Date;

/**
 * TeamApply entity. @author MyEclipse Persistence Tools
 */

public class TeamApply implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer applyType;
	private String categoryList;
	private Integer teamId;
	private Date applyTime;
	private String reason;
	private Integer isSuccess;
	private String pic;
	private String pic1;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public TeamApply() {
	}

	/** minimal constructor */
	public TeamApply(Integer userId, Integer applyType, Integer teamId,
			Date applyTime, String reason, Integer isSuccess, Integer isDelete) {
		this.userId = userId;
		this.applyType = applyType;
		this.teamId = teamId;
		this.applyTime = applyTime;
		this.reason = reason;
		this.isSuccess = isSuccess;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public TeamApply(Integer userId, Integer applyType, String categoryList,
			Integer teamId, Date applyTime, String reason, Integer isSuccess,
			String pic, String pic1, Integer isDelete) {
		this.userId = userId;
		this.applyType = applyType;
		this.categoryList = categoryList;
		this.teamId = teamId;
		this.applyTime = applyTime;
		this.reason = reason;
		this.isSuccess = isSuccess;
		this.pic = pic;
		this.pic1 = pic1;
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

	public Integer getApplyType() {
		return this.applyType;
	}

	public void setApplyType(Integer applyType) {
		this.applyType = applyType;
	}

	public String getCategoryList() {
		return this.categoryList;
	}

	public void setCategoryList(String categoryList) {
		this.categoryList = categoryList;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public Date getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Integer getIsSuccess() {
		return this.isSuccess;
	}

	public void setIsSuccess(Integer isSuccess) {
		this.isSuccess = isSuccess;
	}

	public String getPic() {
		return this.pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getPic1() {
		return this.pic1;
	}

	public void setPic1(String pic1) {
		this.pic1 = pic1;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}