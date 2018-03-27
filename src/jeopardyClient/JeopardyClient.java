package jeopardyClient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import gameObject.*;

//Client class handles connection to server
public class JeopardyClient {
	
	Socket socket = null;
	ObjectInputStream objIn = null;
	ObjectOutputStream objOut = null;
	DataInputStream dataIn = null;
	DataOutputStream dataOut = null;
	int numPlayer, startGameID = 0;
	boolean gameRunning = false;
	
	
	
	//Constructor
	public JeopardyClient() {
			try {
				PlayGame();
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}
		
	}
	
	public void PlayGame() throws ClassNotFoundException {
		
		//Established connection and created Object and dataStreams
		try {
			//Establish connection through port 1286
			socket = new Socket("localhost",1286);
			objIn = new ObjectInputStream(socket.getInputStream());
			objOut = new ObjectOutputStream(socket.getOutputStream());
			dataIn = new DataInputStream(socket.getInputStream());
			dataOut = new DataOutputStream(socket.getOutputStream());
			
		}catch(IOException e) {
			e.printStackTrace(); //Prints IOException
		}
		
		//Initialize Player		
		try {
			numPlayer = dataIn.readInt();
			System.out.println("You are connected! You are player #" + numPlayer + ".");
			System.out.println(dataIn.readUTF());
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		//Initialize threads here
		String tempString = null;
		//Do game loop
		while(!gameRunning) {
			try {
				tempString = dataIn.readUTF();
				System.out.println(tempString);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
			
			if(tempString.equals("Game started")) {
				gameRunning = true;
				break;
			}
		}	
		
		System.out.println("The game has now started. Get ready!");
		//respond to question
		try {
			dataIn.readInt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		try {
			tempString = dataIn.readUTF();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println(tempString);
		//gets whether or not we were right
	
	}
}
