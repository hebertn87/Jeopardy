package gameObject;

//This class handles wrong answers.
public class JeopardyWrong {
	
	public String guess;
	public int playerID;
	
	public String toString() {
		return "Player" + playerID + " guessed: " + guess + ". This is incorrect.";
	}
	
}

