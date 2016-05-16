package cn.ppfix.common.entity;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private Integer pid;
	private String detail;
	private Integer level;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** full constructor */
	public Area(String name, Integer pid, String detail, Integer level,
			Integer isDelete) {
		this.name = name;
		this.pid = pid;
		this.detail = detail;
		this.level = level;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPid() {
		return this.pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}