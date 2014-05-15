package com.e1858.wuye.dao.hibernate;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.ConsumeInfo;
import com.e1858.wuye.entity.hibernate.SysConsumeType;

@Repository("consumeInfoDao")
public class ConsumeInfoDao extends BaseDao<ConsumeInfo> {
	private final String GET_CONSUMEINFOS = " select u from ConsumeInfo u ,SubscriberHouse p where u.community = p.community and u.house = p.house and u.houseRoom=p.houseRoom and p.openid = ? and u.consumeType = ? ";

	public ConsumeInfo getConsumeInfos(String openid, SysConsumeType consumeType, int year, int month) {
		String hql = GET_CONSUMEINFOS + " and u.year = ? and u.month = ?";
		return get(hql, openid, consumeType, year, month);
	}
}
