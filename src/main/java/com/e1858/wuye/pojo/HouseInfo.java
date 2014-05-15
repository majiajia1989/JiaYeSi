package com.e1858.wuye.pojo;

import java.util.List;

import com.e1858.wuye.entity.hibernate.House;
import com.e1858.wuye.entity.hibernate.HouseFloor;
import com.e1858.wuye.entity.hibernate.HouseRoom;
import com.e1858.wuye.entity.hibernate.HouseUnit;

public class HouseInfo
{
	private long community;
	private List<House> house;
	private List<HouseFloor> floor;
	private List<HouseUnit> unit;
	private List<HouseRoom> room;

	public List<House> getHouse()
	{
		return house;
	}
	public void setHouse(List<House> house)
	{
		this.house = house;
	}
	public List<HouseFloor> getFloor()
	{
		return floor;
	}
	public void setFloor(List<HouseFloor> floor)
	{
		this.floor = floor;
	}
	public List<HouseUnit> getUnit()
	{
		return unit;
	}
	public void setUnit(List<HouseUnit> unit)
	{
		this.unit = unit;
	}
	public List<HouseRoom> getRoom()
	{
		return room;
	}
	public void setRoom(List<HouseRoom> rooms)
	{
		this.room = rooms;
	}
	public long getCommunity()
	{
		return community;
	}
	public void setCommunity(long community)
	{
		this.community = community;
	}
}
