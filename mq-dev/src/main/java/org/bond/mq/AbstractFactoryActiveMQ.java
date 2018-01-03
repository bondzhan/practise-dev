/**   
* @Title: AbstractFactoryActiveMQ.java 
* @Package com.bond.mq 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月16日 上午10:22:23 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.mq;

import javax.jms.Connection;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.pool.PooledConnectionFactory;

/**
 * @ClassName: AbstractFactoryActiveMQ
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @param <T>
 * @date 2017年6月16日 上午10:22:23
 * 
 */
abstract class AbstractFactoryActiveMQ implements FactoryActiveMQ {
	private PooledConnectionFactory poolConnenctFactory;
	private ActiveMQConnectionFactory connectFactory;
	private String userName;
	private String passwd;
	private String brokerUrl;
	private int maxConnections = 10;
	private int maximumActive = 8;

	public AbstractFactoryActiveMQ(){
		
	}
	public AbstractFactoryActiveMQ(String userName, String passwd, String brokerUrl, int maxConnections,
			int maximumActive) {
		super();
		this.userName = userName;
		this.passwd = passwd;
		this.brokerUrl = brokerUrl;
		this.maxConnections = maxConnections;
		this.maximumActive = maximumActive;
	}
	
	public AbstractFactoryActiveMQ(String borkerUrl){
		this.brokerUrl = borkerUrl;
	}

	public int getMaxConnections() {
		return maxConnections;
	}

	public void setMaxConnections(int maxConnections) {
		this.maxConnections = maxConnections;
	}

	public int getMaximumActive() {
		return maximumActive;
	}

	public void setMaximumActive(int maximumActive) {
		this.maximumActive = maximumActive;
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

	public String getBrokerUrl() {
		return brokerUrl;
	}

	public void setBrokerUrl(String brokerUrl) {
		this.brokerUrl = brokerUrl;
	}

	public PooledConnectionFactory getPoolConnenctFactory() {
		return poolConnenctFactory;
	}

	public void setPoolConnenctFactory(PooledConnectionFactory poolConnenctFactory) {
		this.poolConnenctFactory = poolConnenctFactory;
	}

	abstract void closeConn(Connection conn) ;

	public void createConnectionFactory() {
		// TODO Auto-generated method stub
		connectFactory = new ActiveMQConnectionFactory(userName, passwd, brokerUrl);
		poolConnenctFactory = new PooledConnectionFactory(connectFactory);
		poolConnenctFactory.setMaxConnections(maxConnections);
		poolConnenctFactory.setMaximumActive(maximumActive);
	}
	
	abstract void sendMessage(String msg, String queueName);

}
