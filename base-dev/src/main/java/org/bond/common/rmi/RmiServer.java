package org.bond.common.rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class RmiServer {

	public static void main(String[] args) throws MalformedURLException, RemoteException, AlreadyBoundException {
		// TODO Auto-generated method stub
		DemoService demoService = new DemoServiceImpl();
		Naming.rebind("rmi://192.168.0.161:12312/Hello", demoService);
	}

}
