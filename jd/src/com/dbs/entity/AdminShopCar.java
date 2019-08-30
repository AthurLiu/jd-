package com.dbs.entity;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class AdminShopCar{
	//购买商品的图片路径
	private String picPath;
	//购买商品的姓名
	private String shopName;
	//购买商品的单价
	private String money;
	//购买商品的数量
	private String shopNum;
	//购买商品的单件价格总和
	private String totalMoney;
	//所有商品总价
	private String allTotalMoney;
	
	public AdminShopCar(String picPath,String shopName,String money,String shopNum,String totalMoney,String allTotalMoney){
		this.picPath = picPath;
		this.shopName = shopName;
		this.money = money;
		this.shopNum = shopNum;
		this.totalMoney = totalMoney;
		this.allTotalMoney = allTotalMoney;
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
	public String getAllTotalMoney() {
		return allTotalMoney;
	}
}
