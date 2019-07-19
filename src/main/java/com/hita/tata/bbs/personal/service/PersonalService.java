package com.hita.tata.bbs.personal.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hita.tata.bbs.personal.dao.PersonalRepository;
import com.hita.tata.bbs.personal.entity.ListAllArticleData;
import com.hita.tata.bbs.personal.param.request.ListAllArticle;
import com.hita.tata.bbs.personal.param.response.GetUserInformResp;
import com.hita.tata.bbs.personal.param.response.ListAllArticleResp;
import com.hita.tata.common.entity.response.Constant;
import com.hita.tata.common.entity.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalService {

	@Autowired
	private PersonalRepository personalRepository;


	/**
	 * 根据用户ID获取用户信息
	 * @param userId
	 * @return
	 */
	public ResponseMessage getUserInform(String userId){
		GetUserInformResp getUserInformResp = personalRepository.getUserInform(userId);
		return ResponseMessage.newOkInstance(getUserInformResp,Constant.SUCCESS);
	}

	/**
	 * 根据用户ID获取用户所有的帖子（分页）
	 * @param listAllArticle
	 * @return
	 */
	public ResponseMessage listAllArticle(ListAllArticle listAllArticle) {
		//确定获取第几页，并规定每一页的大小
		PageHelper.startPage(listAllArticle.getPageNum(),listAllArticle.getPageSize());
		//获取该用户的所有帖子信息
		List<ListAllArticleData> listAllArticleData = personalRepository.listAllArticle(listAllArticle.getUserId());
		PageInfo<ListAllArticleData> info = new PageInfo<>(listAllArticleData);
		//返回给前端的数据
		ListAllArticleResp listAllArticleResp = new ListAllArticleResp();
		listAllArticleResp.setListAllArticleData(listAllArticleData);
		listAllArticleResp.setTotal((int)info.getTotal());
		listAllArticleResp.setPageNum(listAllArticle.getPageNum());
		listAllArticleResp.setPageSize(listAllArticle.getPageSize());
		return ResponseMessage.newOkInstance(listAllArticleResp,Constant.SUCCESS);
	}

}
