package cn.ppfix.common.entity;

import java.util.Date;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private Integer id;
	private String roleName;
	private Integer roleScope;
	private Date createTime;
	private Date logoffTime;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String roleName, Integer roleScope, Date createTime,
			Integer isDelete) {
		this.roleName = roleName;
		this.roleScope = roleScope;
		this.createTime = createTime;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public Role(String roleName, Integer roleScope, Date createTime,
			Date logoffTime, Integer isDelete) {
		this.roleName = roleName;
		this.roleScope = roleScope;
		this.createTime = createTime;
		this.logoffTime = logoffTime;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public Integer getRoleScope() {
		return this.roleScope;
	}

	public void setRoleScope(Integer roleScope) {
		this.roleScope = roleScope;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getLogoffTime() {
		return this.logoffTime;
	}

	public void setLogoffTime(Date logoffTime) {
		this.logoffTime = logoffTime;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}