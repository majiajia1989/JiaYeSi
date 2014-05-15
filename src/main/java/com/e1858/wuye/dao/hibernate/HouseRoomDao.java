package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.HouseRoom;


@Repository
public class HouseRoomDao extends BaseDao<HouseRoom> {
	private final String queryByHouse = HQL_FROM + " a where a.house = ?";
	private final String queryByCommunity = HQL_FROM + " a where a.community = ?";
	private final String queryByOpenid = "select a from HouseRoom a ,SubscriberHouse b where a.id = b.houseRoom and b.openid = ? ";
	
	public List<HouseRoom> queryHouseRoomByHouse(long house) {
		return find(queryByHouse, house);
	}
	
	public List<HouseRoom> queryHouseRoomByCommunity(long community ) {
		return find(queryByCommunity, community);
	}
	
	public HouseRoom queryHouseRoomByOpenid(String openid) {
		return get(queryByOpenid, openid);
	}
}
