/**   
* @Title: Recv.java 
* @Package org.bond.rabbitmq 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月3日 下午3:39:44 
* @version V1.0   
*/
package org.bond.rabbitmq.single;

import java.io.IOException;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Consumer;
import com.rabbitmq.client.DefaultConsumer;
import com.rabbitmq.client.Envelope;

/** 
* @ClassName: Recv 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月3日 下午3:39:44 
*  
*/
public class Recv {
	private final static String QUEUE_NAME = "hello";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
	          throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" [x] Received '" + message + "'");
	      }
	    };
	    channel.basicConsume(QUEUE_NAME, true, consumer);
	  }
}
