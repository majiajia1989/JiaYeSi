package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.HouseRoomDao;
import com.e1858.wuye.entity.hibernate.HouseRoom;


@Service
@Transactional
public class HouseRoomService
{

	@Autowired
	private HouseRoomDao HouseRoomDao;
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#house" + "_roomByHouse")
	public List<HouseRoom> queryHouseRoomByHouse(long house){
		return HouseRoomDao.queryHouseRoomByHouse(house);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#community" + "_roomByCommunicty")
	public List<HouseRoom> queryHouseRoomByCommunity(long community){
		return HouseRoomDao.queryHouseRoomByCommunity(community);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#openid" + "_roomByOpenid")
	public HouseRoom queryHouseRoomByOpenid(String openid){
		return HouseRoomDao.queryHouseRoomByOpenid(openid);
    }
}
