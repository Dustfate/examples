<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../../commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<!-- Tell the browser to be responsive to screen width -->
<meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
<!-- Bootstrap 3.3.7 -->
<link rel="stylesheet" href="${ctx }/AdminLTE-2.3.11/bootstrap/css/bootstrap.css">
<!-- Font Awesome -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="${ctx }/AdminLTE-2.3.11/dist/css/AdminLTE.min.css">
<!-- iCheck -->
<link rel="stylesheet" href="${ctx }/AdminLTE-2.3.11/plugins/iCheck/square/blue.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--
	[if lt IE 9]>
  		<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  		<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
 	<![endif]
-->
</head>
<body class="hold-transition login-page">
	<div class="login-box">
		<div class="login-logo">
			<a href="#"><b>Admin</b>LTE</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">Sign in to start your session</p>
			
			<form id="loginForm" name="loginForm" action="" method="post">
				<div class="form-group has-feedback">
					<input id="userName" name="userName" class="form-control" placeholder="用户名" required>
					<span class="glyphicon glyphicon-user form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input id="passWord" name="passWord" type="password" class="form-control" placeholder="密     码" required>
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-8">
						<div class="checkbox icheck">
							<label> <input id="rememberme" name="rememberme" type="checkbox"> 记住我 </label>
						</div>
					</div>
					<!-- /.col -->
					<div class="col-xs-4">
						<button type="button" class="btn btn-primary btn-block btn-flat" onclick="severCheck();">登录</button>
					</div>
					<!-- /.col -->
				</div>
			</form>

			<div class="social-auth-links text-center">
				<p>- OR -</p>
				<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a> 
				<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>
			</div>
			
			<!-- /.social-auth-links -->

			<a href="#">忘记密码</a><br> 
			<a href="register.html" class="text-center">注册</a>
		</div>
		<!-- /.login-box-body -->
	</div>
	<!-- /.login-box -->

	<!-- jQuery 2.2.3 -->
	<script src="${ctx }/AdminLTE-2.3.11/plugins/jQuery/jquery-2.2.3.min.js"></script>
	<!-- Bootstrap 3.3.7 -->
	<script src="${ctx }/AdminLTE-2.3.11/bootstrap/js/bootstrap.min.js"></script>
	<!-- iCheck -->
	<script src="${ctx }/AdminLTE-2.3.11/plugins/iCheck/icheck.min.js"></script>
	<!-- 提示框 -->
	<script src="${ctx }/js/jquery.tips.js"></script>
	<script>
		$(function() {
			$('input').iCheck({
				checkboxClass : 'icheckbox_square-blue',
				radioClass : 'iradio_square-blue',
				increaseArea : '20%' // optional
			});
		});
		
		function savePaw() {
			if (!$("#rememberme").attr("checked")) {
				$.cookie('userName', '', {
					expires : -1
				});
				$.cookie('passWord', '', {
					expires : -1
				});
				$("#userName").val('');
				$("#passWord").val('');
			}
		}
		
		function saveCookie() {
			if ($("#saveid").attr("checked")) {
				$.cookie('userName', $("#userName").val(), {
					expires : 7
				});
				$.cookie('passWord', $("#passWord").val(), {
					expires : 7
				});
			}
		}
		
		//客户端校验
		function check() {
			if ($("#userName").val() == "") {
				$("#userName").tips({
					side : 2,
					msg : '用户名不得为空',
					bg : '#AE81FF',
					time : 3
				});
				$("#userName").focus();
				return false;
			}

			if ($("#passWord").val() == "") {
				$("#passWord").tips({
					side : 2,
					msg : '密码不得为空',
					bg : '#AE81FF',
					time : 3
				});
				$("#passWord").focus();
				return false;
			}
			return true;
		}

		function severCheck() {
			if(check()){
				$.ajax({
					type : "POST",
					url : '${ctx }/login/login',
					data : $('#loginForm').serialize(),
					dataType : 'json',
					cache : false,
					success : function(data) {
						if ("success" == data.result) {
							saveCookie();
							window.location.href = "${ctx }/login/index";
						} else if ("usererror" == data.result) {
							$("#userName").tips({
								side : 2,
								msg : '用户名或密码有误',
								bg : '#AE81FF',
								time : 15
							});
							$("#passWord").tips({
								side : 2,
								msg : '用户名或密码有误',
								bg : '#AE81FF',
								time : 15
							});
						} else if ("codeerror" == data.result) {
							$("#code").tips({
								side : 1,
								msg : "验证码输入有误",
								bg : '#FF5080',
								time : 15
							});
							$("#code").focus();
						} else {
							$("#userName").tips({
								side : 1,
								msg : "缺少参数",
								bg : '#FF5080',
								time : 15
							});
							$("#userName").focus();
						}
					}
				});
			}
		}
	</script>
</body>
</html>