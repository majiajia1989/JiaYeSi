package com.e1858.wuye.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.Commission;
import com.e1858.wuye.entity.hibernate.CommissionType;
import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.entity.hibernate.SysCorp;
@Repository("commissionDao")
public class CommissionDao extends BaseDao<Commission>
{
	public  final String GET_COMMISSION_BYCORPANDCOMMUNITY=HQL_FROM+"  u  where u.creator=? order by id desc";
	public  final String GET_COMMISSION_BYID=HQL_FROM+" u where u.id=?";
	public  final String GET_TOTALCOUNT="select count(*) from u where u.creator=?";

	public List<Commission> getCommissions(String openid,int offset,int count){
		return findWithPage(GET_COMMISSION_BYCORPANDCOMMUNITY, offset, count, openid);
	}
	
	public long getTotalcount(Subscriber subscriber){
		return find(GET_TOTALCOUNT, subscriber).size();
	}
	
	public Commission getCommissionByID(long id){
		return get(GET_COMMISSION_BYID, id);
	}
	@SuppressWarnings("unchecked")
	public List<Commission> getCommissionByTypeAndDate(SysCorp corp,Community community,
			CommissionType type, String keyword, Date begin, Date end) {
		String hql = GET_COMMISSION_BYCORPANDCOMMUNITY;
		if(type!=null){
			hql += " and u.type=?";
		}
		if (begin != null) {
			hql += " and u.createTime>=:begin";
		}
		if (end != null) {
			hql += " and u.createTime<=:end";
		}
		if (keyword != null) {
			hql+=" and u.content like '%"+keyword+"%'";
		}
		Query query;
		if(type!=null){
			query= createQuery(hql,corp,community,type);
			if (begin != null) {
				query.setDate("begin", begin);
			}
			if (end != null) {
				query.setDate("end", end);
			}
		}else{
			query = createQuery(hql,corp,community);
			if (begin != null) {
				query.setDate("begin", begin);
			}
			if (end != null) {
				query.setDate("end", end);
			}
		}
		return query.list();
	}
	
	
}
