package org.bond.common;

import java.util.concurrent.atomic.AtomicInteger;

public class AliDev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AtomicInteger nextServerCyclicCounter = new AtomicInteger(0);
		System.out.println(2%3);
        for (;;) {
        	int current = nextServerCyclicCounter.get();
        	System.out.println("############# current " + current);
            int next = (current + 1) % 3;
        	System.out.println("############# next" + next);
            if (nextServerCyclicCounter.compareAndSet(current, next))
                System.out.println(next);
            	if(next == 2)
            		break;
        }
	}
	
	public static void intTest(){
		Integer i = -129;
		Integer j = -200;
		
		Object o1 = new Object();
		Object o2 = new Object();
		Object o3 = new Object();

		RSA rsa1 = new RSA();
		RSA rsa2 = new RSA();
		
		
		System.out.println(i==j);
		System.out.println(i.equals(j));
		System.out.println(i.hashCode());
		System.out.println(j.hashCode());
		
		System.out.println(o1.hashCode());
		System.out.println(o2.hashCode());
		System.out.println(o3.hashCode());

		System.out.println(rsa1.hashCode());
		System.out.println(rsa2.hashCode());
	}

}
