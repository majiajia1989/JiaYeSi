package com.e1858.wuye.service.hibernate;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.SubscriberHouseDao;
import com.e1858.wuye.entity.hibernate.SubscriberHouse;

/**
 * 用户管理服务器，负责查询用户、注册用户、锁定用户等操作
 * 
 */
@Service
@Transactional
public class SubscriberHouseService
{

	@Autowired
	private SubscriberHouseDao subscriberHouseDao;
	@Transactional(readOnly = true)
	public SubscriberHouse querySubscriberHouseByOpenId(String openId){
		return subscriberHouseDao.querySubscriberHouseByOpenId(openId);
    }
	
	public void save(SubscriberHouse subscriberHouse){
		ArrayList<Object> params = new ArrayList<Object>();
		params.add(subscriberHouse.getOpenid());
		params.add(subscriberHouse.getHouse());
		params.add(subscriberHouse.getHouseUnit());
		params.add(subscriberHouse.getHouseFloor());
		params.add(subscriberHouse.getHouseRoom());
		subscriberHouseDao.callStorePrecure("call p_subscriberHouse(?,?,?,?,?)", params);
    }
	
	public void saveOrUPdate(SubscriberHouse subscriberHouse){
		 subscriberHouseDao.saveOrUpdate(subscriberHouse);
   }
}
