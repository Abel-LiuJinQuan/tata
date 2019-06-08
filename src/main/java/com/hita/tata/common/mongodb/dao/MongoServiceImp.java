package com.hita.tata.common.mongodb.dao;

import com.hita.tata.common.mongodb.entity.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.gridfs.GridFsOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * Mongo操作实现类
 * @author abel
 */
@Service
public class MongoServiceImp implements MongoService {

	@Autowired
	protected GridFsOperations operations;

//	@Value("${data.mongodb.host}")
//	private String host;
//	@Value("${data.mongodb.prefix}")
//	private String prefix;
//	@Value("${data.mongodb.project}")
//	private String project;


	/**
	 * 存储图片，并返回URL
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Override
	public String saveImage(MultipartFile file) {
		try {
			FileInfo fileInfo = saveFile(file);
			return getFileUrl(fileInfo.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
			return  null;
		}
	}

	/**
	 * 保存文件，返回文件信息
	 * @param file
	 * @return
	 * @throws IOException
	 */
	@Override
	public FileInfo saveFile(MultipartFile file) throws IOException {
		String fileName = new Date().getTime() + "-" + file.getOriginalFilename();
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileName(fileName);
		fileInfo.setSize(file.getSize());
		fileInfo.setPath(fileName);
		operations.store(file.getInputStream(), fileName);
		return fileInfo;
	}

	/**
	 * 获取文件url
	 * @param fileName
	 * @return
	 */
	@Override
	public String getFileUrl(String fileName) {
		//从配置文件中获取
		StringBuilder host = new StringBuilder("129.204.203.97");
		StringBuilder prefix = new StringBuilder("tata");
		StringBuilder project = new StringBuilder("test");

		//拼接成新的url
		StringBuilder result = new StringBuilder();
		result.append("http://" + host);
		result.append("/");
//		result.append(prefix);
//		result.append("/");
//		result.append(project);
//		result.append("/");
		result.append(fileName);

		return result.toString();
	}


}
