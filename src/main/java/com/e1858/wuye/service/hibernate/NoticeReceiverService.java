package com.e1858.wuye.service.hibernate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.e1858.wuye.dao.hibernate.NoticeDao;
import com.e1858.wuye.dao.hibernate.NoticeReceiverDao;
import com.e1858.wuye.entity.hibernate.Community;
import com.e1858.wuye.entity.hibernate.Notice;
import com.e1858.wuye.entity.hibernate.NoticeReceiver;
import com.e1858.wuye.entity.hibernate.SysUser;

@Service
@Transactional
public class NoticeReceiverService
{

	@Autowired
	private NoticeReceiverDao noticeReceiverDao;

	@Transactional(readOnly = true)
	public List<NoticeReceiver> queryNoticeReceiversByOpenId(String openid, byte noticeType, int startIndex, int rows)
	{
		return noticeReceiverDao.queryNoticeReceiversByOpenId(openid, noticeType, startIndex, rows);
	}

	@Transactional(readOnly = true)
	public List<NoticeReceiver> queryNoticeReceiversByReadStatusAndOpenId(String openid, byte readStatus, int startIndex, int rows)
	{
		return noticeReceiverDao.queryNoticeReceiversByReadStatusAndOpenId(openid, readStatus, startIndex, rows);
	}

	@Transactional(readOnly = true)
	public List<NoticeReceiver> queryAllNoticeReceiversByOpenId(String openid, int startIndex, int rows)
	{
		return noticeReceiverDao.queryAllNoticeReceiversByOpenId(openid, startIndex, rows);
	}

	@Transactional(readOnly = true)
	public NoticeReceiver queryAllNoticeReceiverById(long id)
	{
		return noticeReceiverDao.get(id);
	}

	public void update(NoticeReceiver noticeReceiver)
	{
		noticeReceiverDao.update(noticeReceiver);
	}
}
