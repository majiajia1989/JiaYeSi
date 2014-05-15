package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.SubscriberCarDao;
import com.e1858.wuye.entity.hibernate.SubscriberCar;

@Service
@Transactional
public class SubscriberCarService
{
	@Autowired
	private SubscriberCarDao subscriberCarDao;
	
	@Transactional(readOnly = true)
	public List<SubscriberCar> querySubscriberCarByOpenId(String openId){
		return subscriberCarDao.querySubscriberCarByOpenId(openId);
    }
	
	public void save(SubscriberCar subscriberCar)
	{
		subscriberCarDao.save(subscriberCar);
	}
}