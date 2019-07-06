package com.hita.tata.bbs.block.dao;

import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.common.entity.bbs.block.Bbs_class;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BlockRepository {

	/**
	 * 获取所有栏目分类（栏目名 + 图标url）
	 * @return
	 */
	@Results({
			@Result(column = "id",property = "id"),
			@Result(column = "name",property = "name"),
			@Result(column = "imgUrl",property = "imgUrl")
	})
	@Select("select * from bbs_class where enabled = 1 order by createdOn asc")
	List<BlockAndUrl> listBlocks();

	/**
	 * 添加栏目分类
	 * @param bbs_class
	 */
	@Insert("insert into bbs_class values(#{id},#{parentId},#{name}," +
			"#{keyValue},#{sortOrder},#{intro},#{rule}," +
			"#{topicCount},#{replyCount},#{levelPath},#{depth}," +
			"#{lastTopicId},#{url},#{imgUrl},#{createdBy}," +
			"#{enabled},#{createdOn})")
	void addBlocks(Bbs_class bbs_class);

	/**
	 * 修改栏目信息
	 * @param id
	 * @param name
	 * @param parentId
	 * @param imgUrl
	 */
	@Update("update bbs_class set name = #{arg1}, parentId = #{arg2}, imgUrl = #{arg3} where id = #{arg0}")
	void updateBlock(String id,String name,String parentId,String imgUrl);
}
