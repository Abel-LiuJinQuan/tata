package com.hita.tata.bbs.article.web;


import com.hita.tata.bbs.article.param.request.CommentOneComment;
import com.hita.tata.bbs.article.param.request.CommentOneReply;
import com.hita.tata.bbs.article.param.request.PublishArticle;
import com.hita.tata.bbs.article.param.request.PublishReply;
import com.hita.tata.bbs.article.service.ArticleService;
import com.hita.tata.common.entity.response.ResponseMessage;
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
	 * 发布帖子(已测试)
	 * @param publishArticle
	 * @return
	 */
	@RequestMapping(
			value = {"publishArticle"},
			method = RequestMethod.POST
	)
	public ResponseMessage publishArticle(@ModelAttribute PublishArticle publishArticle) {
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
	public ResponseMessage publishReply(@ModelAttribute PublishReply publishReply) {
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
	public ResponseMessage commentOneReply(CommentOneReply commentOneReply) {
		return articleService.commentOneReply(commentOneReply);
	}

	/**
	 * 评论别人的评论(已测试)
	 */
	@RequestMapping(
			value = {"commentOneComment"},
			method = RequestMethod.POST
	)
	public ResponseMessage commentOneComment(CommentOneComment commentOneComment) {
		return articleService.commentOneComment(commentOneComment);
	}

	/**
	 * 获取帖子的详细内容
	 * @param topicId
	 * @return
	 */
	@RequestMapping(
			value = {"getArticleDetail"},
			method = RequestMethod.POST
	)
	public ResponseMessage getArticleDetail(String topicId) {
		return articleService.getArticleDetail(topicId);
	}

}
