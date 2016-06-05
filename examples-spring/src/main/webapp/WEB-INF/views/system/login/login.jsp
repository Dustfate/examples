<%@ page language="java" pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>登录</title>
<%@ include file="../../../../commons/common.jsp"%>
<link rel="stylesheet" href="${ctx }/styles/login.css" media="screen" type="text/css" />
<script type="text/javascript" src="${ctx }/js/registerCheck.js"></script>
<script type="text/javascript" src="${ctx }/js/alert.js"></script>
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
	$("#myModal").modal({
		backdrop: 'static', keyboard: false
	});
	
	$(function () {
		$("#register").click(function(){
			$('.popover-hide').val("");
			$("#agreement").attr("checked",false);
		});

		$("[data-toggle='popover']").popover();
		
		$("#myModal").on('hide.bs.modal', function () {
			$('.popover-hide').popover('hide');
		});
	});
	
	
</script>
</head>
<body>

	<div style="background-color: white;text-align: center;">${message }</div>
	<div class="align-center">
		<form id="mainForm" action="${ctx }/login/login" method="post">
			<input id="username" name="userName" placeholder="账号" class="name" required />
			<input id="password" name="passWord" placeholder="密码" type="password" class="name" required />
			<!-- 
			<input id="confirm_password" name="confirm_password" placeholder="确认密码" class="name" required />
			<textarea rows="3" cols="10" name="subject" placeholder="Please enter your message" class="message" required></textarea>
			-->
			<input name="submit" class="btn" type="submit" value="登录"/>
			<input id="register" name="register" class="btn btn-primary btn-lg" style="font-size: 15px;" data-toggle="modal" data-target="#myModal" type="button" value="注册"/>
		</form>
	</div>
	
	<!-- 模态框（Modal） -->
	<div class="modal fade" id="myModal" role="dialog" data-backdrop="static" data-keyboard="false"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">注册信息</h4>
				</div>
				<div class="modal-body">
					<form id="formUser" name="formUser" class="form-horizontal" role="form" action="" method="post" 
						style="width: 99%;height: 65%;background-color: white;" >
						<div class="form-group">
				            <label class="col-sm-3 control-label">用户名:</label>
				            <div class="col-sm-8">
				                <input id="userName" name="userName" type="text" class="form-control popover-hide" placeholder="请输入您的用户名"
				                	data-container="body" data-toggle="popover" data-placement="top" data-content="" 
				                	onblur="checkUserName(this);" />
				            </div>
				        </div>
				        <div class="form-group">
				            <label class="col-sm-3 control-label">密码:</label>
				            <div class="col-sm-8">
				                <input id="passWord" name="passWord" type="password" class="form-control popover-hide" placeholder="请输入您的密码" 
				                	data-container="body" data-toggle="popover" data-placement="top" data-content="" 
				                	onblur="checkPassword(this);" onkeyup="checkIntensity(this.value);" />
				            </div>
				        </div>
				        <div class="form-group">
				            <label class="col-sm-3 control-label">密码强度:</label>
				            <div class="col-sm-8">
				                <table cellspacing=0 cellpadding=1 width=145 border=0>
									<tbody>
										<tr valign="middle">
											<td id=pwd_lower width="33%">弱</td>
											<td id=pwd_middle width="33%">中</td>
											<td id=pwd_high width="33%">强</td>
										</tr>
									</tbody>
								</table>
				            </div>
				        </div>
				        <div class="form-group">
				            <label class="col-sm-3 control-label">确认密码:</label>
				            <div class="col-sm-8">
				                <input id="conform_password" name="confirm_password" type="password" class="form-control popover-hide" placeholder="请输入您的密码" 
				                	data-container="body" data-toggle="popover" data-placement="top" data-content="" 
				                	onblur="checkConformPassword(this)" />
				            </div>
				        </div>
				        <div class="form-group">
				            <label class="col-sm-3 control-label">邮箱地址:</label>
				            <div class="col-sm-8">
				            	<input id="emailAddress" name="emailAddress" type="email" class="form-control popover-hide" placeholder="请输入您的邮箱地址" 
				            		data-container="body" data-toggle="popover" data-placement="top" data-content="" 
				            		onblur="checkEmail(this)" />
				            </div>
				        </div>
				        <div class="checkbox">
							<label style="margin-left: 80px;">
								<input style="height: 15px;width: 15px;" type="checkbox" id="agreement" 
									data-container="body" data-toggle="popover" data-placement="right" data-content="" 
									onclick="checkAgreement(this)" />
								&nbsp;&nbsp;
								<b>我已看过并接受《<a href="#">用户协议</a>》<span class="popover-hide" id=agreement_notice>*</span></b>
							</label>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button id="sbumit" name="Submit1" class="btn btn-primary" onclick="form_submit();" >注册</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal -->
	</div>
</body>
</html>
