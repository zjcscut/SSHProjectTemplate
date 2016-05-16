package cn.ppfix.common.entity;

import java.util.Date;

/**
 * UserAuth entity. @author MyEclipse Persistence Tools
 */

public class UserAuth implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private String openId;
	private String channel;
	private Date createTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public UserAuth() {
	}

	/** minimal constructor */
	public UserAuth(String openId, String channel, Date createTime,
			Integer isDelete) {
		this.openId = openId;
		this.channel = channel;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public UserAuth(Integer userId, String openId, String channel,
			Date createTime, Integer isDelete) {
		this.userId = userId;
		this.openId = openId;
		this.channel = channel;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getOpenId() {
		return this.openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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