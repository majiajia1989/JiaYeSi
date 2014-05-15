package com.e1858.wuye.dao.hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.Notice;
import com.e1858.wuye.entity.hibernate.NoticeReceiver;
import com.e1858.wuye.pojo.SubscriberInfo;

@Repository("noticeReceiverDao")
public class NoticeReceiverDao extends BaseDao<NoticeReceiver> {
	private final String GET_NOTICE_RECEIVER_BY_OPENID = HQL_FROM + " u where u.openid.openid=? and u.notice.type=? order by u.sendTime desc";
	private final String GET_NOTICE_RECEIVER_BY_READSTATUS_AND_OPENID = HQL_FROM + " u where u.openid.openid=? and u.readStatus=? order by u.sendTime desc";
	private final String GET_ALL_NOTICE_RECEIVER_BY_OPENID = HQL_FROM + " u where u.openid.openid=? order by u.sendTime desc";


	public List<NoticeReceiver> queryNoticeReceiversByOpenId(String openid,byte noticeType,int startIndex,int rows) {
		List<Object> params = new ArrayList<Object>();
		params.add(openid);
		params.add(noticeType);
		return findWithPage(GET_NOTICE_RECEIVER_BY_OPENID,startIndex,rows,params);
	}
	
	public List<NoticeReceiver> queryNoticeReceiversByReadStatusAndOpenId(String openid,byte readStatus,int startIndex,int rows) {
		List<Object> params = new ArrayList<Object>();
		params.add(openid);
		params.add(readStatus);
		return findWithPage(GET_NOTICE_RECEIVER_BY_READSTATUS_AND_OPENID,startIndex,rows,params);
	}
	
	public List<NoticeReceiver> queryAllNoticeReceiversByOpenId(String openid,int startIndex,int rows) {
		List<Object> params = new ArrayList<Object>();
		params.add(openid);
		return findWithPage(GET_ALL_NOTICE_RECEIVER_BY_OPENID,startIndex,rows,params);
	}

}
