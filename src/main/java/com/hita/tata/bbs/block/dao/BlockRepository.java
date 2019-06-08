package com.hita.tata.bbs.block.dao;

import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BlockRepository {

	/**
	 * 获取所有栏目分类（名字 + 图标url）
	 * @return
	 */
	@Results({
		@Result(column = "name",property = "name"),
		@Result(column = "imgUrl",property = "imgUrl")
	})
	@Select("select * from bbs_class where enabled = 1")
	List<BlockAndUrl> listBlocks();
}
