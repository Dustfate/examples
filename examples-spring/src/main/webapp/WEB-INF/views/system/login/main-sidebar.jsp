<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${ctx }/AdminLTE-2.3.3/dist/img/user2-160x160.jpg" class="img-circle"
					alt="User Image">
			</div>
			<div class="pull-left info">
				<p>${userInfo.userName }</p>
				<a href="#"><i class="fa fa-circle text-success"></i> 在线</a>
			</div>
		</div>
		
		<!-- search form -->
		<form action="#" method="get" class="sidebar-form">
			<div class="input-group">
				<input type="text" name="q" class="form-control" placeholder="Search...">
				<span class="input-group-btn">
					<button type="submit" name="search" id="search-btn" class="btn btn-flat">
						<i class="fa fa-search"></i>
					</button>
				</span>
			</div>
		</form>
		<!-- /.search form -->
		
		<!-- sidebar menu: : style can be found in sidebar.less -->
		<ul class="sidebar-menu">
			<li class="header">主导航</li>
			<li class="active treeview">
				<a href="#">
					<i class="fa fa-laptop"></i> <span>系统管理</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li class="active"><a href="#" onclick="openMenu('${ctx }/menu/to_menu_list');"><i class="fa fa-arrow-right"></i> 菜单管理 </a></li>
				</ul>
			</li>
			
			<li>
				<a href="${ctx }/AdminLTE-2.3.3/pages/widgets.html">
					<i class="fa fa-th"></i> 
					<span> 小工具</span>
					<small class="label pull-right bg-green">new</small>
				</a>
			</li>
			
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>


<script type="text/javascript">
	function openMenu(url) {
		parent.parent.setIframeUrl(url);
	}
</script>