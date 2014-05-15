package com.e1858.wuye.dao.hibernate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.Complaint;
import com.e1858.wuye.entity.hibernate.ComplaintResponse;

@Repository("complaintDao")
public class ComplaintDao extends BaseDao<Complaint> {
	private final String QUERY_COMPLAINT_BY_SUBSCRIBER = HQL_FROM + "  u  where u.creator=? order by id desc";
	private final String QUERY_COMPLAINT_BY_COMMUNITY = HQL_FROM + " u where u.community=?";
	private final String QUERY_COMPLAINT_BY_ID = HQL_FROM + " u where u.id=?";

	public List<Complaint> queryComplaintsByCommunity(Community community) {
		return find(QUERY_COMPLAINT_BY_COMMUNITY, community);
	}

	public Complaint queryComplaintByID(long complaintID) {
		return get(QUERY_COMPLAINT_BY_ID, Long.valueOf(complaintID));
	}

//	@SuppressWarnings("unchecked")
//	public List<Complaint> queryComplaintsBySubscriber(String openid, int page, int pageSize) {
//		int number = (page - 1) * pageSize;
//		Query query = createQuery(QUERY_COMPLAINT_BY_SUBSCRIBER, openid);
//		query.setFirstResult(number);
//		query.setMaxResults(pageSize);
//		return query.list();
//	}
	
	public List<Complaint> queryComplaintsBySubscriber(String openid, int offset, int count) {
		return findWithPage(QUERY_COMPLAINT_BY_SUBSCRIBER,offset,count, openid);
	}
}
