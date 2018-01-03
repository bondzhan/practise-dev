/**   
* @Title: Proxy.java 
* @Package com.bond.spring 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年5月17日 上午10:29:04 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.proxy;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/** 
* @ClassName: Proxy 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2017年5月17日 上午10:29:04 
*  
*/
@Configuration  
@ComponentScan  
@EnableAspectJAutoProxy(proxyTargetClass = true)  
public class AspectProxy {

	/** 
	* @Title: main 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param args  参数说明 
	* @return void    返回类型 
	* @author bond
	* @throws 
	*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 AnnotationConfigApplicationContext ctx =  
	                new AnnotationConfigApplicationContext(AspectProxy.class); 
		 A a = ctx.getBean(A.class);
		 a.test();
	}
	
	@Component  
	@Aspect  
	class MyAspect {  
	    @Before("execution(* *(..))")  
	    public void before() {  
	  
	    }  
	}  
	
	@Component
	class A{
		
		@Autowired
		private B b;
		
		final void test(){
			b.test();
		}
	}
	
	@Component
	class B{
		 void test(){
			System.out.print("B");
		}
	}
	
	

}
