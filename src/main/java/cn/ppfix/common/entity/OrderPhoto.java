package cn.ppfix.common.entity;

import java.util.Date;

/**
 * OrderPhoto entity. @author MyEclipse Persistence Tools
 */

public class OrderPhoto implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer orderId;
	private String picMini;
	private String picBig;
	private Date uploadTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public OrderPhoto() {
	}

	/** minimal constructor */
	public OrderPhoto(Integer orderId, String picBig, Date uploadTime,
			Integer isDelete) {
		this.orderId = orderId;
		this.picBig = picBig;
		this.uploadTime = uploadTime;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public OrderPhoto(Integer orderId, String picMini, String picBig,
			Date uploadTime, Integer isDelete) {
		this.orderId = orderId;
		this.picMini = picMini;
		this.picBig = picBig;
		this.uploadTime = uploadTime;
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

	public String getPicMini() {
		return this.picMini;
	}

	public void setPicMini(String picMini) {
		this.picMini = picMini;
	}

	public String getPicBig() {
		return this.picBig;
	}

	public void setPicBig(String picBig) {
		this.picBig = picBig;
	}

	public Date getUploadTime() {
		return this.uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}