package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.HouseUnitDao;
import com.e1858.wuye.entity.hibernate.HouseUnit;


@Service
@Transactional
public class HouseUnitService
{

	@Autowired
	private HouseUnitDao houseUnitDao;
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#house" + "_unitByHouse")
	public List<HouseUnit> queryHouseUnitByHouse(long house){
		return houseUnitDao.queryHouseUnitByHouse(house);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#community" +"_unitByCommunity")
	public List<HouseUnit> queryHouseUnitByCommunity(long community){
		return houseUnitDao.queryHouseUnitByCommunity(community);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#openid" + "_unitByOpenid")
	public HouseUnit queryHouseUnitByOpenid(String openid){
		return houseUnitDao.queryHouseUnitByOpenid(openid);
    }
}
