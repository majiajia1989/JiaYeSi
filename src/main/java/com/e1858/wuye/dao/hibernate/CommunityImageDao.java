package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.CommunityImage;

@Repository("communityImageDao")
public class CommunityImageDao extends BaseDao<CommunityImage>
{
	private final String GET_COMMUNITYIMAGE_BYCOMMUNITY = HQL_FROM + " u where u.community= ? ";
	private final String GET_COMMUNITYIMAGE_BYID = HQL_FROM + " u where u.id=?";
	private final String GET_COMMUNITYWELCOMEIMAGE = " select u from CommunityImage u,CommunityWelcomeImage p where u.id=p.image and p.community=?";

	public List<CommunityImage> getCommunityImages(long communityId)
	{
		return find(GET_COMMUNITYIMAGE_BYCOMMUNITY, communityId);
	}

	public CommunityImage getCommunityImage(long id)
	{
		return get(GET_COMMUNITYIMAGE_BYID, id);
	}
	
	public CommunityImage getCommunityWelcomeImage(long community)
	{
		return get(GET_COMMUNITYWELCOMEIMAGE, community);
	}	
	
}
