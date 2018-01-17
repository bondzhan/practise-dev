/**   
* @Title: ProviderApplication.java 
* @Package org.bond.rpc 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月9日 下午2:11:41 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.rpc;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* @ClassName: ProviderApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月9日 下午2:11:41 
*  
*/
public class ProviderApplication {

	/**
	 * @throws IOException  
	* @Title: main 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param args  参数说明 
	* @return void    返回类型 
	* @author bond
	* @throws 
	*/
	public static void main(String[] args) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {"dubbo-demo-provider.xml"});
        context.start();
        // press any key to exit
        System.in.read();
	}

}
