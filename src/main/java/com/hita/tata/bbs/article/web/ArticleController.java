package com.hita.tata.bbs.article.web;


import com.hita.tata.bbs.article.param.request.PublishArticle;
import com.hita.tata.bbs.article.param.request.PublishReply;
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
	 * 发布帖子（已测试）
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

}
