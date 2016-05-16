package cn.ppfix.common.entity;

import java.util.Date;

/**
 * OrderInfo entity. @author MyEclipse Persistence Tools
 */

public class OrderInfo implements java.io.Serializable {

	// Fields

	private Long id;
	private Integer categoryPid;
	private String cpDetail;
	private Integer categorySid;
	private String csDetail;
	private String categoryDetail;
	private String orderNum;
	private Integer customerId;
	private String customerName;
	private String customerPhone;
	private Integer scopeId;
	private String addressDetail;
	private String freeTime;
	private Integer repairerId;
	private String repairerName;
	private String repairerPhone;
	private Integer teamId;
	private String describeInfo;
	private Integer diagnoseId;
	private String diagnoseInfo;
	private String grabRemark;
	private String sentAddress;
	private Integer orderStatus;
	private String statusDesc;
	private Float refrencePrice;
	private Float commitPrice;
	private Float lastPrice;
	private Date createTime;
	private Date repairTime;
	private Date finishTime;
	private Date cancelTime;
	private Integer existingDay;
	private Integer CEval;
	private Integer REval;
	private Integer isAuto;
	private Integer serviceType;
	private Integer isTransfer;
	private Integer isAlter;
	private String extra;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public OrderInfo() {
	}

	/** minimal constructor */
	public OrderInfo(Integer categoryPid, String cpDetail, Integer categorySid,
			String csDetail, String categoryDetail, String orderNum,
			Integer customerId, String customerName, String customerPhone,
			Integer scopeId, String addressDetail, Integer orderStatus,
			String statusDesc, Date createTime, Integer existingDay,
			Integer CEval, Integer REval, Integer isAuto, Integer serviceType,
			Integer isTransfer, Integer isAlter, Integer isDelete) {
		this.categoryPid = categoryPid;
		this.cpDetail = cpDetail;
		this.categorySid = categorySid;
		this.csDetail = csDetail;
		this.categoryDetail = categoryDetail;
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.scopeId = scopeId;
		this.addressDetail = addressDetail;
		this.orderStatus = orderStatus;
		this.statusDesc = statusDesc;
		this.createTime = createTime;
		this.existingDay = existingDay;
		this.CEval = CEval;
		this.REval = REval;
		this.isAuto = isAuto;
		this.serviceType = serviceType;
		this.isTransfer = isTransfer;
		this.isAlter = isAlter;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public OrderInfo(Integer categoryPid, String cpDetail, Integer categorySid,
			String csDetail, String categoryDetail, String orderNum,
			Integer customerId, String customerName, String customerPhone,
			Integer scopeId, String addressDetail, String freeTime,
			Integer repairerId, String repairerName, String repairerPhone,
			Integer teamId, String describeInfo, Integer diagnoseId,
			String diagnoseInfo, String grabRemark, String sentAddress,
			Integer orderStatus, String statusDesc, Float refrencePrice,
			Float commitPrice, Float lastPrice, Date createTime,
			Date repairTime, Date finishTime, Date cancelTime,
			Integer existingDay, Integer CEval, Integer REval, Integer isAuto,
			Integer serviceType, Integer isTransfer, Integer isAlter,
			String extra, Integer isDelete) {
		this.categoryPid = categoryPid;
		this.cpDetail = cpDetail;
		this.categorySid = categorySid;
		this.csDetail = csDetail;
		this.categoryDetail = categoryDetail;
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customerName = customerName;
		this.customerPhone = customerPhone;
		this.scopeId = scopeId;
		this.addressDetail = addressDetail;
		this.freeTime = freeTime;
		this.repairerId = repairerId;
		this.repairerName = repairerName;
		this.repairerPhone = repairerPhone;
		this.teamId = teamId;
		this.describeInfo = describeInfo;
		this.diagnoseId = diagnoseId;
		this.diagnoseInfo = diagnoseInfo;
		this.grabRemark = grabRemark;
		this.sentAddress = sentAddress;
		this.orderStatus = orderStatus;
		this.statusDesc = statusDesc;
		this.refrencePrice = refrencePrice;
		this.commitPrice = commitPrice;
		this.lastPrice = lastPrice;
		this.createTime = createTime;
		this.repairTime = repairTime;
		this.finishTime = finishTime;
		this.cancelTime = cancelTime;
		this.existingDay = existingDay;
		this.CEval = CEval;
		this.REval = REval;
		this.isAuto = isAuto;
		this.serviceType = serviceType;
		this.isTransfer = isTransfer;
		this.isAlter = isAlter;
		this.extra = extra;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getCategoryPid() {
		return this.categoryPid;
	}

	public void setCategoryPid(Integer categoryPid) {
		this.categoryPid = categoryPid;
	}

	public String getCpDetail() {
		return this.cpDetail;
	}

	public void setCpDetail(String cpDetail) {
		this.cpDetail = cpDetail;
	}

	public Integer getCategorySid() {
		return this.categorySid;
	}

	public void setCategorySid(Integer categorySid) {
		this.categorySid = categorySid;
	}

	public String getCsDetail() {
		return this.csDetail;
	}

	public void setCsDetail(String csDetail) {
		this.csDetail = csDetail;
	}

	public String getCategoryDetail() {
		return this.categoryDetail;
	}

	public void setCategoryDetail(String categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public String getOrderNum() {
		return this.orderNum;
	}

	public void setOrderNum(String orderNum) {
		this.orderNum = orderNum;
	}

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerPhone() {
		return this.customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}

	public Integer getScopeId() {
		return this.scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

	public String getAddressDetail() {
		return this.addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getFreeTime() {
		return this.freeTime;
	}

	public void setFreeTime(String freeTime) {
		this.freeTime = freeTime;
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

	public String getRepairerPhone() {
		return this.repairerPhone;
	}

	public void setRepairerPhone(String repairerPhone) {
		this.repairerPhone = repairerPhone;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getDescribeInfo() {
		return this.describeInfo;
	}

	public void setDescribeInfo(String describeInfo) {
		this.describeInfo = describeInfo;
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

	public String getGrabRemark() {
		return this.grabRemark;
	}

	public void setGrabRemark(String grabRemark) {
		this.grabRemark = grabRemark;
	}

	public String getSentAddress() {
		return this.sentAddress;
	}

	public void setSentAddress(String sentAddress) {
		this.sentAddress = sentAddress;
	}

	public Integer getOrderStatus() {
		return this.orderStatus;
	}

	public void setOrderStatus(Integer orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getStatusDesc() {
		return this.statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public Float getRefrencePrice() {
		return this.refrencePrice;
	}

	public void setRefrencePrice(Float refrencePrice) {
		this.refrencePrice = refrencePrice;
	}

	public Float getCommitPrice() {
		return this.commitPrice;
	}

	public void setCommitPrice(Float commitPrice) {
		this.commitPrice = commitPrice;
	}

	public Float getLastPrice() {
		return this.lastPrice;
	}

	public void setLastPrice(Float lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRepairTime() {
		return this.repairTime;
	}

	public void setRepairTime(Date repairTime) {
		this.repairTime = repairTime;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public Date getCancelTime() {
		return this.cancelTime;
	}

	public void setCancelTime(Date cancelTime) {
		this.cancelTime = cancelTime;
	}

	public Integer getExistingDay() {
		return this.existingDay;
	}

	public void setExistingDay(Integer existingDay) {
		this.existingDay = existingDay;
	}

	public Integer getCEval() {
		return this.CEval;
	}

	public void setCEval(Integer CEval) {
		this.CEval = CEval;
	}

	public Integer getREval() {
		return this.REval;
	}

	public void setREval(Integer REval) {
		this.REval = REval;
	}

	public Integer getIsAuto() {
		return this.isAuto;
	}

	public void setIsAuto(Integer isAuto) {
		this.isAuto = isAuto;
	}

	public Integer getServiceType() {
		return this.serviceType;
	}

	public void setServiceType(Integer serviceType) {
		this.serviceType = serviceType;
	}

	public Integer getIsTransfer() {
		return this.isTransfer;
	}

	public void setIsTransfer(Integer isTransfer) {
		this.isTransfer = isTransfer;
	}

	public Integer getIsAlter() {
		return this.isAlter;
	}

	public void setIsAlter(Integer isAlter) {
		this.isAlter = isAlter;
	}

	public String getExtra() {
		return this.extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}