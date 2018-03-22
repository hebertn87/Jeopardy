//Nathan Hebert 3/7/2018
//This is the server that allows the clients to connet to the game
package jeopardy;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]) throws IOException {
		
		ServerSocket ss = new ServerSocket(1286);
		Socket s = ss.accept();
		
		OutputStream socketOutStream = s.getOutputStream();
		DataOutputStream socketDOS = new DataOutputStream(socketOutStream);
		
		//Communicate with the socket 
		socketDOS.writeUTF("Welcome To Jeopardy!");
		
		//Clean up
		socketDOS.close();
		socketOutStream.close();
		s.close();
		ss.close();
	}
}
