package cn.ppfix.common.entity;

import java.util.Date;

/**
 * PayLogs entity. @author MyEclipse Persistence Tools
 */

public class PayLogs implements java.io.Serializable {

	// Fields

	private Integer id;
	private String payNum;
	private Integer orderId;
	private String orderNum;
	private Integer customerId;
	private String customer;
	private Integer teamId;
	private String teamName;
	private Integer repairerId;
	private String repairer;
	private String message;
	private Float money;
	private String channel;
	private Integer payStatus;
	private Date createTime;
	private Date finishTime;
	private String chargeId;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public PayLogs() {
	}

	/** minimal constructor */
	public PayLogs(String payNum, Integer orderId, String orderNum,
			Integer customerId, String customer, Integer teamId,
			String teamName, Integer repairerId, String repairer, Float money,
			String channel, Integer payStatus, Date createTime, Integer isDelete) {
		this.payNum = payNum;
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customer = customer;
		this.teamId = teamId;
		this.teamName = teamName;
		this.repairerId = repairerId;
		this.repairer = repairer;
		this.money = money;
		this.channel = channel;
		this.payStatus = payStatus;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public PayLogs(String payNum, Integer orderId, String orderNum,
			Integer customerId, String customer, Integer teamId,
			String teamName, Integer repairerId, String repairer,
			String message, Float money, String channel, Integer payStatus,
			Date createTime, Date finishTime, String chargeId, Integer isDelete) {
		this.payNum = payNum;
		this.orderId = orderId;
		this.orderNum = orderNum;
		this.customerId = customerId;
		this.customer = customer;
		this.teamId = teamId;
		this.teamName = teamName;
		this.repairerId = repairerId;
		this.repairer = repairer;
		this.message = message;
		this.money = money;
		this.channel = channel;
		this.payStatus = payStatus;
		this.createTime = createTime;
		this.finishTime = finishTime;
		this.chargeId = chargeId;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPayNum() {
		return this.payNum;
	}

	public void setPayNum(String payNum) {
		this.payNum = payNum;
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

	public Integer getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomer() {
		return this.customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public Integer getRepairerId() {
		return this.repairerId;
	}

	public void setRepairerId(Integer repairerId) {
		this.repairerId = repairerId;
	}

	public String getRepairer() {
		return this.repairer;
	}

	public void setRepairer(String repairer) {
		this.repairer = repairer;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Float getMoney() {
		return this.money;
	}

	public void setMoney(Float money) {
		this.money = money;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getFinishTime() {
		return this.finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	public String getChargeId() {
		return this.chargeId;
	}

	public void setChargeId(String chargeId) {
		this.chargeId = chargeId;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}