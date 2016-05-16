package cn.ppfix.common.entity;

/**
 * Poster entity. @author MyEclipse Persistence Tools
 */

public class Poster implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer type;
	private String location;
	private String linkUrl;
	private Integer sort;
	private String title;
	private String content;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Poster() {
	}

	/** minimal constructor */
	public Poster(Integer type, String location, Integer sort, Integer isDelete) {
		this.type = type;
		this.location = location;
		this.sort = sort;
		this.isDelete = isDelete;
	}

	/** full constructor */
	public Poster(Integer type, String location, String linkUrl, Integer sort,
			String title, String content, Integer isDelete) {
		this.type = type;
		this.location = location;
		this.linkUrl = linkUrl;
		this.sort = sort;
		this.title = title;
		this.content = content;
		this.isDelete = isDelete;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLinkUrl() {
		return this.linkUrl;
	}

	public void setLinkUrl(String linkUrl) {
		this.linkUrl = linkUrl;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}