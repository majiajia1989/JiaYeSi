<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="boards" value='<%=request.getAttribute("CONTEXT_BOARDS")%>' />
<c:set var="topics" value='<%=request.getAttribute("CONTEXT_TOPICS")%>' />
<!DOCTYPE html>
<html>
<head>
<title>我的话题</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/public.css'/>" />
<base target="_self">
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-inset="true" >
				<c:forEach items="${boards}" var="board" varStatus="step">
					<li data-role="list-divider">${board.name}</span></li>
					<c:forEach items="${topics}" var="topic" varStatus="step">
						<c:if test="${board.id == topic.bbsBoard.id}">
							<li data-theme="b" data-icon="delete">
								<a href="${ctx}/bbs/removeTopic/${topic.id}" data-transition="pop">
								<span>${topic.title}</span>
								<p class="ui-li-aside">${topic.lastPost}</p>
								</a>
							</li>
							<li >
								<a  href="${ctx}/bbs/topic/${topic.id}/1">
								<p style="white-space: normal;word-break:break-all;">${topic.content}</p>
								<p></p>
								<p>浏览数:${topic.views}</p>
								<p></p>
								<p>回复数:${topic.replies}</p>
								</a>
							</li>
						</c:if>
					</c:forEach>
				</c:forEach>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed">
		<div data-role="navbar">
			<ul>
				<li>
	    			<a href="javascript:history.back();" class="ui-btn ui-icon-back ui-btn-icon-top ui-btn-inline">后退</a>
	    		</li>
	    		<li>
	    			<a href="${ctx}/bbs/boards" class="ui-btn ui-icon-bullets ui-btn-icon-top ui-btn-inline">板块</a>
	    		</li>
	    		<li>
	    			<a href="${ctx}/bbs/creamTopic" class="ui-btn ui-icon-thumbs-o-up ui-btn-icon-top ui-btn-inline">精华话题</a>
	    		</li>
	    		<li>
	    			<a href="${ctx}/bbs/topTopic" class="ui-btn ui-icon-cloud-upload ui-btn-icon-top ui-btn-inline">置顶话题</a>
	    		</li>
	    		<li>    		
	    			<a href="javascript:void();" class="ui-btn ui-icon-user ui-btn-icon-top ui-btn-inline ui-btn-active">我的话题</a>
	    		</li>
	    	</ul>
		</div>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
		});
	</script>
</body>
<!-- END BODY -->
</html>