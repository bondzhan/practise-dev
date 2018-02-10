/**   
* @Title: Consumer.java 
* @Package org.bond.starter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月5日 下午3:25:16 
* @version V1.0   
*/
package org.bond.starter;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/** 
* @ClassName: Consumer 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月5日 下午3:25:16 
*  
*/
@Component
@RabbitListener(queues = "springboot-amqp")
public class Consumer {

	@RabbitHandler
    public void process(Msg msg) {
        System.out.println("Receiver : " + msg);
    }
}
