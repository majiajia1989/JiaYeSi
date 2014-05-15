package com.e1858.wuye.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1858.wechat.api.json.user.UserInfo;
import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.ServicePhone;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.service.hibernate.ServicePhoneService;
import com.e1858.wuye.service.hibernate.SubscriberService;

@Controller
@RequestMapping("/community")
public class ServicePhoneController
{
	@Autowired
	private ServicePhoneService servicePhoneService;
	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping("/telephone")
	public String telephone(HttpServletRequest request){
		HttpSession session  =request.getSession();
		Subscriber subscriber = (Subscriber)session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		request.setAttribute(CommonConstant.SERVICE_PHONE, servicePhoneService.queryServicePhoneByCorp(subscriber.getCorp(),subscriber.getCommunity()));
		return "community/telephone";
	}		
}
