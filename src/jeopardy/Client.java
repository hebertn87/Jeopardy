//Nathan Hebert 3/7/2018
//This is the client class, that contains how the client connects to the server and handles the questions
package jeopardy;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.io.DataOutputStream;

//Client class handles connection to server
public class Client {
	public static void main(String args[]) throws IOException {
		//Establish connection through port 1286
		Socket s = new Socket("localhost",1286);
		
		//Access the input stream with data input stream
		InputStream sIn = s.getInputStream();
		
		//Access the input stream with data input stream
		DataInputStream socketDIS = new DataInputStream(sIn);
		
		//Read from socket data input stream
		String testString = new String (socketDIS.readUTF());
		
		//Print data read
		System.out.println(testString);
		
		//clean up
		socketDIS.close();
		sIn.close();
		s.close();
	}
	
	
}


