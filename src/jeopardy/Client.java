//Nathan Hebert 3/7/2018
//This is the client class, that contains how the client connects to the server and handles the questions
package jeopardy;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.io.DataOutputStream;
import java.io.OutputStream;

//Client class handles connection to server
public class Client {
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


