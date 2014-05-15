<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>我的代办事务</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/public.css'/>" />
</head>
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				 <c:forEach items="${commissions}" var="commissionInfo"
					varStatus="loop">
					<c:if test="${loop.index mod 2 eq 0}">
						<li><a
							href="${ctx}/community/commissionDetail/${commissionInfo.id}">
								<h2 style="margin-top: 1em;margin-right: 4em;">${commissionInfo.content}</h2>
								<p class="ui-li-aside">
									<strong>${commissionInfo.createTime}</strong>
								</p>
						</a></li>
					</c:if>
					<c:if test="${loop.index mod 2 ne 0}">
						<li><a
							href="${ctx}/community/commissionDetail/${commissionInfo.id}">				
								<h2 style="margin-top: 1em;">${commissionInfo.content}</h2>
								<p class="ui-li-aside">
									<strong>${commissionInfo.createTime}</strong>
								</p>
						</a></li>
					</c:if>
				</c:forEach>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<div data-role="navbar">
				<ul>
					<li><a href="javascript:history.back();"
						class="ui-btn ui-icon-back ui-btn-icon-left ui-btn-inline"
						target="_self">后 退</a></li>
					<li><a href="${ctx}/community/commission"
						class="ui-btn ui-icon-plus ui-btn-icon-left ui-btn-inline"
						target="_self">新 建</a></li>
					<c:if test="${!empty next_page}">
							<li><a href="${ctx}/community/commissions/${next_page}"
								class="ui-btn ui-icon-more ui-btn-icon-left ui-btn-inline"
								target="_self">更 多</a>
							</li>
					</c:if>
					<c:if test="${empty next_page}">
							<li><a href="javascript:App.toast();"
								class="ui-btn ui-icon-more ui-btn-icon-left ui-btn-inline"
								target="_self">更 多</a>
							</li>
					</c:if>
				</ul>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
		});
	</script>
</body>
<!-- END BODY -->
</html>
