package cn.ppfix.common.entity;

import java.util.Date;

/**
 * UserAddress entity. @author MyEclipse Persistence Tools
 */

public class UserAddress implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer scopeId;
	private String scope;
	private String department;
	private String detail;
	private Integer isDefault;
	private Date refreshTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public UserAddress() {
	}

	/** minimal constructor */
	public UserAddress(Integer userId, String department, String detail,
			Integer isDefault, Date refreshTime, Integer isDelete) {
		this.userId = userId;
		this.department = department;
		this.detail = detail;
		this.isDefault = isDefault;
		this.refreshTime = refreshTime;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public UserAddress(Integer userId, Integer scopeId, String scope,
			String department, String detail, Integer isDefault,
			Date refreshTime, Integer isDelete) {
		this.userId = userId;
		this.scopeId = scopeId;
		this.scope = scope;
		this.department = department;
		this.detail = detail;
		this.isDefault = isDefault;
		this.refreshTime = refreshTime;
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

	public Integer getScopeId() {
		return this.scopeId;
	}

	public void setScopeId(Integer scopeId) {
		this.scopeId = scopeId;
	}

	public String getScope() {
		return this.scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getDepartment() {
		return this.department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Date getRefreshTime() {
		return this.refreshTime;
	}

	public void setRefreshTime(Date refreshTime) {
		this.refreshTime = refreshTime;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}