<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>立案文件管理管理</title>
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
		<li class="active"><a href="${ctx}/sfm/sfmCaseFiles/">立案文件管理列表</a></li>
		<shiro:hasPermission name="sfm:sfmCaseFiles:edit"><li><a href="${ctx}/sfm/sfmCaseFiles/form">立案文件管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sfmCaseFiles" action="${ctx}/sfm/sfmCaseFiles/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>案件ID：</label>
				<form:input path="caseId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>任务ID：</label>
				<form:input path="taskId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="sfm:sfmCaseFiles:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sfmCaseFiles">
			<tr>
				<shiro:hasPermission name="sfm:sfmCaseFiles:edit"><td>
    				<a href="${ctx}/sfm/sfmCaseFiles/form?id=${sfmCaseFiles.id}">修改</a>
					<a href="${ctx}/sfm/sfmCaseFiles/delete?id=${sfmCaseFiles.id}" onclick="return confirmx('确认要删除该立案文件管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>