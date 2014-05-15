package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.House;
import com.e1858.wuye.entity.hibernate.ServicePhone;


@Repository
public class HouseDao extends BaseDao<House> {
	private final String queryByCommunity = HQL_FROM + " a where a.community = ?";
	private final String queryByOpenid = "select a from House a ,SubscriberHouse b where a.id = b.house and b.openid = ? ";

	public List<House> queryHouseByCommunit(long community) {
		return find(queryByCommunity, community);
	}
	
	public House queryHouseByOpenid(String openid) {
		return get(queryByOpenid, openid);
	}
}
