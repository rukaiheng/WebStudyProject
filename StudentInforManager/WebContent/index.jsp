<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login" method="post">
		<div style="padding-top: 50px">
			<table width="750" height = "400" align="center" border="1" background="images/login.jpg">
				<tr height="200">
					<td colspan="4"></td>
				</tr>

				<tr height="10">
					<td width="38%"></td>
					<td width="10%">username:</td>
					<td width="16%"><input type="text" name="username"
						id="username" /></td>
					<td></td>
				</tr>
				<tr height = "10">
					<td></td>
					<td width="10%">password:</td>
					<td width="16%"><input type="password" name="password" id="password" /></td>
					<td></td>
				</tr>
				<tr height = "10">
					<td></td>
					<td width="10%"></td>
					<td width="16%">
						<input with="30" type="submit" name="login" id="login" value="submit" /> 
						<input with="30" type="submit" name="reset" id="reset" value="reset" /></td>
					<td></td>
				</tr>
				<tr heiht = "10">
					<td></td>
					<td colspan="3" style="font-style: normal;color: red"> ${errorMessage}</td>
				</tr>
			</table>
		</div>
	</form>
</body>
</html>