package com.e1858.wuye.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.e1858.wuye.pojo.HouseInfo;
import com.e1858.wuye.service.hibernate.HouseFloorService;
import com.e1858.wuye.service.hibernate.HouseRoomService;
import com.e1858.wuye.service.hibernate.HouseService;
import com.e1858.wuye.service.hibernate.HouseUnitService;

@Controller
@RequestMapping("/house")
public class HouseController
{
	@Autowired HouseFloorService houseFloorService;
	@Autowired HouseUnitService houseUnitService;
	@Autowired HouseRoomService houseRoomService;
	
	@RequestMapping(value = "/getByCommunity", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getByCommunity(@RequestParam long community)
	{
		return "";
	}
	
	@RequestMapping(value = "/detail", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String detail(long house)
	{
		HouseInfo housJson = new HouseInfo();
		housJson.setFloor(houseFloorService.queryHouseFloorByHouse(house));
		housJson.setUnit(houseUnitService.queryHouseUnitByHouse(house));
		housJson.setRoom(houseRoomService.queryHouseRoomByHouse(house));
		return JSON.toJSONString(housJson);
	}
}
