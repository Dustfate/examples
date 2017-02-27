<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>CSS3 3D旋转下拉菜单DEMO演示</title>
	<%@ include file="../commons/common.jsp"%>
	<link href="../styles/menu.css" rel="stylesheet" type="text/css" />
</head>
<body>

<div class="container">
	<ul class="menu">
		<li><a href="#">主页</a></li>
		<li><a href="#">菜单一</a>
			<ul class="submenu">
				<li><a href="#">子菜单A</a></li>
				<li><a href="#">子菜单B</a></li>
				<li><a href="#">子菜单C</a></li>
				<li><a href="#">子菜单D</a></li>
				<li><a href="#">子菜单E</a></li>
				<li><a href="#">子菜单F</a></li>
				<li><a href="#">子菜单G</a></li>
				<li><a href="#">子菜单H</a></li>
			</ul>
		</li>
		<li class="active"><a href="#s2">菜单二</a>
			<ul class="submenu">
				<li><a href="#">子菜单A</a></li>
				<li><a href="#">子菜单B</a></li>
				<li><a href="#">子菜单C</a></li>
				<li><a href="#">子菜单D</a></li>
				<li><a href="#">子菜单E</a></li>
				<li><a href="#">子菜单F</a></li>
				<li><a href="#">子菜单G</a></li>
				<li><a href="#">子菜单H</a></li>
			</ul>
		</li>
		<li><a href="#">菜单三</a>
			<ul class="submenu">
				<li><a href="#">子菜单A</a></li>
				<li><a href="#">子菜单B</a></li>
				<li><a href="#">子菜单C</a></li>
				<li><a href="#">子菜单D</a></li>
				<li><a href="#">子菜单E</a></li>
				<li><a href="#">子菜单F</a></li>
				<li><a href="#">子菜单G</a></li>
				<li><a href="#">子菜单H</a></li>
			</ul>
		</li>
		<li><a href="#">菜单四</a></li>
		<li><a href="#">返回教程</a></li>
	</ul>
</div>
</body>
</html>