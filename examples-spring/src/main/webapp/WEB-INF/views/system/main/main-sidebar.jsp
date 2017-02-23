<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<aside class="main-sidebar">
	<!-- sidebar: style can be found in sidebar.less -->
	<section class="sidebar">
		<!-- Sidebar user panel -->
		<div class="user-panel">
			<div class="pull-left image">
				<img src="${ctx }/AdminLTE-2.3.11/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
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
			
			<c:forEach items="${menuList}" var="menu" varStatus="vs">
				<c:if test="${vs.index == 0}">
					<li class="active treeview">
						<a href="#">
							<i class="fa fa-laptop"></i> <span>${menu.menuName }</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
						<ul class="treeview-menu">
							<li><a href="#" onclick="openMenu('${ctx }/menu/to_menu_list');"><i class="fa fa-arrow-right"></i> 菜单管理 </a></li>
						</ul>
					</li>
				</c:if>
				<c:if test="${vs.index > 0}">
					<li class="treeview">
						<a href="#">
							<i class="fa fa-laptop"></i> <span>${menu.menuName }</span> <i class="fa fa-angle-left pull-right"></i>
						</a>
					</li>
				</c:if>
			</c:forEach>
			
			
			
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>