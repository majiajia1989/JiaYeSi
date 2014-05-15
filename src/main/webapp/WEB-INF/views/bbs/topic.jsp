<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="topic" value='<%=request.getAttribute("CONTEXT_TOPIC")%>' />
<c:set var="posts" value='<%=request.getAttribute("CONTEXT_POSTS")%>' />
<c:set var="nextPage" value='<%=request.getAttribute("PAGE_NEXT")%>' />
<!DOCTYPE html>
<html>
<head>
<title>${topic.title}</title>
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
		<header data-role="header" data-position="fixed">
			<h1>${topic.title}</h1>
		</header>
		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				<c:forEach items="${posts}" var="post" varStatus="step">
					<li data-role="list-divider"  data-theme="b">${post.title}<p class="ui-li-aside">${post.subscriber.alias}</p></li>
					<li>
							<c:if test="${empty post.subscriber.headimgurl}">
								<img src="<c:url value='/assets/img/photos.png'/>" alt="" />
							</c:if>
							<c:if test="${!empty post.subscriber.headimgurl}">
								<img src="${post.subscriber.headimgurl}"/>
							</c:if>
						<p style="white-space: normal;word-break:break-all;">${post.content}</p>
					</li>
					<li data-role="list-divider">&nbsp;<p class="ui-li-aside">${post.createTime}</p></li>
				</c:forEach>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed">
			<div data-role="navbar">
			<ul>
			<li>
			<a href="javascript:history.back();" class="ui-btn ui-icon-back ui-btn-icon-left ui-btn-inline" >后退</a>
			</li>
			<li>
			<a href="${ctx}/bbs/topic/${topic.id}/newPost" class="ui-btn  ui-icon-plus ui-btn-icon-left ui-shadow ui-corner-all ui-btn-inline">回复</a>
			</li>
			<li>
			<c:if test="${!empty nextPage}">
			<a href="${ctx}/bbs/topic/${topic.id}/${nextPage}" class="ui-btn ui-icon-more ui-btn-icon-left ui-btn-inline" >更多</a>
			</c:if>
			<c:if test="${empty nextPage}">
			<a href="javascript:App.toast();" class="ui-btn ui-icon-more ui-btn-icon-left ui-btn-inline">更多</a>
			</c:if>
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