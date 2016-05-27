<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册验证实例</title>
<%@ include file="commons/common.jsp"%>
<script type="text/javascript" src="js/registerCheck.js"></script>
</head>
<body>
${1+2}
${pageContext.request.queryString}         取得请求的参数字符串
      ${pageContext.request.requestURL}         取得请求的URL，但不包括请求之参数字符串
      ${pageContext.request.contextPath}         服务的web application 的名称
      ${pageContext.request.method}           取得HTTP 的方法(GET、POST)
      ${pageContext.request.protocol}         取得使用的协议(HTTP/1.1、HTTP/1.0)
      ${pageContext.request.remoteUser}         取得用户名称
      ${pageContext.request.remoteAddr }         取得用户的IP 地址
      ${pageContext.session.new}             判断session 是否为新的
      ${pageContext.session.id}               取得session 的ID
      ${pageContext.servletContext.serverInfo}   取得主机端的服务信息
	<div id="reg">
		<form name="formUser" action="http://localhost:8080/examples-spring/register/successed" method=post>
			<br>
			<table width="100%" align=center border=0>
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
							<input id="password" name="password" type="password" 
								onblur="checkPassword(this)" onkeyup="checkIntensity(this.value)" />
							<span id=password_notice>*</span></td>
					</tr>
					<tr>
						<td align=right><strong>密码强度:</strong></td>
						<td>
							<table cellspacing=0 cellpadding=1 width=145 border=0>
								<tbody>
									<tr align=middle>
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
							<input id="conform_password" name="confirm_password" type="password" 
								onBlur="checkConformPassword(this)" />
							<span id=conform_password_notice>*</span>
						</td>
					</tr>
					<tr>
						<td align=right><strong>邮箱:</strong></td>
						<td>
							<input id="email" name="email" onblur="checkEmail(this)" />
							<span id=email_notice>*</span>
						</td>
					</tr>
					<tr>
						<td></td>
						<td>
							<label> 
								<input type="checkbox" id="agreement" onclick="checkAgreement(this)">
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
</body>
</html>