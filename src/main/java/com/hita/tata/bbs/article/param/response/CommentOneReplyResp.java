package com.hita.tata.bbs.article.param.response;

import java.util.Date;

/**
 * "评论别人的回复接口"返回参数
 */
public class CommentOneReplyResp {
	private String id;
	private String replyId;
	private String body;
	private String userId;
	private Date createdOn;

	public CommentOneReplyResp() {
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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
