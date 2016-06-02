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
				<p>亚历山大·皮尔斯</p>
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
					<i class="fa fa-dashboard"></i> <span>仪表板</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li class="active">
						<a href="../../AdminLTE-2.3.3/index.html"><i class="fa fa-circle-o"></i> 仪表板 v1 </a></li>
						<li><a href="../../AdminLTE-2.3.3/index2.html"><i class="fa fa-circle-o"></i> 仪表板 v2 </a></li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-files-o"></i>
					<span>布局选项</span> <span class="label label-primary pull-right">4</span>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="../../AdminLTE-2.3.3/pages/layout/top-nav.html"><i class="fa fa-circle-o"></i> 顶部导航 </a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/layout/boxed.html"><i class="fa fa-circle-o"></i> Boxed </a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/layout/fixed.html"><i class="fa fa-circle-o"></i> Fixed </a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/layout/collapsed-sidebar.html"><i class="fa fa-circle-o"></i> 关闭侧边栏 </a>
					</li>
				</ul>
			</li>
			<li>
				<a href="../../AdminLTE-2.3.3/pages/widgets.html">
					<i class="fa fa-th"></i> 
					<span> 小工具</span>
					<small class="label pull-right bg-green">new</small>
				</a>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-pie-chart"></i>
					<span> 图表</span>
					<i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="../../AdminLTE-2.3.3/pages/charts/chartjs.html">
						<i class="fa fa-circle-o"></i> ChartJS</a></li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/charts/morris.html">
						<i class="fa fa-circle-o"></i> Morris</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/charts/flot.html">
						<i class="fa fa-circle-o"></i> Flot</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/charts/inline.html"><i class="fa fa-circle-o"></i> Inline charts</a>
					</li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-laptop"></i>
					<span>UI 元素</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="../../AdminLTE-2.3.3/pages/UI/general.html">
						<i class="fa fa-circle-o"></i> General</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/UI/icons.html">
						<i class="fa fa-circle-o"></i> 图表</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/UI/buttons.html"><i
							class="fa fa-circle-o"></i> 按钮</a></li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/UI/sliders.html">
						<i class="fa fa-circle-o"></i> 滑块</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/UI/timeline.html">
						<i class="fa fa-circle-o"></i> 时间轴</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/UI/modals.html">
						<i class="fa fa-circle-o"></i> Modals</a>
					</li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-edit"></i>
					<span>表单</span><i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="../../AdminLTE-2.3.3/pages/forms/general.html">
						<i class="fa fa-circle-o"></i> General Elements</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/forms/advanced.html">
						<i class="fa fa-circle-o"></i> Advanced Elements</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/forms/editors.html">
						<i class="fa fa-circle-o"></i> 编辑</a>
					</li>
				</ul>
			</li>
			
			<li class="treeview">
				<a href="#">
					<i class="fa fa-table"></i>
					<span>表格</span><i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="../../AdminLTE-2.3.3/pages/tables/simple.html">
						<i class="fa fa-circle-o"></i> 简单表格</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/tables/data.html">
						<i class="fa fa-circle-o"></i> 数据表格</a>
					</li>
				</ul>
			</li>
			
			<li>
				<a href="../../AdminLTE-2.3.3/pages/calendar.html">
					<i class="fa fa-calendar"></i>
					<span>日历</span> <small class="label pull-right bg-red">3</small>
				</a>
			</li>
			<li>
				<a href="../../AdminLTE-2.3.3/pages/mailbox/mailbox.html">
					<i class="fa fa-envelope"></i> <span>邮箱</span>
					<small class="label pull-right bg-yellow">12</small>
				</a>
			</li>
			<li class="treeview">
				<a href="#">
					<i class="fa fa-folder"></i>
					<span>Examples</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/invoice.html">
						<i class="fa fa-circle-o"></i> Invoice</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/profile.html">
						<i class="fa fa-circle-o"></i> 简介</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/login.html">
						<i class="fa fa-circle-o"></i> 登录</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/register.html">
						<i class="fa fa-circle-o"></i> 注册</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/lockscreen.html">
						<i class="fa fa-circle-o"></i> 锁屏</a></li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/404.html">
						<i class="fa fa-circle-o"></i> 404 Error</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/500.html">
						<i class="fa fa-circle-o"></i> 500 Error</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/blank.html">
						<i class="fa fa-circle-o"></i> 空白页</a>
					</li>
					<li>
						<a href="../../AdminLTE-2.3.3/pages/examples/pace.html">
						<i class="fa fa-circle-o"></i> Pace Page</a>
					</li>
				</ul>
			</li>
			<li class="treeview">
				<a href="#"> 
					<i class="fa fa-share"></i>
					<span>Multilevel</span> <i class="fa fa-angle-left pull-right"></i>
				</a>
				<ul class="treeview-menu">
					<li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
					<li>
						<a href="#"><i class="fa fa-circle-o"></i> Level One<i class="fa fa-angle-left pull-right"></i></a>
						<ul class="treeview-menu">
							<li><a href="#"><i class="fa fa-circle-o"></i> Level Two</a></li>
							<li>
								<a href="#"><i class="fa fa-circle-o"></i> Level Two<i class="fa fa-angle-left pull-right"></i></a>
								<ul class="treeview-menu">
									<li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
									<li><a href="#"><i class="fa fa-circle-o"></i> Level Three</a></li>
								</ul>
							</li>
						</ul>
					</li>
					<li><a href="#"><i class="fa fa-circle-o"></i> Level One</a></li>
				</ul>
			</li>
			<li>
				<a href="../../AdminLTE-2.3.3/documentation/index.html"><i class="fa fa-book"></i>
				<span>文档</span></a>
			</li>
			<li class="header">标签</li>
			<li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>重要</span></a></li>
			<li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>警告</span></a></li>
			<li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>信息</span></a></li>
		</ul>
	</section>
	<!-- /.sidebar -->
</aside>

