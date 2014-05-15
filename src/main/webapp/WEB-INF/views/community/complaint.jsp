<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>投诉与建议</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css' />" />
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">新建投诉与建议</li>
				<li><f:form class="form-validate" method="post"
						action="${ctx}/community/complaint" id="complaint-form"
						commandName="complaintCommand">
						<div>
							<div
								class="form-group <f:errors path="content">has-error</f:errors>">
								<f:textarea class="form-control placeholder-no-fix required"
									cols="40" rows="8" autocomplete="off" name="content"
									placeholder="请填写投诉或建议的内容.." path="content" />
								<f:errors cssClass="help-block" element="span" path="content" />
							</div>
							<div class="ui-field-contain">
								<label for="anonymous">匿名提交</label> <select name="anonymous"
									id="anonymous" data-role="slider">
									<option value="false">否</option>
									<option value="true">是</option>
								</select>
							</div>
						</div>
					</f:form></li>
			</ul>
		</div>

		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="javascript:window.history.back();" target="_self" style="margin: 0.2em; float: left;"
				class="ui-btn ui-icon-back ui-btn-icon-left ui-shadow ui-corner-all ui-btn-inline">后退</a>
			<a href="#" id="submit-btn" target="_self" style="margin: 0.2em; float: right;"
				class="ui-btn ui-btn-inline ui-mini ui-corner-all ui-btn-icon-right ui-icon-check">确定
			</a>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js' />" /></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery-validation/dist/jquery.validate.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/pages/complaint.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			Complaint.init();
		});
	</script>
</body>
<!-- END BODY -->
</html>
