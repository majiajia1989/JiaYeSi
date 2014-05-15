package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.HouseFloor;


@Repository
public class HouseFloorDao extends BaseDao<HouseFloor> {
	private final String queryByHouse = HQL_FROM + " a where a.house = ?";
	private final String queryByCommunity = HQL_FROM + " a where a.community = ?";
	private final String queryByOpenid = "select a from HouseFloor a ,SubscriberHouse b where a.id = b.houseFloor and b.openid = ? ";
	
	public List<HouseFloor> queryHouseFloorByHouse(long house) {
		return find(queryByHouse, house);
	}
	
	public List<HouseFloor> queryHouseFloorByCommunity(long community ) {
		return find(queryByCommunity, community);
	}
	
	public HouseFloor queryHouseFloorByOpenid(String openid) {
		return get(queryByOpenid, openid);
	}
}
