package com.hita.tata.web;

import com.hita.tata.common.mongodb.dao.MongoServiceImp;
import com.hita.tata.common.mongodb.entity.FileInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping(value = "test")
public class Test {
	@Autowired
	private MongoServiceImp mongoServiceImp;

	@RequestMapping(
			value = {"test"},
			method = RequestMethod.POST
	)
	public FileInfo test(@RequestBody MultipartFile file) {
		try {
			return mongoServiceImp.saveFile(file);
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
