<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>班级信息管理</title>

<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

<script type="text/javascript">
	function searchGrade()
	{
		$('#dg').datagrid('load',{
			gradeName: $('#s_gradeName').val()
		});
	}
</script>

</head>
<body style="margin: 5px;">
	<table id="dg" title="班级信息" class="easyui-datagrid" fitColumns = "true" pagination = "true" 
	rownumbers = "true" fit = "true" url="GradeServlet" toolbar="#toolbar">
		<thead > 
			<tr> 
				<th field="checkbox" checkbox="true"></th>
				<th field="gradeId" width="50">编号</th>
				<th field="gradename" width="100">年级名称</th>
				<th field="gradeDesc" width="250">年级描述</th>
			</tr>
		</thead>
	</table>
	
	<div id="toolbar">
		<div>
			<a href="#" class="easyui-linkbutton" iconCls="icon-add" plain = "true">添加</a>
			<span class="datagrid-btn-separator" style="vertical-align: middle; display:inline-block; float: none;"/>
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-edit" plain = "true">修改</a>
			<span class="datagrid-btn-separator" style="vertical-align: middle; display:inline-block; float:none"></span>
			
			<a href="#" class="easyui-linkbutton" iconCls="icon-remove" plain = "true">删除</a>
			<span class="datagrid-btn-separator" style="vertical-align: middle;display:inline-block;float:none"></span>
			
			<div style="display: inline-block;">
				&nbsp;&nbsp;班级名称: <input type="text" name="s_gradeName" id="s_gradeName"/>
				<a href="Javascript:searchGrade()" class="easyui-linkbutton" iconCls="icon-search" plain = "true"></a>
			</div>
			
		</div>
	</div>
	
</body>
</html>