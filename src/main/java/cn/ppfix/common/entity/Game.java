package cn.ppfix.common.entity;

import java.util.Date;

/**
 * Game entity. @author MyEclipse Persistence Tools
 */

public class Game implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer userId;
	private Integer mobileScore;
	private Integer gameScore;
	private Integer totalScore;
	private Date createTime;
	private Date refreshTime;
	private Integer times;
	private Integer isDelete;

	// Constructors

	/** default constructor */
	public Game() {
	}

	/** full constructor */
	public Game(Integer userId, Integer mobileScore, Integer gameScore,
			Integer totalScore, Date createTime, Date refreshTime,
			Integer times, Integer isDelete) {
		this.userId = userId;
		this.mobileScore = mobileScore;
		this.gameScore = gameScore;
		this.totalScore = totalScore;
		this.createTime = createTime;
		this.refreshTime = refreshTime;
		this.times = times;
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

	public Integer getMobileScore() {
		return this.mobileScore;
	}

	public void setMobileScore(Integer mobileScore) {
		this.mobileScore = mobileScore;
	}

	public Integer getGameScore() {
		return this.gameScore;
	}

	public void setGameScore(Integer gameScore) {
		this.gameScore = gameScore;
	}

	public Integer getTotalScore() {
		return this.totalScore;
	}

	public void setTotalScore(Integer totalScore) {
		this.totalScore = totalScore;
	}

	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getRefreshTime() {
		return this.refreshTime;
	}

	public void setRefreshTime(Date refreshTime) {
		this.refreshTime = refreshTime;
	}

	public Integer getTimes() {
		return this.times;
	}

	public void setTimes(Integer times) {
		this.times = times;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

}