package com.hita.tata.bbs.article.entity;

import com.hita.tata.common.entity.user.UserInform;

import java.util.Date;

public class ArticleInform {
	private String id;
	private String classId;
	private String title;
	private String body;
	private UserInform userInform;
	private Integer replyCount;
	private Date createdOn;

	public ArticleInform() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getClassId() {
		return classId;
	}

	public void setClassId(String classId) {
		this.classId = classId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public UserInform getUserInform() {
		return userInform;
	}

	public void setUserInform(UserInform userInform) {
		this.userInform = userInform;
	}

	public Integer getReplyCount() {
		return replyCount;
	}

	public void setReplyCount(Integer replyCount) {
		this.replyCount = replyCount;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
