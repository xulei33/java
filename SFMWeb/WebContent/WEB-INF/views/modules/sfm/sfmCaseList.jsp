<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>立案管理管理</title>
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
		<li class="active"><a href="${ctx}/sfm/sfmCase/">立案管理列表</a></li>
		<shiro:hasPermission name="sfm:sfmCase:edit"><li><a href="${ctx}/sfm/sfmCase/form">立案管理添加</a></li></shiro:hasPermission>
	</ul>
	<form:form id="searchForm" modelAttribute="sfmCase" action="${ctx}/sfm/sfmCase/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<ul class="ul-form">
			<li><label>案件ID：</label>
				<form:input path="caseId" htmlEscape="false" maxlength="11" class="input-medium"/>
			</li>
			<li><label>告警ID：</label>
				<form:input path="alertId" htmlEscape="false" maxlength="20" class="input-medium"/>
			</li>
			<li><label>立案人：</label>
				<sys:treeselect id="user" name="user.id" value="${sfmCase.user.id}" labelName="user.name" labelValue="${sfmCase.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="input-small" allowClear="true" notAllowSelectParent="true"/>
			</li>
			<li><label>立案时间：</label>
				<input name="createTime" type="text" readonly="readonly" maxlength="20" class="input-medium Wdate"
					value="<fmt:formatDate value="${sfmCase.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>"
					onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss',isShowClear:false});"/>
			</li>
			<li class="btns"><input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/></li>
			<li class="clearfix"></li>
		</ul>
	</form:form>
	<sys:message content="${message}"/>
	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead>
			<tr>
				<shiro:hasPermission name="sfm:sfmCase:edit"><th>操作</th></shiro:hasPermission>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${page.list}" var="sfmCase">
			<tr>
				<shiro:hasPermission name="sfm:sfmCase:edit"><td>
    				<a href="${ctx}/sfm/sfmCase/form?id=${sfmCase.id}">修改</a>
					<a href="${ctx}/sfm/sfmCase/delete?id=${sfmCase.id}" onclick="return confirmx('确认要删除该立案管理吗？', this.href)">删除</a>
				</td></shiro:hasPermission>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>