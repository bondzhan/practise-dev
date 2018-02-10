/**   
* @Title: Msg.java 
* @Package org.bond.starter 
* @Description: TODO(用一句话描述该文件做什么) 
* @author bond
* @date 2018年2月6日 上午10:28:56 
* @version V1.0   
*/
package org.bond.starter;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName: Msg
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author bond
 * @date 2018年2月6日 上午10:28:56
 * 
 */
public class Msg implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -1227856252206855499L;

	private String msgRecMobile;
	private String msgContent;
	private Date msgCreateTime;
	private String msgTitle;

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMsgContent() + " " + getMsgRecMobile() + " " + getMsgTitle() + " " + getMsgCreateTime();
	}

	public Date getMsgCreateTime() {
		return msgCreateTime;
	}

	public void setMsgCreateTime(Date msgCreateTime) {
		this.msgCreateTime = msgCreateTime;
	}

	public String getMsgRecMobile() {
		return msgRecMobile;
	}

	public void setMsgRecMobile(String msgRecMobile) {
		this.msgRecMobile = msgRecMobile;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public String getMsgTitle() {
		return msgTitle;
	}

	public void setMsgTitle(String msgTitle) {
		this.msgTitle = msgTitle;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
