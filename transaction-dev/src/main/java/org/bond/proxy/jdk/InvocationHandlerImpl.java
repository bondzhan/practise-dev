package org.bond.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InvocationHandlerImpl implements InvocationHandler {
	Logger logger = LoggerFactory.getLogger(getClass());

	private Object target;
	
	public InvocationHandlerImpl(){
	}

	
	public InvocationHandlerImpl(Object target){
		this.target = target;
	}

	// 绑定委托对象，并返回代理类
	public Object bind(Object target) {
		this.target = target;
		// 绑定该类实现的所有接口，取得代理类
		return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), this);
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable// 不依赖具体接口实现
	{
		Object result = null;// 被代理的类型为Object基类
		// 这里就可以进行所谓的AOP编程了
		logger.info("before invoke");
		// 在调用具体函数方法前，执行功能处理
		result = method.invoke(target, args);
		logger.info("after invoke");
		// 在调用具体函数方法后，执行功能处理
		return result;
	}
}
