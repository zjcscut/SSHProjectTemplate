package cn.ppfix.common.entity;

import java.util.Date;

/**
 * OrderTransfer entity. @author MyEclipse Persistence Tools
 */

public class OrderTransfer implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer originOrderId;
	private Integer originRepairerId;
	private String originRepairerName;
	private Integer newOrderId;
	private Integer newRepairerId;
	private String newRepairerName;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public OrderTransfer() {
	}

	/** full constructor */
	public OrderTransfer(Integer originOrderId, Integer originRepairerId,
			String originRepairerName, Integer newOrderId,
			Integer newRepairerId, String newRepairerName, Date createTime,
			Integer isDelete) {
		this.originOrderId = originOrderId;
		this.originRepairerId = originRepairerId;
		this.originRepairerName = originRepairerName;
		this.newOrderId = newOrderId;
		this.newRepairerId = newRepairerId;
		this.newRepairerName = newRepairerName;
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

	public Integer getOriginOrderId() {
		return this.originOrderId;
	}

	public void setOriginOrderId(Integer originOrderId) {
		this.originOrderId = originOrderId;
	}

	public Integer getOriginRepairerId() {
		return this.originRepairerId;
	}

	public void setOriginRepairerId(Integer originRepairerId) {
		this.originRepairerId = originRepairerId;
	}

	public String getOriginRepairerName() {
		return this.originRepairerName;
	}

	public void setOriginRepairerName(String originRepairerName) {
		this.originRepairerName = originRepairerName;
	}

	public Integer getNewOrderId() {
		return this.newOrderId;
	}

	public void setNewOrderId(Integer newOrderId) {
		this.newOrderId = newOrderId;
	}

	public Integer getNewRepairerId() {
		return this.newRepairerId;
	}

	public void setNewRepairerId(Integer newRepairerId) {
		this.newRepairerId = newRepairerId;
	}

	public String getNewRepairerName() {
		return this.newRepairerName;
	}

	public void setNewRepairerName(String newRepairerName) {
		this.newRepairerName = newRepairerName;
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