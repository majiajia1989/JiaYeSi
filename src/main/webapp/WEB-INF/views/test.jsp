<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="community" value="${sessionScope.CONTEXT_COMMUNITY}" />
<c:set var="user" value="${sessionScope.CONTEXT_USER_INFO}" />
<c:set var="houseInfo"
	value='<%=request.getAttribute("COMMUNITY_HOUSE")%>' />
<!DOCTYPE html>
<html>
<head>
<title>请完善相关信息</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="http://cdn.bootcss.com/twitter-bootstrap/3.1.1/css/bootstrap.min.css">
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/test.css'/>" />
</head>
<body>
	<!--page start-->
	<div data-role="page">
		<!--content start-->
		<div data-role="content" style="padding: 0.4em">
					<table class="kuang" border="0" cellpadding="0" cellspacing="0"
						width="100%">
						<tr>
							<td>${community.name}欢迎${user.nickname}</td>
							<c:if test="${empty user.headimgurl}">
								<td width="50" class="padding-top10"><img
									src="<c:url value='/assets/img/photos.png'/>" alt="" /></td>
							</c:if>
							<c:if test="${!empty user.headimgurl}">
								<td width="50" class="padding-top10"><img
									src="<c:url value='${user.headimgurl}'/>" alt="" /></td>
							</c:if>
						</tr>
					</table>
					<f:form class="registe-form form-validate"
						action="${ctx}/registe" method="post" commandName="registeCommand">
						<c:if test="${!empty errMsg}">
							<div class="alert alert-danger">
								<button class="close" data-close="alert"></button>
								<span>${errMsg}</span>
							</div>
						</c:if>
						<div data-role="fieldcontain" data-mini="true"
							class="form-group <f:errors path="house">has-error</f:errors>">
							<label for="house" class="select control-label">楼号:</label>
							<f:select data-mini="true" class="form-control required" min="0"
								path="house">
								<option value="">请选择</option>
								<c:forEach items="${houseInfo.house}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</f:select>
							<f:errors cssClass="help-block" element="span" path="house" />
						</div>
						<div data-role="fieldcontain"
							class="form-group <f:errors path="unit">has-error</f:errors>">
							<label for="unit" class="select control-label">单元:</label>
							<f:select class="form-control required" min="0" path="unit">
								<option value="">请选择</option>
								<c:forEach items="${houseInfo.unit}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</f:select>
							<f:errors cssClass="help-block" element="span" path="unit" />
						</div>
						<div data-role="fieldcontain"
							class="form-group <f:errors path="floor">has-error</f:errors>">
							<label for="unit" class="select control-label">楼层:</label>
							<f:select class="form-control required" min="0" path="floor">
								<option value="">请选择</option>
								<c:forEach items="${houseInfo.floor}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</f:select>
							<f:errors cssClass="help-block" element="span" path="floor" />
						</div>
						<div data-role="fieldcontain"
							class="form-group <f:errors path="room">has-error</f:errors>">
							<label for="unit" class="select control-label">门牌:</label>
							<f:select class="form-control required" min="0" path="room">
								<option value="">请选择</option>
								<c:forEach items="${houseInfo.room}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</f:select>
							<f:errors cssClass="help-block" element="span" path="room" />
						</div>
						<div data-role="fieldcontain"
							class="form-group <f:errors path="mobilePhone">has-error</f:errors>">
							<label for="mobilePhone" class="control-label">手机号码:</label>
							<f:input class="form-control" path="mobilePhone" />
							<f:errors cssClass="help-block" element="span" path="mobilePhone" />
						</div>
						<div data-role="fieldcontain"
							class="form-group <f:errors path="carNumber">has-error</f:errors>">
							<label for="carNumber" class="control-label">车牌号码:</label>
							<f:input class="form-control" path="carNumber" />
							<f:errors cssClass="help-block" element="span" path="carNumber" />
						</div>
					</f:form>
		</div>
		<!--footer start-->
		<div data-role="footer" data-position="fixed">
			<a href="#" id="btn-ok" class="ui-btn ui-icon-more ui-btn-icon-left ui-btn-inline" style="margin: 0.2em; float:right">确定</a>
		</div>
		<!--footer end-->
	</div>
	<!--page end-->
	<script type="text/javascript" src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/plugins/jquery-validation/dist/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/scripts/pages/registe.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			Registe.init();
		});
	</script>
</body>
</html>
