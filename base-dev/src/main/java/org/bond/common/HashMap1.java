package org.bond.common;

import java.util.HashMap;
import java.util.Map;

public class HashMap1 {

	public static void main(String[] args) {
		// Map中put的对象是引用关系，取出来之后再赋值，再取出来对象也会发生变化
		Map<String, StringBuffer> map = new HashMap<String, StringBuffer>();
		StringBuffer sb = new StringBuffer("aa");
		map.put("1", sb);
		map.put("2", sb);
		map.get("1").append("3");
		System.out.println(map.get("2"));
		System.out.println(map.get("1"));
	}

}
