package ex1;

import java.util.ArrayList;

public class Parser {

	int next = 0;

	private ArrayList<Token> input;

	public Parser(ArrayList<Token> tokenizedInput) {
		this.input = tokenizedInput;
	}

	public boolean Start() {
		F();

		if (next == input.size()) {
			System.out.println("true");
			return true;
		} else {
			System.out.println("false");
			return false;
		}
	}

	private boolean E() {
		int saveNext = next;
		next++;
		// if next term is a plus
		if (Term(Token.PLUS)) {
			return T() && Term(Token.PLUS) && T();
		} else {
			next = saveNext;
			if (E() && Term(Token.PLUS) && T()) {
				return true;
			} else {
				// Restore next pointer
				next = saveNext;
				return T();
			}
		}
	}

	private boolean T() {
		int saveNext = next;
		next++;
		// if next term is a plus
		if (Term(Token.MULTIPLY)) {
			return F() && Term(Token.PLUS) && F();
		} else {
			next = saveNext;
			if (T() && Term(Token.MULTIPLY) && F()) {
				return true;
			} else {
				// Restore next pointer
				next = saveNext;
				return F();
			}
		}
	}

	private boolean F() {
		int saveNext = next;
		if (Term(Token.LEFT_BRACKET) && E() && Term(Token.RIGHT_BRACKET)) {
			return true;
		} else {
			// Restore next pointer
			next = saveNext;
			return Term(Token.INT);
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
