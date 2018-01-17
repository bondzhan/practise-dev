/**   
* @Title: DemoService.java 
* @Package org.bond.rpc.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月9日 下午2:19:40 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/** 
* @ClassName: DemoService 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月9日 下午2:19:40 
*  
*/
public interface DemoService extends Remote{
	
	public String sayHello(String str) throws RemoteException ;
	
//	public Person getPersion(Person person);
}
