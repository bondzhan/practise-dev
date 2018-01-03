/**   
* @Title: StaticBind.java 
* @Package com.bond.spring.proxy 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2017年5月17日 上午11:57:07 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.proxy;

/**
 * @ClassName: StaticBind
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2017年5月17日 上午11:57:07
 * 
 */
public class StaticBind {

	/**
	 * @Title: main @Description: TODO(这里用一句话描述这个方法的作用) @param @param args
	 *         参数说明 @return void 返回类型 @author bond @throws
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A a = new A();
		Number i = Integer.valueOf(1);
		Number l = Long.valueOf(1L);
		if(i instanceof Integer){
			System.out.println("Integer");

		}
		if(l instanceof Long){
			System.out.println("Long");

		}
		a.hello(i);
		a.hello(l);
	}

	static class A {
		public void hello(Number n) {
			System.out.println("number" + n);
		}

		public void hello(Long l) {
			System.out.println("Long" + l);
		}

		public void hello(Integer i) {
			System.out.println("integer" + i);
		}

	}

}
