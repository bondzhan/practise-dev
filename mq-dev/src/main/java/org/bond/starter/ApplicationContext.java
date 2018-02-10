package org.bond.starter;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class ApplicationContext implements ApplicationContextAware {
	
  private static org.springframework.context.ApplicationContext ctx;

	/* (non-Javadoc)
	 * @see org.springframework.context.ApplicationContextAware#setApplicationContext(org.springframework.context.ApplicationContext)
	 */
	@Override
	public void setApplicationContext(org.springframework.context.ApplicationContext applicationContext)
			throws BeansException {
		ApplicationContext.ctx = applicationContext;
	}
	
	public static Object getBean(String beanName){
		return ctx.getBean(beanName);
	}
}
