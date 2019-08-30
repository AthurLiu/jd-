package com.dbs.dao;
import java.sql.*;
import java.util.*;
import java.util.Map.Entry;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.StringUtils;

import com.dbs.entity.AdminOrder;
import com.dbs.entity.AdminShopCar;
import com.dbs.entity.AdminUser;
import com.dbs.util.DBUtil;

/**
 * @author Anthony
 * @date 2019/08/20
 * @version V1.0
 *
 */
public class AdminDaoImpl implements AdminDao{
	
	/**
	 * 查找当前用户的user_id
	 * @param username
	 * @param conn
	 * @param st
	 * @param rs
	 * @return 当前用户的user_id
	 * @throws SQLException
	 */
	private String find_userID(String username,Connection conn,Statement st,ResultSet rs) throws SQLException {
		String user_id = "";
		String sql = "(select user_id from t_personalInfo where user_name = '"+username+"')";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		if(rs.next()) {
			user_id = rs.getString(1);
		}
		return user_id;
	}
	
	/**
	 * 将订单信息加入到订单表里面
	 * @param user_id
	 * @param conn
	 * @param st
	 * @param rs
	 * @return true表示插入成功，false表示插入失败
	 * @throws SQLException
	 */
	public boolean insertBeforeOrder(String user_id,Connection conn,Statement st,ResultSet rs) throws SQLException {
		String sql = "insert into t_order values(to_char(sysdate,'yymmdd')||t_order_id.nextval,sysdate,"
				+ "'"+user_id+"',"
				+ "'"+user_id+"',sysdate,"
				+ "'"+user_id+"',sysdate)";
		st = conn.createStatement();
		boolean flag = !st.execute(sql);
		return flag;
	}
	
	/**
	 * 	查询出向条目表里面添加的信息
	 * @param user_id
	 * @param conn
	 * @param st
	 * @param rs
	 * @return 添加结果
	 * @throws SQLException 
	 */
	private Map<String,String> findInsertItem(String user_id,Connection conn,Statement st,ResultSet rs) throws SQLException {
		Map<String,String> map = new HashMap<>();
		String sql = "select pro_id,bas_number from t_basket where user_id = '"+user_id+"'";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			map.put(rs.getString(1),rs.getString(2));
		}
		return map;
	}
	
	/**
	 * 	根据user_id查询出最近的一次订单      
	 * @param user_id 
	 * @param conn
	 * @param st
	 * @param rs
	 * @throws SQLException 
	 * @return 最近的一次订单编号（本次订单编号）
	 */
	private String ord_id(String user_id,Connection conn,Statement st,ResultSet rs) throws SQLException {
		String str = "";
		String sql = "select ord_id from t_order where user_id = '"+user_id+"' order by ord_id desc";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			str = rs.getString(1);
		}
		return str;
	}
	/**
	 * 	向订单条目表里面加商品  
	 * @param user_id 用户id
	 * @param pro_id  产品id
	 * @param pro_num 产品数量
	 * @param conn
	 * @param st
	 * @param rs
	 * @return 
	 * @throws SQLException 
	 */
	private boolean InsertItem(String order_id,String pro_id,String pro_num,Connection conn,Statement st,ResultSet rs) throws SQLException {
		boolean flag = false;
		String sql = "insert into t_orderpro values(t_orderpro_id.nextval,'"+order_id+"','"+pro_id+"','"+pro_num+"')";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		if(rs.next()) {
			flag = true;
		}
		return flag;
	}
	
	/**
	 * 	根据user_id查出用户在订单表里面的所有订单编号
	 * @param user_id 
	 * @param conn
	 * @param st
	 * @param rs
	 * @throws SQLException 
	 * @return 最近的一次订单编号（本次订单编号）
	 */
	private List<String> findAllOrderId(String user_id,Connection conn,Statement st,ResultSet rs) throws SQLException {
		List<String> list = new ArrayList<String>();
		String sql = "select ord_id from t_order where user_id = '"+user_id+"'";
		st = conn.createStatement();
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			list.add(rs.getString(1));
		}
		return list;
	}
	
	/**
	 * 	根据user_id查出用户在订单表里面的所有订单编号
	 * @param user_id 
	 * @param conn
	 * @param st
	 * @param rs
	 * @throws SQLException 
	 * @return 最近的一次订单编号（本次订单编号）
	 */
	private void deldtePeople(String sql,Connection conn,Statement st,ResultSet rs) throws SQLException {
		st = conn.createStatement();
		rs = st.executeQuery(sql);
	}
	
	/**
	 * 删除某个人的所有信息
	 * @param username 用户名
	 * @return
	 */
	public String delUser(String username) {
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		String str = "删除失败";
		String user_id = "";
		List<String> list = new ArrayList<String>();
		try {
			conn.setAutoCommit(false);
			user_id = find_userID(username, conn, st, rs);
			if(!StringUtils.isEmpty(user_id)) {
				list = findAllOrderId(user_id, conn, st, rs);
				if(!list.isEmpty()) {
					for(int i = 0; i < list.size();i++) {
						String sql = "delete from t_orderpro where ord_id = " + list.get(i);
						deldtePeople(sql, conn, st, rs);
					}
					String sql = "delete from t_order where user_id = " + user_id;
					deldtePeople(sql, conn, st, rs);
					sql = "delete from t_basket where user_id = " + user_id;
					deldtePeople(sql, conn, st, rs);
					sql = "delete from t_personalinfo where user_id = " + user_id;
					deldtePeople(sql, conn, st, rs);
					conn.commit();
					str = "删除成功";
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closeAll(rs, st, conn);
		}
		return str;
	}
	
	/**
	 * 	订单表里面的插入订单信息
	 * @param username  用户名
	 */
	public boolean insertOrder(String username) {
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		boolean flag = false;
		String user_id = "";
		Map<String,String> map = new HashMap<>();
		
		try {
			conn.setAutoCommit(false);
			user_id = find_userID(username, conn, st, rs);
			if(!StringUtils.isEmpty(user_id)) {
				if(insertBeforeOrder(user_id,conn, st, rs)) {
					String order_id = ord_id(user_id,conn, st, rs);
					if(!StringUtils.isEmpty(order_id)) {
						map = findInsertItem(user_id,conn, st, rs);
						if(!map.isEmpty()) {
							for(Entry<String, String> entry : map.entrySet()) {
								flag = InsertItem(order_id,entry.getKey(),entry.getValue(),conn, st, rs);
							}
							conn.commit();
						}
					}
				}
			}			   
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closeAll(rs, st, conn);
		}
		return flag;	
	}
	
	/**
	 * 	登录验证
	 * @param username  用户名
	 * @param password  密码
	 */
	public boolean login(String username, String password) {
		String sql = "select * from t_personalInfo where user_name = ? and user_pass = ?";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2, DigestUtils.md5Hex(password));
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return false;
	}
	
	/**
	 * 	显示购物车里面的所有内容
	 * 	@param username 用户名
	 */
	public List<AdminShopCar> findAllUserInfo(String username){	
		List<AdminShopCar> car = null;
		String sql = "select p.user_name,s.pro_name,s.pro_pic,s.pro_price,b.bas_number from t_personalinfo p,t_basket b,t_product s "
				+ "where p.user_name = '"+username+"' and p.user_id = b.user_id and b.pro_id = s.pro_id";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			car = new ArrayList<>();
			rs = conn.createStatement().executeQuery(sql);
			double totalPrice = 0;
			while(rs.next()) {
				double price = Double.parseDouble(rs.getString(4))*Double.parseDouble(rs.getString(5));
				car.add(new AdminShopCar(rs.getString(3).substring(3, rs.getString(3).length()), rs.getString(2), 
						String.format("%.2f", Double.parseDouble(rs.getString(4))), rs.getString(5), 
						String.format("%.2f", price),String.format("%.2f", totalPrice += price)));
			} 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, st, conn);
		}
		return car;
	}

	/**
	 * 	用户注册
	 *  @param register 用户注册对象
	 */
	public boolean register(AdminUser register) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean flag = false;
		try {
			if(exit(register.getUsername(),conn,pstmt,rs)) {
				String sql = "insert into t_personalInfo values"
						+ "(t_personalInfo_id.Nextval,?,?,?,?,?,?,"
						+ "t_personalInfo_id.Currval,sysdate,"
						+ "t_personalInfo_id.Currval,sysdate,?)";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,register.getUsername());
				pstmt.setString(2,DigestUtils.md5Hex(register.getPassword()));
				pstmt.setString(3,register.getSex());
				pstmt.setDouble(4,Double.parseDouble(register.getPhone()));
				pstmt.setString(5,register.getEmail());
				pstmt.setString(6,register.getAddress());
				pstmt.setString(7,"common");
				if(pstmt.executeUpdate() == 1) 
					flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return flag;
	}
	
	/**
	 * 	注册用户的用户名是否存在
	 * @param username 用户名
	 * @return 存在，返回false，不存在，返回true
	 * @throws SQLException 
	 */
	public boolean exit(String username,Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException {
		String sql = "select * from t_personalInfo where user_name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,username);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			return false;
		}
		return true;
	}
	
	/**
	 * 	购物车表里面是否已经存在要添加的商品
	 * @param username 用户名
	 * @param shopname 商品名
	 * @return 存在，返回false，不存在，返回true
	 * @throws SQLException 
	 */
	private boolean exit(String username,String shopname,Connection conn,PreparedStatement pstmt,ResultSet rs) throws SQLException {
		String sql = "select p.user_id from t_basket b,t_personalinfo p,t_product d where b.user_id = p.user_id  "
				+ "and b.pro_id = d.pro_id and p.user_name = ? and d.pro_name = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setString(2,shopname);
		rs = pstmt.executeQuery();
		while(rs.next()) {
			return false;
		}
		return true;
	}

	/**
	 *	 购物车添加商品，已经存在，则对商品的数量进行更新，不存在，则进行添加
	 *	@param username 用户名
	 *	@param shopname 商品名 
	 *	@param number 商品数量
	 *	@return 添加成功，返回true，失败，返回false
	 */
	public boolean addCar(String username,String shopname, String number) {
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Boolean flag = false;
		try {
			if(exit(username,shopname,conn,pstmt,rs)) {
				String sql = "insert into t_basket values("
						+ "t_basket_id.Nextval,"
						+ "(select user_id from t_personalInfo where user_name = ?),"
						+ "(select pro_id from t_product where pro_name = ?),?,"
						+ "(select user_id from t_personalInfo where user_name = ?),sysdate,"
						+ "(select user_id from t_personalInfo where user_name = ?),sysdate)";		
				
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,username);
					pstmt.setString(2,shopname);
					pstmt.setDouble(3,Double.parseDouble(number));
					pstmt.setString(4,username);
					pstmt.setString(5,username);
					if(pstmt.executeUpdate() == 1) 
						flag = true;
			} else {
				String sql = "update t_basket set bas_number = bas_number + ? "
						+ "where user_id = (select user_id from t_personalInfo where user_name = ?)"
						+ "and pro_id = (select pro_id from t_product where pro_name = ?)";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setDouble(1,Double.parseDouble(number));
				pstmt.setString(2,username);
				pstmt.setString(3,shopname);
				if(pstmt.executeUpdate() == 1)
					flag = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return flag;
	}

	/**
	 * 	清空某个人的购物车
	 * 	@param username 用户名
	 */
	public void deleteAllShopCar(String username) {
		String sql = "delete from t_basket "
				+ "where user_id = (select user_id from t_personalinfo where user_name = '"+username+"')";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, st, conn);
		}
	}

	/**
	 * 	清空某个人的购物车里面的一项商品
	 * 	@param username 用户名
	 *  @param shopname 商品名
	 */
	public void deleteSomeShopCar(String username, String shopname) {
		String sql = "delete from t_basket where "
				+ "user_id = (select user_id from t_personalinfo where user_name = '"+username+"') "
				+ " and pro_id = (select pro_id from t_product where pro_name = '"+shopname+"')";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, st, conn);
		}
	}

	/**
	 * 	某个人的购物车里面的一项商品数量加一
	 * 	@param username 用户名
	 *  @param shopname 商品名
	 */
	public void AddShopCar1(String username, String shopname) {
		String sql = "update t_basket set bas_number = bas_number + 1 "
				+ "where user_id = (select user_id from t_personalInfo where user_name = ?)"
				+ "and pro_id = (select pro_id from t_product where pro_name = ?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,shopname);
			pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
	}

	/**
	 * 	某个人的购物车里面的一项商品数量减一
	 * 	@param username 用户名
	 *  @param shopname 商品名
	 */
	public void MulShopCar1(String username, String shopname) {
		if(shopCarNumber(username,shopname)) {
			String sql = "update t_basket set bas_number = bas_number - 1 "
					+ "where user_id = (select user_id from t_personalInfo where user_name = ?)"
					+ "and pro_id = (select pro_id from t_product where pro_name = ?)";
			Connection conn = DBUtil.getConn();
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,username);
				pstmt.setString(2,shopname);
				pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			} finally {
				DBUtil.closeAll(rs, pstmt, conn);
			}
		}
	}
	
	/**
	 * 单件商品数量为1时，再去减，购物车里面删除该商品
	 * @param username 用户名
	 * @param shopname 商品名
	 * @return 商品删除成功与否
	 */
	private boolean shopCarNumber(String username, String shopname) {
		boolean flag = true;
		String sql = "select bas_number from t_basket "
				+ "where user_id = (select user_id from t_personalInfo where user_name = ?)"
				+ "and pro_id = (select pro_id from t_product where pro_name = ?)";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			pstmt.setString(2,shopname);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				if(rs.getString(1).equals("1")) {
					deleteSomeShopCar(username, shopname);
					flag = false;
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return flag;
	}
	
	/**
	 * 	查询省的名称
	 * @param countryname 国家名
	 */
	public String findProvinces(String countryname) {
		StringBuffer sb = new StringBuffer();
		sb.append("<select onchange='getCity(this)'>");
		String sql = "select p.PROVINCESNAME from country c,PROVINCES p where c.code = p.countryID and c.countryname = '"+countryname+"'";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			
			while(rs.next()) {
				sb.append("<option>"+rs.getString(1)+"</option>");
			}
			sb.append("</select>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, st, conn);
		}
		return sb.toString();
	}


	/**
	 * 	查询市的名字
	 * 	@param province 省名
	 */
	public String findCities(String province) {
		StringBuffer sb = new StringBuffer();
		sb.append("<select onchange='showCity(this)'>");
		String sql = "select c.city from cities c,PROVINCES p where c.provinceid = p.code and p.PROVINCESNAME = '"+province+"'";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while(rs.next()) {
				sb.append("<option>"+rs.getString(1)+"</option>");
			}
			sb.append("</select>");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, st, conn);
		}
		return sb.toString();
	}

	/**
	 * 输出订单表里面的所有信息
	 */
	public List<AdminOrder> findAllOrderInfo(String username) {
		List<AdminOrder> list = new ArrayList<>();
		String sql = "select o.ord_time,o.ord_id,p.user_address,s.pro_pic,s.pro_name,t.pr_number,s.pro_price "
				+ "from t_orderpro t,t_order o,t_personalInfo p,t_product s "
				+ "where t.ord_id = o.ord_id and o.user_id = p.user_id and s.pro_id = t.pro_id and p.user_name = ? order by o.ord_id desc";
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		double total = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				double price = Double.parseDouble(rs.getString(6))*Double.parseDouble(rs.getString(7));
				list.add(new AdminOrder(rs.getString(1).substring(0, rs.getString(1).length()-2), 
						"JD"+rs.getString(2), rs.getString(3), rs.getString(4).substring(3), rs.getString(5), rs.getString(6), 
						String.format("%.2f", Double.parseDouble(rs.getString(7))), 
						String.format("%.2f", price),String.format("%.2f", total+=price)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return list;
	}

	/**
	 * 	用户名是否存在
	 * @param username 用户名
	 * @return 存在，返回false，不存在，返回true
	 */
	public boolean exit(String username) {
		String sql = "select * from t_personalInfo where user_name = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return true;
	}
	
	/**
	 * 	查询用户的用户权限
	 * @param username 用户名
	 * @return 返回用户权限
	 */
	public String user_power(String username) {
		String str = "";
		String sql = "select user_power from t_personalinfo where user_name = ?";
		Connection conn = DBUtil.getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,username);
			rs = pstmt.executeQuery();
			if(rs.next()) { 
				str = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			DBUtil.closeAll(rs, pstmt, conn);
		}
		return str;
	}
	
	/**
	 * 清空所有表
	 */
	public String trunAllTable(String username) {
		Connection conn = DBUtil.getConn();
		ResultSet rs = null;
		Statement st = null;
		String str = "清除失败";
		String user_id = "";
		try {
			conn.setAutoCommit(false);
			user_id = find_userID(username, conn, st, rs);
			if(!StringUtils.isEmpty(user_id)) {
				String sql = "delete from t_orderpro where ord_id > 0 ";
				deldtePeople(sql, conn, st, rs);
				sql = "delete from t_order where user_id != " + user_id;
				deldtePeople(sql, conn, st, rs);
				sql = "delete from t_basket where user_id != " + user_id;
				deldtePeople(sql, conn, st, rs);
				sql = "delete from t_personalinfo where user_id != " + user_id;
				deldtePeople(sql, conn, st, rs);		
				conn.commit();	
				str = "清除成功";
			}
		} catch (Exception e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally{
			try {
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			DBUtil.closeAll(rs, st, conn);
		}
		return str;
	}
}
