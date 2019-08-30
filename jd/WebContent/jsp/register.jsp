<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<title>购物商城注册界面</title>
		<link rel="shortcut icon" type="image/x-icon" href="../picture/jd_logo.ico"/>
		<link rel="stylesheet" href="../css/register.css?v=<%=System.currentTimeMillis()%>">
		<script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
		<script charset="UTF-8" src="../js/register.js?v=<%=System.currentTimeMillis()%>"></script>
	</head>
	<body>
		<div class="divt">
			<a href="login.jsp">去登录</a>
		</div>
		<form action="" id="form2" method="POST">
			<br>
			<h4>~~~~~~~~~ register ~~~~~~~~~</h4>
			<table>
				<tr>
					<td>
						用户名：
					</td>
					<td>
						<input id="user" type="text" name="lname" onblur="validateUser(this.form.user)" onchange="login_put('user')"><span id="span1">*</span>
					</td>
				</tr>
				<tr>
					<td>
						密&nbsp;&nbsp;&nbsp;码：
					</td>
					<td>
						<input id="pass" type="password" name="lpwd" onblur="validatePass(this.form.pass)" onchange="login_put('pass')"><span id="span2">*</span>
					</td>
				</tr>
				<tr>
					<td>
						&nbsp;&nbsp;确认密码：
					</td>
					<td>
						<input id="pass1" type="password" onblur="validatePass1(this.form.pass1)" onchange="login_put('pass1')"><span id="span3">*</span>
					</td>
				</tr>
				<tr>
					<td>手机号：</td>
					<td>
						<input id="phone" type="text" name="phone" onblur="validatePhone(this.form.phone)" onchange="login_put('phone')"><span id="span4">*</span>
					</td>
				</tr>
				<tr>
					<td>邮&nbsp;&nbsp;&nbsp;箱：</td>
					<td>
						<input id="email" type="text" name="email" onblur="validateEmail(this.form.email)" onchange="login_put('email')"><span id="span5">*</span>
					</td>
				</tr>
				<tr>
					<td>
						性&nbsp;&nbsp;&nbsp;别：
					</td>
					<td>
						男：<input id="sex" type="radio" name="sex" checked value="M">
						女：<input id="sex" type="radio" name="sex" value="F">
					</td>
				</tr>
				<tr>
					<td colspan="2">地址：
						<input id="address" type="text" name="address" style="display: none">
						<select id="countryID">
							<option value="selected">请选择国家</option>
							<option value="中国">中国</option>
							<option value="美国">美国</option>
							<option value="意大利">意大利</option>
							<option value="俄罗斯">俄罗斯</option>
							<option value="法国">法国</option>
							<option value="德国">德国</option>
							<option value="澳大利亚">澳大利亚</option>
						</select> 
						<span id="province">
							<select>
								<option>请选择省份</option>
							</select>
						</span>
						<span id="city"> 
							<select>
								<option>请选择市</option>
							</select>
						</span>
					</td>
				</tr>
				<tr>
					<td>
						<input class="button" type="reset" value="重置">
					</td>
					<td>
						<input id="submit" class="button" type="button" value="免费注册" onclick="register()">
						<a style="font-size:14px" href="login.jsp" title="登录">登录界面</a>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<span id="tips"><%=request.getParameter("message") == null ? "" : request.getParameter("message")%></span>
					</td>
				</tr>
			</table>
		</form>
		<div class="divb" style="width: 1500px;margin:20px auto;text-align: center">
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
				&nbsp;&nbsp;<span style="color:grey">Copyright © 2004-2019  京东JD.com 版权所有</span>
		</div>
	</body>
</html>