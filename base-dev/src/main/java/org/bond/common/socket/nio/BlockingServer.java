package org.bond.common.socket.nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

import org.bond.common.TestSerializable;

public class BlockingServer {

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
		// TODO Auto-generated method stub
		ServerSocket server = new ServerSocket(87);
		BlockingServer blockServer = new BlockingServer();
		while (true) {
			Socket conn = server.accept();
			if (null != conn) {
				blockServer.readObj(conn);
			}
		}
	}
	

	public void readObj(Socket conn) throws IOException, ClassNotFoundException, InterruptedException {
		if (null != conn) {
			InputStream in = conn.getInputStream();
			ObjectInputStream objIn = new ObjectInputStream(conn.getInputStream());  
			TestSerializable data = (TestSerializable) objIn.readObject();
			if(data.getName().equals("bond10")){
				Thread.sleep(100);
			}
			System.out.println(data.getName());
		}
	}

	public static void readLine(Socket conn) throws IOException {
		if (null != conn) {
			InputStream in = conn.getInputStream();
			InputStreamReader rdr = new InputStreamReader(in);
			LineNumberReader lnr = new LineNumberReader(rdr);
			String s = lnr.readLine();
			if (null != s && !s.equals("")) {
				System.out.println(s);
			}
			in.close();
			rdr.close();
			lnr.close();
		}
	}

}
