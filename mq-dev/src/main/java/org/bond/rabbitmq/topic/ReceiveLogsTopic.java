/**   
* @Title: ReceiveLogsTopic.java 
* @Package org.bond.rabbitmq.topic 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月5日 下午12:15:10 
* @version V1.0   
*/
package org.bond.rabbitmq.topic;
import java.io.IOException;

import com.rabbitmq.client.*;

/** 
* @ClassName: ReceiveLogsTopic 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月5日 下午12:15:10 
*  
*/
public class ReceiveLogsTopic {
	private static final String EXCHANGE_NAME = "topic_logs";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);
	    String queueName = channel.queueDeclare().getQueue();

	    if (argv.length < 1) {
	      System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
	      System.exit(1);
	    }

	    for (String bindingKey : argv) {
	      channel.queueBind(queueName, EXCHANGE_NAME, bindingKey);
	    }

	    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

	    Consumer consumer = new DefaultConsumer(channel) {
	      @Override
	      public void handleDelivery(String consumerTag, Envelope envelope,
	                                 AMQP.BasicProperties properties, byte[] body) throws IOException {
	        String message = new String(body, "UTF-8");
	        System.out.println(" [x] Received '" + envelope.getRoutingKey() + "':'" + message + "'");
	      }
	    };
	    channel.basicConsume(queueName, true, consumer);
	  }
}
