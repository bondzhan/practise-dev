/**   
* @Title: RabbitConfig.java 
* @Package org.bond.starter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月5日 下午3:28:30 
* @version V1.0   
*/
package org.bond.starter;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/** 
* @ClassName: RabbitConfig 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年2月5日 下午3:28:30 
*  
*/
@Configuration
public class RabbitConfig {

    @Bean
    public Queue helloQueue() {
        return new Queue("springboot-amqp");
    }
}
