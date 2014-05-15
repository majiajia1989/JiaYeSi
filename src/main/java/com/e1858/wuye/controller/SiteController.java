package com.e1858.wuye.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.CommunityImage;
import com.e1858.wuye.entity.hibernate.House;
import com.e1858.wuye.entity.hibernate.HouseFloor;
import com.e1858.wuye.entity.hibernate.HouseRoom;
import com.e1858.wuye.entity.hibernate.HouseUnit;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.entity.hibernate.SubscriberCar;
import com.e1858.wuye.entity.hibernate.SubscriberHouse;
import com.e1858.wuye.entity.hibernate.SubscriberPhone;
import com.e1858.wuye.pojo.HouseInfo;
import com.e1858.wuye.pojo.RegisteCommand;
import com.e1858.wuye.service.hibernate.CommunityImageService;
import com.e1858.wuye.service.hibernate.CommunityService;
import com.e1858.wuye.service.hibernate.HouseFloorService;
import com.e1858.wuye.service.hibernate.HouseRoomService;
import com.e1858.wuye.service.hibernate.HouseService;
import com.e1858.wuye.service.hibernate.HouseUnitService;
import com.e1858.wuye.service.hibernate.SubscriberCarService;
import com.e1858.wuye.service.hibernate.SubscriberHouseService;
import com.e1858.wuye.service.hibernate.SubscriberPhoneService;
import com.e1858.wuye.service.hibernate.SubscriberService;

@Controller
public class SiteController
{
	@Autowired
	HouseService houseService;
	@Autowired
	HouseUnitService houseUnitService;
	@Autowired
	HouseFloorService houseFloorService;
	@Autowired
	HouseRoomService houseRoomService;
	
	@Autowired
	SubscriberHouseService subscriberHouseService;
	
	@Autowired
	SubscriberPhoneService subscriberPhoneService;
	
	@Autowired
	SubscriberCarService subscriberCarService;
	@Autowired
	CommunityImageService communityImageService;
	@Autowired
	CommunityService communityService;
	
	@Autowired
	SubscriberService subscriberService;

	@RequestMapping("/welcome")
	public String welcome(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		if (subscriber != null)
			{
			CommunityImage welcomeImage = communityImageService.queryCommunityWelcomeImage(subscriber.getCommunity().getId());
			request.setAttribute(CommonConstant.WELCOME_IMAGE, welcomeImage);
			if (welcomeImage == null || welcomeImage.getUrl()=="")
			{
				return "redirect:index";
			}
			else {
				return "welcome";				
			}
		}
		else {
			return "redirect:index";
		}
	}
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
//		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		Subscriber subscriber = subscriberService.querySubscriberByOpenId("otVG5uDoIexUv0gH48-fBcBfLUpg");
		session.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER, subscriber);
		session.setAttribute(CommonConstant.CONTEXT_HOUSE, subscriberHouseService.querySubscriberHouseByOpenId(subscriber.getOpenid()));
		if (session.getAttribute(CommonConstant.CONTEXT_HOUSE) == null)
		{
			return "redirect:registe";
		}

		List<CommunityImage> communityImages = communityImageService.queryCommunityImages(subscriber.getCommunity().getId());
		request.setAttribute(CommonConstant.COMMUNITY_IMAGE, communityImages);


		return "index";
	}

	@RequestMapping(value = "/registe", method = RequestMethod.GET)
	public ModelAndView regist(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setHouse(houseService.queryHouseByCommunit(subscriber.getCommunity().getId()));
		houseInfo.setUnit(houseUnitService.queryHouseUnitByCommunity(subscriber.getCommunity().getId()));
		houseInfo.setFloor(houseFloorService.queryHouseFloorByCommunity(subscriber.getCommunity().getId()));
		houseInfo.setRoom(houseRoomService.queryHouseRoomByCommunity(subscriber.getCommunity().getId()));
		request.setAttribute(CommonConstant.COMMUNITY_HOUSE, houseInfo);
		return new ModelAndView("registe", "registeCommand", new RegisteCommand());
	}

	@RequestMapping(value = "/registe", method = RequestMethod.POST)
	public ModelAndView registe(HttpServletRequest request, @Valid RegisteCommand registeCommand, BindingResult result)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		ModelAndView modelAndView = new ModelAndView("registe");
		
		if (result.hasErrors())
		{
			HouseInfo houseInfo = new HouseInfo();
			houseInfo.setHouse(houseService.queryHouseByCommunit(subscriber.getCommunity().getId()));
			houseInfo.setUnit(houseUnitService.queryHouseUnitByCommunity(subscriber.getCommunity().getId()));
			houseInfo.setFloor(houseFloorService.queryHouseFloorByCommunity(subscriber.getCommunity().getId()));
			houseInfo.setRoom(houseRoomService.queryHouseRoomByCommunity(subscriber.getCommunity().getId()));
			request.setAttribute(CommonConstant.COMMUNITY_HOUSE, houseInfo);
			return modelAndView;
		}
		
		if(!StringUtils.isBlank(registeCommand.getMobilePhone()))
		{
			subscriber.setMobilePhone(registeCommand.getMobilePhone());
		}
		
		if(!StringUtils.isBlank(registeCommand.getCarNumber()))
		{
			subscriber.setCarNumber(registeCommand.getCarNumber());
		}
		
		if(!StringUtils.isBlank(registeCommand.getMobilePhone()) || !StringUtils.isBlank(registeCommand.getCarNumber()))
		{
			subscriberService.update(subscriber);
		}
		
		SubscriberHouse subscriberHouse= new SubscriberHouse();
		subscriberHouse.setCorp(subscriber.getCorp().getId());
		subscriberHouse.setCommunity(subscriber.getCommunity().getId());
		subscriberHouse.setOpenid(subscriber.getOpenid());
		subscriberHouse.setHouse(Long.valueOf(registeCommand.getHouse()));
		subscriberHouse.setHouseUnit(Long.valueOf(registeCommand.getUnit()));
		subscriberHouse.setHouseFloor(Long.valueOf(registeCommand.getFloor()));
		subscriberHouse.setHouseRoom(Long.valueOf(registeCommand.getRoom()));
		subscriberHouse.setCreateTime(new Date());
		subscriberHouseService.save(subscriberHouse);
		

		if(!StringUtils.isBlank(registeCommand.getMobilePhone()))
		{
			SubscriberPhone subscriberPhone = new SubscriberPhone();
			subscriberPhone.setOpenid(subscriber.getOpenid());
			subscriberPhone.setTelephone("");
			subscriberPhone.setMobilephone(registeCommand.getMobilePhone());
			subscriberPhoneService.save(subscriberPhone);
		}
		
		if(!StringUtils.isBlank(registeCommand.getCarNumber()))
		{
			SubscriberCar subscriberCar = new SubscriberCar();
			subscriberCar.setOpenid(subscriber.getOpenid());
			subscriberCar.setNumber(registeCommand.getCarNumber());
			subscriberCarService.save(subscriberCar);
		}

		
		modelAndView.setViewName("redirect:/index");
		return modelAndView;
	}
	
	
	@RequestMapping(value = "/pctest", method = RequestMethod.GET)
	public ModelAndView pctest(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		session.setAttribute(CommonConstant.CONTEXT_SUBSCRIBER, subscriberService.querySubscriberByOpenId("otVG5uDoIexUv0gH48-fBcBfLUpg"));
		return new ModelAndView("redirect:/index");
	}

	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public ModelAndView test(HttpServletRequest request)
	{
		HouseInfo houseInfo = new HouseInfo();
		houseInfo.setHouse(houseService.queryHouseByCommunit(59));
		houseInfo.setUnit(houseUnitService.queryHouseUnitByCommunity(59));
		houseInfo.setFloor(houseFloorService.queryHouseFloorByCommunity(59));
		houseInfo.setRoom(houseRoomService.queryHouseRoomByCommunity(59));
		request.setAttribute(CommonConstant.COMMUNITY_HOUSE, houseInfo);
		return new ModelAndView("test", "registeCommand", new RegisteCommand());
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public ModelAndView test(HttpServletRequest request, @Valid RegisteCommand registeCommand, BindingResult result)
	{
		HttpSession session = request.getSession();
		ModelAndView modelAndView = new ModelAndView("test");
		if (result.hasErrors())
		{
			HouseInfo houseInfo = new HouseInfo();
			houseInfo.setHouse(houseService.queryHouseByCommunit(59));
			houseInfo.setUnit(houseUnitService.queryHouseUnitByCommunity(59));
			houseInfo.setFloor(houseFloorService.queryHouseFloorByCommunity(59));
			houseInfo.setRoom(houseRoomService.queryHouseRoomByCommunity(59));
			request.setAttribute(CommonConstant.COMMUNITY_HOUSE, houseInfo);
			return modelAndView;
		}
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		SubscriberHouse subscriberHouse= new SubscriberHouse();
		subscriberHouse.setCorp(subscriber.getCorp().getId());
		subscriberHouse.setCommunity(subscriber.getCommunity().getId());
		subscriberHouse.setOpenid(subscriber.getOpenid());
		subscriberHouse.setHouse(Long.valueOf(registeCommand.getHouse()));
		subscriberHouse.setHouseUnit(Long.valueOf(registeCommand.getUnit()));
		subscriberHouse.setHouseFloor(Long.valueOf(registeCommand.getFloor()));
		subscriberHouse.setHouseRoom(Long.valueOf(registeCommand.getRoom()));
		subscriberHouse.setCreateTime(new Date());
		subscriberHouseService.save(subscriberHouse);
		modelAndView.setViewName("test");
		return modelAndView;
	}
}
