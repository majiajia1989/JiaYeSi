package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.SubscriberCar;

@Repository
public class SubscriberCarDao extends BaseDao<SubscriberCar> {
	
	private final String queryByOpenid = HQL_FROM + " u where u.openid = ?";

	public List<SubscriberCar> querySubscriberCarByOpenId(String openId) {
		return find(queryByOpenid, openId);
	}
}
