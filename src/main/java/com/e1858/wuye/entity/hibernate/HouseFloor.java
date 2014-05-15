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
@Table(name = "t_HouseFloor")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class HouseFloor extends BaseEntity 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	@Column(name = "corp")
	private long corp;
	@Column(name = "community")
	private long community;
	@Column(name = "house")
	private long house;
	@Column(name = "name", length = 200)
	private String name;
	@Column(name = "description", length = 1000)
	private String description;
	@Column(name = "creator")
	private long creator;
	@Column(name = "createTime")
	private Date createTime;
	public long getId()
	{
		return id;
	}
	public void setId(long id)
	{
		this.id = id;
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
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public long getCreator()
	{
		return creator;
	}
	public void setCreator(long creator)
	{
		this.creator = creator;
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
