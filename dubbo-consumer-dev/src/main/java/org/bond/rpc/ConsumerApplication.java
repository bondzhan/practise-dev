/**   
* @Title: ConsumerApplication.java 
* @Package org.bond.rpc.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月9日 下午2:07:18 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.rpc;

import org.bond.rpc.pojo.Person;
import org.bond.rpc.service.DemoService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.dubbo.rpc.RpcContext;

/** 
* @ClassName: ConsumerApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月9日 下午2:07:18 
*  
*/
public class ConsumerApplication {

	/** 
	* @Title: main 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param args  参数说明 
	* @return void    返回类型 
	* @author bond
	* @throws 
	*/
	public static void main(String[] args) {
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
	                new String[]{"dubbo-demo-consumer.xml"});
	        context.start();
	        // obtain proxy object for remote invocation
	        DemoService demoService = (DemoService) context.getBean("demoService");
	        // execute remote invocation
	        String hello = demoService.sayHello("world");
	        Person person = new Person();
	        person.setAge(100);
	        person.setName("bond");
	        Person personDb = demoService.getPersion(person);
	        System.out.println(personDb.getId());
	        // show the result
//	        System.out.println(hello);
	        
//	        GenericService barService = (GenericService) context.getBean("demoService");
//	        String hello = (String) barService.$invoke("sayHello",new String[]{"java.lang.String"}, new Object[] { "World" });
	        
	        //本端是否为消费端，这里会返回true
	        boolean isConsumerSide = RpcContext.getContext().isConsumerSide();
	        System.out.println("是否为消费端" + isConsumerSide);
	        // 获取最后一次调用的提供方IP地址
	        String serverIP = RpcContext.getContext().getRemoteHost();
	        System.out.println("提供方IP地址" + serverIP);
	        // 获取当前服务配置信息，所有配置信息都将转换为URL的参数
	        String application = RpcContext.getContext().getUrl().getParameter("application");
	        System.out.println("服务配置信息" + application);
	        System.out.println(hello);
	}

}
