package com.e1858.wuye.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.e1858.wuye.common.CommonConstant;
import com.e1858.wuye.entity.hibernate.BbsBoard;
import com.e1858.wuye.entity.hibernate.BbsPost;
import com.e1858.wuye.entity.hibernate.BbsTopic;
import com.e1858.wuye.entity.hibernate.Subscriber;
import com.e1858.wuye.pojo.HouseInfo;
import com.e1858.wuye.pojo.PostCommand;
import com.e1858.wuye.pojo.RegisteCommand;
import com.e1858.wuye.pojo.TopicCommand;
import com.e1858.wuye.service.hibernate.BbsBoardService;
import com.e1858.wuye.service.hibernate.BbsPostService;
import com.e1858.wuye.service.hibernate.BbsTopicService;
@Controller
@RequestMapping("/bbs")
public class BbsController
{
	@Autowired BbsBoardService bbsBoardService;
	@Autowired BbsTopicService bbsTopicService;
	@Autowired BbsPostService bbsPostService;
	@RequestMapping("/boards")
	public String boards(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<BbsBoard> bbsBoards =bbsBoardService.getEnableBoardByCommunity(subscriber.getCommunity().getId());
		request.setAttribute(CommonConstant.CONTEXT_BOARDS, bbsBoards);
		return "bbs/boards";
	}
	
	@RequestMapping(value = "/board/{id}/{page}", method = RequestMethod.GET)
	public String board(@PathVariable("id") long boardId, @PathVariable("page") int page, HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		BbsBoard bbsBoard = bbsBoardService.getById(boardId);
		request.setAttribute(CommonConstant.CONTEXT_BOARD, bbsBoard);
		List<BbsTopic> bbsTopics =bbsTopicService.getEnableTopicByBoardCommunity(boardId, subscriber.getCommunity().getId(), (page - 1) * CommonConstant.PAGE_SIZE, CommonConstant.PAGE_SIZE + 1);
		if(bbsTopics.size() > CommonConstant.PAGE_SIZE)
		{
			bbsTopics.remove(CommonConstant.PAGE_SIZE);
			request.setAttribute(CommonConstant.PAGE_NEXT, page + 1);
		}
		request.setAttribute(CommonConstant.CONTEXT_TOPICS, bbsTopics);
		return "bbs/board";
	}
	
	
	@RequestMapping(value = "/myTopic", method = RequestMethod.GET)
	public String myTopic(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<BbsTopic> bbsTopics =bbsTopicService.getEnableTopicBySubscriber(subscriber.getOpenid());
		ArrayList<BbsBoard> bbsBoards=new ArrayList<BbsBoard>();
		for(BbsTopic bbsTopic : bbsTopics)
		{
			if(!bbsBoards.contains(bbsTopic.getBbsBoard()))
			{
				bbsBoards.add(bbsTopic.getBbsBoard());
			}
		}
		request.setAttribute(CommonConstant.CONTEXT_BOARDS, bbsBoards);
		request.setAttribute(CommonConstant.CONTEXT_TOPICS, bbsTopics);
		return "bbs/myTopic";
	}
	
	
	@RequestMapping(value = "/topTopic", method = RequestMethod.GET)
	public String topTopic(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<BbsTopic> bbsTopics =bbsTopicService.getTopTopicByCommunity(subscriber.getCommunity().getId());
		ArrayList<BbsBoard> bbsBoards=new ArrayList<BbsBoard>();
		for(BbsTopic bbsTopic : bbsTopics)
		{
			if(!bbsBoards.contains(bbsTopic.getBbsBoard()))
			{
				bbsBoards.add(bbsTopic.getBbsBoard());
			}
		}
		request.setAttribute(CommonConstant.CONTEXT_BOARDS, bbsBoards);
		request.setAttribute(CommonConstant.CONTEXT_TOPICS, bbsTopics);
		return "bbs/topTopic";
	}
	
	@RequestMapping(value = "/creamTopic", method = RequestMethod.GET)
	public String creamTopic(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<BbsTopic> bbsTopics =bbsTopicService.getCreamTopicByCommunity(subscriber.getCommunity().getId());
		ArrayList<BbsBoard> bbsBoards=new ArrayList<BbsBoard>();
		for(BbsTopic bbsTopic : bbsTopics)
		{
			if(!bbsBoards.contains(bbsTopic.getBbsBoard()))
			{
				bbsBoards.add(bbsTopic.getBbsBoard());
			}
		}
		request.setAttribute(CommonConstant.CONTEXT_BOARDS, bbsBoards);
		request.setAttribute(CommonConstant.CONTEXT_TOPICS, bbsTopics);
		return "bbs/creamTopic";
	}
	
	@RequestMapping(value = "/newTopic", method = RequestMethod.GET)
	public ModelAndView newTopic(HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		List<BbsBoard> bbsBoards =bbsBoardService.getEnableBoardByCommunity(subscriber.getCommunity().getId());
		request.setAttribute(CommonConstant.CONTEXT_BOARDS, bbsBoards);
		return new ModelAndView("bbs/newTopic", "topicCommand", new TopicCommand());
	}
	
	@RequestMapping(value = "/board/{id}/newTopic", method = RequestMethod.GET)
	public ModelAndView newTopic(@PathVariable("id") long boardId, HttpServletRequest request) 
	{
		BbsBoard bbsBoard= bbsBoardService.getById(boardId);
		request.setAttribute(CommonConstant.CONTEXT_BOARD, bbsBoard);
		return new ModelAndView("bbs/newTopic", "topicCommand", new TopicCommand());
	}
	
	@RequestMapping(value = "/newTopic", method = RequestMethod.POST)
	public ModelAndView newTopic(HttpServletRequest request ,@Valid TopicCommand topicCommand, BindingResult result) 
	{
			HttpSession session = request.getSession();
			Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
			ModelAndView modelAndView = new ModelAndView("bbs/newTopic");
			if (result.hasErrors())
			{
				List<BbsBoard> bbsBoards =bbsBoardService.getEnableBoardByCommunity(subscriber.getCommunity().getId());
				request.setAttribute(CommonConstant.CONTEXT_BOARDS, bbsBoards);
				return new ModelAndView("bbs/newTopic");
			}
			try
			{
				bbsTopicService.addTopic(Long.valueOf(topicCommand.getBoard()),topicCommand.getTitle(),topicCommand.getContent(),subscriber);
				request.setAttribute(CommonConstant.MSG_SUCCESS, "创建成功！");
				request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/board/").concat(topicCommand.getBoard()).concat("/1") );
				return new ModelAndView("result/success");
			}
			catch(Exception ex)
			{
				Logger logger= Logger.getLogger("exception");
				logger.error(ex.getMessage(), ex);
				request.setAttribute(CommonConstant.MSG_ERROR, ex.getMessage());
				return new ModelAndView("result/error");
			}
	}
	
	
	@RequestMapping(value = "/topic/{id}/{page}", method = RequestMethod.GET)
	public String topic(@PathVariable("id") long topicId, @PathVariable("page") int page, HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		BbsTopic bbsTopic = bbsTopicService.getById(topicId);
		bbsTopic.setViews(bbsTopic.getViews() + 1);
		bbsTopicService.update(bbsTopic);
		List<BbsPost> bbsPosts =bbsPostService.getEnablePostByTopic(topicId,(page - 1) * CommonConstant.PAGE_SIZE,CommonConstant.PAGE_SIZE + 1);
		request.setAttribute(CommonConstant.CONTEXT_TOPIC, bbsTopic);
		if(bbsPosts.size() > CommonConstant.PAGE_SIZE)
		{
			bbsPosts.remove(CommonConstant.PAGE_SIZE);
			request.setAttribute(CommonConstant.PAGE_NEXT, page + 1);
		}
		request.setAttribute(CommonConstant.CONTEXT_POSTS, bbsPosts);
		return "bbs/topic";
	}
	
	@RequestMapping(value = "/topic/{id}/newPost", method = RequestMethod.GET)
	public ModelAndView newPost(@PathVariable("id") long topicId, HttpServletRequest request) 
	{
		BbsTopic bbsTopic= bbsTopicService.getById(topicId);
		request.setAttribute(CommonConstant.CONTEXT_TOPIC, bbsTopic);
		return new ModelAndView("bbs/newPost", "postCommand", new PostCommand());
	}
	
	@RequestMapping(value = "/newPost", method = RequestMethod.POST)
	public ModelAndView newPost(HttpServletRequest request, @Valid PostCommand postCommand, BindingResult result) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		if (result.hasErrors())
		{
			return new ModelAndView("bbs/newPost");
		}
		try
		{
			bbsPostService.addPost(Long.valueOf(postCommand.getTopic()), postCommand.getTitle(), postCommand.getContent(), subscriber);
			request.setAttribute(CommonConstant.MSG_SUCCESS, "回复成功！");
			request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/topic/").concat(postCommand.getTopic()).concat("/1") );
			return new ModelAndView("result/success");
		}
		catch(Exception ex)
		{
			Logger logger= Logger.getLogger("exception");
			logger.error(ex.getMessage(), ex);
			request.setAttribute(CommonConstant.MSG_ERROR, ex.getMessage());
			return new ModelAndView("result/error");
		}
	}
	
	@RequestMapping(value = "/removeTopic/{id}", method = RequestMethod.GET)
	public String removeTopic1(@PathVariable("id") long topicId, HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		BbsTopic bbsTopic= bbsTopicService.getById(topicId);
		if(null == bbsTopic)
		{
			request.setAttribute(CommonConstant.MSG_ERROR, "话题不存在！");
			request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/myTopic"));
			return "result/error";
		}
		if(!subscriber.getOpenid().equalsIgnoreCase(bbsTopic.getSubscriber().getOpenid()))
		{
			request.setAttribute(CommonConstant.MSG_ERROR, "您无权删除该话题！");
			request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/myTopic"));
			return "result/error";
		}
		request.setAttribute(CommonConstant.CONTEXT_TOPIC, bbsTopic);
		return "bbs/removeTopic";
	}
	
	@RequestMapping(value = "/topic/remove/{id}", method = RequestMethod.GET)
	public String removeTopic2(@PathVariable("id") long topicId, HttpServletRequest request) 
	{
		HttpSession session = request.getSession();
		Subscriber subscriber = (Subscriber) session.getAttribute(CommonConstant.CONTEXT_SUBSCRIBER);
		BbsTopic bbsTopic= bbsTopicService.getById(topicId);
		if(null == bbsTopic)
		{
			request.setAttribute(CommonConstant.MSG_ERROR, "话题不存在！");
			request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/myTopic"));
			return "result/error";
		}
		if(!subscriber.getOpenid().equalsIgnoreCase(bbsTopic.getSubscriber().getOpenid()))
		{
			request.setAttribute(CommonConstant.MSG_ERROR, "您无权删除该话题！");
			request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/myTopic"));
			return "result/error";
		}
		bbsTopicService.removeTopic(topicId, subscriber.getOpenid());
		request.setAttribute(CommonConstant.MSG_SUCCESS, "删除话题成功！");
		request.setAttribute(CommonConstant.URL_BACK, request.getContextPath().concat("/bbs/myTopic"));
		return "result/success";
	}
	
}
