<style type="text/css">
  	#menuList_length {
  		text-align: center;
  		width: 150px;
  		height: 34px;
  		float: left;
  	}
  	#menuList_info {
  		text-align: center;
  		width: 230px;
  		height: 34px;
  		float: left;
  	}
  	#menuList_paginate {
  		text-align: right;
  		width: 350px;
  		height: 34px;
  		float: right;
  		
  	}
</style>
<!-- Content Header (Page header) -->
<section class="content-header">
	<h1 style="margin-bottom: 10px;">
		Page Header <small>Optional description</small>
	</h1>
	<ol class="breadcrumb" style="margin-bottom: 10px;">
		<li><a href="#" onclick="goHomePage();"><i class="fa fa-dashboard"></i>首页</a></li>
		<li class="active">菜单管理</li>
	</ol>
</section>

<!-- Main content -->
<section class="content" style="background-color: white;">
	<div class="row">
		<div class="col-xs-12">
			<form class="form-horizontal" role="form" id="form1" action="index.html" method="post">
				<div class="form-group">
					<label class="col-sm-1 control-label no-padding-right" for="txtName">名称：</label>
					<div class="col-sm-7">
						<span class="input-icon width-100"> 
							<input id="menuName" type="text" class="form-control" data-validation-engine="validate[required]" placeholder="菜单名称" />
						</span>
					</div>
					<div class="col-sm-3"></div>
					<div class="col-sm-1 col-xs-1 align-right">
						<button type="button" class="btn btn-info btn-default-ths" id="btnSearch">
							<i class="ace-icon fa fa-search"></i> 搜索 
						</button>

					</div>
				</div>
				
				<hr class="no-margin">
				
				<div class="page-toolbar text-right list-toolbar">
                	<button type="button" class="btn btn-dropbox" id="btnAdd">
                    	<i class="fa fa-plus"></i> 添加
                    </button>
                    <button type="button" class="btn btn-foursquare" id="btnDelete">
                    	<i class="fa fa-trash-o"></i> 删除
                    </button>
               		<button type="button" class="btn btn-facebook" id="btnExport">
                    	<i class="fa fa-file-excel-o"></i> 导出
               		</button>
               	</div>
				
				<div class="box">
					<!--/.box-header -->
<!-- 					<div class="box-header"> -->
<!-- 						<h3 class="box-title">Data Table With Full Features</h3> -->
<!-- 					</div> -->
					<div class="box-body">
						<table id="menuList" class="table table-bordered table-striped table-hover">
							<thead>
								<tr>
									<th>编号</th>
									<th>菜单名称</th>
									<th>菜单图标</th>
									<th>菜单地址</th>
									<th>菜单类型</th>
									<th>是否启用</th>
									<th>操作</th>
								</tr>
							</thead>
							
<!-- 							<tfoot> -->
<!-- 								<tr> -->
<!-- 									<th>编号</th> -->
<!-- 									<th>菜单名称</th> -->
<!-- 									<th>菜单图标</th> -->
<!-- 									<th>菜单地址</th> -->
<!-- 									<th>菜单类型</th> -->
<!-- 									<th>是否启用</th> -->
<!-- 									<th>操作</th> -->
<!-- 								</tr> -->
<!-- 							</tfoot> -->
							
						</table>
					</div>
					<!-- /.box-body -->
				</div>
				<!-- /.box -->
				
			</form>

		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</section>
<!-- /.content -->

<!-- page script -->
<script type="text/javascript">
	$(function() {
		loadData();
	});

	function loadData() {
		var table = $('#menuList')
				.DataTable(
						{
							"dom": "t<'bottom'lip>",
							"language" : {
								url : "${pageContext.request.contextPath}/AdminLTE-2.3.11/language/zh_cn.txt"
							},
							"orderClasses" : false,
							"processing" : true, 												//显示加载效果
							"serverSide" : true, 												//开启服务器模式
							"ajax" : "${pageContext.request.contextPath}/menu/get_menu_list", 	//异步请求地址，和serverSide配合使用
							"paging" : true, 													//设置是否分页 默认是true
							//"scrollY": 450,													//在表格里使用滚动条
							//"scrollX": 200, 													//水平滚动条
							"lengthChange" : true, 												//是否显示改变页面显示条数的下拉框 默认是false
							"lengthMenu" : [ 10, 20, 50, 100 ], 								//显示下拉框的条数(-1表示显示全部)
							"searching" : false, 												//搜索 默认是false
							"ordering" : true, 													//排序 默认是false
							"info" : false, 													//显示分页信息 默认是false
							"scrollCollapse" : false, 											//当显示更少的记录时，是否允许表格减少高度
							//"order": [[ 1, 'asc' ]],											//把默认排序列设置成第2列，这样可以去掉第一列不排序的图标
							"autoWidth" : false,
							"sPaginationType" : "full_numbers", 								//分页样式，支持两种内置方式，two_button 和 full_numbers, 默认使用 two_button。
							"columns" : [ 
								{ "data" : "menuId", "orderable" : false }, 
								{ "data" : "menuName" }, 
								{ "data" : "menuIcon" }, 
								{ "data" : "menuUrl" }, 
								{ "data" : "menuType" }, 
								{ "data" : "isEnable" }
							],
							"createdRow" : function(row, data, index) {//这是某一行中列的值
								if (data.isEnable == 0) {
									$('td', row).eq(5).html("否").css('font-weight', "bold").css('color', "red");
								}
								if (data.isEnable == 1) {
									$('td', row).eq(5).html("是").css('font-weight', "bold");
								}
								$('td', row).eq(6).attr('style', 'text-align: center;')
							},
							"aoColumnDefs" : [
									{ "bSortable" : false, "aTargets" : 6 },//设置某列不排序，多个时可用 "aTargets": [0,1,2]
									{
										"aTargets" : [ 6 ],
										"mRender" : function(data, type, full) {
											return "<a href=\"#myModal-edit\" data-toggle=\"modal\" onclick=\"preUpdate('" + data + "')\">"
													+ "<i class=\"fa fa-lg-2 fa-pencil\"></i>"
												+ "</a>&nbsp;&nbsp;&nbsp;&nbsp;"
												+ "<a href=\"javascript:void(0)\" data-toggle=\"modal\" class=\"smart-mod-eg1\" onclick=\"delPool('" + data + "',event)\">"
													+ "<i class=\"fa fa-lg-2 fa-trash-o\"></i>"
												+ "</a>";
										}
									} ]
						});
	}
</script>