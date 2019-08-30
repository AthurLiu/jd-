<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>我的购物车 - 京东商城</title>
        <script src=""></script>
        <script type="text/javascript" src="js/jquery-3.3.1.js"></script>
        <link rel="shortcut icon" type="image/x-icon" href="picture/jd_logo.ico"/>
        <link rel="stylesheet" href="css/shop_car.css?v=<%=System.currentTimeMillis()%>">
        <script type="text/javascript" src="js/shop_car.js?v=<%= System.currentTimeMillis()%>"></script>
    </head>
    <body>
        <div class="head" id="head">
            <div>
                <div id="local" title="江苏">&nbsp;&nbsp;江苏&nbsp;&nbsp;</div>
                <span><%=session.getAttribute("user").toString()%></span>
                <a href="jsp/user_page.jsp">|  &nbsp;&nbsp;回到首页 |</a>
                <form action="login.do?method=order" method="post" class="orderCar">
                	<input type="submit" value="|  我的订单 |">
                </form>
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
                <a href="">|  &nbsp;京东会员 |</a>
                <select name="" id="">
                    <option value="">企业采购</option>
                    <option value="">企业购</option>
                    <option value="">工业品</option>
                    <option value="">礼品卡</option>
                    <option value="">商品场景馆</option>
                </select>
                <a href="">客户服务ˇˇ</a>
                <a href="">网站导航ˇˇ</a>
                <a href="">手机京东</a>
            </div>
        </div>    

        <br>
        <div class="found">
            <div class="search">      
                <form action="" method="POST">
                    <img src="product/jd_Car.png" alt="">&nbsp;
                    <a href="">购物车</a>
                    <input class="text" type="text" name="search" value="自营"
                    onfocus="if(this.value == '自营'){this.value = '';this.style.color = 'black'}" onblur="if(this.value == ''){this.value = '请输入关键字';this.style.color = 'gray'}" >
                    <input class="submit" type="submit">
                </form>
            </div>
        </div>
        <br><br>
        <div class="shopcar">
            <span>全部商品</span> 
            <span id="orderNum">${shopNumber}种</span> 
            <form action="login.do?method=clearShop" method="post" id="formt">
            	<input id="clearShop" class="submit" type="submit" value="清空购物车" title="清空购物车">
            </form>
            <div class="divt">     
                <input type="checkbox" checked id="checkbox">
                <span>全选</span>
                <span class="spanl">商品</span>
                <span class="spanm">单价</span>
                <span class="spanr">数量</span>
                <span class="spanr">小计</span>
                <span class="spanl">操作</span>
            </div>
            
            <c:forEach items="${info}" var="user" varStatus="loop">
                <hr>
                
	            <div class="divm">
	                <input type="checkbox" id="checkbox${shopNumber}" checked="checked">
	                <img alt="" src="${user.getPicPath()} ">
	                <div class="divtf">
	                    <span>${user.getShopName()}</span>
	                </div>
	                <div class="divbf">
	                    <span>${user.getMoney()}</span>
	                    <form action="login.do?method=mulShop" method="post">
	                    	<input class="a1" type="submit" value="-">
	                    	<input type="text" id="shopName" name="shopName" value="${user.getShopName()}">
	                    </form>
	                    
	                    <span class="s2">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${user.getShopNum()}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
	                    <form action="login.do?method=addShop" method="post">
	                    	<input class="a2" type="submit" value="+">
	                    	<input type="text" id="shopName" name="shopName" value="${user.getShopName()}">
	                    </form>
	                    
	                    <span class="s3">￥${user.getTotalMoney()}</span>
	                    <form action="login.do?method=delShop" method="post">
	                    	<input class="a3" type="submit" value="删除">
	                    	<input type="text" id="shopName" name="shopName" value="${user.getShopName()}">
	                    </form>
	                </div>        
	            </div>
	            <hr>
       		</c:forEach>
        
        </div>
        <div class="divbottom">
            <div>
                <input type="checkbox" checked="checked">
                <span>全选&nbsp;&nbsp;</span>
                <span>&nbsp;&nbsp;删除选中商品&nbsp;&nbsp;</span>
                <span>&nbsp;&nbsp;移到关注&nbsp;&nbsp;</span>
                <span>&nbsp;&nbsp;清理购物车&nbsp;&nbsp;</span>
                <form action="login.do?method=addOrder" method="post">
                    <span >总价：</span>
                    <span class="color">${totalMoney}</span>
                    <input type="submit" id="goOrder" value="去结算">
                </form>
            </div>
        </div>
        <div class="jd_ed">
            <div class="end">
                <table>
                    <tr>
                        <td>
                            <h4>购物指南</h4>
                            <a href="#">购物流程</a><br>
                            <a href="#">会员介绍</a><br>
                            <a href="#">生活旅行</a><br>
                            <a href="#">常见问题</a><br>
                            <a href="#">大家电</a><br>
                            <a href="#">联系客服</a><br>
                        </td>
                        <td>
                            <h4>配送方法</h4>
                            <a href="#">上门自提</a><br>
                            <a href="#">211限时达</a><br>
                            <a href="#">配送服务查询</a><br>
                            <a href="#">配送费收取标准</a><br>
                            <a href="#">海外配送</a><br><br>
                        </td>
                        <td>
                            <h4>支付方法</h4>
                            <a href="#">货到付款</a><br>
                            <a href="#">在线支付</a><br>
                            <a href="#">分期付款</a><br>
                            <a href="#">邮局汇款</a><br>
                            <a href="#">公司转账</a><br><br>
                        </td>
                        <td>
                            <h4>售后服务</h4>
                            <a href="#">售后政策</a><br>
                            <a href="#">价格保护</a><br>
                            <a href="#">退款说明</a><br>
                            <a href="#">返修/退换货</a><br>
                            <a href="#">取消订单</a><br><br>
                        </td>
                        <td>
                            <h4>特色服务</h4>
                            <a href="#">夺宝岛</a><br>
                            <a href="#">DIY装机</a><br>
                            <a href="#">延保服务</a><br>
                            <a href="#">京东IE卡</a><br>
                            <a href="#">京东通讯</a><br>
                            <a href="#">鲸鱼座智能</a><br>
                        </td>
                        <td>
                            <h4>京东自营覆盖区县</h4>
                            <a>京东已向全国2661个区县提供自营配送服务，支持货到付款、POS机刷卡和售后上门服务。</a><br>
                            <a href="#">查看详情></a><br><br>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="mod_copyright_info">
                <p class="about">
                    <a href="#" target="_blank">关于我们</a><span>|</span>
                    <a href="#" target="_blank">联系我们</a><span>|</span>
                    <a href="#" target="_blank">联系客服</a><span>|</span>
                    <a href="#" target="_blank">合作招商</a><span>|</span>
                    <a href="#" target="_blank">商家帮助</a><span>|</span>
                    <a href="#" target="_blank">营销中心</a><span>|</span>
                    <a href="#" target="_blank">手机京东</a><span>|</span>
                    <a href="#" target="_blank">友情链接</a><span>|</span>
                    <a href="#" target="_blank">销售联盟</a><span>|</span>
                    <a href="#" target="_blank">京东社区</a><span>|</span>
                    <a href="#" target="_blank">风险监测</a><span>|</span>
                    <a href="#" target="_blank">隐私政策</a><span>|</span>
                    <a href="#" target="_blank">京东公益</a><span>|</span>
                    <a href="#" target="_blank">English Site</a><span>|</span>
                    <a href="#" target="_blank">Media &amp; IR</a>
                </p>
                <div>
                    <p>
                        <a href="#" target="_blank">京公网安备 11000002000088号</a><span>|</span>
                        <span>京ICP证070359号</span><span>|</span>
                        <a href="#" target="_blank">互联网药品信息服务资格证编号(京)-经营性-2014-0008</a>
                        <span>|</span><span>新出发京零&amp;&nbsp;字第大120007号</span>
                    </p>
                    <p>
                        <span>互联网出版许可证编号新出网证(京)字150号</span><span>|</span>
                        <a href="#" target="_blank">出版物经营许可证</a><span>|</span>
                        <a href="#" target="_blank">网络文化经营许可证京网文[2014]2148-348号</a><span>|</span>
                        <span>违法和不良信息举报电话：4006561155</span>
                    </p>
                    <p>
                        <span>Copyright&nbsp;©&nbsp;2004&nbsp;-&nbsp;2019&nbsp;&nbsp;京东JD.com&nbsp;版权所有</span>
                        <span>|</span><span>消费者维权热线：4006067733</span>
                        <a href="#" target="_blank">经营证照</a><span>|</span>
                        <span>(京)网械平台备字(2018)第00003号</span><span>|</span>
                        <a href="#" target="_blank">营业执照</a>
                    </p>
                </div>
                <div>
                    <p>
                        <a href="#" target="_blank">Global Site</a><span>|</span>
                        <a href="#" target="_blank">Сайт России</a><span>|</span>
                        <a href="#" target="_blank">Situs Indonesia</a><span>|</span>
                        <a href="#" target="_blank">Sitio de España</a><span>|</span>
                        <a href="#" target="_blank"> เว็บไซต์ประเทศไทย </a>
                    </p>
                </div>
                <div>
                    <p>
                        <span>京东旗下网站：</span>
                        <a href="#" target="_blank">京东钱包</a><span>|</span>
                        <a href="#" target="_blank">京东云</a>
                    </p>
                </div>
                <p>
                    <a href="#" target="_blank">可信网站信用评估</a>
                    <a href="#" target="_blank">网络警察提醒你</a>
                    <a href="#" target="_blank">诚信网站</a>
                    <a href="#" target="_blank">中国互联网举报中心</a>
                    <a href="#" target="_blank">网络举报APP下载</a>
                </p>
            </div>
        </div>
    </body>
</html>