package com.hita.tata.bbs.personal.web;

import com.hita.tata.bbs.personal.service.PersonalService;
import com.hita.tata.common.entity.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户个人主页部分
 */
@RestController
@RequestMapping(value = "personal")
public class PersonalController {

	@Autowired
	private PersonalService  personalService;

	/**
	 * 根据用户ID获取用户信息(已测试)
	 * @param userId
	 * @return
	 */
	@RequestMapping(
			value = {"getUserInform/{userId}"},
			method = RequestMethod.POST
	)
	public ResponseMessage getUserInform(@PathVariable String userId) {
		return personalService.getUserInform(userId);
	}

	/**
	 * 获取已发布的帖子
	 */
	@RequestMapping(
			value = {"listPublishedArticle"},
			method = RequestMethod.POST
	)
	public void  listPublishedArticle() {

	}

	/**
	 * 获取草稿箱的帖子
	 */
	@RequestMapping(
			value = {"listDraftsArticle"},
			method = RequestMethod.POST
	)
	public void listDraftsArticle() {

	}

	/**
	 * 获取自己所有的帖子
	 */
	@RequestMapping(
			value = {"listAllArticle"},
			method = RequestMethod.POST
	)
	public void listAllArticle() {

	}

	/**
	 * 获取自己写的所有评论
	 */
	@RequestMapping(
			value = {"listAllComment"},
			method = RequestMethod.POST
	)
	public void listAllComment() {

	}

	/**
	 * 修改个人信息
	 */
	@RequestMapping(
			value = {"updateUserInform"},
			method = RequestMethod.POST
	)
	public void updateUserInform() {

	}
}
