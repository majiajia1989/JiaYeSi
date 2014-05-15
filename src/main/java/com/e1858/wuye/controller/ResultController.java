package com.e1858.wuye.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1858.wuye.common.CommonConstant;

@Controller
@RequestMapping("/result")
public class ResultController
{

	@RequestMapping("/success")
	public String success(HttpServletRequest request)
	{
		String successMsg=request.getParameter("successMsg");
		String backUrl = request.getParameter("backUrl");
		if(StringUtils.isNotEmpty(successMsg))
		{
			request.setAttribute(CommonConstant.MSG_SUCCESS, successMsg);
		}
		if(StringUtils.isNotEmpty(backUrl))
		{
			request.setAttribute(CommonConstant.URL_BACK, backUrl);
		}
		return "result/success";
	}

	@RequestMapping("/error")
	public String error(HttpServletRequest request)
	{
		String errorMsg=request.getParameter("errorMsg");
		String backUrl = request.getParameter("backUrl");
		if(StringUtils.isNotEmpty(errorMsg))
		{
			request.setAttribute(CommonConstant.MSG_ERROR, errorMsg);
		}
		if(StringUtils.isNotEmpty(backUrl))
		{
			request.setAttribute(CommonConstant.URL_BACK, backUrl);
		}
		return "result/error";
	}

}
