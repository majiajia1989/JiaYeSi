<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="boards" value='<%=request.getAttribute("CONTEXT_BOARDS")%>' />
<!DOCTYPE html>
<html>
<head>
<title>论坛板块</title>
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
			<ol data-role="listview" data-inset="true">
				<li data-role="list-divider">板块列表<span class="ui-li-count">${fn:length(boards)}</span></li>
				<c:forEach items="${boards}" var="board" varStatus="step">
					<li>
						<a  href="${ctx}/bbs/board/${board.id}/1">
						<h2>${board.name}</h2>
						<p class="ui-li-aside">话题数: ${board.topics}</p>
						<p>${board.description}</p>
						<p></p>
						</a>
					</li>

				</c:forEach>
			</ol>
		</div>
		<div data-role="footer"  data-position="fixed">
		<div data-role="navbar">
			<ul>
				<li>
	    			<a href="javascript:history.back();" class="ui-btn ui-icon-back ui-btn-icon-top ui-btn-inline">后退</a>
	    		</li>
	    		<li>
	    			<a href="javascript:void();" class="ui-btn ui-icon-bullets ui-btn-icon-top ui-btn-inline ui-btn-active">板块</a>
	    		</li>
	    		<li>
	    			<a href="${ctx}/bbs/creamTopic" class="ui-btn ui-icon-thumbs-o-up ui-btn-icon-top ui-btn-inline">精华话题</a>
	    		</li>
	    		<li>    		
	    			<a href="${ctx}/bbs/myTopic" class="ui-btn ui-icon-user ui-btn-icon-top ui-btn-inline">我的话题</a>
	    		</li>
	    	</ul>
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