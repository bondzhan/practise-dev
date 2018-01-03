package org.bond.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/** 
* @ClassName: Sender 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2017�?3�?29�? 下午6:09:25 
*  
*/
public class Sender {

    //默认代理地址 "failover://tcp://localhost:61616"  服务器地�?不同IP修改不同的IP
    private static final String BROKER_URL=ActiveMQConnection.DEFAULT_BROKER_URL;
    //消息队列名称 
    private static final String SUBJECT="my-activemq";
    private static int i=1;
    public static void main(String[] args) throws JMSException, InterruptedException {
        //初始化连接工�?
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(BROKER_URL);
        //建立连接
        Connection conn= connectionFactory.createConnection();
        //启动连接
        conn.start();
         //创建Session，此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
        Session session= conn.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建目标队列
        Destination dest = session.createQueue(SUBJECT);
        //通过session创建消息的发送�??
        MessageProducer producer=session.createProducer(dest);
        while(true){
            //定义要发送的消息
            TextMessage message= session.createTextMessage("======ActiveMQ发�?�消�?===="+i+"===");
            System.out.println(message.getText());
            //发�?�消�?
            producer.send(message);
            //休眠2�?
            Thread.sleep(2000);
            i++;
            if(i == 3) break;
        }
        conn.close();

    }

}
