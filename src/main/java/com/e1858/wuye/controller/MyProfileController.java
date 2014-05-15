package com.e1858.wuye.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.e1858.wechat.api.json.user.UserInfo;
import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.House;
import com.e1858.wuye.entity.hibernate.HouseFloor;
import com.e1858.wuye.entity.hibernate.HouseRoom;
import com.e1858.wuye.entity.hibernate.HouseUnit;
import com.e1858.wuye.entity.hibernate.NoticeReceiver;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.entity.hibernate.SubscriberCar;
import com.e1858.wuye.entity.hibernate.SubscriberHouse;
import com.e1858.wuye.entity.hibernate.SubscriberPhone;
import com.e1858.wuye.entity.hibernate.Weixin_UserInfo;
import com.e1858.wuye.pojo.HouseInfo;
import com.e1858.wuye.pojo.RegisteCommand;
import com.e1858.wuye.pojo.UpdateUserCommand;
import com.e1858.wuye.service.hibernate.HouseFloorService;
import com.e1858.wuye.service.hibernate.HouseRoomService;
import com.e1858.wuye.service.hibernate.HouseService;
import com.e1858.wuye.service.hibernate.HouseUnitService;
import com.e1858.wuye.service.hibernate.NoticeReceiverService;
import com.e1858.wuye.service.hibernate.SubscriberCarService;
import com.e1858.wuye.service.hibernate.SubscriberPhoneService;
import com.e1858.wuye.service.hibernate.SubscriberService;
import com.e1858.wuye.service.hibernate.Weixin_UserInfoService;

@Controller
@RequestMapping("/myprofile")
public class MyProfileController
{
	@Autowired
	NoticeReceiverService noticeReceiverService;
	@Autowired
	SubscriberService subscriberService;
	@Autowired
	Weixin_UserInfoService weixin_UserInfoService;
	@Autowired
	SubscriberPhoneService subscriberPhoneService;
	@Autowired
	HouseService houseService;
	@Autowired
	HouseUnitService houseUnitService;
	@Autowired
	HouseFloorService houseFloorService;
	@Autowired
	HouseRoomService houseRoomService;

	@Autowired
	SubscriberCarService subscriberCarService;
	
	private static final Logger exceptionLogger = Logger.getLogger("exception");

	@RequestMapping("/myprofile")
	public String index(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		request.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER_INFO, subscriberService.querySubscriberInfoByopenId(subscriber.getOpenid()));
		request.setAttribute(CommonConstant.CONTEXT_USER_INFO, weixin_UserInfoService.getUserInfoByOpenid(subscriber.getOpenid()));

		return "myprofile/myprofile";
	}

	@RequestMapping(value = "/editMyprofile", method = RequestMethod.GET)
	public ModelAndView editMyprofile(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		ModelAndView modelAndView = new ModelAndView("myprofile/editMyprofile");
		UpdateUserCommand updateUserCommand = new UpdateUserCommand();
		updateUserCommand.setMobilePhone(subscriber.getMobilePhone());
		updateUserCommand.setCarNumber(subscriber.getCarNumber());
		updateUserCommand.setGender(subscriber.getGender());
		updateUserCommand.setTelePhone(subscriber.getTelePhone());
		updateUserCommand.setName(subscriber.getName());

		request.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER_INFO, subscriberService.querySubscriberInfoByopenId(subscriber.getOpenid()));
		request.setAttribute(CommonConstant.CONTEXT_USER_INFO, weixin_UserInfoService.getUserInfoByOpenid(subscriber.getOpenid()));
		modelAndView.addObject("updateUserCommand", updateUserCommand);
		return modelAndView;
	}

	@RequestMapping(value = "/editMyprofile", method = RequestMethod.POST)
	public ModelAndView editMyprofile(HttpServletRequest request, @Valid UpdateUserCommand updateUserCommand, BindingResult result)
	{
		ModelAndView modelAndView = new ModelAndView("myprofile/editMyprofile");
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		modelAndView.addObject("updateUserCommand", updateUserCommand);

		request.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER_INFO, subscriberService.querySubscriberInfoByopenId(subscriber.getOpenid()));
		request.setAttribute(CommonConstant.CONTEXT_USER_INFO, weixin_UserInfoService.getUserInfoByOpenid(subscriber.getOpenid()));

		if (result.hasErrors())
		{
			return modelAndView;
		}

		subscriber.setCarNumber(updateUserCommand.getCarNumber());
		subscriber.setMobilePhone(updateUserCommand.getMobilePhone());
		subscriber.setGender(updateUserCommand.getGender());
		subscriber.setTelePhone(updateUserCommand.getTelePhone());
		subscriber.setName(updateUserCommand.getName());
		session.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER, subscriber);

		try
		{
			subscriberService.update(subscriber);
			modelAndView=new ModelAndView("result/success");
			request.setAttribute(CommonConstant.MSG_SUCCESS,"恭喜您，修改成功！");
			request.setAttribute(CommonConstant.URL_BACK,request.getContextPath() +  "/myprofile/editMyprofile");
		}
		catch (Exception e)
		{
			exceptionLogger.info(e);
			modelAndView=new ModelAndView("result/error");
			request.setAttribute(CommonConstant.MSG_ERROR,"对不起，修改失败！");
			request.setAttribute(CommonConstant.URL_BACK,request.getContextPath() +  "/myprofile/editMyprofile");
			e.printStackTrace();
		}
		return modelAndView;
	}

}
