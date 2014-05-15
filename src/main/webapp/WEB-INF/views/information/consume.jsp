<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="type" value='<%=request.getAttribute("CONSUME_TYPE")%>' />
<!DOCTYPE html>
<html>
<head>
<title>生活信息</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
<!-- END THEME STYLES -->
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">生活信息</li>
				<li>
					<form method="post" action="${ctx}/information/consumeinfo"
					id="consume-form" target="_self">
						<div>
							<label class="control-label">消费信息</label>
							<div data-role="fieldcontain" data-mini="true" class="form-group">
								<select id="consumeID" name="consumeID" class="form-control">
									<c:forEach items="${type}" var="items">
									<option value="${items.id}">${items.name}</option>
									</c:forEach>
								</select><input type="hidden" id="name" name="name" value="" />
							</div>
						</div>
						<div>
							<label class="control-label">选择月份</label>
							<div data-role="fieldcontain" data-mini="true" class="form-group">
								<select class="form-control" id="month" name="month"></select>
							</div>
						</div>
					</form>
				</li>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="javascript:history.back();"
				class="ui-btn  ui-icon-back ui-btn-icon-left ui-btn-inline" style="margin: 0.2em; float:left;"
				target="_self">后 退</a>
			<a	href="javascript:Consume.submit()" class="pull-right ui-btn ui-icon-search ui-btn-icon-left" style="margin: 0.2em; float: right;">查 询</a>
		</div>
		<script type="text/javascript"
			src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>			
		<script type="text/javascript"
			src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
		<script type="text/javascript"
			src="<c:url value='/assets/scripts/pages/consume.js'/>"></script>
		<script type="text/javascript">
			$(function() {
				App.init();
				Consume.init();
			});			
		</script>
	</div>
</body>
<!-- END BODY -->
</html>
