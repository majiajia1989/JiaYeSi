<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>代办事务请求</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css'/>" />
</head>
<body>
	<div data-role="page">
		<div data-role="content">
			<f:form id="commission-form" action="${ctx}/community/commission"
				class="form-validate" method="post" commandName="commissionCommand">
				<ul data-role="listview" data-inset="true">
					<li data-role="list-divider">新建代办事务</li>
					<li>

						<div data-role="fieldcontain" data-mini="true">
							<label for="type">类型:</label>
							<div
								class="form-group <f:errors path="type">has-error</f:errors>">
								<f:select data-mini="true" class="form-control required" min="0"
									path="type" id="type">
									<c:if test="${empty type}">
										<option value="">请选择</option>
									</c:if>
									<c:if test="${!empty type}">
										<c:forEach items="${type}" var="typeInfo">
											<option value="${typeInfo.id}">${typeInfo.text}</option>
										</c:forEach>
									</c:if>
								</f:select>
								<f:errors cssClass="help-block" element="span" path="type" />
							</div>

							<label for="template">模板:</label>
							<div
								class="form-group <f:errors path="type">has-error</f:errors>">
								<f:select data-mini="true" class="form-control" min="0"
									path="template" id="template">
								</f:select>
								<f:errors cssClass="help-block" element="span" path="template" />
							</div>

							<label for="content">内容:</label>
							<div
								class="form-group <f:errors path="content">has-error</f:errors>">
								<f:textarea class="form-control required" autocomplete="off"
									placeholder="请填写代办事务内容.." path="content" />
								<f:errors cssClass="help-block" element="span" path="content" />
							</div>
						</div>
					</li>
				</ul>
			</f:form>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="javascript:history.back();"
				class="ui-btn  ui-icon-back ui-btn-icon-left  ui-btn-inline"
				target="_self" style="margin: 0.2em; float: left;">后
				退</a>
			<c:if test="${!success}">
				<a onclick="javascript:Commission.commissionSubmit();" href="#"
					class="ui-btn  ui-icon-check ui-btn-icon-left  ui-btn-inline"
					style="margin: 0.2em; float: right;">确 定</a>
			</c:if>
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
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/pages/commission.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			Commission.init(${template});
		});
	</script>

</body>
<!-- END BODY -->
</html>
