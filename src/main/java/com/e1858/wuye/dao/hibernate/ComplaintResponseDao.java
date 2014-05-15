package com.e1858.wuye.dao.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.Complaint;
import com.e1858.wuye.entity.hibernate.ComplaintResponse;

@Repository("complaintResponseDao")
public class ComplaintResponseDao extends BaseDao<ComplaintResponse>
{
	private final String QUERY_BY_COMPLAINT = HQL_FROM + " u where u.complaint=?";

	public List<ComplaintResponse> queryResponsesByComplaint(Complaint complaint)
	{
		return find(QUERY_BY_COMPLAINT, complaint);
	}

}
