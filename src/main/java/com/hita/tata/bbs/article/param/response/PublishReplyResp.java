package com.hita.tata.bbs.article.param.response;

import java.util.Date;

/**
 * "发表评论接口"返回参数
 */
public class PublishReplyResp {
	private String id;
	private String topicId;
	private String body;
	private String userId;
	private Date createdOn;

	public PublishReplyResp() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
