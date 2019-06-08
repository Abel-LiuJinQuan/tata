package com.hita.tata.web;

import com.hita.tata.common.mongodb.dao.MongoServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(value = "test")
public class Test {
	@Autowired
	private MongoServiceImp mongoServiceImp;

	@RequestMapping(
			value = {"test"},
			method = RequestMethod.POST
	)
	public String test(@RequestBody MultipartFile file) {
			return mongoServiceImp.saveImage(file);
	}

}
