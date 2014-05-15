package com.e1858.wuye.interceptor;

import java.net.URLEncoder;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.Weixin_UserInfo;
import com.e1858.wuye.exception.OAuth2Exception;
import com.e1858.wuye.service.hibernate.SubscriberService;
import com.e1858.wuye.service.hibernate.Weixin_UserInfoService;

public class OAuth2Interceptor implements HandlerInterceptor
{
	@Autowired
	SubscriberService subscriberService;

	private static final Logger logger = Logger.getLogger("web");

	// 不拦截URL
	private List<String> excludedUrls;
	// 认证页面
	private String authUrl;
	// 调试标志
	private String openid="otVG5uIJauQ1Jz184SGRnNO1J2Ng";
	// 调试标志
	private boolean debug = false;

	// Action之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception
	{
		String requestUri = request.getRequestURL().toString();
		String queryString = request.getQueryString();
		if (!StringUtils.isEmpty(queryString))
		{
			requestUri = requestUri.concat("?").concat(queryString);
		}
		String agent = request.getHeader("User-Agent");
		String ip = request.getRemoteAddr();
		logger.info("request:\n".concat(requestUri).concat("\nUser-Agent:\n").concat(agent).concat("\nip:\n").concat(ip));
		for (String url : excludedUrls)
		{
			if (!StringUtils.isEmpty(url) && requestUri.endsWith(url))
			{
				return true;
			}
		}

		HttpSession session = request.getSession();
		if (session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER) == null)
		{
			logger.info("subscriber is null");
			if (debug)
			{
				session.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER,subscriberService.querySubscriberByOpenId(openid));
				return true;
			}
			else
			{
				if (!StringUtils.isEmpty(authUrl))
				{
					response.sendRedirect(request.getContextPath() + authUrl + URLEncoder.encode(requestUri, CommonConstant.ENCODING));
					return false;
				}
				else
				{
					throw new OAuth2Exception(requestUri);
				}
			}
		}
		else
		{
			logger.info("subscriber is not null");
			return true;
		}
	}

	// 生成视图之前执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception ex) throws Exception
	{
	}

	// 最后执行，可用于释放资源
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object object, ModelAndView modelandView) throws Exception
	{
	}

	public List<String> getExcludedUrls()
	{
		return excludedUrls;
	}

	public void setExcludedUrls(List<String> excludedUrls)
	{
		this.excludedUrls = excludedUrls;
	}

	public String getAuthUrl()
	{
		return authUrl;
	}

	public void setAuthUrl(String authUrl)
	{
		this.authUrl = authUrl;
	}

	public boolean isDebug()
	{
		return debug;
	}

	public void setDebug(boolean debug)
	{
		this.debug = debug;
	}

	public String getOpenid()
	{
		return openid;
	}

	public void setOpenid(String openid)
	{
		this.openid = openid;
	}


}
