package com.e1858.wuye.pojo;

import java.util.List;

import com.e1858.wuye.entity.hibernate.House;
import com.e1858.wuye.entity.hibernate.HouseFloor;
import com.e1858.wuye.entity.hibernate.HouseRoom;
import com.e1858.wuye.entity.hibernate.HouseUnit;

public class SubscriberInfo
{
	private String openid;
	private long corp;
	private String corpName;
	private long community;
	private String communityName;
	private long house;
	private String houseName;
	private long houseFloor;
	private String houseFloorName;
	private long houseUnit;
	private String houseUnitName;
	private long houseRoom;
	private String houseRoomName;
	
	public String getOpenid()
	{
		return openid;
	}
	public void setOpenid(String openid)
	{
		this.openid = openid;
	}
	public long getCorp()
	{
		return corp;
	}
	public void setCorp(long corp)
	{
		this.corp = corp;
	}
	public String getCorpName()
	{
		return corpName;
	}
	public void setCorpName(String corpName)
	{
		this.corpName = corpName;
	}
	public long getCommunity()
	{
		return community;
	}
	public void setCommunity(long community)
	{
		this.community = community;
	}
	public String getCommunityName()
	{
		return communityName;
	}
	public void setCommunityName(String communityName)
	{
		this.communityName = communityName;
	}
	public long getHouse()
	{
		return house;
	}
	public void setHouse(long house)
	{
		this.house = house;
	}
	public String getHouseName()
	{
		return houseName;
	}
	public void setHouseName(String houseName)
	{
		this.houseName = houseName;
	}
	public long getHouseFloor()
	{
		return houseFloor;
	}
	public void setHouseFloor(long houseFloor)
	{
		this.houseFloor = houseFloor;
	}
	public String getHouseFloorName()
	{
		return houseFloorName;
	}
	public void setHouseFloorName(String houseFloorName)
	{
		this.houseFloorName = houseFloorName;
	}
	public long getHouseUnit()
	{
		return houseUnit;
	}
	public void setHouseUnit(long houseUnit)
	{
		this.houseUnit = houseUnit;
	}
	public String getHouseUnitName()
	{
		return houseUnitName;
	}
	public void setHouseUnitName(String houseUnitName)
	{
		this.houseUnitName = houseUnitName;
	}
	public long getHouseRoom()
	{
		return houseRoom;
	}
	public void setHouseRoom(long houseRoom)
	{
		this.houseRoom = houseRoom;
	}
	public String getHouseRoomName()
	{
		return houseRoomName;
	}
	public void setHouseRoomName(String houseRoomName)
	{
		this.houseRoomName = houseRoomName;
	}
	
}
