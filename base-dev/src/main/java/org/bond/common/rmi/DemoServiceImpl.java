/**   
* @Title: DemoServiceImpl.java 
* @Package org.bond.rpc.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月9日 下午2:20:31 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/** 
* @ClassName: DemoServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月9日 下午2:20:31 
*  
*/
public class DemoServiceImpl extends UnicastRemoteObject implements DemoService {
	
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = -4091645108513547850L;
	
	protected DemoServiceImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	/* (non-Javadoc)
	 * @see org.bond.rpc.service.DemoService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String str) throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("###" + str + "###");
		return "Hi " + str;
	}
//	@Override
//	public Person getPersion(Person person) {
//		// TODO Auto-generated method stub
//		person.setId(new Random().nextInt());
//		return person;
//	}

}
