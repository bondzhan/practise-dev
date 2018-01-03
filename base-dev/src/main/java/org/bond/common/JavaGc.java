/**   
* @Title: JavaGc.java 
* @Package com.bond.dev 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2016年12月15日 下午2:16:17 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common;

/**
 * @ClassName: JavaGc
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2016年12月15日 下午2:16:17
 * 
 */
public class JavaGc {

	/**
	 * @Title: main @Description: TODO(这里用一句话描述这个方法的作用) @param @param args
	 * 参数说明 @return void 返回类型 @author bond @throws
	 */
	public static void main(String[] args) {
		byte[] b1, b2, b3, b4;// 定义变量
		b1 = new byte[1024 * 1024];// 分配 1MB 堆空间，考察堆空间的使用情况
		b2 = new byte[1024 * 1024];
		b3 = new byte[1024 * 1024];
		b4 = new byte[1024 * 1024];


	}

}
