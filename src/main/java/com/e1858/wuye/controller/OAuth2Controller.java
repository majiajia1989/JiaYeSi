package com.e1858.wuye.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.e1858.wechat.api.ApiOauth;
import com.e1858.wechat.api.json.oauth.Access_Token;
import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.common.Wechat;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.entity.hibernate.Weixin_GongHao;
import com.e1858.wuye.entity.hibernate.Weixin_UserInfo;
import com.e1858.wuye.service.hibernate.SubscriberService;
import com.e1858.wuye.service.hibernate.Weixin_UserInfoService;
import com.e1858.wuye.service.hibernate.Weixin_GongHaoService;

@Controller
@RequestMapping("/OAuth2")
public class OAuth2Controller
{
	@Autowired
	SubscriberService subscriberService;
	
	
	@Autowired
	Weixin_GongHaoService weixin_GongHaoService;

	@RequestMapping("/auth")
	public String auth(HttpServletRequest request, @RequestParam String state)
	{
		String url = request.getRequestURL().toString();
		url = url.substring(0, url.lastIndexOf("/") + 1) + "code";
		Weixin_GongHao weixin_GongHao = weixin_GongHaoService.getGongHao();
		return "redirect:".concat(ApiOauth.codeUrl_snsapi_base(weixin_GongHao.getAppId(), url, state));
	}

	@RequestMapping("/code")
	public String code(HttpServletRequest request, @RequestParam String code, @RequestParam String state)
	{
		HttpSession session = request.getSession();
		Weixin_GongHao weixin_GongHao = weixin_GongHaoService.getGongHao();
		Access_Token access_Token = ApiOauth.access_token(weixin_GongHao.getAppId(), weixin_GongHao.getAppSecret(), code);
		if (0 == access_Token.getErrcode())
		{
			Subscriber subscriber = subscriberService.querySubscriberByOpenId(access_Token.getOpenid());
			session.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER, subscriber);
			session.setAttribute(CommonConstant.CONTEXT_COMMUNITY, subscriber.getCommunity());
		}
		return "redirect:".concat(state);
	}
}
