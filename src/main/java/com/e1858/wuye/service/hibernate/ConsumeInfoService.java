package com.e1858.wuye.service.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.ConsumeInfoDao;
import com.e1858.wuye.entity.hibernate.ConsumeInfo;
import com.e1858.wuye.entity.hibernate.SysConsumeType;

@Service
@Transactional
public class ConsumeInfoService {

	@Autowired
	private ConsumeInfoDao  consumeInfoDao;
    
    @Transactional(readOnly = true)
	public ConsumeInfo getConsumeInfos(String openid, SysConsumeType consumeType, int year, int month){
		return consumeInfoDao.getConsumeInfos(openid, consumeType, year, month);
	}
}
