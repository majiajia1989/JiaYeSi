<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="phone" value='<%=request.getAttribute("SERVICE_PHONE")%>' />
<!DOCTYPE html>
<html>
<head>
<title>常用电话</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css' />" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/public.css'/>" />
<!-- END THEME STYLES -->
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<ol data-role="listview" data-inset="true">
				<c:set var="flag" value="0"></c:set>
				<c:forEach items="${phone}" var="item">
					<c:choose>
						<c:when test="${flag == 0}">
							<li><c:set var="flag" value="1" /> 
							<a href="tel:${item.phone}"
								class="ui-icon-phone"> <h2>${item.title}</h2>
									<p>${item.description}</p>
							</a></li>
						</c:when>
						<c:otherwise>
							<li><c:set var="flag" value="0" /> 
							<a href="tel:${item.phone}" class="ui-icon-phone"> <h2>${item.title}</h2>
									<p>${item.description}</p>
							</a></li>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</ol>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="javascript:history.back();"
				class="ui-btn  ui-icon-back ui-btn-icon-left ui-btn-inline"
				target="_self" style="margin: 0.2em; float:left;">后 退</a>
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
