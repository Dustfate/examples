<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>AdminLTE 2 | Dashboard</title>
	<!-- Tell the browser to be responsive to screen width -->
	<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
	<%@include file="../../AdminLTE-2.3.3/commons/head-css.jsp"%>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
	<div class="wrapper">

		<!-- Main Header -->
		<%@include file="../../AdminLTE-2.3.3/commons/main-header.jsp"%>
		
		<!-- Left side column. contains the logo and sidebar -->
		<%@include file="../../AdminLTE-2.3.3/commons/main-sidebar.jsp"%>

		<!-- Content Wrapper. Contains page content -->
		<%@include file="../../AdminLTE-2.3.3/commons/content-wrapper.jsp"%>
		<!-- /.content-wrapper -->

		<!-- Main Footer -->
		<%@include file="../../AdminLTE-2.3.3/commons/main-footer.jsp"%>

		<!-- Control Sidebar -->
		<%@include file="../../AdminLTE-2.3.3/commons/control-sidebar.jsp"%>
		<!-- /.control-sidebar -->
		
		
		<!-- Add the sidebar's background. This div must be placed immediately after the control sidebar -->
		<div class="control-sidebar-bg"></div>
	</div>
	<!-- ./wrapper -->

	<%@include file="../../AdminLTE-2.3.3/commons/footer-js.jsp"%>
	<!-- page script -->
<script>
	$(function() {
		$('#example1').DataTable({
			"paging" : true,
			"lengthChange" : true,
			"searching" : true,
			"ordering" : true,
			"info" : true,
			"autoWidth" : false
		});
	});
</script>
</body>
</html>