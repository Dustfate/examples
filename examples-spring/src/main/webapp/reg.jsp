<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta charset="UTF-8">
<title>注册</title>
<%@ include file="commons/common.jsp"%>
<script type="text/javascript">
$(document).on("click", "#sub", function(){
	alert();
	$.ajax({
        url: '${ctx}/users/usersAction!reg.action',
        type: 'POST',
        dataType: 'json',
        data: params,
        success: function (json) {
        	var obj = jQuery.parseJSON(json);
			if (obj.success) {
				$('#user_reg_regDialog').dialog('close');
			}
			$.messager.show({
				title : '提示',
				msg : obj.msg
			});
        }

    });
});
function submit(){
	alert();
	
	$.ajax({
        url: '/users/usersAction!reg.action',
        type: 'POST',
        dataType: 'json',
        data: params,
        success: function (json) {
        	var obj = jQuery.parseJSON(json);
			if (obj.success) {
				$('#user_reg_regDialog').dialog('close');
			}
			$.messager.show({
				title : '提示',
				msg : obj.msg
			});
        }

    });
}

</script>
</head>
<body>
	<form id="user_reg_regForm" method="post">
		<table>
			<tr>
				<th>登录名</th>
				<td><input id="username" name="users.username" /></td>
			</tr>
			<tr>
				<th>密码</th>
				<td><input id="passwork" name="users.password" type="password"/></td>
			</tr>
			<tr>
				<th>确认密码</th>
				<td><input id="repassword" name="repassword" type="password"/></td>
			</tr>
			<tr align="center">
				<td colspan="2"><input id="sub" name="sub" type="button" onclick="submit();" value="提交"/></td>
			</tr>
		</table>
	</form>
</body>