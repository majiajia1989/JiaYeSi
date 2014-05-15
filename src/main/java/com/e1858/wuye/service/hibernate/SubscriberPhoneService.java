package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.SubscriberPhoneDao;
import com.e1858.wuye.entity.hibernate.SubscriberPhone;

/**
 * 用户管理服务器，负责查询用户、注册用户、锁定用户等操作
 * 
 */
@Service
@Transactional
public class SubscriberPhoneService
{

	@Autowired
	private SubscriberPhoneDao subscriberPhoneDao;
	@Transactional(readOnly = true)
	public List<SubscriberPhone> querySubscriberPhoneByOpenId(String openId){
		return subscriberPhoneDao.querySubscriberPhoneByOpenId(openId);
    }
	
	public void save(SubscriberPhone subscriberPhone){
		 subscriberPhoneDao.save(subscriberPhone);
    }
	
	public void saveOrUPdate(SubscriberPhone subscriberPhone){
		 subscriberPhoneDao.saveOrUpdate(subscriberPhone);
   }
}
