/**   
* @Title: EmailProducer.java 
* @Package com.bond.email 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午2:13:18 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email.producer;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName: EmailProducer
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年6月13日 下午2:13:18
 */
public class EmailMQProducer extends AbstractMQProducer implements Runnable{
	private static Logger logger = LoggerFactory.getLogger(EmailMQProducer.class);

	// 消息队列名称
	private static final String SUBJECT = "mq-bond-email";
		
	public EmailMQProducer(String mqName) {
		super(mqName);
	}
	
	public EmailMQProducer(){
		super();
	}

	@Override
	public void sendMail() throws JMSException, InterruptedException {
		
        //初始化连接工厂
		Connection conn = getConn(BROKER_URL);
		// 启动连接
		conn.start();
		// 创建Session
		Session session = getSession(conn);
		// 创建目标队列
		Destination dest = session.createQueue(SUBJECT);
		// 通过session创建消息的发送者
		MessageProducer producer = session.createProducer(dest);
		
		int i = 1;
		
		while (true) {
			sendMessage(session, producer, "THIS IS "+i+ " MESSAGES!!!");
			logger.info(this.getMqName());
			// 休眠2秒
//			Thread.sleep(1000);
			i++;
			if (i == 10000)
				break;
		}
		conn.close();
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
			logger.error(e.toString());
		}
	}

}
