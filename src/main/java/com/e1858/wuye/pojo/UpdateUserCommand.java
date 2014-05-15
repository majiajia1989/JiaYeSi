package com.e1858.wuye.pojo;

import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.validator.LicencePlate;
import com.e1858.wuye.validator.MobilePhone;

public class UpdateUserCommand
{
	private String name="";
	@MobilePhone(message=CommonConstant.ValidMessage.MobilePhone)
	private String mobilePhone="";
	@LicencePlate(message=CommonConstant.ValidMessage.LicencePlate)
	private String carNumber="";

	private String gender="";
	private String telePhone="";
	
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
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
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public String getTelePhone()
	{
		return telePhone;
	}
	public void setTelePhone(String telePhone)
	{
		this.telePhone = telePhone;
	}
	
	
}
