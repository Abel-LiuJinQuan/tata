package com.hita.tata.bbs.article.param.request;

/**
 * "发布帖子接口"接收参数
 */
public class PublishArticle {
	private String userId;
	private String title;
	private String content;
	private String parentName;

	public PublishArticle() {
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
}
