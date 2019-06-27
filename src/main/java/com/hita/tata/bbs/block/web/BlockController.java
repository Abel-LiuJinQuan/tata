package com.hita.tata.bbs.block.web;

import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.bbs.block.service.BlockService;
import com.hita.tata.common.entity.bbs.block.Bbs_class;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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

	/**
	 * 添加栏目分类
	 * @param bbs_class
	 * @param file
	 * @return
	 */
	@RequestMapping(
			value = {"addBlock"},
			method = RequestMethod.POST
	)
	public Bbs_class addBlocks(@RequestBody Bbs_class bbs_class, @RequestBody MultipartFile file) {
		return blockService.addBlocks(bbs_class,file);
	}

	/**
	 * 修改栏目信息
	 */
	@RequestMapping(
			value = {"updateBlock"},
			method = RequestMethod.POST
	)
	public void updateBlock() {

	}

	/**
	 * 删除一个栏目
	 */
	@RequestMapping(
			value = {"deleteBlock"},
			method = RequestMethod.POST
	)
	public void deleteBlock() {

	}

	/**
	 * 获取所有栏目名
	 */
	@RequestMapping(
			value = {"listBlockName"},
			method = RequestMethod.POST
	)
	public void listBlockName() {

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
