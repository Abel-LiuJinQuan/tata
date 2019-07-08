package com.hita.tata.common.entity.bbs.Article;

import java.util.Date;

public class Bbs_comment {
	private String id;
	private String replyId;
	private String body;
	private String userId;
	private String buserId;
	private Date modifiedOn;
	private Date createdOn;

	public Bbs_comment() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getBuserId() {
		return buserId;
	}

	public void setBuserId(String buserId) {
		this.buserId = buserId;
	}

	public Date getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Date modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
