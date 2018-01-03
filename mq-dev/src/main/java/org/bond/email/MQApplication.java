/**   
* @Title: MQApplication.java 
* @Package com.bond.email 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午4:48:07 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email;

import org.bond.email.consumer.EmailMQConsumer;
import org.bond.email.producer.EmailMQProducer;

/** 
* @ClassName: MQApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2017年6月13日 下午4:48:07 
*  
*/
public class MQApplication {

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
		EmailMQProducer producer = new EmailMQProducer("send-email");
		EmailMQConsumer consumer = new EmailMQConsumer("consumer-email");
	
		Thread producerThread = new Thread(producer);
		Thread consumerThread = new Thread(consumer);
		
//		producerThread.start();
		consumerThread.start();
	}

}
