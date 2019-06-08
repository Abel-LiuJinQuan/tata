package com.hita.tata.bbs.block.service;

import com.hita.tata.bbs.block.dao.BlockRepository;
import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 论坛版块方法类
 */
@Service
public class BlockService {

	@Autowired
	private BlockRepository blockRepository;

	/**
	 * 获取所有栏目分类（名字 + 图标url）
	 * @return
	 */
	public List<BlockAndUrl> listBlocks() {
		return blockRepository.listBlocks();
	}

}
