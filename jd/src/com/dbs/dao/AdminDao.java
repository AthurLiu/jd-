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
	 * ��¼
	 * @param username �û���
	 * @param password ����
	 * @return ע��ɹ�����true��ʧ�ܷ���false
	 */
	boolean login(String username, String password);
	
	/**
	 * ��Ʒ���빺�ﳵ
	 * @param username �û���
	 * @param shopname ��Ʒ��
	 * @param number ��Ʒ����
	 * @return ����ɹ�����true��ʧ�ܷ���false
	 */
	boolean addCar(String username,String shopname,String number);
	
	/**
	 * ע��
	 * @param register
	 * @return ע��ɹ�����true��ʧ�ܷ���false
	 */
	boolean register(AdminUser register);

	/**
	 * ��ʾĳ�˹��ﳵ�����������Ʒ
	 * @param username �û���
	 * @return ���ҳɹ�����true��ʧ�ܷ���false
	 */
	List<AdminShopCar> findAllUserInfo(String username);
	 
	/**
	 * ���ĳ���˵Ĺ��ﳵ
	 * @param username �û���
	 */
	void deleteAllShopCar(String username);
	 
	/**
	 * ɾ��ĳ���˵Ĺ��ﳵ������ض���Ʒ
	 * @param username �û���
	 * @param shopname ��Ʒ��
	 */
	void deleteSomeShopCar(String username,String shopname);
	 
	/**
	 * ĳ���˵Ĺ��ﳵ��ĳ����Ʒ��һ
	 * @param username �û���
	 * @param shopname ��Ʒ��
	 */
	void AddShopCar1(String username,String shopname);
	
	/**
	 * ĳ���˵Ĺ��ﳵ��ĳ����Ʒ��һ
	 * @param username �û���
	 * @param shopname ��Ʒ��
	 */
	void MulShopCar1(String username,String shopname);
	
	/**
	 * ����ָ����������ѯʡ������
	 * @param countryname ������
	 * @return ������������ʡ�����֣�Ŀǰ�������й���
	 */
	String findProvinces(String countryname);
	 
	/**
	 * ����ָ��ʡ����ѯ������
	 * @param province
	 * @return ʡ���������е�����
	 */
	String findCities(String province);
	 
	/**
	 * ĳ�˹��ﳵ�������Ʒ��ӵ�������
	 * @param username �û���
	 * @return ��ӳɹ�����true��ʧ�ܷ���false
	 */
	boolean insertOrder(String username);
	
	/**
	 * ���ĳ���˵Ķ�����Ϣ
	 * @param username �û���
	 * @return List<AdminOrder>
	 */
	List<AdminOrder> findAllOrderInfo(String username);
	
	/**
	 * ע���¼ʱ�ж��û��Ƿ���ڣ�AJAX�ֲ�ˢ�£�
	 * @param username �û���
	 * @return �û������ڷ���true�������ڷ���false
	 */
	boolean exit(String username);
	
	/**
	 * ɾ��ĳ���˵�������Ϣ
	 * @param username �û���
	 * @return
	 */
	String delUser(String username);
	
	/**
	 * ������б�
	 * @return
	 */
	String trunAllTable(String username);
	
	/**
	 * ��ѯ�û���Ȩ��
	 * @param username
	 * @return
	 */
	String user_power(String username);
}
