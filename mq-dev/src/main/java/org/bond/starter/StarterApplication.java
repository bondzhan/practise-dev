/**   
* @Title: StarterApplication.java 
* @Package org.bond.starter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月5日 下午3:23:16 
* @version V1.0   
*/
package org.bond.starter;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/** 
* @ClassName: StarterApplication 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月5日 下午3:23:16 
*  
*/
@SpringBootApplication
public class StarterApplication {
	public static void main(String args[]){
		SpringApplication.run(StarterApplication.class, args);
//		Producer producer = (Producer) ApplicationContext.getBean("producer");
//		for(int i = 0; i <= 10000; i++){
//			Msg msg = new Msg();
//			msg.setMsgCreateTime(new Date());
//			msg.setMsgTitle("title" + i);
//			msg.setMsgRecMobile("" + i);
//			msg.setMsgContent("content" + i);
//			producer.send(msg);
//		}
	}
	
}
