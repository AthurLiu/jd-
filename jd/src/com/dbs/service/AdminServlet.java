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
	 *	��¼ҳ��
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
	 * 	ע��ҳ��
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
	 * 	���ﳵ���ҳ��
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
	 * 	��Ӷ���
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
	 * ��ʾ����ҳ��
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
	 * ��ʾ���ﳵҳ��
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
	 * 	�жϸ��û��Ƿ����(ע��)
	 * @param user
	 * @param out
	 * @param adminDao
	 */
	private void canRegister(String user,PrintWriter out) {
		if(!adminDao.exit(user)) 
			out.println("�û����Ѵ��ڣ������������û�����");
		else 
			out.println("�û��������ڣ�����ע�ᣡ");
	}
	
	/**
	 * 	�жϸ��û��Ƿ���ڣ���¼��
	 * @param user
	 * @param out
	 * @param adminDao
	 */
	private void canLogin(String user,PrintWriter out) {
		if(!adminDao.exit(user)) 
			out.println("�û������ڣ�");
		else 
			out.println("�û��������ڣ�");
	}
	
	/**
	 * 	��յ�ǰ�û��Ĺ��ﳵ
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
	 * 	ɾ����ǰ�û����ﳵ�����ĳ����Ʒ
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
	 * 	��ǰ�û���ĳ����Ʒ������һ
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
	 * 	��ǰ�û���ĳ����Ʒ������һ
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
	 * 	���ݹ��Ҳ���ʡ
	 * @param country ������
	 * @param out
	 * @param adminDao
	 */
	public void findProvince(String country,PrintWriter out) {
		out.println(adminDao.findProvinces(country));	
	}
	
	/**
	 * 	����ʡ������
	 * @param province ʡ��
	 * @param out
	 * @param adminDao
	 */
	public void findCity(String province,PrintWriter out) {
		out.println(adminDao.findCities(province));
	}
	
	/**
	 * 	�˳���¼�����session
	 * @param request
	 */
	public void exitLogin(HttpServletRequest request) {
		request.getSession().invalidate();
	}
	
	/**
	 * 	ɾ��ĳ���˵�������Ϣ������Ա��
	 * @param country ������
	 * @param out
	 * @param adminDao
	 */
	public void delUser(String username,PrintWriter out) {
		out.println(adminDao.delUser(username));	
	}
	
	/**
	 * 	������б�
	 * @param country ������
	 * @param out
	 * @param adminDao
	 */
	public void trunAllTable(PrintWriter out,HttpServletRequest request) {
		String username = request.getSession().getAttribute("user").toString();
		out.println(adminDao.trunAllTable(username));	
	}
	
	/**
	 * �쳣������ת
	 * @param out
	 */
	public void error(PrintWriter out) {
		out.println("<html>");	
		out.println("<meta http-equiv='refresh' content='0;URL=jsp/error.jsp'>");
		out.println("</html>");
	}
}
