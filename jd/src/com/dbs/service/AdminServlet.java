package com.dbs.service;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.util.StringUtils;
import com.dbs.dao.AdminDao;
import com.dbs.dao.AdminDaoImpl;
import com.dbs.entity.AdminOrder;
import com.dbs.entity.AdminShopCar;
import com.dbs.entity.AdminUser;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name="/AdminServlet",urlPatterns= {"/login.do"})
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDao adminDao = new AdminDaoImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String method = request.getParameter("method");

		if(!StringUtils.isEmpty(method)) {
			if(method.endsWith(":registCheck")) {
				canRegister(method.split(":")[0],out);
			} else if (method.endsWith(":loginCheck")){
				canLogin(method.split(":")[0],out);
			} else if (method.endsWith(":countryToProvince")){
				findProvince(method.split(":")[0],out);
			} else if (method.endsWith(":provinceToCity")){
				findCity(method.split(":")[0],out);
			} else if (method.endsWith(":delUser")){
				delUser(method.split(":")[0],out);
			} else if("login".equals(method)) {
				login(request,out);
			} else if ("register".equals(method)){
				register(request,out);
			} else if ("addCar".equals(method)) {
				addCar(request,response);
			} else if("showCar".equals(method)) {
				showCar(request,response);
			} else if("order".equals(method)) {
				showOrder(request,response);
			} else if("exitLogin".equals(method)) {
				exitLogin(request);
			} else if("clearShop".equals(method)) {
				clearShop(request,response);
			} else if("mulShop".equals(method)) {
				mulShop(request,response);
			} else if("addShop".equals(method)) {
				addShop(request,response);
			} else if("delShop".equals(method)) {
				delShop(request,response);
			} else if("trunAllTable".equals(method)) {
				trunAllTable(out,request);
			} else if("addOrder".equals(method)){
				addOrder(request,response);
			} else {
				error(out);
			}
		} else {
			error(out);
		}		
	}
	
	/**
	 *	登录页面
	 * @param request
	 * @param out
	 * @param adminDao
	 * @throws IOException 
	 */
	protected void login(HttpServletRequest request, PrintWriter out){
		String username = request.getParameter("name");
		String password = request.getParameter("pwd");
		HttpSession session = request.getSession();
		if(!StringUtils.isEmpty(session.getAttribute("user")) && session.getAttribute("user").equals(username)) {
			out.println("repeat_login");
		} else {
			if(adminDao.login(username, password)) {
				session.setAttribute("user", username);
				if(adminDao.user_power(username).equals("admin")) 
					out.println("admin");
				else 
					out.println("success");			
			} else {
				out.println("fail");
			}
		}
	}
	
	/**
	 * 	注册页面
	 * @param request
	 * @param out
	 * @param adminDao
	 * @throws IOException 
	 */
	protected void register(HttpServletRequest r, PrintWriter out) throws IOException {
		AdminUser register = new AdminUser(r.getParameter("lname"),r.getParameter("lpwd"),r.getParameter("phone"),
				r.getParameter("email"),r.getParameter("sex"),r.getParameter("address"));
		if(adminDao.register(register)) 
			out.println("success");
		else 
			out.println("fail");
	}
	
	/**
	 * 	购物车添加页面
	 * @param request
	 * @param out
	 * @param adminDao
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void addCar(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String shopname = request.getParameter("sname");
		String number = request.getParameter("shopno");
		String username = request.getSession().getAttribute("user").toString();
		if(!StringUtils.isEmpty(number) || !StringUtils.isEmpty(shopname)) {
			adminDao.addCar(username,shopname,number);
		}
		showCar(request, response);
	}
	
	/**
	 * 	添加订单
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void addOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		if(adminDao.insertOrder(username)) {
			adminDao.deleteAllShopCar(username);
			showOrder(request,response);
		} else {
			request.getRequestDispatcher("jsp/shopCar.jsp").forward(request, response);	
		}
	}
	
	/**
	 * 显示订单页面
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showOrder(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		List<AdminOrder> list = adminDao.findAllOrderInfo(username);
		request.setAttribute("info", list);
		request.setAttribute("total", list.size() == 0 ? 0 : list.get(list.size()-1).getTotal());
		request.getRequestDispatcher("jsp/order_page.jsp").forward(request, response);	
	}
	
	/**
	 * 显示购物车页面
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void showCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		List<AdminShopCar> list = adminDao.findAllUserInfo(username);
		request.setAttribute("info", list);
		request.setAttribute("shopNumber", list.size());
		request.setAttribute("totalMoney", list.size() == 0 ? 0 : list.get(list.size()-1).getAllTotalMoney());
		request.getRequestDispatcher("jsp/shopCar.jsp").forward(request, response);	
	}
	
	/**
	 * 	判断该用户是否存在(注册)
	 * @param user
	 * @param out
	 * @param adminDao
	 */
	private void canRegister(String user,PrintWriter out) {
		if(!adminDao.exit(user)) 
			out.println("用户名已存在，请重新输入用户名！");
		else 
			out.println("用户名不存在，可以注册！");
	}
	
	/**
	 * 	判断该用户是否存在（登录）
	 * @param user
	 * @param out
	 * @param adminDao
	 */
	private void canLogin(String user,PrintWriter out) {
		if(!adminDao.exit(user)) 
			out.println("用户名存在！");
		else 
			out.println("用户名不存在！");
	}
	
	/**
	 * 	清空当前用户的购物车
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws IOException 
	 * @throws ServletException 
	 */
	protected void clearShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		adminDao.deleteAllShopCar(username);	
		showCar(request, response);
	}
	
	/**
	 * 	删除当前用户购物车里面的某件商品
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void delShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		String shopname = request.getParameter("shopName");
		adminDao.deleteSomeShopCar(username, shopname);
		showCar(request, response);
	}
	
	/**
	 * 	当前用户的某件商品数量加一
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void addShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		String shopname = request.getParameter("shopName");
		adminDao.AddShopCar1(username, shopname);
		showCar(request, response);
	}
	
	/**
	 * 	当前用户的某件商品数量减一
	 * @param request
	 * @param response
	 * @param adminDao
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void mulShop(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String username = request.getSession().getAttribute("user").toString();
		String shopname = request.getParameter("shopName");
		adminDao.MulShopCar1(username, shopname);
		showCar(request, response);
	}
	
	/**
	 * 	根据国家查找省
	 * @param country 国家名
	 * @param out
	 * @param adminDao
	 */
	public void findProvince(String country,PrintWriter out) {
		out.println(adminDao.findProvinces(country));	
	}
	
	/**
	 * 	根据省查找市
	 * @param province 省名
	 * @param out
	 * @param adminDao
	 */
	public void findCity(String province,PrintWriter out) {
		out.println(adminDao.findCities(province));
	}
	
	/**
	 * 	退出登录，清除session
	 * @param request
	 */
	public void exitLogin(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	/**
	 * 	删除某个人的所有信息（管理员）
	 * @param country 国家名
	 * @param out
	 * @param adminDao
	 */
	public void delUser(String username,PrintWriter out) {
		out.println(adminDao.delUser(username));	
	}
	
	/**
	 * 	清空所有表
	 * @param country 国家名
	 * @param out
	 * @param adminDao
	 */
	public void trunAllTable(PrintWriter out,HttpServletRequest request) {
		String username = request.getSession().getAttribute("user").toString();
		out.println(adminDao.trunAllTable(username));	
	}
	
	/**
	 * 异常请求跳转
	 * @param out
	 */
	public void error(PrintWriter out) {
		out.println("<html>");	
		out.println("<meta http-equiv='refresh' content='0;URL=jsp/error.jsp'>");
		out.println("</html>");
	}
}
