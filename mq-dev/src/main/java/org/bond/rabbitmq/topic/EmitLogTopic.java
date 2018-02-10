/**   
* @Title: EmitLogTopic.java 
* @Package org.bond.rabbitmq.topic 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月5日 下午12:14:30 
* @version V1.0   
*/
package org.bond.rabbitmq.topic;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/** 
* @ClassName: EmitLogTopic 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月5日 下午12:14:30 
*  
*/
public class EmitLogTopic {
	private static final String EXCHANGE_NAME = "topic_logs";

	  public static void main(String[] argv) {
	    Connection connection = null;
	    Channel channel = null;
	    try {
	      ConnectionFactory factory = new ConnectionFactory();
	      factory.setHost("localhost");

	      connection = factory.newConnection();
	      channel = connection.createChannel();

	      channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

	      String routingKey = getRouting(argv);
	      String message = getMessage(argv);

	      channel.basicPublish(EXCHANGE_NAME, routingKey, null, message.getBytes("UTF-8"));
	      System.out.println(" [x] Sent '" + routingKey + "':'" + message + "'");

	    }
	    catch  (Exception e) {
	      e.printStackTrace();
	    }
	    finally {
	      if (connection != null) {
	        try {
	          connection.close();
	        }
	        catch (Exception ignore) {}
	      }
	    }
	  }

	  private static String getRouting(String[] strings){
	    if (strings.length < 1)
	    	    return "anonymous.info";
	    return strings[0];
	  }

	  private static String getMessage(String[] strings){
	    if (strings.length < 2)
	    	    return "Hello World!";
	    return joinStrings(strings, " ", 1);
	  }

	  private static String joinStrings(String[] strings, String delimiter, int startIndex) {
	    int length = strings.length;
	    if (length == 0 ) return "";
	    if (length < startIndex ) return "";
	    StringBuilder words = new StringBuilder(strings[startIndex]);
	    for (int i = startIndex + 1; i < length; i++) {
	        words.append(delimiter).append(strings[i]);
	    }
	    return words.toString();
	  }
}
