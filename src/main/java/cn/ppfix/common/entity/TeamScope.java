package cn.ppfix.common.entity;

/**
 * TeamScope entity. @author MyEclipse Persistence Tools
 */

public class TeamScope implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer teamId;
	private Integer scopeId;
	private String scope;
	private Integer isDefault;
	private Integer isFree;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public TeamScope() {
	}

	/** full constructor */
	public TeamScope(Integer teamId, Integer scopeId, String scope,
			Integer isDefault, Integer isFree, Integer isDelete) {
		this.teamId = teamId;
		this.scopeId = scopeId;
		this.scope = scope;
		this.isDefault = isDefault;
		this.isFree = isFree;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTeamId() {
		return this.teamId;
	}

	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
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

	public Integer getIsDefault() {
		return this.isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public Integer getIsFree() {
		return this.isFree;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}