package jeopardyClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//Client class handles connection to server
public class JeopardyClient {
	public static void main(String args[]) throws IOException {
		
		int clientNum = 1;
		//Establish connection through port 1286
		Socket s = new Socket("localhost",1286);
		
		//Access the input stream with data input stream
		InputStream sIn = s.getInputStream();
		OutputStream sOn = s.getOutputStream();
		
		//Access the input stream with data input stream
		DataInputStream socketDIS = new DataInputStream(sIn);
		DataOutputStream socketDOS = new DataOutputStream(sOn);
		
		//Read from socket data input stream
		//String testString = new String (socketDIS.readUTF());
		
		//Print data read
		socketDOS.writeInt(clientNum);
		
		socketDOS.writeUTF("I receieved your message, I'm ready to play!");
		
		//clean up
		socketDIS.close();
		socketDOS.close();
		sIn.close();
		sOn.close();
		s.close();
	}	
}
