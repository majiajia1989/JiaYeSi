package com.e1858.wuye.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.HtmlUtils;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.Complaint;
import com.e1858.wuye.entity.hibernate.ComplaintResponse;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.pojo.ComplaintCommand;
import com.e1858.wuye.pojo.ComplaintResponseCommand;
import com.e1858.wuye.pojo.ComplaintsCommand;
import com.e1858.wuye.service.hibernate.ComplaintService;
import com.e1858.wuye.service.hibernate.SubscriberService;

@Controller
@RequestMapping("/community")
public class ComplaintController {
	@Autowired
	private ComplaintService complaintService;

	@Autowired
	private SubscriberService subscriberService;

	@RequestMapping(value = "/complaints/{page}", method = RequestMethod.GET)
	public ModelAndView initComplaints(@PathVariable("page") int page, HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("community/complaints");
		List<ComplaintsCommand> complaints = readComplaints(request, page);
		if (complaints.size() > 0) {
			request.setAttribute("page", Integer.valueOf(page));
			if (complaints.size() <= CommonConstant.PAGE_SIZE) {
				modelAndView.addObject("complaints", complaints);
			} else {
				modelAndView.addObject("complaints", complaints.subList(0, CommonConstant.PAGE_SIZE));
				modelAndView.addObject(CommonConstant.PAGE_NEXT, Integer.valueOf(page+1));
			}
		} else {
			modelAndView.setViewName("forward:/community/complaint");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/complaint", method = RequestMethod.GET)
	public ModelAndView complaint(HttpServletRequest request) {
		ModelAndView modelAndView = new ModelAndView("community/complaint", "complaintCommand", new ComplaintCommand());
		modelAndView.addObject("success", false);
		return modelAndView;
	}

	@RequestMapping(value = "/complaint", method = RequestMethod.POST)
	public ModelAndView complaint(HttpServletRequest request, @Valid ComplaintCommand complaintCommand,
			BindingResult result) {
		ModelAndView modelAndView = new ModelAndView("community/complaint", "complaintCommand", complaintCommand);
		if (result.hasErrors()) {
			return modelAndView;
		}
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		Complaint complaint = new Complaint();
		try {
			if (complaintCommand.isAnonymous()) {
				complaint.setCreator(CommonConstant.ANONYMOUS_SUBCRIBER_OPENID);//匿名
			} else {
				complaint.setCreator(subscriber.getOpenid());
			}
			complaint.setCommunity(subscriber.getCommunity());
			complaint.setCorp(subscriber.getCorp());
			complaint.setContent(complaintCommand.getContent());
			complaint.setCreateTime(new Date());
			complaintService.saveComplaint(complaint);
			modelAndView = new ModelAndView("result/success");
			modelAndView.addObject("successMsg", "投诉成功!");
			request.setAttribute(CommonConstant.MSG_SUCCESS, "投诉成功!");
		} catch (Exception e) {
			e.printStackTrace();
			modelAndView = new ModelAndView("result/error");
			modelAndView.addObject("errMsg", "投诉失败！");
			request.setAttribute(CommonConstant.MSG_ERROR, "投诉失败!");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/complaintDetail/{id}", method = RequestMethod.GET)
	public ModelAndView initComplaintDetail(@PathVariable("id") long id, HttpServletRequest request) {

		ModelAndView modelAndView = new ModelAndView("community/complaintDetail");
		Complaint complaint = complaintService.queryComplaintByID(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<ComplaintResponse> complaintResponses = complaintService.queryResponsesByComplaint(complaint);
		ComplaintsCommand cmd = new ComplaintsCommand();
		cmd.setTitle(complaint.getContent());
		cmd.setContent(complaint.getContent());
		cmd.setContent(HtmlUtils.htmlEscape(cmd.getContent()).replaceAll("\n", "<br>"));
		cmd.setCreateTime(sdf.format(complaint.getCreateTime()));
		ArrayList<ComplaintResponseCommand> cmdR_list = new ArrayList<ComplaintResponseCommand>();
		for (ComplaintResponse complaintResponse : complaintResponses) {
			ComplaintResponseCommand cmdR = new ComplaintResponseCommand();
			cmdR.setContent(complaintResponse.getContent());
			cmdR.setContent(HtmlUtils.htmlEscape(cmdR.getContent()).replaceAll("\n", "<br>"));
			cmdR.setCreateTime(sdf.format(complaintResponse.getCreateTime()));
			cmdR_list.add(cmdR);
		}
		cmd.setResponse(cmdR_list);
		request.setAttribute("complaint", cmd);
		return modelAndView;
	}

	private List<ComplaintsCommand> readComplaints(HttpServletRequest request, int page) {
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Complaint> complaints = complaintService.queryComplaintsBySubscriber(subscriber.getOpenid(), (page-1) *CommonConstant.PAGE_SIZE ,
				CommonConstant.PAGE_SIZE + 1);
		List<ComplaintsCommand> cmd_list = new ArrayList<ComplaintsCommand>();
		try {
			for (Complaint complaint : complaints) {
				ComplaintsCommand cmd = new ComplaintsCommand();
				cmd.setId(complaint.getId());
				cmd.setContent(HtmlUtils.htmlEscape(complaint.getContent()));
				cmd.setCreateTime(sdf.format(complaint.getCreateTime()));
				cmd_list.add(cmd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cmd_list;
	}

	public String substring(String text, int length) throws UnsupportedEncodingException {
		if (text == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int currentLength = 0;
		for (char c : text.toCharArray()) {
			currentLength += String.valueOf(c).getBytes("GBK").length;
			if (currentLength <= length) {
				sb.append(c);
			} else {
				break;
			}
		}
		return sb.toString();
	}
}
