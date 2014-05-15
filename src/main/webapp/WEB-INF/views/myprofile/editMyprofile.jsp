<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value='<%=request.getAttribute("CONTEXT_USER_INFO")%>' />
<c:set var="subscriberInfo"
	value='<%=request.getAttribute("CONTEXT_SUBSCRIBER_INFO")%>' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>完善个人信息</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
</head>
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-count-theme="b" data-inset="true">
				<li data-icon="false" ><a href="#"><img
						<c:if test="${empty user.headimgurl || user.headimgurl==''}">
						 src="<c:url value='/assets/img/photos.png'/>" 
						 </c:if>
						<c:if test="${!(empty user.headimgurl || user.headimgurl=='')}">
						 src="<c:url value='${user.headimgurl}'/>"
						 </c:if>
						alt="" />
						<h2>${user.nickname}</h2></a></li>
				<li data-icon="false"><a href="#">
						<div class="ui-grid-b" style="margin-bottom: 0.4em;">
							<span>小区:</span><span>${subscriberInfo.communityName}</span>
						</div>
						<div class="ui-grid-b">
							<div class="ui-block-a">
								<span>楼号:</span><span>${subscriberInfo.houseName}</span>
							</div>
							<div class="ui-block-b">
								<span>单元:</span><span>${subscriberInfo.houseUnitName}</span>
							</div>
							<div class="ui-block-c">
								<span>门牌:</span><span>${subscriberInfo.houseRoomName}</span>
							</div>
						</div>
				</a></li>
			</ul>
			<ul data-role="listview" data-inset="true">
				<li data-role="list-divider">完善信息</li>
				<li><f:form 
						action="${ctx}/myprofile/editMyprofile" method="post"
						commandName="updateUserCommand" class="registe-form form-validate">
						<c:if test="${!empty errMsg}">
							<div class="alert alert-danger">
								<button class="close" data-close="alert"></button>
								<span>${errMsg}</span>
							</div>
						</c:if>
						<div data-role="fieldcontain"
							class="form-group ui-field-contain <f:errors path="mobilePhone">has-error</f:errors>"
							style="margin: .5em 0;">
							<label for="name">别&nbsp;&nbsp;名:</label>
							<f:input id="name" class="form-control name" path="name" />
							<f:errors cssClass="help-block" element="span" path="name" />
						</div>
						<div data-role="fieldcontain"
							class="form-group ui-field-contain  <f:errors path="mobilePhone">has-error</f:errors>"
							style="margin: .5em 0;">
							<label for="mobilePhone">手机号码:</label>
							<f:input id="mobilePhone" class="form-control mobilePhone"
								path="mobilePhone" />
							<f:errors cssClass="help-block" element="span" path="mobilePhone" />
						</div>
						<div data-role="fieldcontain"
							class="form-group ui-field-contain  <f:errors path="carNumber">has-error</f:errors>"
							style="margin: .5em 0;">
							<label for="carNumber">车牌号码:</label>
							<f:input id="carNumber" class="form-control carNumber"
								path="carNumber" />
							<f:errors cssClass="help-block" element="span" path="carNumber" />
						</div>
					</f:form></li>
			</ul>

		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="#" onclick="history.back();"
				class="ui-btn ui-btn-inline ui-btn-icon-left ui-icon-back"
				target="_self" style="margin: 0.2em; float: left;">后 退</a>
				<a id="btn-update" href="#"
				onclick="window.location.reload();"
				class="pull-right ui-btn ui-icon-check ui-btn-icon-left" style="margin: 0.2em; float: right;">确
				定</a>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery-validation/dist/jquery.validate.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
	<script type="text/javascript" required
		src="<c:url value='/assets/scripts/pages/editMyprofile.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			EditMyprofile.init();
		});
	</script>
</body>
</html>
