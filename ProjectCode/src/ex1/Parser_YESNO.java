package ex1;

import java.util.ArrayList;

public class Parser_YESNO {

	int next = 0;

	private ArrayList<Token> input;

	public Parser_YESNO(ArrayList<Token> tokenizedInput) {
		this.input = tokenizedInput;
	}

	public boolean Start() {
		System.out.println("Result = " + F());

		if (next == input.size()) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	private boolean E() {
			return T() && E_prime();
	}
	
	private boolean E_prime(){
		int saveNext = next;
		if(Term(Token.PLUS) && T() && E_prime()){
			return true;
		}else{
			next = saveNext;
			return true;
		}
	}

	private boolean T() {
		return F() && T_prime();
	}
	
	private boolean T_prime(){
		int saveNext = next;
		if(Term(Token.MULTIPLY) && F() && T_prime()){
			return true;
		}else{
			next = saveNext;
			return true;
		}
	}

	private boolean F() {
		int saveNext = next;
		
		if (Term(Token.INT)) {
			return true;
		} else {
			// Restore next pointer
			next = saveNext;
			return Term(Token.LEFT_BRACKET) && E() && Term(Token.RIGHT_BRACKET);
		}
	}

	/**
	 * Checks if the next input matches a token. Increments next pointer
	 * regardless of matched or not.
	 * 
	 * @param tok
	 *            : Token - Token to match to
	 * @return Boolean - Match sucsceeded
	 */
	private boolean Term(Token tok) {
		return input.get(next++) == tok;
	}

}
