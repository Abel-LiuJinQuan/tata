package com.hita.tata.bbs.article.dao;

import com.hita.tata.bbs.article.entity.ArticleInform;
import com.hita.tata.common.entity.bbs.Article.Bbs_comment;
import com.hita.tata.common.entity.bbs.Article.Bbs_reply;
import com.hita.tata.common.entity.bbs.Article.Bbs_topic;
import com.hita.tata.common.entity.user.UserInform;
import org.apache.ibatis.annotations.*;

/**
 * 帖子数据库操作方法类
 * @author abel
 */
@Mapper
public interface ArticleRepository {

	/**
	 * 获取指定帖子的当前回复量
	 * @param id
	 */
	@Select("select replyCount from bbs_topic where id = #{arg0}")
	int getReplyCount(String id);


	/**
	 * 获取该用户的回复总量
	 * @param userId
	 * @return
	 */
	@Select("select replyCount from bbs_user where id = #{arg0}")
	int getReplyCount2(String userId);

	/**
	 * 获取该用户的帖子总量
	 * @param userId
	 * @return
	 */
	@Select("select topicCount from bbs_user where id = #{arg0}")
	int getTopicCount(String userId);

	/**
	 * 获取该栏目的帖子总数
	 * @param name
	 * @return
	 */
	@Select("select topicCount from bbs_class where name = #{arg0}")
	int getTopicCount2(String name);
	/**
	 * 让指定帖子的回复量 + 1
	 * @param replyCount
	 * @param topicId
	 */
	@Update("update bbs_topic set replyCount = #{arg0} where id = #{arg1}")
	void addOneReplyCount(Integer replyCount,String topicId);

	/**
	 * 让用户的回复总量 + 1
	 * @param replyCount
	 * @param userId
	 */
	@Update("update bbs_user set replyCount = #{arg0} where id = #{arg1}")
	void addOneReplyCount2(Integer replyCount,String userId);

	/**
	 * 让用户的帖子总量 + 1
	 * @param topicCount
	 * @param userId
	 */
	@Update("update bbs_user set topicCount = #{arg0} where id = #{arg1}")
	void addOneTopicCount(Integer topicCount,String userId);

	/**
	 * 让栏目分类表的帖子总量 + 1
	 * @param topicCount
	 * @param name
	 */
	@Update("update bbs_class set topicCount = #{arg0} where name = #{arg1}")
	void addOneTopicCount2(Integer topicCount,String name);

	/**
	 * 添加、发布帖子
	 * @param bbs_topic
	 */
	@Insert("insert into bbs_topic values(#{id},#{classId},#{specialId},#{title},#{body}," +
			"#{userId},#{enabled},#{hits},#{replyCount},#{modifiedBy},#{modifiedOn}," +
			"#{repliedBy},#{repliedOn},#{iconId},#{isClose},#{imgUrl},#{createdOn})")
	void publishArticle(Bbs_topic bbs_topic);

	/**
	 * 回复楼主的帖子
	 * @param bbs_reply
	 */
	@Insert("insert into bbs_reply values(#{id},#{topicId},#{title},#{body},#{userId}," +
			"#{modifiedOn},#{createdOn})")
	void publishReply(Bbs_reply bbs_reply);

	/**
	 * 评论别人的回复
	 * @param bbs_comment
	 */
	@Insert("insert into bbs_comment values(#{id},#{replyId},#{body},#{userId},#{buserId}," +
			"#{modifiedOn},#{createdOn})")
	void commentOneReply(Bbs_comment bbs_comment);


	/**
	 * 获取一条帖子
	 * @param topicId
	 * @return
	 */
	@Results({
			@Result(column = "id",property = "id"),
			@Result(column = "classId",property = "classId"),
			@Result(column = "title",property = "title"),
			@Result(column = "body",property = "body"),
			@Result(column = "userId",property = "userInform",
					one = @One(select = "com.hita.tata.bbs.article.dao.ArticleRepository.getUserInform")),
			@Result(column = "replyCount",property = "replyCount"),
			@Result(column = "createdOn",property = "createdOn")
	})
	@Select("select * from bbs_topic where id = #{arg0}")
	ArticleInform getArticle(String topicId);

	/**
	 * 根据用户ID获取用户的基本信息
	 * @param userId
	 * @return
	 */
	@Results({
			@Result(column = "id",property = "userId"),
			@Result(column = "userName",property = "userName"),
			@Result(column = "headUrl",property = "headUrl")
	})
	@Select("select * from bbs_user where id = #{arg0}")
	UserInform getUserInform(String userId);

}
