<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="topic" value='<%=request.getAttribute("CONTEXT_TOPIC")%>' />
<!DOCTYPE html>
<html>
<head>
<title>${topic.title}</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/public.css'/>" />
<body>
<div data-role="page" data-close-btn="none" data-dialog="true">
		<div data-role="header">
		<h1>温馨提示</h1>
		</div>

		<div role="main" class="ui-content">
		<h3>标题: ${topic.title}</h3>
		<p>创建时间: ${topic.createTime}</p>
		<p><red>您确定要删除该话题吗？</red></p>
			<a href="${ctx}/bbs/topic/remove/${topic.id}" class="ui-btn ui-shadow ui-corner-all ui-btn-b">确定</a>
			<a href="" data-rel="back" class="ui-btn ui-shadow ui-corner-all ui-btn-b">取消</a>
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
</html>