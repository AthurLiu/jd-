package com.dbs.dao;
import java.util.List;
import com.dbs.entity.AdminOrder;
import com.dbs.entity.AdminShopCar;
import com.dbs.entity.AdminUser;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public interface AdminDao {
	
	/**
	 * 登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 注册成功返回true，失败返回false
	 */
	boolean login(String username, String password);
	
	/**
	 * 商品加入购物车
	 * @param username 用户名
	 * @param shopname 商品名
	 * @param number 商品数量
	 * @return 加入成功返回true，失败返回false
	 */
	boolean addCar(String username,String shopname,String number);
	
	/**
	 * 注册
	 * @param register
	 * @return 注册成功返回true，失败返回false
	 */
	boolean register(AdminUser register);

	/**
	 * 显示某人购物车里面的所有商品
	 * @param username 用户名
	 * @return 查找成功返回true，失败返回false
	 */
	List<AdminShopCar> findAllUserInfo(String username);
	 
	/**
	 * 清空某个人的购物车
	 * @param username 用户名
	 */
	void deleteAllShopCar(String username);
	 
	/**
	 * 删除某个人的购物车里面的特定商品
	 * @param username 用户名
	 * @param shopname 商品名
	 */
	void deleteSomeShopCar(String username,String shopname);
	 
	/**
	 * 某个人的购物车里某件商品加一
	 * @param username 用户名
	 * @param shopname 商品名
	 */
	void AddShopCar1(String username,String shopname);
	
	/**
	 * 某个人的购物车里某件商品减一
	 * @param username 用户名
	 * @param shopname 商品名
	 */
	void MulShopCar1(String username,String shopname);
	
	/**
	 * 根据指定国家名查询省的名字
	 * @param countryname 国家名
	 * @return 国家下面所有省的名字（目前仅限于中国）
	 */
	String findProvinces(String countryname);
	 
	/**
	 * 根据指定省名查询市名字
	 * @param province
	 * @return 省下面所有市的名字
	 */
	String findCities(String province);
	 
	/**
	 * 某人购物车里面的商品添加到订单表
	 * @param username 用户名
	 * @return 添加成功返回true，失败返回false
	 */
	boolean insertOrder(String username);
	
	/**
	 * 输出某个人的订单信息
	 * @param username 用户名
	 * @return List<AdminOrder>
	 */
	List<AdminOrder> findAllOrderInfo(String username);
	
	/**
	 * 注册登录时判断用户是否存在（AJAX局部刷新）
	 * @param username 用户名
	 * @return 用户名存在返回true，不存在返回false
	 */
	boolean exit(String username);
	
	/**
	 * 删除某个人的所有信息
	 * @param username 用户名
	 * @return
	 */
	String delUser(String username);
	
	/**
	 * 清空所有表
	 * @return
	 */
	String trunAllTable(String username);
	
	/**
	 * 查询用户的权限
	 * @param username
	 * @return
	 */
	String user_power(String username);
}
