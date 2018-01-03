/**   
* @Title: MQImpl.java 
* @Package com.bond.email 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午3:18:31 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * @ClassName: MQImpl
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年6月13日 下午3:18:31
 * 
 */
public abstract class MQImpl implements MQ {
	// 默认代理地址 "failover://tcp://localhost:61616" 服务器地址不同IP修改不同的IP
	public static final String BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	// 默认队列名称
	public static final String DEFALUT_MQ_NAME = "MQ-BOND";
	
	private String brokerUrl;
	private String userName;
	private String passwd;
	

	public String getBrokerUrl() {
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	private String mqName;

	public MQImpl() {
	}

	public MQImpl(String mqName) {
		this.mqName = mqName;
	}

	public String getMqName() {
		return mqName;
	}

	public void setMqName(String mqName) {
		this.mqName = mqName;
	}

	/*
	 * 初始化连接工厂
	 * 
	 * @see com.bond.email.MQ#getConn(java.lang.String)
	 */
	public Connection getConn(String borkerUrl) throws JMSException {
		// 初始化连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(borkerUrl);
		// 建立连接
		return connectionFactory.createConnection();
	}

	/*
	 * 创建Session
	 * 
	 * @see com.bond.email.MQ#getSession(javax.jms.Connection)
	 */
	public Session getSession(Connection conn) throws JMSException {
		// 此方法第一个参数表示会话是否在事务中执行，第二个参数设定会话的应答模式
		Session session = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
		return session;
	}

}
