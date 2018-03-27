package gameObject;

//This class handles correct answers
public class JeopardyCorrect {
	
	public String correct;
	public int playerID;
	public int dollar;
	
	public int getDollar() {
		return dollar;
	}
	
	public String toString() {
		return "Player " + playerID + " got the correct answer! He guessed: " + correct + " and was awarded $" + dollar + ".";
	}
	
	
}
