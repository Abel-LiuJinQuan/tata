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
		@Result(column = "name",property = "name"),
		@Result(column = "imgUrl",property = "imgUrl")
	})
	@Select("select * from bbs_class where enabled = 1 order by createdOn asc")
	List<BlockAndUrl> listBlocks();

	/**
	 * 添加栏目分类
	 * @param bbs_class
	 */
	@Insert("insert into bbs_class values(#{bbs_class.id},#{bbs_class.parentId},#{bbs_class.name}," +
			"#{bbs_class.keyValue},#{bbs_class.sortOrder},#{bbs_class.intro},#{bbs_class.rule}," +
			"#{bbs_class.topicCount},#{bbs_class.replyCount},#{levelPath},#{bbs_class.depth}," +
			"#{bbs_class.lastTopicId},#{bbs_class.url},#{bbs_class.imgUrl},#{bbs_class.createdBy}," +
			"#{bbs_class.enabled},#{bbs_class.createdOn})")
	void addBlocks(Bbs_class bbs_class);
}
