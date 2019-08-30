package com.dbs.entity;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class AdminOrder{
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
	//��������ʱ��
	private String orderTime;
	//�������
	private String orderID;
	//�ջ���ַ
	private String orderAdress;
	//��Ʒ�۸��ܺ�
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
