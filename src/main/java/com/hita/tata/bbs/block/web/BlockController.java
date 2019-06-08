package com.hita.tata.bbs.block.web;

import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.bbs.block.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

	@RequestMapping(
			value = {"add"},
			method = RequestMethod.POST
	)
	public String add(@RequestBody MultipartFile file) throws IOException {
		return blockService.addImage(file);
	}

}
