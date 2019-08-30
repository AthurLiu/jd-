<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>我的订单 - 京东商城</title>
        <link rel="shortcut icon" type="image/x-icon" href="picture/jd_logo.ico"/>
        <link rel="stylesheet" href="css/order_page.css?v=<%=System.currentTimeMillis()%>">
    </head>
    <body>
        <div class="head" id="head">
            <div>
                <div id="local" title="江苏">&nbsp;&nbsp;江苏&nbsp;&nbsp;</div>
                <span><%=session.getAttribute("user").toString()%></span>
                <a href="jsp/user_page.jsp">|  &nbsp;&nbsp;回到首页 |</a>
                <a href="#">  &nbsp;我的订单 |</a>
                <select name="" id="">
                    <option value="">我的京东</option>
                    <option value="">消息</option>
                    <option value="">待处理订单</option>
                    <option value="">返修退换货</option>
                    <option value="">降价商品</option>
                    <option value="">我的京豆</option>
                    <option value="">我的白条</option>
                    <option value="">我的关注</option>
                    <option value="">我的问答</option>
                </select>
                <a href="#">|  &nbsp;京东会员 |</a>
                <select name="" id="" style="color: red">
                    <option value="" style="color: gray">企业采购</option>
                    <option value="" style="color: gray">企业购</option>
                    <option value="" style="color: gray">工业品</option>
                    <option value="" style="color: gray">礼品卡</option>
                    <option value="" style="color: gray">商品场景馆</option>
                </select>
                <a href="#">客户服务ˇˇ</a>
                <a href="#">网站导航ˇˇ</a>
                <a href="#">手机京东</a>
            </div>
        </div>    

        <div class="found">
            <div class="search">      
                <form action="" method="POST">
                    <a class="name" href="#">我的京东</a>
                    <a href="#">首页</a>
                    <a href="#">账户设置</a>
                    <a href="#">评价</a>
                    <a href="#">消息</a>
                    <input class="text" type="text" name="search" value="自营"
                    onfocus="if(this.value == '自营'){this.value = '';this.style.color = 'black'}" onblur="if(this.value == ''){this.value = '请输入关键字';this.style.color = 'gray'}" >
                    <input class="button" type="button" value="查询">
                    <input class="submit" type="submit" value="购物车">
                </form>
            </div>
        </div>
        <br>
        <div class="body"> 
            <div class="body_left">
                <p>订单中心</p>
                <a href="#" style="color: orangered">我的订单</a><br>
                <a href="#">我的活动</a><br>
                <a href="#">评价晒单</a><br>
                <a href="#">我的常购商品</a><br>
                <a href="#">代下单</a><br>
                <p>关注中心</p>
                <a href="#">关注的商品</a><br>
                <a href="#">关注的店铺</a><br>
                <a href="#">关注的专辑</a><br>
                <a href="#">收藏的内容</a><br>
                <a href="#">关注的活动</a><br>
                <p>资产中心</p>
                <a href="#">小金库</a><br>
                <a href="#">京东白条</a><br>
                <a href="#">领货码</a><br>
                <a href="#">余额</a><br>
                <a href="#">红包</a><br>
                <a href="#">银行卡</a><br>
                <a href="#">优惠券</a><br>
                <a href="#">礼品卡</a><br>
                <a href="#">京豆</a><br>
                <a href="#">京东钢镚</a><br>
                <p>特色业务</p>
                <a href="#">我的营业厅</a><br>
                <a href="#">京东通信</a><br>
                <a href="#">定期购</a><br>
                <a href="#">我的回收单</a><br>
                <a href="#">节能补贴</a><br>
                <a href="#">医药服务</a><br>
                <a href="#">流量加油站</a><br>
                <a href="#">黄金托管</a><br>
                <a href="#">我的课程</a><br>
                <a href="#">海外房产预约</a><br>
                <a href="#">我的海囤全球</a><br>
                <a href="#">装修服务</a><br>
                <a href="#">我的拍卖</a><br>
                <a href="#">我的集运</a><br>
                <a href="#">耗材自动递送</a><br>
                <a href="#">京东机票</a><br>
                <p>客户服务</p>
                <a href="#">返修退换货</a><br>
                <a href="#">价格保护</a><br>
                <a href="#">意见建议</a><br>
                <a href="#">我的问答</a><br>
                <a href="#">购买咨询</a><br>
                <a href="#">交易纠纷</a><br>
                <a href="#">京东维修</a><br>
                <a href="#">我的发票</a><br>
                <a href="#">举报中心</a><br>
                <p>设置</p>
                <a href="#">个人信息</a><br>
                <a href="#">收货地址</a><br>
            </div>            <br>
            <div class="body_middle">
                &nbsp;&nbsp;&nbsp;&nbsp;<a href="#">全部订单</a>
                <a href="#">待付款</a>
                <a href="#">待收货</a>
                <a href="#">待评价</a>
                <a href="#">我的常购商品</a>
                <a href="#">订单回收站</a>
                <div class="div2">
                    &nbsp;&nbsp;<span>近三个月订单</span>
                    <span class="spanl">订单详情</span>
                    <span class="spanl">收货人</span>
                    <span class="spanr">金额</span>
                    <span class="spanr">全部状态</span>
                    <span class="spanr">操作</span>
                </div>
                <hr>
            
                <c:forEach items="${info}" var="user" varStatus="loop">
	                <div class="div3">
	                    <span>时间：${user.getOrderTime()}</span>
	                    <span>订单号：${user.getOrderID()}</span>
	                    <span>收货地址：${user.getOrderAdress()}</span>
	                </div>
	                <div class="div4">
	                    <img alt="shopPicture" src="${user.getPicPath()}">
	                    <div class="name">
	                        <span>${user.getShopName()}</span>
	                    </div>
	                    <div class="number">
	                        <span>${user.getShopNum()}</span>
	                        <div>
	                         	<span><%=session.getAttribute("user").toString()%></span>
		                     </div>   
		                   <span class="stip">￥&nbsp;&nbsp;${user.getTotalMoney()}&nbsp;&nbsp;</span>
		                   <span class="stip">待支付</span>
		                   <input class="stip" type="submit" value="立即购买">
		               </div>        
	                </div>
	       		</c:forEach>
            </div>
        </div>
        <br><br>
        <div class="divbottom">
            <div>
                <span class="spanl">&nbsp;&nbsp;删除订单&nbsp;&nbsp;</span>
                <span>&nbsp;&nbsp;清理订单记录&nbsp;&nbsp;</span>
                <form action="" method="post">
                    <span >总价：</span>
                    <span class="color">${total}</span>
                    <input type="button" id="goOrder" value="去付款">
                </form>
            </div>
        </div>
    </body>
</html>