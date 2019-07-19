package com.hita.tata.bbs.personal.web;

import com.hita.tata.bbs.personal.param.request.ListAllArticle;
import com.hita.tata.bbs.personal.service.PersonalService;
import com.hita.tata.common.entity.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
	 * 根据用户ID获取用户所有的帖子（分页）(已测试)
	 * @param listAllArticle
	 * @return
	 */
	@RequestMapping(
			value = {"listAllArticle"},
			method = RequestMethod.POST
	)
	public ResponseMessage listAllArticle(@ModelAttribute ListAllArticle listAllArticle) {
		return personalService.listAllArticle(listAllArticle);
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
