package com.hita.tata.bbs.block.web;

import com.hita.tata.bbs.block.param.response.AddBlockResp;
import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.bbs.block.service.BlockService;
import com.hita.tata.common.entity.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 论坛栏目部分
 * @author abel
 */
@RestController
@RequestMapping(value = "block")
public class BlockController {

	@Autowired
	private BlockService blockService;

	/**
	 * 获取所有栏目，并排序返回 （已测试）
	 * @return 栏目名 + 图标url
	 */
	@RequestMapping(
			value = {"listBlocks"},
			method = RequestMethod.POST
	)
	public ResponseMessage listBlocks() {
		return blockService.listBlocks();
	}

	/**
	 * 添加栏目 （已测试）
	 * @param file logo图片
	 * @param name 栏目名
	 * @param parentName 栏目所属频道
	 * @return
	 */
	@RequestMapping(
			value = {"addBlock"},
			method = RequestMethod.POST
	)
	public ResponseMessage addBlocks(@RequestParam("file") MultipartFile file,String name,String parentName) {
		return blockService.addBlocks(file,name,parentName);
	}

	/**
	 * 修改栏目信息 （已测试）
	 * @param file logo图片
	 * @param id 栏目所属频道
	 * @param name 栏目名
	 * @param parentName 栏目所属频道
	 * @return
	 */
	@RequestMapping(
			value = {"updateBlock"},
			method = RequestMethod.POST
	)
	public ResponseMessage updateBlock(@RequestParam("file") MultipartFile file,String id,String name,String parentName) {
		return blockService.updateBlock(file,id,name,parentName);
	}

//	/**
//	 * 添加图片并返回URL
//	 * @param file
//	 * @return
//	 * @throws IOException
//	 */
//	@RequestMapping(
//			value = {"add"},
//			method = RequestMethod.POST
//	)
//	public String add(@RequestBody MultipartFile file) throws IOException {
//		return blockService.addImage(file);
//	}

}
