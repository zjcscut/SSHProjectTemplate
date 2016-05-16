package cn.ppfix.common.entity;

import java.util.Date;

/**
 * TeamInfo entity. @author MyEclipse Persistence Tools
 */

public class TeamInfo implements java.io.Serializable {

	// Fields

	private Integer id;
	private String categoryDetail;
	private String scopeDetail;
	private String teamName;
	private String picMini;
	private String picBig;
	private String description;
	private String address;
	private Integer leaderId;
	private String leaderName;
	private String leaderPhone;
	private Integer memberNum;
	private Integer receiveTotal;
	private Integer cancelTotal;
	private Integer successTotal;
	private Float success;
	private Float teamScore;
	private Integer rank;
	private Date createTime;
	private Date logoffTime;
	private Integer isLogoff;

	// Constructors

	/** default constructor */
	public TeamInfo() {
	}

	/** minimal constructor */
	public TeamInfo(String teamName, String description, String address,
			Integer leaderId, String leaderName, String leaderPhone,
			Integer memberNum, Integer receiveTotal, Integer cancelTotal,
			Integer successTotal, Float success, Float teamScore, Integer rank,
			Date createTime, Integer isLogoff) {
		this.teamName = teamName;
		this.description = description;
		this.address = address;
		this.leaderId = leaderId;
		this.leaderName = leaderName;
		this.leaderPhone = leaderPhone;
		this.memberNum = memberNum;
		this.receiveTotal = receiveTotal;
		this.cancelTotal = cancelTotal;
		this.successTotal = successTotal;
		this.success = success;
		this.teamScore = teamScore;
		this.rank = rank;
		this.createTime = createTime;
		this.isLogoff = isLogoff;
	}

	/** full constructor */
	public TeamInfo(String categoryDetail, String scopeDetail, String teamName,
			String picMini, String picBig, String description, String address,
			Integer leaderId, String leaderName, String leaderPhone,
			Integer memberNum, Integer receiveTotal, Integer cancelTotal,
			Integer successTotal, Float success, Float teamScore, Integer rank,
			Date createTime, Date logoffTime, Integer isLogoff) {
		this.categoryDetail = categoryDetail;
		this.scopeDetail = scopeDetail;
		this.teamName = teamName;
		this.picMini = picMini;
		this.picBig = picBig;
		this.description = description;
		this.address = address;
		this.leaderId = leaderId;
		this.leaderName = leaderName;
		this.leaderPhone = leaderPhone;
		this.memberNum = memberNum;
		this.receiveTotal = receiveTotal;
		this.cancelTotal = cancelTotal;
		this.successTotal = successTotal;
		this.success = success;
		this.teamScore = teamScore;
		this.rank = rank;
		this.createTime = createTime;
		this.logoffTime = logoffTime;
		this.isLogoff = isLogoff;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategoryDetail() {
		return this.categoryDetail;
	}

	public void setCategoryDetail(String categoryDetail) {
		this.categoryDetail = categoryDetail;
	}

	public String getScopeDetail() {
		return this.scopeDetail;
	}

	public void setScopeDetail(String scopeDetail) {
		this.scopeDetail = scopeDetail;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getPicMini() {
		return this.picMini;
	}

	public void setPicMini(String picMini) {
		this.picMini = picMini;
	}

	public String getPicBig() {
		return this.picBig;
	}

	public void setPicBig(String picBig) {
		this.picBig = picBig;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getLeaderId() {
		return this.leaderId;
	}

	public void setLeaderId(Integer leaderId) {
		this.leaderId = leaderId;
	}

	public String getLeaderName() {
		return this.leaderName;
	}

	public void setLeaderName(String leaderName) {
		this.leaderName = leaderName;
	}

	public String getLeaderPhone() {
		return this.leaderPhone;
	}

	public void setLeaderPhone(String leaderPhone) {
		this.leaderPhone = leaderPhone;
	}

	public Integer getMemberNum() {
		return this.memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	public Integer getReceiveTotal() {
		return this.receiveTotal;
	}

	public void setReceiveTotal(Integer receiveTotal) {
		this.receiveTotal = receiveTotal;
	}

	public Integer getCancelTotal() {
		return this.cancelTotal;
	}

	public void setCancelTotal(Integer cancelTotal) {
		this.cancelTotal = cancelTotal;
	}

	public Integer getSuccessTotal() {
		return this.successTotal;
	}

	public void setSuccessTotal(Integer successTotal) {
		this.successTotal = successTotal;
	}

	public Float getSuccess() {
		return this.success;
	}

	public void setSuccess(Float success) {
		this.success = success;
	}

	public Float getTeamScore() {
		return this.teamScore;
	}

	public void setTeamScore(Float teamScore) {
		this.teamScore = teamScore;
	}

	public Integer getRank() {
		return this.rank;
	}

	public void setRank(Integer rank) {
		this.rank = rank;
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

	public Integer getIsLogoff() {
		return this.isLogoff;
	}

	public void setIsLogoff(Integer isLogoff) {
		this.isLogoff = isLogoff;
	}

}