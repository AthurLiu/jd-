<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<title>购物商城登录界面</title>
		<link rel="shortcut icon" type="image/x-icon" href="../picture/jd_logo.ico"/>
		<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
		<link rel="stylesheet" href="../css/login.css?v=<%=System.currentTimeMillis()%>">		
	</head>
	<body>
		<div class="divt">
			<form action="" id="form1" method="POST">
				<br>
				<h4>~~~~~~~~~ login ~~~~~~~~~</h4>
				<table>
					<tr>
						<td>
							&nbsp;&nbsp;用户名：
						</td>
						<td>
							<input id="name" type="text" name="name" onblur="validateUser(this.form.name)">
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码：
						</td>
						<td>
							<input id="pwd" type="password" name="pwd" onblur="validatePass(this.form.pwd)" value="qwertyuiop">
						</td>
					</tr>
					<tr>
						<td>
							&nbsp;&nbsp;验证码：
						</td>
						<td>
							<input id="yzm" type="text"  onblur="validateYzm(this.form.yzm)">
						</td>
					</tr>
					<tr>
						<td>
							<p title="看不清，换一张" onclick="change()">&nbsp;&nbsp;换一张：</p>
						</td>
						<td>
							<div id="number"></div><span id="yzm_time"></span>
						</td>
					</tr>
					<tr>
						<td>
							<a href="register.jsp" title="注册">注&nbsp;&nbsp;&nbsp;册</a>
						</td>
						<td>
							<input class="button" type="button" value="登录" onclick="login()">
							<input class="button" type="reset" value="复位">
						</td>
					</tr>
					<tr>
						<td>
							<a class="find_pass" href="" title="找回密码">找回密码</a>
						</td>
						<td>
							<div id="mes">
								<span id="tips"><%=request.getParameter("message") == null ? "" : request.getParameter("message")%></span>
							</div>
						</td>
					</tr>
				</table>
				<span id="hide_pass"><img alt="" src="../picture/eye.jpg" title="隐藏密码"></span>
			</form>
			<script src="../js/login.js?v=<%=System.currentTimeMillis()%>" type="text/javascript"></script>
		</div>
		<div class="divb">
			&nbsp;&nbsp;<a href=""> 关于我们 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 联系我们 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 人才招聘 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 商家入驻 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 广告服务 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 手机京东 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 友情链接 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 销售联盟 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 京东社区 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href=""> 京东公益 </a>&nbsp;&nbsp;|
			&nbsp;&nbsp;<a href="">English Site</a><br><br>
			&nbsp;&nbsp;<span>Copyright © 2004-2019  京东JD.com 版权所有</span>
		</div>
	</body>
</html>