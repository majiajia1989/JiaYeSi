package com.e1858.wuye.service.hibernate;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.ComplaintDao;
import com.e1858.wuye.dao.hibernate.ComplaintResponseDao;
import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.Complaint;
import com.e1858.wuye.entity.hibernate.ComplaintResponse;

@Service
@Transactional
public class ComplaintService {

	@Autowired
	private ComplaintDao complaintDao;
	@Autowired
	private ComplaintResponseDao complaintResponseDao;

	@Transactional(readOnly=true)
	public List<Complaint> queryComplaintsByCommunity(Community community) {
		return complaintDao.queryComplaintsByCommunity(community);
	}

	@Transactional(readOnly=true)
	public List<ComplaintResponse> queryResponsesByComplaint(Complaint complaint) {
		return complaintResponseDao.queryResponsesByComplaint(complaint);
	}

	@Transactional(readOnly=true)
	public Complaint queryComplaintByID(long complaintID) {
		return complaintDao.queryComplaintByID(complaintID);
	}

	public void saveComplaintResponse(ComplaintResponse response) {
		complaintResponseDao.save(response);
	}

	public void saveComplaint(Complaint complaint) {
		complaintDao.save(complaint);
	}

	@Transactional(readOnly=true)
	public List<Complaint> queryComplaintsBySubscriber(String openid, int offset, int count) {
		return complaintDao.queryComplaintsBySubscriber(openid, offset, count);
	}
}
