package cn.ppfix.common.entity;

import java.util.Date;

/**
 * OrderAlter entity. @author MyEclipse Persistence Tools
 */

public class OrderAlter implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderId;
	private Integer repairerId;
	private String repairerName;
	private Float alterPrice;
	private String reason;
	private String picUrl;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public OrderAlter() {
	}

	/** minimal constructor */
	public OrderAlter(Integer orderId, Integer repairerId, String repairerName,
			Float alterPrice, String reason, Date createTime, Integer isDelete) {
		this.orderId = orderId;
		this.repairerId = repairerId;
		this.repairerName = repairerName;
		this.alterPrice = alterPrice;
		this.reason = reason;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public OrderAlter(Integer orderId, Integer repairerId, String repairerName,
			Float alterPrice, String reason, String picUrl, Date createTime,
			Integer isDelete) {
		this.orderId = orderId;
		this.repairerId = repairerId;
		this.repairerName = repairerName;
		this.alterPrice = alterPrice;
		this.reason = reason;
		this.picUrl = picUrl;
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

	public Integer getRepairerId() {
		return this.repairerId;
	}

	public void setRepairerId(Integer repairerId) {
		this.repairerId = repairerId;
	}

	public String getRepairerName() {
		return this.repairerName;
	}

	public void setRepairerName(String repairerName) {
		this.repairerName = repairerName;
	}

	public Float getAlterPrice() {
		return this.alterPrice;
	}

	public void setAlterPrice(Float alterPrice) {
		this.alterPrice = alterPrice;
	}

	public String getReason() {
		return this.reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getPicUrl() {
		return this.picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
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