<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/taglibs.jsp"%>
<%@include file="../../../../AdminLTE-2.3.3/commons/head-css.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>首页</title>
	
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="content-wrapper">
	<!-- Content Header (Page header) -->
	<section class="content-header">
		<h1>
			Page Header <small>Optional description</small>
		</h1>
		<ol class="breadcrumb">
			<li><a href="#" onclick="test();"><i class="fa fa-dashboard"></i> 首页</a></li>
			<li class="active">菜单管理</li>
		</ol>
	</section>

	<!-- Main content -->
	<section class="content">
		<div class="row">
			<div class="col-xs-12">
	
				<div class="box">
					<!--
					<div class="box-header">
						<h3 class="box-title">Data Table With Full Features</h3>
					</div>
					 /.box-header -->
					<div class="box-body">
						<table id="example" class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>编号</th>
									<th>菜单名称</th>
									<th>菜单图标</th>
									<th>菜单地址</th>
									<th>菜单类型</th>
									<th>是否启用</th>
								</tr>
							</thead>
							<!-- 
							<tfoot>
								<tr>
									<th>编号</th>
									<th>菜单名称</th>
									<th>菜单图标</th>
									<th>菜单地址</th>
									<th>菜单类型</th>
									<th>是否启用</th>
								</tr>
							</tfoot>
							-->
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
	
			</div>
			<!-- /.col -->
		</div>
		<!-- /.row -->
		
	</section>
	<!-- /.content -->

</div>
</body>
</html>

<%@include file="../../../../AdminLTE-2.3.3/commons/footer-js.jsp"%>
<!-- page script -->
<script type="text/javascript">
	$(function() {
		$('#example').DataTable({
			language: {
		        "sProcessing": "处理中...",
		        "sLengthMenu": "显示 _MENU_ 项结果",
		        "sZeroRecords": "没有匹配结果",
		        "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
		        "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
		        "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
		        "sInfoPostFix": "",
		        "sSearch": "搜索:",
		        "sUrl": "",
		        "sEmptyTable": "表中数据为空",
		        "sLoadingRecords": "载入中...",
		        "sInfoThousands": ",",
		        "oPaginate": {
		            "sFirst": "首页",
		            "sPrevious": "上页",
		            "sNext": "下页",
		            "sLast": "末页"
		        },
		        "oAria": {
		            "sSortAscending": ": 以升序排列此列",
		            "sSortDescending": ": 以降序排列此列"
		        }
		    },
		    "orderClasses": false,
	        "processing": true,						//显示加载效果
	        "serverSide": true,						//开启服务器模式
			"ajax": "${ctx}/menu/get_menu_list",	//异步请求地址 和serverSide配合使用
			"paging": true,							//设置是否分页 默认是true
			"scrollY": 450,							//在表格里使用滚动条
			//"scrollX": 200, 						//水平滚动条
			"lengthChange" : true,					//是否显示改变页面显示条数的下拉框 默认是false
		    "lengthMenu": [10, 20, 50, 100],		//显示下拉框的条数
			"searching" : true,						//搜索 默认是false
			"ordering" : true,						//排序 默认是false
			"scrollCollapse": false,				//当显示更少的记录时，是否允许表格减少高度
			//"columnDefs": [							
			//	{ "orderable": false, "targets": 0 }//设置某列不排序
			//],
			//"order": [[ 1, 'asc' ]],				//把默认排序列设置成第2列，这样可以去掉第一列不排序的图标
			"info" : true,
			"autoWidth" : false,
			"columns": [
				{ "data": "menuId" },
			    { "data": "menuName" },
			    { "data": "menuIcon" },
			    { "data": "menuUrl" },
			    { "data": "menuType" },
			    { "data": "isEnable" }
			]
		});
	});
	
	/**
	*设置index页面的iframe的高度
	*/
	function changeHeight(){
		var hi = $(".content-wrapper").outerHeight(true);
		parent.parent.startInit('mainFrame', hi);
	}
	
</script>