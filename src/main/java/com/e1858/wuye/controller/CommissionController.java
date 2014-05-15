package com.e1858.wuye.controller;
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
import com.e1858.wuye.entity.hibernate.Commission;
import com.e1858.wuye.entity.hibernate.CommissionResponse;
import com.e1858.wuye.entity.hibernate.CommissionTemplate;
import com.e1858.wuye.entity.hibernate.CommissionType;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.pojo.CommissionCommand;
import com.e1858.wuye.pojo.CommissionResponseCommand;
import com.e1858.wuye.pojo.CommissionsCommand;
import com.e1858.wuye.pojo.TreeNode;
import com.e1858.wuye.service.hibernate.CommissionService;
import com.e1858.wuye.service.hibernate.SubscriberService;
import com.e1858.wuye.utils.JsonUtil;
import com.e1858.wuye.utils.Util;

@Controller
@RequestMapping("/community")
public class CommissionController
{
	@Autowired
	CommissionService commissionService;
	@Autowired
	SubscriberService subscriberService;

	@RequestMapping(value = "/commissions/{page}", method = RequestMethod.GET)
	public ModelAndView initCommissions(@PathVariable("page") int page, HttpServletRequest request)
	{
		List<CommissionsCommand> commissions = readCommissions(request, page);
		ModelAndView modelAndView = new ModelAndView("community/commissions");
		if (commissions.size() > 0)
		{
			modelAndView.addObject("page", Integer.valueOf(page));
			if(commissions.size()<=CommonConstant.PAGE_SIZE){
				modelAndView.addObject("commissions", commissions);
			}else{
				modelAndView.addObject("commissions", commissions.subList(0, CommonConstant.PAGE_SIZE));
				modelAndView.addObject("next_page", Integer.valueOf(page+1));
			}
		}
		else
		{
			modelAndView.setViewName("forward:/community/commission");
		}
		return modelAndView;

	}

	@RequestMapping(value = "/commission", method = RequestMethod.GET)
	public ModelAndView commission(HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("community/commission", "commissionCommand", new CommissionCommand());
		modelAndView.addObject("type", readType(request));
		modelAndView.addObject("template", readTemplate(request));
		modelAndView.addObject("success", false);
		return modelAndView;
	}

	@RequestMapping(value = "/commissionDetail/{id}", method = RequestMethod.GET)
	public ModelAndView initCommissionDetail(@PathVariable("id") long id, HttpServletRequest request)
	{
		ModelAndView modelAndView = new ModelAndView("community/commissionDetail");
		Commission commission = commissionService.getCommission(id);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		List<CommissionResponse> commissionResponses = commissionService.getCommissionResponses(commission);
		CommissionsCommand cmd = new CommissionsCommand();
		cmd.setTitle(Util.htmlRemoveTag(commission.getContent()));
		cmd.setContent(HtmlUtils.htmlEscape(commission.getContent()).replaceAll("\n", "<br>"));
		cmd.setCreateTime(sdf.format(commission.getCreateTime()));
		ArrayList<CommissionResponseCommand> cmdR_list = new ArrayList<CommissionResponseCommand>();
		for (CommissionResponse commissionResponse : commissionResponses)
		{
			CommissionResponseCommand cmdR = new CommissionResponseCommand();
			cmdR.setContent(HtmlUtils.htmlEscape(commissionResponse.getContent()).replaceAll("\n", "<br>"));
			cmdR.setCreateTime(sdf.format(commissionResponse.getCreateTime()));
			cmdR_list.add(cmdR);
		}
		cmd.setReply(cmdR_list);
		request.setAttribute("commission", cmd);
		return modelAndView;
	}

	private List<TreeNode> readType(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (subscriber != null)
		{
			for (CommissionType commissionType : commissionService.getCommissionTypes(subscriber.getCorp(), subscriber.getCommunity()))
			{
				TreeNode treeNode = new TreeNode();
				treeNode.setId(((Long) commissionType.getId()).toString());
				treeNode.setText(commissionType.getName());
				result.add(treeNode);
			}
		}
		return result;
	}

	private String readTemplate(HttpServletRequest request)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<TreeNode> result = new ArrayList<TreeNode>();
		if (subscriber != null)
		{
			for (CommissionType commissionType : commissionService.getCommissionTypes(subscriber.getCorp(), subscriber.getCommunity()))
			{
				TreeNode treeNode = new TreeNode();
				treeNode.setId(((Long) commissionType.getId()).toString());
				treeNode.setText(commissionType.getName());
				List<CommissionTemplate> commissionTemplates = commissionService.getCommissionTemplates(commissionType);
				ArrayList<TreeNode> templateResult = new ArrayList<TreeNode>();
				for (CommissionTemplate commissionTemplate : commissionTemplates)
				{
					TreeNode treeNode2 = new TreeNode();
					treeNode2.setId(((Long) commissionTemplate.getId()).toString());
					treeNode2.setText(commissionTemplate.getContent());
					templateResult.add(treeNode2);
				}
				treeNode.setChildren(templateResult);
				result.add(treeNode);
			}
		}
		return JsonUtil.toJson(result);
	}

	@RequestMapping(value = "/commission", method = RequestMethod.POST)
	public ModelAndView commission(HttpServletRequest request, @Valid CommissionCommand commissionCommand, BindingResult result)
	{
		ModelAndView modelAndView = new ModelAndView("community/commission");
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		modelAndView.addObject("commissionCommand", commissionCommand);
		if (commissionCommand.getType().equals(""))
		{
			modelAndView.addObject("infoMsg", "请选择事务类型!");
		}
		else if (commissionCommand.getContent() == "" || commissionCommand.getContent().length() == 0)
		{
			modelAndView.addObject("infoMsg", "内容不能为空!");
		}
		else
		{
			try
			{
				Commission commission = new Commission();
				commission.setCreator(subscriber.getOpenid());
				commission.setCorp(subscriber.getCorp());
				commission.setCommunity(subscriber.getCommunity());
				commission.setContent(commissionCommand.getContent());
				commission.setType(commissionService.getCommissionTypeByID(Long.parseLong(commissionCommand.getType())));
				commission.setCreateTime(new Date());
				commissionService.saveCommission(commission);
				modelAndView=new ModelAndView("result/success");
//				modelAndView.addObject("successMsg","新建成功!");
				request.setAttribute(CommonConstant.MSG_SUCCESS, "新建成功!");
				request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/community/commissions/").concat("1") );
			}
			catch (Exception e)
			{
				modelAndView=new ModelAndView("result/error");
//				modelAndView.addObject("errMsg", "新建失败！");
				request.setAttribute(CommonConstant.MSG_ERROR, e.getMessage());
				e.printStackTrace();
			}
		}
		request.setAttribute("commissionType", readTemplate(request));
		return modelAndView;
	}

	private List<CommissionsCommand> readCommissions(HttpServletRequest request, int page)
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<Commission> commissions = commissionService.getCommissions(subscriber.getOpenid(), (page-1)*CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE+1);
		List<CommissionsCommand> cmd_list = new ArrayList<CommissionsCommand>();
		try
		{
			for (Commission commission : commissions)
			{
				CommissionsCommand cmd = new CommissionsCommand();
				cmd.setId(commission.getId());
				/**
				if (commission.getContent().length() <= 15)
				{
					cmd.setContent(HtmlUtils.htmlEscape(commission.getContent()).replaceAll("\n", "<br>"));
				}
				else
				{
					cmd.setContent(HtmlUtils.htmlEscape(substring(commission.getContent(), 30)).replaceAll("\n", "<br>") + "...");
				}
				*/
				cmd.setContent(HtmlUtils.htmlEscape(commission.getContent()).replaceAll("\n", "<br>"));
				cmd.setCreateTime(sdf.format(commission.getCreateTime()));
				cmd_list.add(cmd);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return cmd_list;
	}
}
