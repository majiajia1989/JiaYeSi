package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.CommunityImageDao;
import com.e1858.wuye.entity.hibernate.CommunityImage;


@Service
@Transactional
public class CommunityImageService {

	@Autowired
	private CommunityImageDao  coummunityImageDao;

    @Transactional(readOnly = true)
	public CommunityImage queryCommunityImageById(long id){
		return coummunityImageDao.getCommunityImage(id);
	}
    
    @Transactional(readOnly = true)
	public List<CommunityImage> queryCommunityImages(long communityId){
		return coummunityImageDao.getCommunityImages(communityId);
	}
    
    @Transactional(readOnly = true)
	public CommunityImage queryCommunityWelcomeImage(long community){
		return coummunityImageDao.getCommunityWelcomeImage(community);
	}    
    
}
