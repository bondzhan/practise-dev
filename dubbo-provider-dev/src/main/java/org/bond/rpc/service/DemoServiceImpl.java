/**   
* @Title: DemoServiceImpl.java 
* @Package org.bond.rpc.service 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月9日 下午2:20:31 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.rpc.service;

import java.util.Random;

import org.bond.rpc.pojo.Person;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;

/** 
* @ClassName: DemoServiceImpl 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月9日 下午2:20:31 
*  
*/
public class DemoServiceImpl implements DemoService {
	Logger log = LoggerFactory.getLogger(getClass());
	/* (non-Javadoc)
	 * @see org.bond.rpc.service.DemoService#sayHello(java.lang.String)
	 */
	@Override
	public String sayHello(String str) {
		// TODO Auto-generated method stub
		log.info("###" + str + "###");
		return "Hi " + str;
	}
	@Override
	public Person getPersion(Person person) {
		// TODO Auto-generated method stub
		person.setId(new Random().nextInt());
		return person;
	}

}
