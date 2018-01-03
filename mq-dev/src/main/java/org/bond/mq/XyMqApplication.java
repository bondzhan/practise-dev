package org.bond.mq;

import org.apache.activemq.ActiveMQConnection;

public class XyMqApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		XyFactoryActiveMQ xyMq = new XyFactoryActiveMQ("", "",ActiveMQConnection.DEFAULT_BROKER_URL, 10, 8);
		int i = 0;
		while(true){
			xyMq.sendMessage("No." + i + "This is bond !!!", "mq-bond-email");
			i++;
			if(i > 100000){
				break;
			}
		}
	}

}
