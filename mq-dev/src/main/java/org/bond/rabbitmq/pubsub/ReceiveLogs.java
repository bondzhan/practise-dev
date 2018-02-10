/**   
* @Title: ReceiveLogs.java 
* @Package org.bond.rabbitmq.pubsub 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月3日 下午5:36:16 
* @version V1.0   
*/
package org.bond.rabbitmq.pubsub;
import java.io.IOException;

import com.rabbitmq.client.*;
/** 
* @ClassName: ReceiveLogs 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月3日 下午5:36:16 
*  
*/
public class ReceiveLogs {
	private static final String EXCHANGE_NAME = "logs";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);
	    String queueName = channel.queueDeclare().getQueue();
	    channel.queueBind(queueName, EXCHANGE_NAME, "");

	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope,
	                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" [x] Received '" + message + "'");
	      }
	    };
	    channel.basicConsume(queueName, true, consumer);
	  } 
}
