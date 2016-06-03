<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@ include file="../../../../commons/common.jsp"%>

</head>
<body>
<form id="mainForm" action="http://localhost:8080/examples-spring/menu/menu_list" method="post">
	<input id="pager" name="pager" value="${page.getCurPage }" />
	<table id="table_report" class="table table-striped table-bordered table-hover">
		<thead>
			<tr>
				<th class="center" style="width: 50px;">序号</th>
				<th class='center'>名称</th>
				<th class='center'>资源路径</th>
				<th class='center'>排序</th>
				<th class='center'>操作</th>
			</tr>
		</thead>
		<c:choose>
			<c:when test="${not empty menuList}">
				<c:forEach items="${menuList}" var="menu" varStatus="vs">
					<tr id="tr${menu.menuId }">
						<td class="center">${vs.index+1}</td>
						<td class='center'><i class="${menu.menuIcon }">&nbsp;</i>${menu.menuName }&nbsp;
							<c:if test="${menu.menuType == '1' }">
								<span class="label label-success arrowed">系统</span>
							</c:if>
							<c:if test="${menu.menuType != '1' }">
								<span class="label label-important arrowed-in">业务</span>
							</c:if>
						</td>
						<td>${menu.menuUrl == '#'? '': menu.menuUrl}</td>
						<td class='center'>${menu.menuOrder }</td>
						<td style="width: 25%;">
							<a class='btn btn-mini btn-warning' onclick="openClose('${menu.menuId }',this,${vs.index })">展开</a>
							<a class='btn btn-mini btn-purple' title="图标" onclick="editTb('${menu.menuId }')"><i class='icon-picture'></i></a>
							<a class='btn btn-mini btn-info' title="编辑" onclick="editmenu('${menu.menuId }')"><i class='icon-edit'></i></a>
							<a class='btn btn-mini btn-danger' title="删除" onclick="delmenu('${menu.menuId }',true)"><i class='icon-trash'></i></a>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="100">没有相关数据</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<tr align="right">
			<td colspan="5">
				<input id="previous" type="button" value="上一页" onclick="previous();" />
				&nbsp;&nbsp;&nbsp;&nbsp;
				<input id="next" type="button" value="下一页" onclick="next();" />
			</td>
		</tr>
	</table>
</form>
	<script type="text/javascript">
		function previous(){
			
			$("#mainForm").submit();
		}
		
		function next(){
			$("#pager").val(${page.getCurPage }+1);
			$("#mainForm").submit();
		}
	</script>
</body>
</html>