//Nathan Hebert 3/7/2018
//This is the server that allows the clients to connect to the game
package jeopardy;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;

public class Server implements Runnable {
	
	Socket s;
	
	public Server(Socket _s) {
		this.s = _s;
	}
	
	public static void main(String args[]) throws IOException {
		
		ServerSocket ss = new ServerSocket(1286);
		System.out.println("Server is listening for clients.");
		
		while(true) {
			Socket sock = ss.accept();
			InputStream inStream = sock.getInputStream();
			DataInputStream serverInStream = new DataInputStream(inStream);
			Integer clientNum = new Integer (serverInStream.readInt());
			Integer leftToConn = 3 - clientNum;
			System.out.println("Client " + clientNum + " has connected. Waiting on " +  leftToConn + " Players.");
			new Thread(new Server(sock)).start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
}
