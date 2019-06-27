package com.hita.tata.bbs.block.service;

import com.hita.tata.bbs.block.dao.BlockRepository;
import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.common.entity.bbs.block.Bbs_class;
import com.hita.tata.common.mongodb.dao.MongoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
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
	 * 获取所有栏目分类（名字 + 图标url）
	 * @return
	 */
	public List<BlockAndUrl> listBlocks() {
		return blockRepository.listBlocks();
	}

	/**
	 * 添加栏目分类
	 * @param bbs_class
	 * @param file
	 * @return
	 */
	public Bbs_class addBlocks(Bbs_class bbs_class, MultipartFile file) {
		String id = file.getOriginalFilename() + new Date().getTime();
		String url = mongoServiceImp.saveImage(file);
		bbs_class.setId(id);
		bbs_class.setImgUrl(url);
		blockRepository.addBlocks(bbs_class);
		return bbs_class;
	}

	public String addImage(MultipartFile file) throws IOException {
		operations.store(file.getInputStream(),file.getOriginalFilename());
		return mongoServiceImp.getFileUrl(file.getOriginalFilename());
//		return file.getOriginalFilename();
	}

}
