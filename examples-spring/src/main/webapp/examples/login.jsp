<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CSS3联系表单 背景透明迷人DEMO演示</title>
	<%@ include file="../commons/common.jsp"%>
	<link rel="stylesheet" href="../styles/login.css" media="screen" type="text/css" />
</head>
<body>
	<form>
		<input name="name" placeholder="What is your name?" class="name" required />
		<input name="emailaddress" placeholder="What is your email?" class="email" type="email" required />
		<textarea rows="4" cols="50" name="subject" placeholder="Please enter your message" class="message" required></textarea>
		<input name="submit" class="btn" type="submit" value="Send" />
	</form>

</body>
</html>
