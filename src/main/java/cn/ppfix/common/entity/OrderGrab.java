package cn.ppfix.common.entity;

import java.util.Date;

/**
 * OrderGrab entity. @author MyEclipse Persistence Tools
 */

public class OrderGrab implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderId;
	private Integer repairerId;
	private Integer diagnoseId;
	private String diagnoseInfo;
	private Float refrencePrice;
	private Float price;
	private Integer serviceType;
	private String address;
	private String remark;
	private Date createTime;
	private Integer status;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public OrderGrab() {
	}

	/** minimal constructor */
	public OrderGrab(Integer orderId, Integer repairerId, Integer diagnoseId,
			String diagnoseInfo, Float refrencePrice, Float price,
			Integer serviceType, String address, Date createTime,
			Integer status, Integer isDelete) {
		this.orderId = orderId;
		this.repairerId = repairerId;
		this.diagnoseId = diagnoseId;
		this.diagnoseInfo = diagnoseInfo;
		this.refrencePrice = refrencePrice;
		this.price = price;
		this.serviceType = serviceType;
		this.address = address;
		this.createTime = createTime;
		this.status = status;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public OrderGrab(Integer orderId, Integer repairerId, Integer diagnoseId,
			String diagnoseInfo, Float refrencePrice, Float price,
			Integer serviceType, String address, String remark,
			Date createTime, Integer status, Integer isDelete) {
		this.orderId = orderId;
		this.repairerId = repairerId;
		this.diagnoseId = diagnoseId;
		this.diagnoseInfo = diagnoseInfo;
		this.refrencePrice = refrencePrice;
		this.price = price;
		this.serviceType = serviceType;
		this.address = address;
		this.remark = remark;
		this.createTime = createTime;
		this.status = status;
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

	public Integer getDiagnoseId() {
		return this.diagnoseId;
	}

	public void setDiagnoseId(Integer diagnoseId) {
		this.diagnoseId = diagnoseId;
	}

	public String getDiagnoseInfo() {
		return this.diagnoseInfo;
	}

	public void setDiagnoseInfo(String diagnoseInfo) {
		this.diagnoseInfo = diagnoseInfo;
	}

	public Float getRefrencePrice() {
		return this.refrencePrice;
	}

	public void setRefrencePrice(Float refrencePrice) {
		this.refrencePrice = refrencePrice;
	}

	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}