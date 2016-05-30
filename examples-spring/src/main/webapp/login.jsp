<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<!DOCTYPE html">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<%@ include file="commons/common.jsp"%>
<link rel="stylesheet" href="${ctx }/styles/login.css" media="screen" type="text/css" />
<script type="text/javascript" src="${ctx }/js/registerCheck.js"></script>
<style type="text/css">
.align-center {
	width: 350px;
	height: 250px;
	position: absolute;
	left: 50%;
	top: 50%;
	margin-top: -150px;
	margin-left: -175px;
	border: solid #000 0px;
	z-index: 1;
}
</style>
<script type="text/javascript">
	function submitForm() {
		$.ajax({
			url : '${ctx}/users/usersAction!reg.action',
			type : 'POST',
			dataType : 'json',
			data : $('#mainForm').serialize(),
			success : function(json) {
				var obj = jQuery.parseJSON(json);
				if (obj.success) {
					alert(obj.msg);
				}
			}
		});
	}
</script>
</head>
<body>
	<div class="align-center">
		<form id="mainForm" action="${ctx }/login/login" method="post">
			<input id="username" name="userName" placeholder="账号" class="name" required />
			<input id="password" name="passWord" placeholder="密码" class="name" required />
			<!-- 
			<input id="confirm_password" name="confirm_password" placeholder="确认密码" class="name" required />
			<textarea rows="3" cols="10" name="subject" placeholder="Please enter your message" class="message" required></textarea>
			-->
			<input name="submit" class="btn" type="submit" value="登录"/>
			<input name="register" class="btn btn-primary btn-lg" style="font-size: 15px;" data-toggle="modal" data-target="#myModal" type="button" value="注册"/>
		</form>
	</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">模态框（Modal）标题</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form" name="formUser" action="${ctx }/register/successed" method="post" style="width: 99%;background-color: white;" >
						<div class="form-group">
				            <label for="inputEmail3" class="col-sm-2 control-label">用户名:</label>
				            <div class="col-sm-8">
				                <input type="email" class="form-control" id="inputEmail3" placeholder="请输入您的用户名"/>
				            </div>
				        </div>
				        <div class="form-group">
				            <label for="inputEmail3" class="col-sm-2 control-label">密码:</label>
				            <div class="col-sm-8">
				                <input class="form-control" id="password" name="password" type="password" placeholder="请输入您的密码" 
				                	onblur="checkPassword(this)" onkeyup="checkIntensity(this.value)" />
				            </div>
				        </div>
				        
						<table style="width: 100%; text-align: center;" class="form-group">
							<tbody>
								<tr>
									<td align=right width="15%"><strong>用户名:</strong></td>
									<td width="57%">
										<input id="username" name="username" onblur="checkUserName(this)" />
										<span id="username_notice">*</span>
									</td>
								</tr>
								<tr>
									<td align=right><strong>密码:</strong></td>
									<td>
										<input id="password" name="password" type="password" onblur="checkPassword(this)" onkeyup="checkIntensity(this.value)" />
										<span id="password_notice">*</span>
									</td>
								</tr>
								<tr>
									<td align=right><strong>密码强度:</strong></td>
									<td>
										<table cellspacing=0 cellpadding=1 width=145 border=0>
											<tbody>
												<tr valign="middle">
													<td id=pwd_lower width="33%">弱</td>
													<td id=pwd_middle width="33%">中</td>
													<td id=pwd_high width="33%">强</td>
												</tr>
											</tbody>
										</table>
									</td>
								</tr>
								<tr>
									<td align=right><strong>确认密码:</strong></td>
									<td>
										<input id="conform_password" name="confirm_password"
											type="password" onBlur="checkConformPassword(this)" />
										<span id="conform_password_notice">*</span>
									</td>
								</tr>
								<tr>
									<td align=right><strong>邮箱:</strong></td>
									<td>
										<input id="email" name="email" onblur="checkEmail(this)" /><span id=email_notice>*</span>
									</td>
								</tr>
								<tr>
									<td></td>
									<td>
										<label>
											<input type="checkbox" id="agreement" onclick="checkAgreement(this)" />
											<b>我已看过并接受《<a href="#">用户协议</a>》<span id=agreement_notice>*</span></b>
										</label>
									</td>
								</tr>
								<tr>
									<td><input type=hidden value=act_register name=act></td>
									<td><input type=submit value=确认注册 name="Submit1" class="anniu" disabled></td>
								</tr>
								<tr>
									<td colspan=2></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary">提交更改</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
