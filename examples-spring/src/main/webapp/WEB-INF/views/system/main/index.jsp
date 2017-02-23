<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>首页</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<%@include file="../../../../AdminLTE-2.3.11/commons/head-css.jsp"%>
	<%@include file="../../../../AdminLTE-2.3.11/commons/footer-js.jsp"%>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">
		<!-- Main Header -->
		<%@include file="main-header.jsp"%>
		
		<!-- 左侧菜单栏 -->
		<%@include file="main-sidebar.jsp"%>

		<!-- 右侧内容区域 -->
		<div class="content-wrapper">
			
		</div>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@include file="main-footer.jsp"%>
		
		<!-- 右上角的设置 -->
		<%@include file="control-sidebar.jsp"%>
		<!-- /.control-sidebar -->
		
		<!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->
	
	<script type="text/javascript">
		$(function() {
			openMenu("${ctx}/menu/to_menu_list");
		});
		function goHomePage(){
			alert("跳转到首页");
		}
		//打开左侧菜单
		function openMenu(url) {
			$.get(url, function(data) {
				$(".content-wrapper").html(data);
			});
		}
	</script>
</body>
</html>
