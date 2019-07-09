package com.hita.tata.bbs.article.param.request;

public class CommentOneComment {
	private String topicId;
	private String replyId;
	private String body;
	private String userId;
	private String buserId;

	public CommentOneComment() {
	}

	public String getTopicId() {
		return topicId;
	}

	public void setTopicId(String topicId) {
		this.topicId = topicId;
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
}
