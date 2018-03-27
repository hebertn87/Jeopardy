package gameObject;

//This class handles sending questions
public class JeopardyQuestion {
	
	int questionID;
	String question;
	int dollars;
	
	public JeopardyQuestion(int _questionID, String _question, int _dollars) {
		questionID = _questionID;
		question = _question;
		dollars = _dollars;

	}
	
	public String toString() {
		return "This Question is Worth " + dollars + " Dollars. Here is the Question: " + question;
	}
	
}
