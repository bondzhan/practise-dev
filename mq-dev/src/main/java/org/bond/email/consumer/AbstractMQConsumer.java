/**   
* @Title: MQConsumer.java 
* @Package com.bond.email.consumer 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年6月13日 下午3:16:25 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.email.consumer;

import org.bond.email.MQImpl;

/** 
* @ClassName: MQConsumer 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2017年6月13日 下午3:16:25 
*  
*/
public abstract class AbstractMQConsumer extends MQImpl  {
	
	public AbstractMQConsumer(){
	}
	
	public AbstractMQConsumer(String mqName){
		setMqName(mqName);
	}
}
