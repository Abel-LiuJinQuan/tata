package com.hita.tata.bbs.block.service;

import com.hita.tata.bbs.block.dao.BlockRepository;
import com.hita.tata.bbs.block.param.response.AddBlockResp;
import com.hita.tata.common.entity.bbs.block.Bbs_class;
import com.hita.tata.common.entity.response.Constant;
import com.hita.tata.common.entity.response.ResponseMessage;
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
	public ResponseMessage listBlocks() {
		List list = blockRepository.listBlocks();
		//如果获取的数量为0
		if(list.size() == 0) {
			return ResponseMessage.newErrorInstance(Constant.ERROR);
		} else {
			return ResponseMessage.newOkInstance(list,Constant.SUCCESS);
		}
	}

	/**
	 * 添加栏目分类
	 * @param
	 * @param file
	 * @return
	 */
	public ResponseMessage addBlocks(MultipartFile file,String name,String parentName) {

		String filename = file.getOriginalFilename();
		//判断是否为图片
		if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".gif")
				|| filename.endsWith(".jpeg") || filename.endsWith(".JPG") || filename.endsWith(".PNG")
				|| filename.endsWith(".GIF") || filename.endsWith(".JPEG")) {

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
			return ResponseMessage.newOkInstance(addBlockResp,Constant.SUCCESS);
		} else {
			return ResponseMessage.newErrorInstance(Constant.ERROR);
		}
	}

	/**
	 * 修改栏目信息
	 * @param file
	 * @param id
	 * @param name
	 * @param parentName
	 * @return
	 */
	public ResponseMessage updateBlock(MultipartFile file,String id,String name,String parentName) {
		String filename = file.getOriginalFilename();
		//判断是否为图片
		if (filename.endsWith(".jpg") || filename.endsWith(".png") || filename.endsWith(".gif")
				|| filename.endsWith(".jpeg") || filename.endsWith(".JPG") || filename.endsWith(".PNG")
				|| filename.endsWith(".GIF") || filename.endsWith(".JPEG")) {

			//栏目logo图片的URL
			String url = mongoServiceImp.saveImage(file);
			//返回给前端的数据
			AddBlockResp addBlockResp = new AddBlockResp();
			addBlockResp.setId(id);
			addBlockResp.setName(name);
			addBlockResp.setParentName(parentName);
			addBlockResp.setImgUrl(url);
			blockRepository.updateBlock(id, name, parentName, url);
			return ResponseMessage.newOkInstance(addBlockResp,Constant.SUCCESS);
		} else {
			return ResponseMessage.newErrorInstance(Constant.ERROR);
		}
	}


	public String addImage(MultipartFile file) throws IOException {
		operations.store(file.getInputStream(),file.getOriginalFilename());
		return mongoServiceImp.getFileUrl(file.getOriginalFilename());
//		return file.getOriginalFilename();
	}

}
