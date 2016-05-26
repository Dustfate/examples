<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<!DOCTYPE html">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CSS3联系表单 背景透明迷人DEMO演示</title>
	<%@ include file="commons/common.jsp"%>
	<link rel="stylesheet" href="styles/login.css" media="screen" type="text/css" />
	<script type="text/javascript">
		function submitForm(){
			$.ajax({
		        url: '${ctx}/users/usersAction!reg.action',
		        type: 'POST',
		        dataType: 'json',
		        data: $('#mainForm').serialize(),
		        success: function (json) {
		        	var obj = jQuery.parseJSON(json);
					if (obj.success) {
						alert(obj.msg);
					}
		        }
		    });
		}
		
		
	</script>
</head>
<body>
	<form id="mainForm" action="http://localhost:8080/examples-spring/login" method="post">
		<input id="username" name="Users.username" placeholder="账号" class="name" required />
		<input id="password" name="Users.password" placeholder="密码" class="name" required />
		<input name="password" placeholder="确认密码" class="name" required />
		<textarea rows="3" cols="10" name="subject" placeholder="Please enter your message" class="message" required></textarea>
		<input name="submit" class="btn" type="submit" value="注册"/>
	</form>

</body>
</html>
