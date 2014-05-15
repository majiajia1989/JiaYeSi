package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.SysConsumeType;

@Repository("consumeTypeDao")
public class ConsumeTypeDao extends BaseDao<SysConsumeType>
{
	public List<SysConsumeType> getConsumeTypes()
	{
		return find(HQL_FROM);
	}
}
