package jeopardyServer;

import java.io.IOException;

public class JeopardyServerDriver {
	
	//Main Driver for server
	public static void main(String args[]) {
		try {
			@SuppressWarnings("unused")
			JeopardyServer gameServer = new JeopardyServer(3); //Put in 2 for 3 players as we start at 0.
			
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
