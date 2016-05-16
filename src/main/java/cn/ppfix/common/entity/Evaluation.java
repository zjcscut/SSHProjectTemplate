package cn.ppfix.common.entity;

import java.util.Date;

/**
 * Evaluation entity. @author MyEclipse Persistence Tools
 */

public class Evaluation implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderId;
	private Integer userId;
	private Integer type;
	private Float attitude;
	private Float efficiency;
	private Float level;
	private Float credit;
	private String content;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Evaluation() {
	}

	/** full constructor */
	public Evaluation(Integer orderId, Integer userId, Integer type,
			Float attitude, Float efficiency, Float level, Float credit,
			String content, Date createTime, Integer isDelete) {
		this.orderId = orderId;
		this.userId = userId;
		this.type = type;
		this.attitude = attitude;
		this.efficiency = efficiency;
		this.level = level;
		this.credit = credit;
		this.content = content;
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

	public Integer getOrderId() {
		return this.orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
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

	public Float getLevel() {
		return this.level;
	}

	public void setLevel(Float level) {
		this.level = level;
	}

	public Float getCredit() {
		return this.credit;
	}

	public void setCredit(Float credit) {
		this.credit = credit;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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