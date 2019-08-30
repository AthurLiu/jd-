package com.dbs.entity;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class AdminOrder{
	//订单商品的图片路径
	private String picPath;
	//订单商品的名称
	private String shopName;
	//订单商品的单价
	private String money;
	//订单商品的数量
	private String shopNum;
	//订单商品的单件价格总和
	private String totalMoney;
	//订单创建时间
	private String orderTime;
	//订单编号
	private String orderID;
	//收货地址
	private String orderAdress;
	//商品价格总和
	private String total;
	public AdminOrder(String orderTime, String orderID, String orderAdress, String picPath, String shopName, String shopNum, 
			String money, String totalMoney,String total) {
		this.picPath = picPath;
		this.shopName = shopName;
		this.money = money;
		this.shopNum = shopNum;
		this.totalMoney = totalMoney;
		this.orderTime = orderTime;
		this.orderID = orderID;
		this.orderAdress = orderAdress;
		this.total = total;
	}
	public String getPicPath() {
		return picPath;
	}
	public String getShopName() {
		return shopName;
	}
	public String getMoney() {
		return money;
	}
	public String getShopNum() {
		return shopNum;
	}
	public String getTotalMoney() {
		return totalMoney;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public String getOrderID() {
		return orderID;
	}
	public String getOrderAdress() {
		return orderAdress;
	}
	public String getTotal() {
		return total;
	}
}
