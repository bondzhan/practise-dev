/**   
* @Title: Receiver.java 
* @Package com.bond.jms 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年3月29日 下午6:09:38 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
* @ClassName: Receiver 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2017年3月29日 下午6:09:38 
*  
*/
public class Receiver implements MessageListener{

	    //默认代理地址 "failover://tcp://localhost:61616"  服务器地址不同IP修改不同的IP
	    private static final String BROKER_URL=ActiveMQConnection.DEFAULT_BROKER_URL;
	    //消息队列名称 
	    private static final String SUBJECT="my-activemq";
	    public static void main(String[] args) throws JMSException {
	        //初始化连接工厂
	        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(BROKER_URL);
	        //建立连接
	        Connection conn= connectionFactory.createConnection();
	        //启动连接
	        conn.start();
	         //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
	        Session session= conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
	        //创建目标队列
	        Destination dest=session.createQueue(SUBJECT);
	        //通过session创建消息的接收者
	        MessageConsumer consumer= session.createConsumer(dest);
	        //初始化监听
	        Receiver receiver=new Receiver();
	        //给接收者添加监听对象
	        consumer.setMessageListener(receiver);
	    }
	    public void onMessage(Message arg0) {
	        TextMessage message=(TextMessage) arg0;
	        try {
	            System.out.println("接收到消息"+message.getText());
	            Thread.sleep(1000);
	        } catch (Exception e) {
	        	 System.out.println("error"+e.getMessage());
	        }

	    }

}
