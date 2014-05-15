package com.e1858.wuye.dao.hibernate;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.CommissionTemplate;
import com.e1858.wuye.entity.hibernate.CommissionType;

@Repository("commissionTemplate")
public class CommissionTemplateDao extends BaseDao<CommissionTemplate>
{

private final String GET_COMMISSIONTEMPLATE_BY_TYPE = HQL_FROM + " u where u.type=?";
private final String GET_COMMISSIONTEMPLATE_BY_ID = HQL_FROM + " u where u.id=?";
	
	public List<CommissionTemplate> getCommissionTemplateByType(CommissionType commissionType)
	{
		return find(GET_COMMISSIONTEMPLATE_BY_TYPE, commissionType);
	}
	public CommissionTemplate getCommissionTemplateByID(long id){
		return get(GET_COMMISSIONTEMPLATE_BY_ID, id);
	}
}
