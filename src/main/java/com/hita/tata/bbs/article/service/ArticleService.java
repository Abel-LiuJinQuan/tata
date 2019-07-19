package com.hita.tata.bbs.article.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hita.tata.bbs.article.dao.ArticleRepository;
import com.hita.tata.bbs.article.entity.ArticleInform;
import com.hita.tata.bbs.article.entity.ReplyInform;
import com.hita.tata.bbs.article.param.request.CommentOneComment;
import com.hita.tata.bbs.article.param.request.CommentOneReply;
import com.hita.tata.bbs.article.param.request.PublishArticle;
import com.hita.tata.bbs.article.param.request.PublishReply;
import com.hita.tata.bbs.article.param.response.*;
import com.hita.tata.bbs.block.param.request.GetArticleByBlock;
import com.hita.tata.bbs.block.param.response.ArticleListInform;
import com.hita.tata.bbs.block.param.response.GetArticleByBlockResp;
import com.hita.tata.common.entity.bbs.Article.Bbs_comment;
import com.hita.tata.common.entity.bbs.Article.Bbs_reply;
import com.hita.tata.common.entity.bbs.Article.Bbs_topic;
import com.hita.tata.common.entity.response.Constant;
import com.hita.tata.common.entity.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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
	@Transactional
	public ResponseMessage publishArticle(PublishArticle publishArticle) {
		//创建发表时间和帖子ID
		Date date = new Date();
		String id = "article" + date.getTime();
		//返回给前端的数据
		PublishArticleResp publishArticleResp = new PublishArticleResp();
		publishArticleResp.setId(id);
		publishArticleResp.setUserId(publishArticle.getUserId());
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
		bbs_topic.setUserId(publishArticle.getUserId());
		bbs_topic.setReplyCount(0);
		//存进数据库
		articleRepository.publishArticle(bbs_topic);
		//让用户表的帖子总数 + 1
		Integer topicCount = articleRepository.getTopicCount(publishArticle.getUserId());
		articleRepository.addOneTopicCount(topicCount+1,publishArticle.getUserId());
		//让版块分类表的帖子总数 + 1
		Integer topicCount2 = articleRepository.getTopicCount2(publishArticle.getParentName());
		articleRepository.addOneTopicCount2(topicCount2+1,publishArticle.getParentName());
		return ResponseMessage.newOkInstance(publishArticleResp,Constant.SUCCESS);
	}

	/**
	 * 回复楼主的帖子
	 * @param publishReply
	 * @return
	 */
	@Transactional
	public ResponseMessage publishReply(PublishReply publishReply) {
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
		return ResponseMessage.newOkInstance(publishReplyResp,Constant.SUCCESS);
	}

	/**
	 * 评论别人的回复
	 * @param commentOneReply
	 * @return
	 */
	@Transactional
	public ResponseMessage commentOneReply(CommentOneReply commentOneReply) {
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
		return ResponseMessage.newOkInstance(commentOneReplyResp,Constant.SUCCESS);
	}

	/**
	 * 评论别人的评论
	 * @param commentOneComment
	 */
	@Transactional
	public ResponseMessage commentOneComment(CommentOneComment commentOneComment) {
		//创建发表时间和评论ID
		Date date = new Date();
		String id = "comment" + date.getTime();
		//返回给前端的数据
		CommentOneCommentResp commentOneCommentResp = new CommentOneCommentResp();
		commentOneCommentResp.setId(id);
		commentOneCommentResp.setTopicId(commentOneComment.getTopicId());
		commentOneCommentResp.setReplyId(commentOneComment.getReplyId());
		commentOneCommentResp.setBody(commentOneComment.getBody());
		commentOneCommentResp.setUserId(commentOneComment.getUserId());
		commentOneCommentResp.setBuserId(commentOneComment.getBuserId());
		commentOneCommentResp.setCreatedOn(date);
		//存储到数据库的数据
		Bbs_comment bbs_comment = new Bbs_comment();
		bbs_comment.setId(id);
		bbs_comment.setReplyId(commentOneComment.getReplyId());
		bbs_comment.setBody(commentOneComment.getBody());
		bbs_comment.setUserId(commentOneComment.getUserId());
		bbs_comment.setBuserId(commentOneComment.getBuserId());
		bbs_comment.setCreatedOn(date);
		//存储到数据库
		articleRepository.commentOneReply(bbs_comment);
		addReplyCount(commentOneComment.getTopicId(),commentOneComment.getUserId());
		return ResponseMessage.newOkInstance(commentOneCommentResp,Constant.SUCCESS);
	}

	/**
	 * 获取帖子的详细内容
	 * @param topicId
	 * @return
	 */
	@Transactional
	public ResponseMessage getArticleDetail(String topicId) {
		//获取主帖的信息
		ArticleInform articleInform  = articleRepository.getArticle(topicId);
		//获取帖子的回复和相关评论
		List<ReplyInform> replyInform = articleRepository.getReplyInform(topicId);
		//返回给前端的数据
		GetArticleDetailResp getArticleDetailResp = new GetArticleDetailResp();
		getArticleDetailResp.setArticleInform(articleInform);
		getArticleDetailResp.setReplyList(replyInform);
		return ResponseMessage.newOkInstance(getArticleDetailResp,Constant.SUCCESS);
	}

	/**
	 * 根据栏目名获取帖子列表（分页获取）
	 * @param getArticleByBlock
	 * @return
	 */
	@Transactional
	public ResponseMessage getArticleList(GetArticleByBlock getArticleByBlock) {
		//确定获取第几页，并规定每一页的大小
		PageHelper.startPage(getArticleByBlock.getPageNum(),getArticleByBlock.getPageSize());
		//查询所有记录
		List<ArticleListInform> articleListInform = articleRepository.getArticleList(getArticleByBlock.getBlockName());
		//返回给前端的参数
		GetArticleByBlockResp getArticleByBlockResp = new GetArticleByBlockResp();
		getArticleByBlockResp.setArticleList(articleListInform);
		getArticleByBlockResp.setPageNum(getArticleByBlock.getPageNum());
		getArticleByBlockResp.setPageSize(getArticleByBlock.getPageSize());
		//获取查询总数
		PageInfo<ArticleListInform> info = new PageInfo<>(articleListInform);
		getArticleByBlockResp.setTotal((int)info.getTotal());
		return ResponseMessage.newOkInstance(getArticleByBlockResp,Constant.SUCCESS);
//		return getArticleByBlockResp;
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
