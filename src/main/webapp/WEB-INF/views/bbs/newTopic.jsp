<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="board" value='<%=request.getAttribute("CONTEXT_BOARD")%>' />
<c:set var="boards" value='<%=request.getAttribute("CONTEXT_BOARDS")%>' />
<!DOCTYPE html>
<html>
<head>
<title>新话题</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<base target="_self">
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<f:form class="topic-form form-validate" action="${ctx}/bbs/newTopic" method="post" commandName="topicCommand">
						<c:if test="${!empty errMsg}">
							<div class="alert alert-danger">
								<button class="close" data-close="alert"></button>
								<span>${errMsg}</span>
							</div>
						</c:if>
						<c:if test="${!empty boards}">
						<div data-role="fieldcontain" data-mini="true" class="form-group <f:errors path="board">has-error</f:errors>">
							<label for="board" class="select control-label">板块</label>
							<f:select data-mini="true" class="form-control required" min="0" path="board">
								<option value="">请选择</option>
								<c:forEach items="${boards}" var="item">
									<option value="${item.id}">${item.name}</option>
								</c:forEach>
							</f:select>
							<f:errors cssClass="help-block" element="span" path="board" />
						</div>
						</c:if>
						<c:if test="${!empty board}">
							<div data-role="fieldcontain" data-mini="true" class="form-group">
							<label>板块</label>
							<input value="${board.name}" readonly/>
							<input type="hidden" name="board" value="${board.id}">
							</div>
						</c:if>
						<div data-role="fieldcontain" class="form-group <f:errors path="title">has-error</f:errors>">
							<label for="title" class="control-label">标题</label>
							<f:input class="form-control required" minlength="3" maxlength="100" path="title" />
							<f:errors cssClass="help-block" element="span" path="title" />
						</div>
						<div data-role="fieldcontain" class="form-group <f:errors path="content">has-error</f:errors>">
							<label for="content" class="control-label">内容</label>
							<f:textarea rows="20" class="form-control required" minlength="3" path="content" />
							<f:errors cssClass="help-block" element="span" path="content" />
						</div>
					</f:form>
		</div>
		<div data-role="footer" data-position="fixed">
			<a href="javascript:history.back();" class="ui-btn ui-icon-back ui-btn-icon-left ui-btn-inline" style="margin: 0.2em; float:left">后退</a>
			<a href="#" id="btn-ok" class="ui-btn ui-icon-check ui-btn-icon-left ui-btn-inline" style="margin: 0.2em; float:right">确定</a>
		</div>
	</div>

	<script type="text/javascript" src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/plugins/jquery-validation/dist/jquery.validate.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/scripts/pages/newTopic.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			Topic.init();
		});
	</script>
</body>
<!-- END BODY -->
</html>