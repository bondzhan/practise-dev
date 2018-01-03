/**   
* @Title: AbstractMQProducer.java 
* @Package com.bond.email 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午2:54:31 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email.producer;

import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.bond.email.MQImpl;

/**
 * @ClassName: AbstractMQProducer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年6月13日 下午2:54:31
 * 
 */
public abstract class AbstractMQProducer extends MQImpl {
	private static Logger logger = LoggerFactory.getLogger(AbstractMQProducer.class);

	
	public AbstractMQProducer(){
	}
	
	public AbstractMQProducer(String mqName){
		setMqName(mqName);
	}

	/*
	 * 发送消息
	 * 
	 * @see com.bond.email.MQProducer#sendMessage(javax.jms.Session,
	 * javax.jms.MessageProducer, java.lang.String)
	 */
	public void sendMessage(Session session, MessageProducer producer, String msg) throws JMSException {
		// 定义要发送的消息
		TextMessage message = session.createTextMessage(msg);
		logger.info("send: " + message.getText());
		System.out.println("send: " + message.getText());
		// 发送消息
		producer.send(message);
	}	
	
	public abstract void sendMail() throws JMSException, InterruptedException;

}
