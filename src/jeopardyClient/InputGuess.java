package jeopardyClient;

import java.util.Scanner;
import java.io.ObjectOutputStream;

public class InputGuess{
	
	Scanner scan;
	int playerID;
	ObjectOutputStream objOut;
	
	public InputGuess(int _pID, ObjectOutputStream _objOut) {
		
		scan = new Scanner(System.in);
		playerID = _pID;
		objOut = _objOut;
	}
}
