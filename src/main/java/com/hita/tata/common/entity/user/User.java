package com.hita.tata.common.entity.user;

import java.util.Date;

public class User {

	private Integer id;
	private String userName;
	private String nickName;
	private String password;
	private String email;
	private String headUrl;
	private String introduction;
	private String signature;
	private Integer topicCount;
	private Integer replyCount;
	private Integer bestTopicCount;
	private Integer lastTopicId;
	private Integer lastReplyId;
	private Integer amount;
	private String enabled;
	private Date createdOn;

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHeadUrl() {
		return headUrl;
	}

	public void setHeadUrl(String headUrl) {
		this.headUrl = headUrl;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Integer getTopicCount() {
		return topicCount;
	}

	public void setTopicCount(Integer topicCount) {
		this.topicCount = topicCount;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Integer getBestTopicCount() {
		return bestTopicCount;
	}

	public void setBestTopicCount(Integer bestTopicCount) {
		this.bestTopicCount = bestTopicCount;
	}

	public Integer getLastTopicId() {
		return lastTopicId;
	}

	public void setLastTopicId(Integer lastTopicId) {
		this.lastTopicId = lastTopicId;
	}

	public Integer getLastReplyId() {
		return lastReplyId;
	}

	public void setLastReplyId(Integer lastReplyId) {
		this.lastReplyId = lastReplyId;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getEnabled() {
		return enabled;
	}

	public void setEnabled(String enabled) {
		this.enabled = enabled;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
