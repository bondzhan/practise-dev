/**   
* @Title: XyFactoryActiveMQ.java 
* @Package com.bond.mq 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月16日 上午11:24:42 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.mq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * @ClassName: XyFactoryActiveMQ
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年6月16日 上午11:24:42
 * 
 */
public class XyFactoryActiveMQ extends AbstractFactoryActiveMQ {

	private ExecutorService threadPool;

	public XyFactoryActiveMQ() {
	}

	public XyFactoryActiveMQ(String userName, String passwd, String brokerUrl, int maxConnections, int maximumActive) {
		super(userName, passwd, brokerUrl, maxConnections, maximumActive);
		init();
	}

	public void closeSession(Session session) {
		try {
			if (session != null) {
				session.close();
				session = null;
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	private void init() {
		createConnectionFactory();
		threadPool = Executors.newFixedThreadPool(10);
	}

	@Override
	public void sendMessage(final String msg, final String queueName) {
		threadPool.execute(new Runnable() {

			public void run() {
				try {
					Connection connection = getPoolConnenctFactory().createConnection();
					connection.start();
					Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
					Destination dest = session.createQueue(queueName);
					// TODO Auto-generated method stub
					MessageProducer producer = session.createProducer(dest);
					// 定义要发送的消息
					TextMessage message = session.createTextMessage(msg);
					System.out.println("send: " + message.getText());
					// 发送消息
					producer.send(message);
					closeSession(session);
					closeConn(connection);
 				} catch (JMSException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

	/*
	 * 创建Session
	 * 
	 * @see com.bond.email.MQ#getSession(javax.jms.Connection)
	 */
	public Session getSession() throws JMSException {
		// 此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
		Connection connection = getPoolConnenctFactory().createConnection();
		connection.start();
		return connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
	}

	public void closeConn(Connection conn) {
		// TODO Auto-generated method stub
		try {
			if (conn != null) {
				conn.close();
				conn = null;
			}
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
