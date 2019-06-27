package com.hita.tata.bbs.article.web;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 论坛帖子部分
 * @author abel
 */
@RestController
@RequestMapping(value = "article")
public class ArticleController {

	/**
	 * 发布帖子
	 */
	@RequestMapping(
			value = {"publishArticle"},
			method = RequestMethod.POST
	)
	public void publishArticle() {

	}

	/**
	 * 保存到草稿箱
	 */
	@RequestMapping(
			value = {"saveDrafts"},
			method = RequestMethod.POST
	)
	public void saveDrafts() {

	}

	/**
	 * 发表评论
	 */
	@RequestMapping(
			value = {"publishComment"},
			method = RequestMethod.POST
	)
	public void publishComment() {

	}

}
