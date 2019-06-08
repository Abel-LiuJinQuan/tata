package com.hita.tata.bbs.block.web;

import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.bbs.block.service.BlockService;
import com.hita.tata.common.entity.bbs.block.Bbs_class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 论坛版块部分controller
 * @author abel
 */
@RestController
@RequestMapping(value = "block")
public class BlockController {

	@Autowired
	private BlockService blockService;

	/**
	 * 获取所有栏目分类（名字 + 图标url）
	 * @return
	 */
	@RequestMapping(
			value = {"listBlocks"},
			method = RequestMethod.POST
	)
	public List<BlockAndUrl> listBlocks() {
		return blockService.listBlocks();
	}

}
