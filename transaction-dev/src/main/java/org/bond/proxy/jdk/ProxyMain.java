package org.bond.proxy.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;


public class ProxyMain {

	public static void main(String args[]) throws NoSuchMethodException, SecurityException, InstantiationException,
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		InvocationHandlerImpl proxyInvoke = new InvocationHandlerImpl();
//		 Subject subject = (Subject) proxyInvoke.bind(new SubjectImpl());
//		 System.out.println(subject.getClass().getName());
//		 subject.sayHi("bond");
//		 subject.hashCode();
//		 subject.toString();
//		proxy2();
//		proxy();
		proxy3();
	}

	public static void proxy() {
		
		Subject sub = new SubjectImpl();
		// InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
		InvocationHandler handler = new InvocationHandlerImpl(sub);
		
//		Class class1 = Proxy.getProxyClass(sub.getClass().getClassLoader(),
//				 sub.getClass().getInterfaces());
//		System.out.println(class1.getName());
//		
//		UserService userService = new UserServiceImpl();
//		Class class2 = Proxy.getProxyClass(userService.getClass().getClassLoader(),
//				userService.getClass().getInterfaces());
//		System.out.println(class2.getName());
//		
//		Class class3 = Proxy.getProxyClass(sub.getClass().getClassLoader(),
//				 sub.getClass().getInterfaces());
//		System.out.println(class3.getName()); 
		// 通过 Proxy 直接创建动态代理类实例
		Subject proxy = (Subject) Proxy.newProxyInstance(sub.getClass().getClassLoader(),
				 sub.getClass().getInterfaces(), handler);
		InvocationHandler handler2 = Proxy.getInvocationHandler(proxy);
		System.out.println(proxy.getClass().getName());
		proxy.sayHi("you you ");
	}
	
	public static void proxy2() throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		// InvocationHandlerImpl 实现了 InvocationHandler 接口，并能实现方法调用从代理类到委托类的分派转发
		// 其内部通常包含指向委托类实例的引用，用于真正执行分派转发过来的方法调用
		InvocationHandler proxyInvoke = new InvocationHandlerImpl(new SubjectImpl());
		// 通过 Proxy 为包括 Interface 接口在内的一组接口动态创建代理类的类对象
		Class clzss = Proxy.getProxyClass(Subject.class.getClassLoader(), new Class[] { Subject.class });
		// 通过反射从生成的类对象获得构造函数对象
		Constructor constructor = clzss.getConstructor(new Class[] { InvocationHandler.class });
		// 通过构造函数对象创建动态代理类实例
		Subject proxy = (Subject) constructor.newInstance(new Object[] { proxyInvoke });
		System.out.println(proxy.getClass().getName());
		proxy.sayHi("bond");
	}
	
	
	 //实现框架功能，生成代理只需要传递target目标类，和封装了系统功能的对象MyAdvice  
    public static void proxy3() {  
    	ArrayList target = new ArrayList(); //目标类
    	SubjectImpl sub = new SubjectImpl();
        Collection proxy = (Collection)Proxy.newProxyInstance(   //生成代理类对象  
            target.getClass().getClassLoader(),  
            target.getClass().getInterfaces(),  
            new InvocationHandler() {  
                public Object invoke(Object proxy, Method method, Object[] args)  
                    throws Throwable {  
                	sub.sayHi(method.getName() + " start"); //切面代码  
                    Object retVal = method.invoke(target ,args);//调用目标类的方法  
                	sub.sayHi(method.getName() + " end"); //切面代码  
                    return retVal;  
                }  
            }  
        );
        proxy.add("aaa");
        System.out.println(proxy.toArray()[0]);
    }  
}
