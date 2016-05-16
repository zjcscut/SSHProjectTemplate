package cn.ppfix.common.entity;

/**
 * MemberCategory entity. @author MyEclipse Persistence Tools
 */

public class MemberCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer memberId;
	private Integer categoryId;
	private String category;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public MemberCategory() {
	}

	/** full constructor */
	public MemberCategory(Integer memberId, Integer categoryId,
			String category, Integer isDelete) {
		this.memberId = memberId;
		this.categoryId = categoryId;
		this.category = category;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
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

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}