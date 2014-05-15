package com.e1858.wuye.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.CommunityImage;
import com.e1858.wuye.entity.hibernate.NoticeReceiver;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.service.hibernate.CommunityImageService;
import com.e1858.wuye.service.hibernate.CommunityService;
import com.e1858.wuye.service.hibernate.NoticeReceiverService;
import com.e1858.wuye.service.hibernate.SubscriberService;

@Controller
@RequestMapping("/community")
public class CommunityConntroller
{
	@Autowired
	CommunityImageService communityImageService;

	@RequestMapping("/service")
	public String service(HttpServletRequest request)
	{

		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<CommunityImage> communityImages = communityImageService.queryCommunityImages(subscriber.getCommunity().getId());
		request.setAttribute(CommonConstant.COMMUNITY_IMAGE, communityImages);

		return "community/service";
	}

}
