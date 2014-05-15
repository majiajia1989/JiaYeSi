package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.HouseDao;
import com.e1858.wuye.entity.hibernate.House;

@Service
@Transactional
public class HouseService
{

	@Autowired
	private HouseDao houseDao;
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#community" + "_houseByCommunity")
	public List<House> queryHouseByCommunit(long community){
		return houseDao.queryHouseByCommunit(community);
    }
	
	@Transactional(readOnly = true)
	@Cacheable(value = "House", key = "#openid" + "_houseByOpenid")
	public House queryHouseByOpenid(String openid){
		return houseDao.queryHouseByOpenid(openid);
    }
}
