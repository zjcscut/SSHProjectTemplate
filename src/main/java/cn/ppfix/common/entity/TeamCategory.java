package cn.ppfix.common.entity;

/**
 * TeamCategory entity. @author MyEclipse Persistence Tools
 */

public class TeamCategory implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer teamId;
	private Integer categoryId;
	private String category;
	private Integer level;
	private Integer pid;
	private Integer isFree;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public TeamCategory() {
	}

	/** full constructor */
	public TeamCategory(Integer teamId, Integer categoryId, String category,
			Integer level, Integer pid, Integer isFree, Integer isDelete) {
		this.teamId = teamId;
		this.categoryId = categoryId;
		this.category = category;
		this.level = level;
		this.pid = pid;
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

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
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