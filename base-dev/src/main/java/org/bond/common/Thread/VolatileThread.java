/**   
* @Title: VolatileThread.java 
* @Package org.bond.common.Thread 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年1月3日 下午4:36:21 
* @company 版权所有 深圳市天行云供应链有限公司
* @version V1.0   
*/
package org.bond.common.Thread;

/** 
* @ClassName: VolatileThread 
* @Description: TODO(这里用一句话描述这个类的作用) 
* @author bond
* @date 2018年1月3日 下午4:36:21 
*  
*/
public class VolatileThread{

	/**
	 * @throws InterruptedException  
	* @Title: main 
	* @Description: TODO(这里用一句话描述这个方法的作用) 
	* @param @param args  参数说明 
	* @return void    返回类型 
	* @author bond
	* @throws 
	*/
	public static void main(String[] args) throws InterruptedException {
		CountThread countThread = new CountThread();
		countThread.start();
		Thread.sleep(4000);
		countThread.cancel();
		countThread.join();
		System.out.println(countThread.count);
	}
}

class CountThread extends Thread{
	private boolean ready = true;
	public int count = 0;
	@Override
	public void run(){
		while(ready){
			count ++;
			System.out.println("CountThread count ++ : " + count);
		}
	}
	
	public void cancel(){
		ready = false;
	}
}
