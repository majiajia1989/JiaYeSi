package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.HouseUnit;


@Repository
public class HouseUnitDao extends BaseDao<HouseUnit> {
	private final String queryByHouse = HQL_FROM + " a where a.house = ?";
	private final String queryByCommunity = HQL_FROM + " a where a.community = ?";
	private final String queryByOpenid = "select a from HouseUnit a ,SubscriberHouse b where a.id = b.houseUnit and b.openid = ? ";
	
	public List<HouseUnit> queryHouseUnitByHouse(long house) {
		return find(queryByHouse, house);
	}
	
	public List<HouseUnit> queryHouseUnitByCommunity(long community ) {
		return find(queryByCommunity, community);
	}
	
	public HouseUnit queryHouseUnitByOpenid(String openid) {
		return get(queryByOpenid, openid);
	}
}
