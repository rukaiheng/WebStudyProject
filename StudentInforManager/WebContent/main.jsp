<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>main page</title>


<%
	if(session.getAttribute("user")==null)
	{
		response.sendRedirect("index.jsp");
		return;
	}
%>

<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="jquery-easyui-1.5.3/themes/icon.css">
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.min.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="jquery-easyui-1.5.3/jquery.easyui.min.js"></script>

<script  type="text/javascript">
	$(function(){
		var treeData = [{
			text:"根",
			children:[{
			text:"班级信息管理",
			attributes: {
				url: "gradeInfoManage.jsp"
			}
			},{
			text:"学生信息管理",
			attributes:{
				url:"StudentInfoManage.jsp"
			}
			}]
		}];
		
		$("#tree").tree({
			data:treeData,
			lines:true,
			onClick:function(node){
				
				if(node.attributes){	
					openTab(node.text, node.attributes.url);
				}
			}
		});
		
		//add new tab
		function openTab(text, url)
		{
			if($("#tabs").tabs("exists", text)){
				//if the tab is already exist, just select it
				$("#tabs").tabs("select", text);
			}
			else{
				//create a iframe
				var content = "<iframe frameborder='0' width='100%' height = '100%' scrolling='auto' src = "+url+"></iframe>";
				//if there is no such a tab, add a tab
				$("#tabs").tabs('add',{
					title:text,
					content: content
				});
			}
		}
	})
</script>

</head>
<body class= "easyui-layout">
	<div region = "north" style="height:80px;background-color: #E0EDFF">
		
		<div align = "left" style="float:left" >
			<img src="images/main.jpg">
		</div>
	
		<div style = "float: right; padding-top: 10px;"> 
			<font size="3px", color="red">
				当前用户为: ${user.username}
			</font>	
		</div>
	</div>
	<div region = "west" style = "width: 180px" title="导航菜单"> 
		<ul id = "tree"></ul>
	</div>
	<div region = "south" style = "height: 30px" align="center">copyright: <a href="http://www.baidu.com">www.java1234.com</a></div>
	<div region = "center">
		<div class="easyui-tabs" fit="true" border = "false" id="tabs">
			<div title = "main page" >main</div>
		</div>
	</div>
</body>
</html>