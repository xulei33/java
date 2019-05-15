<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流程配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			
		});
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
        	return false;
        }
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li class="active"><a href="${ctx}/sfm/sfmFlow/">流程配置列表</a></li>
		<shiro:hasPermission name="sfm:sfmFlow:edit"><li><a href="${ctx}/sfm/sfmFlow/form">流程配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sfmFlow" action="${ctx}/sfm/sfmFlow/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>流程名称：</label>
				<form:input path="flowName" htmlEscape="false" maxlength="128" class="input-medium"/>
			</li>
			<li><label>流程状态：</label>
				<form:input path="flowStatus" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="sfm:sfmFlow:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sfmFlow">
			<tr>
				<shiro:hasPermission name="sfm:sfmFlow:edit"><td>
    				<a href="${ctx}/sfm/sfmFlow/form?id=${sfmFlow.id}">修改</a>
					<a href="${ctx}/sfm/sfmFlow/delete?id=${sfmFlow.id}" onclick="return confirmx('确认要删除该流程配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>