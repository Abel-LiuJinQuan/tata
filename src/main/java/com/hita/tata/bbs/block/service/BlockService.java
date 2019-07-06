package com.hita.tata.bbs.block.service;

import com.hita.tata.bbs.block.dao.BlockRepository;
import com.hita.tata.bbs.block.param.response.AddBlockResp;
import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.common.entity.bbs.block.Bbs_class;
import com.hita.tata.common.mongodb.dao.MongoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * 论坛版块方法类
 */
@Service
public class BlockService {

	@Autowired
	private BlockRepository blockRepository;
	@Autowired
	protected GridFsOperations operations;
	@Autowired
	protected MongoServiceImp mongoServiceImp;

	/**
	 * 获取所有栏目分类（栏目名 + 图标url）
	 * @return
	 */
	public List<BlockAndUrl> listBlocks() {
		return blockRepository.listBlocks();
	}

	/**
	 * 添加栏目分类
	 * @param
	 * @param file
	 * @return
	 */
	public AddBlockResp addBlocks(MultipartFile file,String name,String parentName) {
		Date dateTime = new Date();
		//栏目ID
		String id = file.getOriginalFilename() + dateTime.getTime();
		//栏目logo图片的URL
		String url = mongoServiceImp.saveImage(file);
		//返回给前端的数据
		AddBlockResp addBlockResp = new AddBlockResp();
		addBlockResp.setId(id);
		addBlockResp.setImgUrl(url);
		addBlockResp.setName(name);
		addBlockResp.setParentName(parentName);
		addBlockResp.setCreatedOn(dateTime);
		//存进数据库的数据
		Bbs_class bbs_class = new Bbs_class();
		bbs_class.setId(id);
		bbs_class.setParentId(parentName);
		bbs_class.setName(name);
		bbs_class.setTopicCount(0);
		bbs_class.setReplyCount(0);
		bbs_class.setImgUrl(url);
		bbs_class.setEnabled("1");
		bbs_class.setCreatedOn(dateTime);
		//添加进数据库
		blockRepository.addBlocks(bbs_class);
		return addBlockResp;
	}

	public AddBlockResp updateBlock(MultipartFile file,String id,String name,String parentName) {
		//栏目logo图片的URL
		String url = mongoServiceImp.saveImage(file);
		//返回给前端的数据
		AddBlockResp addBlockResp = new AddBlockResp();
		addBlockResp.setId(id);
		addBlockResp.setName(name);
		addBlockResp.setParentName(parentName);
		addBlockResp.setImgUrl(url);
		blockRepository.updateBlock(id,name,parentName,url);
		return addBlockResp;
	}


	public String addImage(MultipartFile file) throws IOException {
		operations.store(file.getInputStream(),file.getOriginalFilename());
		return mongoServiceImp.getFileUrl(file.getOriginalFilename());
//		return file.getOriginalFilename();
	}

}
