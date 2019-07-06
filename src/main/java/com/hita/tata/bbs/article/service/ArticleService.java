package com.hita.tata.bbs.article.service;

import com.hita.tata.bbs.article.dao.ArticleRepository;
import com.hita.tata.bbs.article.param.request.PublishArticle;
import com.hita.tata.bbs.article.param.response.PublishArticleResp;
import com.hita.tata.common.entity.bbs.Article.Bbs_topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 帖子方法类
 * @author abel
 */
@Service
public class ArticleService {

	@Autowired
	private ArticleRepository articleRepository;

	/**
	 * 发布帖子
	 * @param publishArticle
	 * @return
	 */
	public PublishArticleResp publishArticle(PublishArticle publishArticle) {
		Date date = new Date();
		String id = "article" + date.getTime();
		//返回给前端的数据
		PublishArticleResp publishArticleResp = new PublishArticleResp();
		publishArticleResp.setId(publishArticle.getId());
		publishArticleResp.setTitle(publishArticle.getTitle());
		publishArticleResp.setContent(publishArticle.getContent());
		publishArticleResp.setParentName(publishArticle.getParentName());
		publishArticleResp.setCreatedOn(date);
		//存进数据库的数据
		Bbs_topic bbs_topic = new Bbs_topic();
		bbs_topic.setId(id);
		bbs_topic.setBody(publishArticle.getContent());
		bbs_topic.setClassId(publishArticle.getParentName());
		bbs_topic.setEnabled("1");
		bbs_topic.setCreatedOn(date);
		bbs_topic.setTitle(publishArticle.getTitle());
		bbs_topic.setUserId(publishArticle.getId());
		bbs_topic.setReplyCount(0);
		//存进数据库
		articleRepository.publishArticle(bbs_topic);
		return publishArticleResp;

	}
}
