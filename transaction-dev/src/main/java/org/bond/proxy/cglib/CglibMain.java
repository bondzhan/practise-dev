package org.bond.proxy.cglib;

import javax.security.auth.Subject;

import org.bond.proxy.jdk.SubjectImpl;

public class CglibMain {

	public static void main(String args[]){
		MethodInterceptorImpl methodInterceptor = new MethodInterceptorImpl();
		SubjectImpl sub =  (SubjectImpl) methodInterceptor.getInstance(new SubjectImpl());
		sub.sayHi("bond bond bond");
	}
}
