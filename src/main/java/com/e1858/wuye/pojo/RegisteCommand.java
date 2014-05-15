package com.e1858.wuye.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.validator.LicencePlate;
import com.e1858.wuye.validator.MobilePhone;

public class RegisteCommand
{
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Digits(integer=65535,fraction=0, message= CommonConstant.ValidMessage.Digits)
	private String house;
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Digits(integer=65535,fraction=0, message= CommonConstant.ValidMessage.Digits)
	private String unit;
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Digits(integer=65535,fraction=0, message= CommonConstant.ValidMessage.Digits)
	private String floor;
	@NotBlank(message= CommonConstant.ValidMessage.NotBlank)
	@NotEmpty(message= CommonConstant.ValidMessage.NotBlank)
	@Digits(integer=65535,fraction=0, message= CommonConstant.ValidMessage.Digits)
	private String room;
	
	@MobilePhone(message= CommonConstant.ValidMessage.MobilePhone)
	private String mobilePhone;
	@LicencePlate(message= CommonConstant.ValidMessage.LicencePlate)
	private String carNumber;
	public String getHouse()
	{
		return house;
	}
	public void setHouse(String house)
	{
		this.house = house;
	}
	public String getUnit()
	{
		return unit;
	}
	public void setUnit(String unit)
	{
		this.unit = unit;
	}
	public String getFloor()
	{
		return floor;
	}
	public void setFloor(String floor)
	{
		this.floor = floor;
	}
	public String getRoom()
	{
		return room;
	}
	public void setRoom(String room)
	{
		this.room = room;
	}
	public String getMobilePhone()
	{
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone)
	{
		this.mobilePhone = mobilePhone;
	}
	public String getCarNumber()
	{
		return carNumber;
	}
	public void setCarNumber(String carNumber)
	{
		this.carNumber = carNumber;
	}
	
	
}
