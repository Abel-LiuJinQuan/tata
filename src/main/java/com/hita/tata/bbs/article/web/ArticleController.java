package com.hita.tata.bbs.article.web;


import com.hita.tata.bbs.article.param.request.CommentOneReply;
import com.hita.tata.bbs.article.param.request.PublishArticle;
import com.hita.tata.bbs.article.param.request.PublishReply;
import com.hita.tata.bbs.article.param.response.CommentOneReplyResp;
import com.hita.tata.bbs.article.param.response.PublishArticleResp;
import com.hita.tata.bbs.article.param.response.PublishReplyResp;
import com.hita.tata.bbs.article.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 论坛帖子部分
 * @author abel
 */
@RestController
@RequestMapping(value = "article")
public class ArticleController {
	@Autowired
	private ArticleService articleService;

	/**
	 * 发布帖子（*******待修改*******）
	 * @param publishArticle
	 * @return
	 */
	@RequestMapping(
			value = {"publishArticle"},
			method = RequestMethod.POST
	)
	public PublishArticleResp publishArticle(@ModelAttribute PublishArticle publishArticle) {
		return articleService.publishArticle(publishArticle);
	}

	/**
	 * 回复楼主的帖子(已测试)
	 * @param publishReply
	 * @return
	 */
	@RequestMapping(
			value = {"publishReply"},
			method = RequestMethod.POST
	)
	public PublishReplyResp publishReply(@ModelAttribute PublishReply publishReply) {
		return articleService.publishReply(publishReply);
	}

	/**
	 * 评论别人的回复（已测试）
	 * @param commentOneReply
	 * @return
	 */
	@RequestMapping(
			value = {"commentOneReply"},
			method = RequestMethod.POST
	)
	public CommentOneReplyResp commentOneReply(CommentOneReply commentOneReply) {
		return articleService.commentOneReply(commentOneReply);
	}

	/**
	 * 评论别人的评论
	 */
	@RequestMapping(
			value = {"commentOneComment"},
			method = RequestMethod.POST
	)
	public void commentOneComment() {

	}

}
