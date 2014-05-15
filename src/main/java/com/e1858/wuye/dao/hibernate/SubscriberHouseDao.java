package com.e1858.wuye.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.SubscriberHouse;


@Repository
public class SubscriberHouseDao extends BaseDao<SubscriberHouse> {
	private final String queryByOpenid = HQL_FROM + " u where u.openid = ?";

	public SubscriberHouse querySubscriberHouseByOpenId(String openId) {
		return get(queryByOpenid, openId);
	}
	
}
