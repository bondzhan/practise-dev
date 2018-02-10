/**   
* @Title: Worker.java 
* @Package org.bond.rabbitmq.worker 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月3日 下午4:31:00 
* @version V1.0   
*/
package org.bond.rabbitmq.worker;

import com.rabbitmq.client.*;

import java.io.IOException;
/** 
* @ClassName: Worker 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月3日 下午4:31:00 
*  
*/
public class Worker {

  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    final Connection connection = factory.newConnection();
    final Channel channel = connection.createChannel();

    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
    System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

    //RabbitMQ一次不能给一个worker多个消息
    channel.basicQos(1);

    final Consumer consumer = new DefaultConsumer(channel) {
      @Override
      public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
        String message = new String(body, "UTF-8");

        System.out.println(" [x] Received '" + message + "'");
        try {
          doWork(message);
        } finally {
          System.out.println(" [x] Done");
          channel.basicAck(envelope.getDeliveryTag(), false);
        }
      }
    };
    // 开始消息确认(false) 消费者发回确认(告知)告诉RabbitMQ已经收到，处理了一个特定的消息,RabbitMQ即可删除
    boolean autoAck  = false;
    channel.basicConsume(TASK_QUEUE_NAME, autoAck, consumer);
  }

  private static void doWork(String task) {
    for (char ch : task.toCharArray()) {	
      if (ch == '.') {
        try {
          System.out.println("sleep 3 seconds");
          Thread.sleep(3000);
        } catch (InterruptedException _ignored) {
          Thread.currentThread().interrupt();
        }
      }
    }
  }
}