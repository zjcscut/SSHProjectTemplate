package cn.ppfix.common.entity;

import java.util.Date;

/**
 * OrderLogs entity. @author MyEclipse Persistence Tools
 */

public class OrderLogs implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderId;
	private String orderNum;
	private Integer operatorId;
	private String message;
	private Date createTime;
	private Integer logStatus;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public OrderLogs() {
	}

	/** full constructor */
	public OrderLogs(Integer orderId, String orderNum, Integer operatorId,
			String message, Date createTime, Integer logStatus, Integer isDelete) {
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.operatorId = operatorId;
		this.message = message;
		this.createTime = createTime;
		this.logStatus = logStatus;
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

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getOperatorId() {
		return this.operatorId;
	}

	public void setOperatorId(Integer operatorId) {
		this.operatorId = operatorId;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getLogStatus() {
		return this.logStatus;
	}

	public void setLogStatus(Integer logStatus) {
		this.logStatus = logStatus;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}