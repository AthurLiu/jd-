<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
        <title>华为（HUAWEI） 荣耀8X 手机全面屏全网通 魅海蓝 6GB+128GB 尊享版</title>
        <link rel="shortcut icon" type="image/x-icon" href="../picture/jd_logo.ico"/>
        <link rel="stylesheet" href="../css/user_shop.css?v=<%=System.currentTimeMillis()%>">
        <script src="../js/pro_shop.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="head" id="head">
            <div>
                <div id="local" title="江苏">&nbsp;&nbsp;江苏&nbsp;&nbsp;</div>
                <span><%=session.getAttribute("user").toString()%></span>
                <a href="../jsp/user_page.jsp">|  &nbsp;&nbsp;回到首页 |</a>
                <form action="../login.do?method=order" method="post" class="orderCar">
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
        <div class="found">
            <br>
            <br>
            <div class="search">
                <form action="../login.do?method=showCar" method="post">
                    <input class="text" type="text" value="请输入关键字"
                    onfocus="if(this.value == '请输入关键字'){this.value = '';this.style.color = 'black'}" onblur="if(this.value == ''){this.value = '请输入关键字';this.style.color = 'gray'}" >
                    <input class="find" type="button" value="  查  找  ">
                    <input class="submit" type="submit" value="我的购物车">
                </form>
                <ul class="ul1">
                    <li>
                        <a class="col" href="">周五鲜放假</a>
                    </li>
                    <li>
                        <a href="">不分类纸</a>
                    </li>
                    <li>
                        <a href="">耳机</a>
                    </li>
                    <li>
                        <a href="">清凉空调</a>
                    </li>
                    <li>
                        <a href="">清凉家具</a>
                    </li>
                    <li>
                        <a href="">爱车服务</a>
                    </li>
                    <li>
                        <a href="">清凉节</a>
                    </li>
                    <li>
                        <a href="">全城热练</a>
                    </li>
                </ul>
            </div>
        </div>
        <br><br>
        <div id="body">
            <div class="divt"></div>
            <div class="divt1">
                <div>
                    <ul>
                        <li>
                            <a class="col" href="">首页有惊喜</a>
                        </li>
                        <li>
                            <a href="">所以产品</a>
                        </li>
                        <li>
                            <a href="">OPPO</a>
                        </li>
                        <li>
                            <a href="">一加</a>
                        </li>
                        <li>
                            <a href="">iPhone</a>
                        </li>
                        <li>
                            <a href="">荣耀</a>
                        </li>
                        <li>
                            <a href="">华为</a>
                        </li>
                        <li>
                            <a href="">小米</a>
                        </li>
                        <li>
                            <a href="">魅族</a>
                        </li>
                        <li>
                            <a href="">realme</a>
                        </li>
                        <li>
                            <a href="">三星</a>
                        </li>
                        <li>
                            <a href="">配件专区</a>
                        </li>
                        <li>
                            <a href="">会员中心</a>
                        </li>
                        <li>
                            <a href="">碎屏险</a>
                        </li>
                        <li>
                            <a href="">企业购</a>
                        </li>
                        <li>
                            <a href="">牧申美妆店</a>
                        </li>
                    </ul>
                </div>
            </div>
            <div class="div2">
                <div>
                    <a href="">手机通讯</a><span>></span>
                    <a href="">手机</a><span>></span>
                    <a href="">华为</a><span>></span>
                    <a href="">华为（HUAWEI） 荣耀8X </a>
                    <a href="" class="shopname">牧申手机旗舰店</a><span> | </span>
                    <a href="">联系客服</a><span> | </span>
                    <a href="">关注店铺 </a>
                </div>
            </div>
            <div class="div3">
                <div>
                    <div class="left">
                        <div id="back_g" class="back_pho"></div>
                        <br>
                        <img src="../product/phone1.png" alt="" onmouseover="change_bk('p1','phone')">
                        <img src="../product/phone2.jpg" alt="" onmouseover="change_bk('p2','phone')">
                        <img src="../product/phone3.jpg" alt="" onmouseover="change_bk('p3','phone')">
                        <img src="../product/phone4.jpg" alt="" onmouseover="change_bk('p4','phone')">
                        <img src="../product/phone5.jpg" alt="" onmouseover="change_bk('p5','phone')">
                        <br><br>
                        <a href="">关注</a><span> | </span>
                        <a href="">分享</a><span> | </span>
                        <a href="">对比</a><span> | </span>
                        <a href="">举报</a>
                    </div>
                    <div class="right">
                        <p>华为（HUAWEI） 荣耀8X 手机全面屏全网通 魅海蓝 6GB+128GB 尊享版</p>
                        <div>
                            <span>【15天价保，一级授权经销商，全国联保】【荣耀直供，支持7天无理由退换货】【赠：品牌礼包】</span>
                            <a href="">荣耀10青春</a>
                            <div class="quiksal">&nbsp; &nbsp;品牌闪购</div>
                            <span>闪购价&nbsp;&nbsp;</span> 
                            &nbsp;&nbsp;￥<span>1519.00</span> 
                            &nbsp;&nbsp;<span>[￥2099.00]</span>
                            <a class="a" href="">降价通知></a>
                            <br>
                            <span>促销&nbsp;&nbsp;</span>
                            <a href="">
                                <img src="../product/ph1.jpg" alt="">
                            </a>
                            <span>x1</span>
                            <a href="">
                                <img src="../product/ph2.jpg" alt="">
                            </a>
                            <span>x1</span>
                            <a href="">
                                <img src="../product/ph3.jpg" alt="">
                            </a>
                            <span>x1</span> 
                            <span>赠完为止</span>
                            <br>
                            <a class="a" href="">满额返券&nbsp;&nbsp;</a>购买此商品满10元返配件优惠券 
                            <a class="a" href="">详情 >></a>
                            <br>
                            增值业务 &nbsp;&nbsp;<a class="a" href="">高价回收-卖了换钱</a>
                            <a class="a" href="">3元1G</a>
                            <br>
                            配送至 &nbsp;&nbsp;<span>北京朝阳区三环以内</span>
                            <span>有货</span>
                            <span>支持</span>
                            <a class="a" href="">货到付款</a>
                            <a class="a" href="">送运费险</a>
                            <a class="a" href="">15天价保</a>
                            <a class="a" href="">一年质保</a>
                            <span>免运费</span>
                            <br>
                            <span class="sendpath">由牧申手机旗舰店从 上海 发货, 并提供售后服务. 今日17:00前完成下单，预计7月21日20:00前发货，7月24日24:00前送达</span>
                           
                            <div>
                                选择颜色 &nbsp;&nbsp;
                                <img src="../product/ph1.png" alt="">
                                <a href="">魅海蓝</a>
                                <img src="../product/ph5.jpg" alt="">
                                <a href="">幻夜黑</a>
                                <img src="../product/ph6.jpg" alt="">
                                <a href="">魅焰红</a>
                                <img src="../product/ph7.jpg" alt="">
                                <a href="">梦幻紫</a>
                                <img src="../product/ph8.jpg" alt="">
                                <a href="">幻樱蓝</a>
                            </div>
                            选择版本 &nbsp;&nbsp;
                            <a class="b" href="">4GB+64GB标配版</a>
                            <a class="b" href="">4GB+64GB高配版</a>
                            <a class="b" href="">6GB+124GB尊享版版</a>
                            <br>
                            增值保障 &nbsp;&nbsp;
                            <a class="b" href="">京享无忧2年 ￥149 </a>
                            <a class="b" href="">碎屏保2年 ￥119 </a>
                            <a class="b" href="">原厂电池换新 ￥39 </a>
                            <br>
                            白条分期 &nbsp;&nbsp;
                            <a class="b" href="" title="无服务费">不分期</a>
                            <a class="b" href="" title="含服务费：费率0.5%起，￥7.6起×3期">￥513.94起×3期</a>
                            <a class="b" href="" title="含服务费：费率0.5%起，￥7.6起×6期">￥260.75起×6期</a>
                            <a class="b" href="" title="含服务费：费率0.5%起，￥7.6起×12期">￥134.22起×12期</a>
                            <a class="b" href="" title="含服务费：费率0.5%起，￥7.6起×24期">￥70.93起×24期 </a>
                            <br>
                            <span class="raise">增值保障不支持一键打白条</span> 
                            <br>
                            <form action="../login.do?method=addCar" method="post">
                                <input name="sname" value="华为（HUAWEI）荣耀8X 手机全面屏全网通 魅海蓝 6GB+128GB 尊享版" class="name">
					                                    件数：<input id="number" type="text" value="1" width="40px" name="shopno">
					                                    总价：<input id="total_price" type="text" value="1519.00" width="40px" name="totalprice" readonly>
                                <input type="button" value=" + " onclick="add('1519.00')">
                                <input type="button" value=" - " onclick="mul('1519.00')">
                                <input type="submit" value="加入购物车" class="addShop" >
                            </form>
                            
                            <br>
                            温馨提示 ·支持7天无理由退货(激活后不支持)
                            <br>
                        </div>
                    </div>
                </div>    
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