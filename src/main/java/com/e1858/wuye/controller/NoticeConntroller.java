package com.e1858.wuye.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.CommunityImage;
import com.e1858.wuye.entity.hibernate.NoticeReceiver;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.service.hibernate.CommunityImageService;
import com.e1858.wuye.service.hibernate.CommunityService;
import com.e1858.wuye.service.hibernate.NoticeReceiverService;
import com.e1858.wuye.service.hibernate.SubscriberService;

@Controller
@RequestMapping("/community")
public class NoticeConntroller
{
	@Autowired
	NoticeReceiverService noticeReceiverService;
	@Autowired
	SubscriberService subscriberService;

	@RequestMapping("/allNotice/{page}")
	public String allNotice(HttpServletRequest request, @PathVariable("page") int page)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber =
		(Subscriber)session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		//Subscriber subscriber = subscriberService.querySubscriberByOpenId("otVG5uPIepTAbJ4u3xOUxqKzq6IQ");
		page = page <= 0 ? 1 : page;
		int resultCnt = 0;

		// String openId = "otVG5uPIepTAbJ4u3xOUxqKzq6IQ";
		List<NoticeReceiver> noticeReceivers = noticeReceiverService.queryAllNoticeReceiversByOpenId(subscriber.getOpenid(), (page-1)*CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE + 1);
		resultCnt = noticeReceivers.size();
		if (resultCnt == CommonConstant.PAGE_SIZE + 1)
		{
			noticeReceivers.remove(CommonConstant.PAGE_SIZE);
		}
		request.setAttribute(CommonConstant.NOTICE_RECEIVERS, noticeReceivers);
		request.setAttribute(CommonConstant.PAGE_CURRENT, page);
		request.setAttribute(CommonConstant.PAGE_PREVIOUS, page == 1 ? 1 : page - 1);
		request.setAttribute(CommonConstant.PAGE_NEXT, resultCnt < CommonConstant.PAGE_SIZE + 1 ? page : page + 1);
		return "community/allNotice";
	}

	@RequestMapping("/unreadNotice/{page}")
	public String unreadNotice(HttpServletRequest request, @PathVariable("page") int page)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber =
		(Subscriber)session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		//Subscriber subscriber = subscriberService.querySubscriberByOpenId("otVG5uPIepTAbJ4u3xOUxqKzq6IQ");
		page = page <= 0 ? 1 : page;

		int resultCnt = 0;
		// String openId = "otVG5uPIepTAbJ4u3xOUxqKzq6IQ";
		List<NoticeReceiver> noticeReceivers = noticeReceiverService.queryNoticeReceiversByReadStatusAndOpenId(subscriber.getOpenid(), CommonConstant.NoticeReadStatus.UnRead, (page-1)*CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE + 1);

		resultCnt = noticeReceivers.size();
		if (resultCnt == CommonConstant.PAGE_SIZE + 1)
		{
			noticeReceivers.remove(CommonConstant.PAGE_SIZE);
		}

		request.setAttribute(CommonConstant.NOTICE_RECEIVERS, noticeReceivers);
		request.setAttribute(CommonConstant.PAGE_CURRENT, page);
		request.setAttribute(CommonConstant.PAGE_PREVIOUS, page == 1 ? 1 : page - 1);
		request.setAttribute(CommonConstant.PAGE_NEXT, resultCnt < CommonConstant.PAGE_SIZE + 1 ? page : page + 1);
		return "community/unreadNotice";
	}

	@RequestMapping("/readedNotice/{page}")
	public String readedNotice(HttpServletRequest request, @PathVariable("page") int page)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber =
		(Subscriber)session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		//Subscriber subscriber = subscriberService.querySubscriberByOpenId("otVG5uPIepTAbJ4u3xOUxqKzq6IQ");
		page = page <= 0 ? 1 : page;
		int resultCnt = 0;

		// String openId = "otVG5uPIepTAbJ4u3xOUxqKzq6IQ";
		List<NoticeReceiver> noticeReceivers = noticeReceiverService.queryNoticeReceiversByReadStatusAndOpenId(subscriber.getOpenid(), CommonConstant.NoticeReadStatus.Readed, (page-1)*CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE + 1);
		resultCnt = noticeReceivers.size();
		if (resultCnt == CommonConstant.PAGE_SIZE + 1)
		{
			noticeReceivers.remove(CommonConstant.PAGE_SIZE);
		}
		request.setAttribute(CommonConstant.NOTICE_RECEIVERS, noticeReceivers);
		request.setAttribute(CommonConstant.PAGE_CURRENT, page);
		request.setAttribute(CommonConstant.PAGE_PREVIOUS, page == 1 ? 1 : page - 1);
		request.setAttribute(CommonConstant.PAGE_NEXT, resultCnt < CommonConstant.PAGE_SIZE + 1 ? page : page + 1);
		return "community/readedNotice";
	}

	@RequestMapping("/noticeDetail/{noticeReceiverId}")
	public String noticeDetail(HttpServletRequest request, @PathVariable("noticeReceiverId") int noticeReceiverId)
	{
		NoticeReceiver noticeReceiver = noticeReceiverService.queryAllNoticeReceiverById(noticeReceiverId);
		if (noticeReceiver != null)
		{
			if (noticeReceiver.getReadStatus() == CommonConstant.NoticeReadStatus.UnRead)
			{
				noticeReceiver.setReadStatus(CommonConstant.NoticeReadStatus.Readed);
				noticeReceiverService.update(noticeReceiver);
			}
		}
		request.setAttribute(CommonConstant.NOTICE_INFO, noticeReceiver);
		
		return "community/noticeDetail";
	}

}
