/**   
* @Title: EmailMQConsumer.java 
* @Package com.bond.email.consumer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午3:29:27 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email.consumer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: EmailMQConsumer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年6月13日 下午3:29:27
 * 
 */
public class EmailMQConsumer extends AbstractMQConsumer implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(EmailMQConsumer.class);
	
	public EmailMQConsumer(){
	}

	public EmailMQConsumer(String mqName){
		super(mqName);
	}
	

	// 消息队列名称
	private static final String SUBJECT = "mq-bond-email";

	public void sendMail() throws JMSException, InterruptedException {
		// 初始化连接工厂
		Connection conn = getConn(BROKER_URL);
		// 启动连接
		conn.start();
		// 创建Session
		Session session = getSession(conn);
		// 创建目标队列
		Destination dest = session.createQueue(SUBJECT);
		// 通过session创建消息的发送者
		MessageConsumer consumer = session.createConsumer(dest);

		while (true) {
			logger.info(this.getMqName());
			// 设置接收者接收消息的时间，为了便于测试，这里设定为100s
			TextMessage message = (TextMessage) consumer.receive(1000 * 1000);
			if (null != message) {
				logger.info("线程" + this.getMqName() + "收到消息:" + message.getText());
				System.out.println("线程" + this.getMqName() + "收到消息:" + message.getText());
			} else {
				continue;
			}
		}
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			sendMail();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error(e.toString());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
