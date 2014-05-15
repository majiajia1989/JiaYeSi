package com.e1858.wuye.service.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.SubscriberDao;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.pojo.SubscriberInfo;

/**
 * 用户管理服务器，负责查询用户、注册用户、锁定用户等操作
 * 
 */
@Service
@Transactional
public class SubscriberService
{

	@Autowired
	private SubscriberDao subscriberDao;

	@Transactional(readOnly = true)
	public Subscriber querySubscriberByOpenId(String openId){
		return subscriberDao.querySubscriberByOpenId(openId);
    }
	

	@Transactional(readOnly = true)
	public SubscriberInfo querySubscriberInfoByopenId(String openid)
	{
		return subscriberDao.querySubscriberInfoByopenId(openid);
	}
	
	public void update(Subscriber subscriber){
		subscriberDao.update(subscriber);
	}
	
	public void merge(Subscriber subscriber){
		subscriberDao.merge(subscriber);
	}
	
	public void save(Subscriber subscriber){
		subscriberDao.save(subscriber);
	}
}
