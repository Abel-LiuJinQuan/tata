package com.hita.tata.bbs.personal.service;

import com.hita.tata.bbs.personal.dao.PersonalRepository;
import com.hita.tata.bbs.personal.param.response.GetUserInformResp;
import com.hita.tata.common.entity.response.Constant;
import com.hita.tata.common.entity.response.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
