package com.dbs.entity;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class AdminShopCar{
	//������Ʒ��ͼƬ·��
	private String picPath;
	//������Ʒ������
	private String shopName;
	//������Ʒ�ĵ���
	private String money;
	//������Ʒ������
	private String shopNum;
	//������Ʒ�ĵ����۸��ܺ�
	private String totalMoney;
	//������Ʒ�ܼ�
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
