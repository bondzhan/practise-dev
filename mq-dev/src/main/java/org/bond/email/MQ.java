/**   
* @Title: MQ.java 
* @Package com.bond.email 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午3:14:53 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email;

import javax.jms.Connection;
import javax.jms.JMSException;
import javax.jms.Session;

/**
 * @ClassName: MQ
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年6月13日 下午3:14:53
 * 
 */
public interface MQ {
	public Connection getConn(String borkerUrl) throws JMSException;

	public Session getSession(Connection conn) throws JMSException;
}
