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

</head>
<body>
	<table id="dg" title="班级信息" class="easyui-datagrid" fitColumns = "true" pagination = "true" 
	rownumbers = "true" fit = "true" url="GradeServlet">
		<thead > 
			<tr> 
				<th field="gradeId" width="50">编号</th>
				<th field="gradename" width="100">年级名称</th>
				<th field="gradeDesc" width="250">年级描述</th>
			</tr>
		</thead>
	</table>
</body>
</html>