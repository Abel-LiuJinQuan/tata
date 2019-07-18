package com.hita.tata.bbs.article.entity;

import com.hita.tata.common.entity.user.UserInform;

import java.util.Date;

public class CommentInform {
	private String replyId;
	private String commentId;
	private String body;
	private UserInform userInform;		//评论者的用户信息
	private UserInform buserInfrom;	//被评论者的用户信息
	private Date createdOn;

	public CommentInform() {
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getCommentId() {
		return commentId;
	}

	public void setCommentId(String commentId) {
		this.commentId = commentId;
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

	public UserInform getBuserInfrom() {
		return buserInfrom;
	}

	public void setBuserInfrom(UserInform buserInfrom) {
		this.buserInfrom = buserInfrom;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
}
