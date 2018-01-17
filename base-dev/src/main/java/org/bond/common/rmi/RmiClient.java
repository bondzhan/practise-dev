/**   
* @Title: RmiClient.java 
* @Package org.bond.common.rmi 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月11日 下午4:50:17 
* @version V1.0   
*/
package org.bond.common.rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/** 
* @ClassName: RmiClient 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月11日 下午4:50:17 
*  
*/
public class RmiClient {

	/** 
	* @Title: main 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param args  参数说明 
	* @return void    返回类型 
	* @author bond
	* @throws 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  try {  
			  DemoService h = (DemoService)Naming.lookup("rmi://192.168.0.161:12312/Hello");  
	            System.out.println(h.sayHello("zx"));  
	        } catch (MalformedURLException e) {  
	            System.out.println("url格式异常");  
	        } catch (RemoteException e) {  
	            System.out.println("创建对象异常");  
	            e.printStackTrace();  
	        } catch (NotBoundException e) {  
	            System.out.println("对象未绑定");  
	        }  
	}

}
