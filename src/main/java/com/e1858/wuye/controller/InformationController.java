package com.e1858.wuye.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.ConsumeInfo;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.entity.hibernate.SysConsumeType;
import com.e1858.wuye.pojo.ConsumeCommand;
import com.e1858.wuye.service.hibernate.ConsumeInfoService;
import com.e1858.wuye.service.hibernate.ConsumeTypeService;

@Controller
@RequestMapping("/information")
public class InformationController
{
	@Autowired
	ConsumeTypeService consumeTypeService;
	@Autowired
	ConsumeInfoService consumeInfoService;
	
	@RequestMapping("/consume")
	public String expense(HttpServletRequest request){
		List<SysConsumeType> consumeTypes = consumeTypeService.getConsumeTypes();
		request.setAttribute(CommonConstant.CONSUME_TYPE, consumeTypes);
		return "information/consume";
	}
	
	@RequestMapping(value = "/consumeinfo" , method = RequestMethod.POST )
	public String info(HttpServletRequest request , ConsumeCommand consumeCommand)
	{
		HttpSession session  =request.getSession();
		Subscriber subscriber = (Subscriber)session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		ConsumeInfo consumeInfo = new ConsumeInfo();
		SysConsumeType consumeType = new SysConsumeType();
		consumeType.setId(consumeCommand.getConsumeID());
		int year = Integer.valueOf(consumeCommand.getMonth().substring(0,4));
		int month = Integer.valueOf(consumeCommand.getMonth().substring(4));
		consumeInfo = consumeInfoService.getConsumeInfos(subscriber.getOpenid(), consumeType, year, month);
		request.setAttribute(CommonConstant.CONSUME_INFO, consumeInfo);		
		request.setAttribute("name", consumeCommand.getMonth().substring(0,4)+ "年" + consumeCommand.getMonth().substring(4) + "月" + consumeCommand.getName());
		return "information/consumeinfo";
	}
}
