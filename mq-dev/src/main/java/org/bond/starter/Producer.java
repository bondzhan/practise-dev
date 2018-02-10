/**   
* @Title: Producer.java 
* @Package org.bond.starter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月5日 下午3:24:18 
* @version V1.0   
*/
package org.bond.starter;

import java.util.Date;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ClassName: Producer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2018年2月5日 下午3:24:18
 * 
 */
@Component
public class Producer {
	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(Msg msg) {
		System.out.println("Sender : " + msg);
		this.rabbitTemplate.convertAndSend("springboot-amqp", msg);
	}
}
