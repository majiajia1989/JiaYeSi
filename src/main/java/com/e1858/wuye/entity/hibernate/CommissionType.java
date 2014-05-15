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
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "t_CommissionType")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class CommissionType extends BaseEntity
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "corp")
	private SysCorp corp;
	
	@ManyToOne
	@JoinColumn(name="community")
	private Community community;
	
	@Column(name="name",length=200)
	private String name;
	
	@Column(name = "creator")
	private long creator;
	
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

	public SysCorp getCorp()
	{
		return corp;
	}

	public void setCorp(SysCorp corp)
	{
		this.corp = corp;
	}

	public Community getCommunity()
	{
		return community;
	}

	public void setCommunity(Community community)
	{
		this.community = community;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
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
