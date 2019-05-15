<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>交易管理管理</title>
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
		<li class="active"><a href="${ctx}/sfm/sfmAlert/">交易管理列表</a></li>
		<shiro:hasPermission name="sfm:sfmAlert:edit"><li><a href="${ctx}/sfm/sfmAlert/form">交易管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sfmAlert" action="${ctx}/sfm/sfmAlert/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>报警唯一标记：</label>
				<form:input path="alertId" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>交易编号：</label>
				<form:input path="cmxTranId" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li><label>机构号：</label>
				<form:input path="office.id" htmlEscape="false" maxlength="64" class="input-medium"/>
			</li>
			<li><label>操作员编号：</label>
				<sys:treeselect id="user" name="user.id" value="${sfmAlert.user.id}" labelName="user.name" labelValue="${sfmAlert.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>报警值：</label>
				<form:input path="alertValue" htmlEscape="false" maxlength="100" class="input-medium"/>
			</li>
			<li><label>报警状态：</label>
				<form:input path="alertStatus" htmlEscape="false" maxlength="10" class="input-medium"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="sfm:sfmAlert:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sfmAlert">
			<tr>
				<shiro:hasPermission name="sfm:sfmAlert:edit"><td>
    				<a href="${ctx}/sfm/sfmAlert/form?id=${sfmAlert.id}">修改</a>
					<a href="${ctx}/sfm/sfmAlert/delete?id=${sfmAlert.id}" onclick="return confirmx('确认要删除该交易管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>