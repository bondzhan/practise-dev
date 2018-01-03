package org.bond.common;

public class AliDev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
