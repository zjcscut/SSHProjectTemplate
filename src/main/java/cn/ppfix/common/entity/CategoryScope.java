package cn.ppfix.common.entity;

/**
 * CategoryScope entity. @author MyEclipse Persistence Tools
 */

public class CategoryScope implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer scopeId;
	private String scope;
	private Integer categoryId;
	private String category;
	private Integer isFree;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public CategoryScope() {
	}

	/** full constructor */
	public CategoryScope(Integer scopeId, String scope, Integer categoryId,
			String category, Integer isFree, Integer isDelete) {
		this.scopeId = scopeId;
		this.scope = scope;
		this.categoryId = categoryId;
		this.category = category;
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

	public Integer getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
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