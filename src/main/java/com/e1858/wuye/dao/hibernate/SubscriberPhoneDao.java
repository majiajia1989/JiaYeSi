package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.SubscriberPhone;


@Repository
public class SubscriberPhoneDao extends BaseDao<SubscriberPhone> {
	private final String queryByOpenid = HQL_FROM + " u where u.openid = ?";

	public List<SubscriberPhone> querySubscriberPhoneByOpenId(String openId) {
		return find(queryByOpenid, openId);
	}
}
