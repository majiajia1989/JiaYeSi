package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.HouseFloorDao;
import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.HouseFloor;


@Service
@Transactional
public class HouseFloorService
{

	@Autowired
	private HouseFloorDao HouseFloorDao;
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#house" + "_floorByHouse")
	public List<HouseFloor> queryHouseFloorByHouse(long house){
		return HouseFloorDao.queryHouseFloorByHouse(house);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key =  "#community" + "_floorByCommunicty")
	public List<HouseFloor> queryHouseFloorByCommunity(long community){
		return HouseFloorDao.queryHouseFloorByCommunity(community);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#openid" + "_floorByOpenid")
	public HouseFloor queryHouseFloorByOpenid(String openid){
		return HouseFloorDao.queryHouseFloorByOpenid(openid);
    }
}
