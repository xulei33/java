<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>环节配置管理</title>
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
		<li class="active"><a href="${ctx}/sfm/sfmWorkItem/">环节配置列表</a></li>
		<shiro:hasPermission name="sfm:sfmWorkItem:edit"><li><a href="${ctx}/sfm/sfmWorkItem/form">环节配置添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sfmWorkItem" action="${ctx}/sfm/sfmWorkItem/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>流程ID：</label>
				<form:input path="flowId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>环节ID：</label>
				<form:input path="workItemId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="sfm:sfmWorkItem:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sfmWorkItem">
			<tr>
				<shiro:hasPermission name="sfm:sfmWorkItem:edit"><td>
    				<a href="${ctx}/sfm/sfmWorkItem/form?id=${sfmWorkItem.id}">修改</a>
					<a href="${ctx}/sfm/sfmWorkItem/delete?id=${sfmWorkItem.id}" onclick="return confirmx('确认要删除该环节配置吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>