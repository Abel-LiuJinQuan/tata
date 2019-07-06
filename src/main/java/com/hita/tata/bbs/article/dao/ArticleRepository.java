package com.hita.tata.bbs.article.dao;

import com.hita.tata.common.entity.bbs.Article.Bbs_topic;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * 帖子数据库操作方法类
 * @author abel
 */
@Mapper
public interface ArticleRepository {

	/**
	 * 添加、发布帖子
	 * @param bbs_topic
	 */
	@Insert("insert into bbs_topic values(#{id},#{classId},#{specialId},#{title},#{body}," +
			"#{userId},#{enabled},#{hits},#{replyCount},#{modifiedBy},#{modifiedOn}," +
			"#{repliedBy},#{repliedOn},#{iconId},#{isClose},#{imgUrl},#{createdOn})")
	void publishArticle(Bbs_topic bbs_topic);
}
