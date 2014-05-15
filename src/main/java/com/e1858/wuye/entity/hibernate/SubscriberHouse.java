package com.e1858.wuye.entity.hibernate;

import java.util.Date;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_SubscriberHouse")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class SubscriberHouse extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="openid",unique = true, nullable = false, length = 32)
	private String openid;
	
	@Column(name="corp")
	private long corp;
	
	@Column(name="community")
	private long community;
	
	@Column(name="house")
	private long house;
	
	@Column(name="houseUnit")
	private long houseUnit;
	
	@Column(name="houseFloor")
	private long houseFloor;
	
	@Column(name="houseRoom")
	private long houseRoom;
	
	@Column(name="createTime")
	private Date createTime;

	public long getId()
	{
		return id;
	}

	public void setId(long id)
	{
		this.id = id;
	}

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

	public long getCommunity()
	{
		return community;
	}

	public void setCommunity(long community)
	{
		this.community = community;
	}

	public long getHouse()
	{
		return house;
	}

	public void setHouse(long house)
	{
		this.house = house;
	}

	public long getHouseUnit()
	{
		return houseUnit;
	}

	public void setHouseUnit(long houseUnit)
	{
		this.houseUnit = houseUnit;
	}

	public long getHouseFloor()
	{
		return houseFloor;
	}

	public void setHouseFloor(long houseFloor)
	{
		this.houseFloor = houseFloor;
	}

	public long getHouseRoom()
	{
		return houseRoom;
	}

	public void setHouseRoom(long houseRoom)
	{
		this.houseRoom = houseRoom;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}
	

}
