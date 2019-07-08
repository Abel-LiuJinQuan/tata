package com.hita.tata.bbs.article.service;

import com.hita.tata.bbs.article.dao.ArticleRepository;
import com.hita.tata.bbs.article.param.request.CommentOneReply;
import com.hita.tata.bbs.article.param.request.PublishArticle;
import com.hita.tata.bbs.article.param.request.PublishReply;
import com.hita.tata.bbs.article.param.response.CommentOneReplyResp;
import com.hita.tata.bbs.article.param.response.PublishArticleResp;
import com.hita.tata.bbs.article.param.response.PublishReplyResp;
import com.hita.tata.common.entity.bbs.Article.Bbs_comment;
import com.hita.tata.common.entity.bbs.Article.Bbs_reply;
import com.hita.tata.common.entity.bbs.Article.Bbs_topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
		//帖子总计+1（用户表、版块分类表）
		//**************************************************
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

	/**
	 * 回复楼主的帖子
	 * @param publishReply
	 * @return
	 */
	@Transactional
	public PublishReplyResp publishReply(PublishReply publishReply) {
		//创建发表时间和回复ID
		Date date = new Date();
		String id = "reply" + date.getTime();
		//返回给前端的数据
		PublishReplyResp publishReplyResp = new PublishReplyResp();
		publishReplyResp.setId(id);
		publishReplyResp.setBody(publishReply.getBody());
		publishReplyResp.setTopicId(publishReply.getTopicId());
		publishReplyResp.setUserId(publishReply.getUserId());
		publishReplyResp.setCreatedOn(date);
		//存储到数据库的数据
		Bbs_reply bbs_reply = new Bbs_reply();
		bbs_reply.setId(id);
		bbs_reply.setTopicId(publishReply.getTopicId());
		bbs_reply.setBody(publishReply.getBody());
		bbs_reply.setUserId(publishReply.getUserId());
		bbs_reply.setCreatedOn(date);
		//存储到数据库
		articleRepository.publishReply(bbs_reply);
		//让帖子表和用户表的回复总数 + 1
		addReplyCount(publishReply.getTopicId(),publishReply.getUserId());
		return publishReplyResp;
	}

	/**
	 * 评论别人的回复
	 * @param commentOneReply
	 * @return
	 */
	@Transactional
	public CommentOneReplyResp commentOneReply(CommentOneReply commentOneReply) {
		//创建发表时间和评论ID
		Date date = new Date();
		String id = "comment" + date.getTime();
		//返回给前端的数据
		CommentOneReplyResp commentOneReplyResp = new CommentOneReplyResp();
		commentOneReplyResp.setId(id);
		commentOneReplyResp.setReplyId(commentOneReply.getReplyId());
		commentOneReplyResp.setBody(commentOneReply.getBody());
		commentOneReplyResp.setUserId(commentOneReply.getUserId());
		commentOneReplyResp.setCreatedOn(date);
		//存储到数据库的数据
		Bbs_comment bbs_comment = new Bbs_comment();
		bbs_comment.setId(id);
		bbs_comment.setReplyId(commentOneReply.getReplyId());
		bbs_comment.setBody(commentOneReply.getBody());
		bbs_comment.setUserId(commentOneReply.getUserId());
		bbs_comment.setCreatedOn(date);
		//存储到数据库
		articleRepository.commentOneReply(bbs_comment);
		//让帖子表和用户表的回复总数 + 1
		addReplyCount(commentOneReply.getTopicId(),commentOneReply.getUserId());
		return commentOneReplyResp;
	}

	/**
	 * 让帖子表和用户表的回复总数 + 1
	 * @param topicId
	 * @param userId
	 */
	public void addReplyCount(String topicId, String userId) {
		//获取当前该帖子的回复量
		Integer replyCount = articleRepository.getReplyCount(topicId);
		//让该帖子的回复量+1
		articleRepository.addOneReplyCount(replyCount + 1,topicId);
		//获取该用户的回复总量
		Integer replyCount2 = articleRepository.getReplyCount2(userId);
		//让该用户的回复总量 + 1
		articleRepository.addOneReplyCount2(replyCount2 + 1, userId);
	}
}
