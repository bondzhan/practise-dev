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

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @ClassName: TestSerializable
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2018年1月11日 上午10:16:36
 * 
 */
public class TestSerializable extends TestParent implements Serializable{

	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	private static final long serialVersionUID = 5529968381341928513L;
	/** 
	* @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么) 
	*/ 
	public static int staticVar = 5;
	public static void main(String[] args) {
		try {
			TestSerializable  test = new TestSerializable();
			test.staticVarParent = 11;
			// 初始时staticVar为5
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("result.obj"));
			out.writeObject(test);
			out.writeObject(test);
			out.close();
			// 序列化后修改为10
			TestSerializable.staticVar = 10;
			ObjectInputStream oin = new ObjectInputStream(new FileInputStream("result.obj"));
			TestSerializable t = (TestSerializable) oin.readObject();
			TestSerializable t2 = (TestSerializable) oin.readObject();

			oin.close();
			// 再读取，通过t.staticVar打印新的值
			System.out.println(t.staticVar);
			System.out.println(t.staticVarParent);
			System.out.println(t == t2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
