package jeopardyServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import gameObject.JeopardyQuestion;
import gameObject.JeopardyAnswer;

public class JeopardyServer {
	
	Integer numPlayer;
	ServerSocket serverSocket;
	Socket[] socket;
	InputStream[] in;
	OutputStream[] out;
	DataInputStream[] dataIn;
	DataOutputStream[] dataOut;
	ObjectInputStream[] objIn;
	ObjectOutputStream[] objOut;
	int startGameID = 13;
	
	public JeopardyServer(int _numPlayer) throws IOException {
		
		//Initialize Sockets
		serverSocket = new ServerSocket();
		serverSocket = new ServerSocket(1286);
		
		JeopardyQuestion question  = new JeopardyQuestion(1, "What is 2 + 2", 200);
		JeopardyAnswer answer = new JeopardyAnswer(1, "4", 200);
		
		

						
			//Set the players number
			numPlayer = _numPlayer;
			
			//Construct connection members
			socket = new Socket[numPlayer];
			in = new InputStream[numPlayer];
			out = new OutputStream[numPlayer];
			dataIn = new DataInputStream[numPlayer];
			dataOut = new DataOutputStream[numPlayer];
			objIn = new ObjectInputStream[numPlayer];
			objOut = new ObjectOutputStream[numPlayer];
		
			for(int i = 0; i < numPlayer; i++) {
				System.out.println("Waiting for " + (numPlayer - i) + " clients.");
			
				for(int j = 0; j < i; j++) {
					dataOut[j].writeUTF("Still waiting on "+ (numPlayer - i) + " Players");
				}

				socket[i] = serverSocket.accept();
				System.out.println("Accepted #" + (i + 1) + " client." );
				
				//Input and output binding
				out[i] = socket[i].getOutputStream();
				in[i] = socket[i].getInputStream();
				objOut[i] = new ObjectOutputStream(socket[i].getOutputStream());
				objIn[i] = new ObjectInputStream(socket[i].getInputStream());
				dataOut[i] = new DataOutputStream(out[i]);
				dataIn[i] = new DataInputStream(in[i]);
				
				dataOut[i].writeInt((i + 1));
			}
		
			//For loop that tells players what player they are, and tells them when the game starts
			for(int i = 0; i < numPlayer; i++) {
				System.out.println("Game has now started");
				dataOut[i].writeUTF("Game started");
				dataOut[i].writeInt(numPlayer);
				dataOut[i].flush();			
			}
			
			//Handle game logic and send
			for(int i = 0; i < numPlayer; i++)
			{
			dataOut[i].writeUTF(question.toString());
			}
			
			//initialize threads
			boolean istrue = true;
			while(istrue) {
				Thread clientThread;
				ClientListenerThread myThread = new ClientListenerThread();
				clientThread = new Thread(myThread);
				clientThread.run();
			}
			
			
			
			//Clean up
			for(int i = 0; i < numPlayer; i++) {
				dataOut[i].close();
				dataIn[i].close();
				objOut[i].close();
				objIn[i].close();
				in[i].close();
				out[i].close();
				socket[i].close();
			}
		
	}
}
