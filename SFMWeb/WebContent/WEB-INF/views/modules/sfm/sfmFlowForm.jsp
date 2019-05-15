<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>流程配置管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			//$("#name").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
		function addRow(list, idx, tpl, row){
			$(list).append(Mustache.render(tpl, {
				idx: idx, delBtn: true, row: row
			}));
			$(list+idx).find("select").each(function(){
				$(this).val($(this).attr("data-value"));
			});
			$(list+idx).find("input[type='checkbox'], input[type='radio']").each(function(){
				var ss = $(this).attr("data-value").split(',');
				for (var i=0; i<ss.length; i++){
					if($(this).val() == ss[i]){
						$(this).attr("checked","checked");
					}
				}
			});
		}
		function delRow(obj, prefix){
			var id = $(prefix+"_id");
			var delFlag = $(prefix+"_delFlag");
			if (id.val() == ""){
				$(obj).parent().parent().remove();
			}else if(delFlag.val() == "0"){
				delFlag.val("1");
				$(obj).html("&divide;").attr("title", "撤销删除");
				$(obj).parent().parent().addClass("error");
			}else if(delFlag.val() == "1"){
				delFlag.val("0");
				$(obj).html("&times;").attr("title", "删除");
				$(obj).parent().parent().removeClass("error");
			}
		}
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sfm/sfmFlow/">流程配置列表</a></li>
		<li class="active"><a href="${ctx}/sfm/sfmFlow/form?id=${sfmFlow.id}">流程配置<shiro:hasPermission name="sfm:sfmFlow:edit">${not empty sfmFlow.id?'修改':'添加'}</shiro:hasPermission><shiro:lacksPermission name="sfm:sfmFlow:edit">查看</shiro:lacksPermission></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sfmFlow" action="${ctx}/sfm/sfmFlow/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>		
		<div class="control-group">
			<label class="control-label">流程ID：</label>
			<div class="controls">
				<form:input path="flowId" htmlEscape="false" maxlength="11" class="input-xlarge required"/>
				<span class="help-inline"><font color="red">*</font> </span>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">流程名称：</label>
			<div class="controls">
				<form:input path="flowName" htmlEscape="false" maxlength="128" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">流程描述：</label>
			<div class="controls">
				<form:input path="flowDescription" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">流程状态：</label>
			<div class="controls">
				<form:input path="flowStatus" htmlEscape="false" maxlength="10" class="input-xlarge "/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">创建人：</label>
			<div class="controls">
				<sys:treeselect id="user" name="user.id" value="${sfmFlow.user.id}" labelName="user.name" labelValue="${sfmFlow.user.name}"
					title="用户" url="/sys/office/treeData?type=3" cssClass="" allowClear="true" notAllowSelectParent="true"/>
			</div>
		</div>
			<div class="control-group">
				<label class="control-label">环节定义表：</label>
				<div class="controls">
					<table id="contentTable" class="table table-striped table-bordered table-condensed">
						<thead>
							<tr>
								<th class="hide"></th>
								<th>环节ID</th>
								<th>环节名称</th>
								<th>环节描述</th>
								<th>处理类型</th>
								<th>环节类型</th>
								<th>用户角色ID</th>
								<th>Java服务类</th>
								<th>下一环节ID</th>
								<shiro:hasPermission name="sfm:sfmFlow:edit"><th width="10">&nbsp;</th></shiro:hasPermission>
							</tr>
						</thead>
						<tbody id="sfmWorkItemList">
						</tbody>
						<shiro:hasPermission name="sfm:sfmFlow:edit"><tfoot>
							<tr><td colspan="10"><a href="javascript:" onclick="addRow('#sfmWorkItemList', sfmWorkItemRowIdx, sfmWorkItemTpl);sfmWorkItemRowIdx = sfmWorkItemRowIdx + 1;" class="btn">新增</a></td></tr>
						</tfoot></shiro:hasPermission>
					</table>
					<script type="text/template" id="sfmWorkItemTpl">//<!--
						<tr id="sfmWorkItemList{{idx}}">
							<td class="hide">
								<input id="sfmWorkItemList{{idx}}_id" name="sfmWorkItemList[{{idx}}].id" type="hidden" value="{{row.id}}"/>
								<input id="sfmWorkItemList{{idx}}_delFlag" name="sfmWorkItemList[{{idx}}].delFlag" type="hidden" value="0"/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_workItemId" name="sfmWorkItemList[{{idx}}].workItemId" type="text" value="{{row.workItemId}}" maxlength="11" class="input-small required"/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_workItemName" name="sfmWorkItemList[{{idx}}].workItemName" type="text" value="{{row.workItemName}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_workItemDesc" name="sfmWorkItemList[{{idx}}].workItemDesc" type="text" value="{{row.workItemDesc}}" maxlength="512" class="input-small "/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_procType" name="sfmWorkItemList[{{idx}}].procType" type="text" value="{{row.procType}}" maxlength="3" class="input-small "/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_workItemType" name="sfmWorkItemList[{{idx}}].workItemType" type="text" value="{{row.workItemType}}" maxlength="3" class="input-small "/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_userRoleId" name="sfmWorkItemList[{{idx}}].userRoleId" type="text" value="{{row.userRoleId}}" maxlength="30" class="input-small "/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_classpath" name="sfmWorkItemList[{{idx}}].classpath" type="text" value="{{row.classpath}}" maxlength="128" class="input-small "/>
							</td>
							<td>
								<input id="sfmWorkItemList{{idx}}_nextWorkItemId" name="sfmWorkItemList[{{idx}}].nextWorkItemId" type="text" value="{{row.nextWorkItemId}}" maxlength="11" class="input-small "/>
							</td>
							<shiro:hasPermission name="sfm:sfmFlow:edit"><td class="text-center" width="10">
								{{#delBtn}}<span class="close" onclick="delRow(this, '#sfmWorkItemList{{idx}}')" title="删除">&times;</span>{{/delBtn}}
							</td></shiro:hasPermission>
						</tr>//-->
					</script>
					<script type="text/javascript">
						var sfmWorkItemRowIdx = 0, sfmWorkItemTpl = $("#sfmWorkItemTpl").html().replace(/(\/\/\<!\-\-)|(\/\/\-\->)/g,"");
						$(document).ready(function() {
							var data = ${fns:toJson(sfmFlow.sfmWorkItemList)};
							for (var i=0; i<data.length; i++){
								addRow('#sfmWorkItemList', sfmWorkItemRowIdx, sfmWorkItemTpl, data[i]);
								sfmWorkItemRowIdx = sfmWorkItemRowIdx + 1;
							}
						});
					</script>
				</div>
			</div>
		<div class="form-actions">
			<shiro:hasPermission name="sfm:sfmFlow:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>