<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title></title>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <script type="text/javascript" src="../js/jquery-3.3.1.js"></script>
        <script src="../js/super_user.js?v=<%=System.currentTimeMillis()%>" type="text/javascript"></script>
        <link rel="stylesheet" href="../css/super_user.css?v=<%=System.currentTimeMillis() %>">
    </head>
    <body>
    <a class="exitlogin">退出登录</a>
        <div>
            <h1>超管</h1><span id="user"><%=session.getAttribute("user").toString()%></span><br><br><br>
           <form>
           		<div>
	                <span>用户名</span>
	                <input type="text" name="name" id="name" onblur="validateUser(this.form.name)"><br><br>
	                <input id="delUser" type="button" value="删除用户" onclick="delUser(this.form.name)">
	                <input id="trunAllTable" type="button" value="清空数据库" onclick="trunAllTable(this.form.name)">
	                <input id="dropAllTable" type="button" value="删除数据库" onclick="dropAllTable(this.form.name)"><br><br>
	                <span id="tips"></span>
                </div>
           </form>
        </div>
    </body>
</html>