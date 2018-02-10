/**   
* @Title: NewTask.java 
* @Package org.bond.rabbitmq.worker 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月3日 下午4:30:29 
* @version V1.0   
*/
package org.bond.rabbitmq.worker;

/** 
* @ClassName: NewTask 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月3日 下午4:30:29 
*  
*/
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

public class NewTask {

  private static final String TASK_QUEUE_NAME = "task_queue";

  public static void main(String[] argv) throws Exception {
    ConnectionFactory factory = new ConnectionFactory();
    factory.setHost("localhost");
    Connection connection = factory.newConnection();
    Channel channel = connection.createChannel();

    //消息持久化
    boolean durable = true;
    channel.queueDeclare(TASK_QUEUE_NAME, true, false, false, null);
    argv = new String[]{"第3条消息..."};
    String message = getMessage(argv);
    //在RabbitMQ中，消息不能直接发送到队列，需要指定exchange
    //使用由空字符串标识的默认交换.
    //这种交换是特殊的 - 它允许我们准确地指定消息应该去哪个队列
    channel.basicPublish("", TASK_QUEUE_NAME,
        MessageProperties.PERSISTENT_TEXT_PLAIN,//消息标记为持久
        message.getBytes("UTF-8"));
    System.out.println(" [x] Sent '" + message + "'");

    channel.close();
    connection.close();
  }

  private static String getMessage(String[] strings) {
    if (strings.length < 1)
      return "this is bond!";
    return joinStrings(strings, " ");
  }

  private static String joinStrings(String[] strings, String delimiter) {
    int length = strings.length;
    if (length == 0) return "";
    StringBuilder words = new StringBuilder(strings[0]);
    for (int i = 1; i < length; i++) {
      words.append(delimiter).append(strings[i]);
    }
    return words.toString();
  }
}
