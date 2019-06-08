package com.hita.tata.bbs.block.service;

import com.hita.tata.bbs.block.dao.BlockRepository;
import com.hita.tata.bbs.block.param.response.BlockAndUrl;
import com.hita.tata.common.mongodb.dao.MongoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
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

	public String addImage(MultipartFile file) throws IOException {
		operations.store(file.getInputStream(),file.getOriginalFilename());
		return mongoServiceImp.getFileUrl(file.getOriginalFilename());
//		return file.getOriginalFilename();
	}

}
