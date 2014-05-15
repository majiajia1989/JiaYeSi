<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="infos" value='<%=request.getAttribute("CONSUME_INFO")%>' />
<c:set var="title" value='<%=request.getAttribute("name")%>' />
<!DOCTYPE html>
<html>
<head>
<title>查询结果</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
	<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/pages/consumeInfo.css' />" />
<!-- END THEME STYLES -->
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content" class="ui-content">
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">${title}信息</li>
				<li>
					<table border="0" cellpadding="0" cellspacing="0"
						width="100%">
						<c:if test="${empty infos.payNumber}">
							<tr>
								<td class="td_left" align="center" style="padding:10px;">未查到本期缴费信息</td>
							</tr>
						</c:if>
						<c:if test="${!empty infos.payNumber}">
							<tr>
								<td class="td_left">缴费户号</td>
								<td class="td_right">${infos.payNumber}</td>
							</tr>
							<tr>
								<td class="td_left">查询月份</td>
								<td class="td_right">${infos.year}年<f:formatNumber
										value="${infos.month}" pattern="00" />月</td>
							</tr>
							<tr>
								<td class="td_left">上期表数</td>
								<td class="td_right"><f:formatNumber
										value="${infos.postAmount}" pattern=".0" /></td>
							</tr>
							<tr>
								<td class="td_left">本期表数</td>
								<td class="td_right"><f:formatNumber
										value="${infos.currentAmount}" pattern=".0" /></td>
							</tr>
							<tr>
								<td class="td_left">本期用量</td>
								<td class="td_right"><f:formatNumber
										value="${infos.amount}" pattern=".0" /></td>
							</tr>
							<tr>
								<td class="td_left" style="border-bottom:0px">缴费金额</td>
								<td class="td_right" style="border-bottom:0px"><f:formatNumber
										value="${infos.payAmount}" type="currency" pattern=".00" /></td>
							</tr>
						</c:if>
					</table>
				</li>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="javascript:history.back();"
				class="ui-btn  ui-icon-back ui-btn-icon-left ui-btn-inline" style="margin: 0.2em; float:left;"
				target="_self">后 退</a>
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
