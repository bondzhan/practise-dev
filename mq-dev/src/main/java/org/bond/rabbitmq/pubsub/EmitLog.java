/**   
* @Title: EmitLog.java 
* @Package org.bond.rabbitmq.pubsub 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月3日 下午5:37:02 
* @version V1.0   
*/
package org.bond.rabbitmq.pubsub;
import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
/** 
* @ClassName: EmitLog 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月3日 下午5:37:02 
*  
*/
public class EmitLog {

	  private static final String EXCHANGE_NAME = "logs";

	  public static void main(String[] argv) throws Exception {
	    ConnectionFactory factory = new ConnectionFactory();
	    factory.setHost("localhost");
	    Connection connection = factory.newConnection();
	    Channel channel = connection.createChannel();

	    channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.FANOUT);

	    String message = getMessage(argv);

	    channel.basicPublish(EXCHANGE_NAME, "", null, message.getBytes("UTF-8"));
	    System.out.println(" [x] Sent '" + message + "'");

	    channel.close();
	    connection.close();
	  }

	  private static String getMessage(String[] strings){
	    if (strings.length < 1)
	    	    return "info: Hello World!";
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
