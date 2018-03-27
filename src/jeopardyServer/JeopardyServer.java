package jeopardyServer;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class JeopardyServer implements Runnable{
	
	Socket s;
	
	public JeopardyServer(Socket _s) {
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
			new Thread(new JeopardyServer(sock)).start();
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
