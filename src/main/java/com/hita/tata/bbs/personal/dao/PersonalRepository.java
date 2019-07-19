package com.hita.tata.bbs.personal.dao;
import com.hita.tata.bbs.personal.entity.ListAllArticleData;
import com.hita.tata.bbs.personal.param.response.GetUserInformResp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PersonalRepository {


	/**
	 * 根据用户ID获取用户信息
	 * @param userId
	 * @return
	 */
	@Results({
			@Result(column = "id",property = "userId"),
			@Result(column = "userName",property = "userName"),
			@Result(column = "nickName",property = "nickName"),
			@Result(column = "email",property = "email"),
			@Result(column = "headUrl",property = "headUrl"),
			@Result(column = "introduction",property = "introduction"),
			@Result(column = "signature",property = "signature"),
			@Result(column = "topicCount",property = "topicCount"),
			@Result(column = "replyCount",property = "replyCount"),
			@Result(column = "amount",property = "amount"),
			@Result(column = "createdOn",property = "createdOn")
	})
	@Select("select * from bbs_user where id = #{arg0}")
	GetUserInformResp getUserInform(String userId);

	/**
	 * 根据用户ID获取用户所有的帖子
	 * @param userId
	 * @return
	 */
	@Results({
			@Result(column = "userId",property = "userId"),
			@Result(column = "id",property = "topicId"),
			@Result(column = "title",property = "title"),
			@Result(column = "replyCount",property = "replyCount")
	})
	@Select("select * from bbs_topic where userId = #{arg0}")
	List<ListAllArticleData> listAllArticle(String userId);

}
