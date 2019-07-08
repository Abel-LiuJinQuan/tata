package com.hita.tata.bbs.article.dao;

import com.hita.tata.common.entity.bbs.Article.Bbs_reply;
import com.hita.tata.common.entity.bbs.Article.Bbs_topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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
}
