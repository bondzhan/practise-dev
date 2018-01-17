/**   
* @Title: Person.java 
* @Package org.bond.rpc.pojo 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月11日 下午2:29:51 
* @version V1.0   
*/
package org.bond.common.rmi;

import java.io.Serializable;

/** 
* @ClassName: Person 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月11日 下午2:29:51 
*  
*/
public class Person implements Serializable{

	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
