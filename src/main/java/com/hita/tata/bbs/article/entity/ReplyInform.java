package com.hita.tata.bbs.article.entity;

import com.hita.tata.common.entity.user.UserInform;

import java.util.Date;
import java.util.List;

public class ReplyInform {
	private String topicId;
	private String replyId;
	private String body;
	private UserInform userInform;
	private Date createdOn;
	private List<CommentInform> commentInform;

	public ReplyInform() {
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

	public UserInform getUserInform() {
		return userInform;
	}

	public void setUserInform(UserInform userInform) {
		this.userInform = userInform;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public List<CommentInform> getCommentInform() {
		return commentInform;
	}

	public void setCommentInform(List<CommentInform> commentInform) {
		this.commentInform = commentInform;
	}
}
