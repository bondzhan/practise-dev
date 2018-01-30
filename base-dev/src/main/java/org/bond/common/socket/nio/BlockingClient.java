package org.bond.common.socket.nio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import org.bond.common.TestSerializable;

public class BlockingClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		printObj();
	}

	public static void printObj() throws UnknownHostException, IOException {
		Socket client = null;
		ObjectOutputStream outObj = null;
		int i = 1;
		while (i < 100) {
			client = new Socket("127.0.0.1", 87);
			outObj = new ObjectOutputStream(client.getOutputStream());
			TestSerializable test = new TestSerializable();
			test.setName("bond" + i);
			outObj.writeObject(test);
			i++;
		}
		outObj.flush();
		outObj.close();
		outObj = null;
		client.close();
		client = null;
	}

	public static void printStr() {
		Socket client = null;
		DataOutputStream out = null;
		DataInputStream in = null;
		int i = 1;
		while (i < 100)
			try {
				client = new Socket("127.0.0.1", 87);
				client.setSoTimeout(10000);
				out = new DataOutputStream((client.getOutputStream()));

				String query = "client " + i;
				byte[] request = query.getBytes();
				out.write(request);
				out.flush();
				client.shutdownOutput();

				out.close();
				client.close();
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
	}

}
