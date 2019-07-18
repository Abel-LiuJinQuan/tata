package com.hita.tata.bbs.article.param.response;

import com.hita.tata.bbs.article.entity.ArticleInform;
import com.hita.tata.bbs.article.entity.ReplyInform;

import java.util.List;

public class GetArticleDetailResp {
	private ArticleInform articleInform;
	private List<ReplyInform> replyList;

	public GetArticleDetailResp() {
	}

	public ArticleInform getArticleInform() {
		return articleInform;
	}

	public void setArticleInform(ArticleInform articleInform) {
		this.articleInform = articleInform;
	}

	public List<ReplyInform> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<ReplyInform> replyList) {
		this.replyList = replyList;
	}
}
