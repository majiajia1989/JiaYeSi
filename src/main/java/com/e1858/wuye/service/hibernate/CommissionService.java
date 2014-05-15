package com.e1858.wuye.service.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.CommissionDao;
import com.e1858.wuye.dao.hibernate.CommissionResponseDao;
import com.e1858.wuye.dao.hibernate.CommissionTemplateDao;
import com.e1858.wuye.dao.hibernate.CommissionTypeDao;
import com.e1858.wuye.entity.hibernate.Commission;
import com.e1858.wuye.entity.hibernate.CommissionResponse;
import com.e1858.wuye.entity.hibernate.CommissionTemplate;
import com.e1858.wuye.entity.hibernate.CommissionType;
import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.SysCorp;

@Service
@Transactional
public class CommissionService
{

	@Autowired
	private CommissionDao  commissionDao;
	@Autowired
	private CommissionResponseDao commissionResponseDao;
	
	@Autowired
	private CommissionTypeDao commissionTypeDao;
	
	@Autowired
	private CommissionTemplateDao commissionTemplateDao;
	
	@Transactional(readOnly = true)  
	public List<CommissionType> getCommissionTypes(SysCorp corp,Community community) 
	{
		return commissionTypeDao.getCommissionTypeByCorpAndCommunity(corp, community);
	}
	
	public void deleteCommissionType(CommissionType commissionType){
		commissionTypeDao.delete(commissionType);
	}
	public void deleteCommissionTemplate(CommissionTemplate commissionTemplate){
		commissionTemplateDao.delete(commissionTemplate);
	}
	
	public void saveCommissionType(CommissionType commissionType){
		commissionTypeDao.save(commissionType);
	}
	public void saveCommisionTemplate(CommissionTemplate commissionTemplate){
		commissionTemplateDao.save(commissionTemplate);
	}
	@Transactional(readOnly = true)  
	public CommissionType getCommissionTypeByName(SysCorp corp,Community community,String name){
		return commissionTypeDao.getCommissionTypeByName(corp, community, name);
	}
	@Transactional(readOnly = true)  
	public List<CommissionTemplate> getCommissionTemplates(CommissionType commissionType){
		return commissionTemplateDao.getCommissionTemplateByType(commissionType);
	}
	@Transactional(readOnly = true)  
	public CommissionType getCommissionTypeByID(long id){
		return commissionTypeDao.getCommissionTypeByID(id);
	}
	@Transactional(readOnly = true)  
	public CommissionTemplate getCommissionTemplateByID(long id){
		return commissionTemplateDao.getCommissionTemplateByID(id);
	}
	@Transactional(readOnly = true)  
	public List<Commission> getCommissions(String openid,int offset,int count){
		return commissionDao.getCommissions(openid,offset,count);
	}
	@Transactional(readOnly = true)  
	public List<Commission> getCommissionsByDate(SysCorp corp,Community community,CommissionType type, String keyword, Date begin, Date end){
		return commissionDao.getCommissionByTypeAndDate(corp, community, type, keyword, begin, end);
	}
	@Transactional(readOnly = true)  
	public Commission getCommission(long id){
		return commissionDao.getCommissionByID(id);
	}
	@Transactional(readOnly = true)  
	public List<CommissionResponse> getCommissionResponses(Commission commission){
		return commissionResponseDao.queryResponsesByCommission(commission);
	}
	public void saveCommissionResponse(CommissionResponse commissionResponse){
		commissionResponseDao.save(commissionResponse);
	}
	
	public void saveCommission(Commission commission){
		commissionDao.save(commission);
	}
}
