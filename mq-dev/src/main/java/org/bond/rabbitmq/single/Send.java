/**   
* @Title: Send.java 
* @Package org.bond.rabbitmq 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月3日 下午3:38:20 
* @version V1.0   
*/
package org.bond.rabbitmq.single;

/** 
* @ClassName: Send 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月3日 下午3:38:20 
*  
*/
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class Send {

  private final static String QUEUE_NAME = "hello";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    channel.queueDeclare(QUEUE_NAME, false, false, false, null);
    String message = "Hello Bond!";
    //默认交换的指定队列
    channel.basicPublish("", QUEUE_NAME, null, message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    connection.close();
  }
}