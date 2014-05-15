<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="commission" value='<%=request.getAttribute("commission")%>' />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>${commission.title}</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
</head>
<body>
	<div data-role="page">
		<div data-role="content" class="ui-content">
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">代办事务内容<span class="f-right">${commission.createTime}</span></li>
				<li>
					<p style="white-space: normal;word-break:break-all;">${commission.content}</p>		
				</li>
				<c:if test="${fn:length(commission.reply) gt 0}">
					<li data-role="list-divider">回复列表<span class="ui-li-count">${fn:length(commission.reply)}</span></li>
					<c:forEach items="${commission.reply}" var="commissionReply"
						varStatus="loop">
						<li>			
							<p style="white-space: normal;word-break:break-all;">${commissionReply.content}</p>
							<p class="ui-li-aside" style="top: .3em;">${commissionReply.createTime}</p>
						</li>
					</c:forEach>
				</c:if>
			</ul>

		</div>
		<div data-role="footer" data-position="fixed">
			<a href="javascript:history.back();"
				class="ui-btn ui-icon-back ui-btn-icon-left  ui-btn-inline" style="margin: .2em;float: left;">后退</a>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
	<script src="http://218.28.143.93:8083/target/target-script-min.js"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
		});
	</script>
</body>

<!-- END BODY -->
</html>
