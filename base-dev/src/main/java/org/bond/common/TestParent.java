/**   
* @Title: TestSerializable.java 
* @Package org.bond.common 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月11日 上午10:16:36 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: TestSerializable
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2018年1月11日 上午10:16:36
 * 
 */
public class TestParent{

	public int staticVarParent = 1;
	
	public static List list = new ArrayList();
	
	public static void main(String args[]){
		TestParent.list.add("1");
		TestParent t1 = new TestParent();
		TestParent.list.add("2");
		TestParent t2 = new TestParent();
		TestParent.list.add("3");
		TestParent t3 = new TestParent();
		System.out.println("t1=" + t1.list.size() + " hascode=" + t1.toString());
		System.out.println("t2=" + t2.list.size() + " hascode=" + t1.toString());
		System.out.println("t3=" + t3.list.size() + " hascode=" + t1.toString());
		App app1 = new App();
		App app2 = app1;
		String str1 = new String("a");
		String str2 = "a";

		System.out.println(app1==app2);
		System.out.println(t1.equals(t2));

	}
}
