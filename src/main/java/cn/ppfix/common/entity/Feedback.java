package cn.ppfix.common.entity;

import java.util.Date;

/**
 * Feedback entity. @author MyEclipse Persistence Tools
 */

public class Feedback implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer sendId;
	private String contactWay;
	private String infoContent;
	private Integer handleStatus;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Feedback() {
	}

	/** full constructor */
	public Feedback(Integer sendId, String contactWay, String infoContent,
			Integer handleStatus, Date createTime, Integer isDelete) {
		this.sendId = sendId;
		this.contactWay = contactWay;
		this.infoContent = infoContent;
		this.handleStatus = handleStatus;
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

	public Integer getSendId() {
		return this.sendId;
	}

	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}

	public String getContactWay() {
		return this.contactWay;
	}

	public void setContactWay(String contactWay) {
		this.contactWay = contactWay;
	}

	public String getInfoContent() {
		return this.infoContent;
	}

	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}

	public Integer getHandleStatus() {
		return this.handleStatus;
	}

	public void setHandleStatus(Integer handleStatus) {
		this.handleStatus = handleStatus;
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