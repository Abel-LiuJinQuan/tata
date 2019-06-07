package com.hita.tata.common.mongodb.dao;

import com.hita.tata.common.mongodb.entity.FileInfo;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Mongo操作接口类
 */
@Service
public interface MongoService {
	String saveImage(MultipartFile file) throws IOException;
	FileInfo saveFile(MultipartFile file) throws IOException;
	String getFileUrl(String fileName);
}
