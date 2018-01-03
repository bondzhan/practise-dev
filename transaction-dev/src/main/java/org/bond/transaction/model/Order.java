/**   
* @Title: Order.java 
* @Package org.bond.transaction.model 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年11月30日 下午3:58:21 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.transaction.model;

import java.util.Date;

/**
 * @ClassName: Order
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年11月30日 下午3:58:21
 * 
 */
public class Order {

	private String forderId;
	private Date fcreateTime;


	public String getForderId() {
		return forderId;
	}

	public void setForderId(String forderId) {
		this.forderId = forderId;
	}

	public Date getFcreateTime() {
		return fcreateTime;
	}

	public void setFcreateTime(Date fcreateTime) {
		this.fcreateTime = fcreateTime;
	}

}
