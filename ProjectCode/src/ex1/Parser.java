package ex1;

import java.util.ArrayList;

public class Parser {

	int next = 0;
	MyNode root = new MyNode(-1, "  ");
	private ArrayList<Token> input;

	/**
	 * Constructor for the class, expects an array list of tokens from
	 * Tokenizer.getOutputTok.
	 * 
	 * @param tokenizedInput
	 *            : ArrayList<Token> input - the tokenized input
	 */
	public Parser(ArrayList<Token> tokenizedInput) {
		this.input = tokenizedInput;
	}

	/**
	 * Starts the parse of the tokenized input. Returns boolean if the parse is
	 * sucsessful.
	 * 
	 * @return boolean - Parse Sucsessful.
	 */
	public boolean Start() {
		root = new MyNode(-1, "  ");
		next = 0;
		boolean result = F(0, root);

		// Check if it checked the whole input or ended early.
		if (next != input.size()) {
			result = false;
		}

		//Print result
		System.out.println();
		System.out.println("Valid input? = " + result);
		System.out.println();

		return result;
	}

	/**
	 * Prints the parse tree to the console.
	 */
	public void printTree() {
		System.out.println("Printing the parse tree for the input.");
		root.getChildren().get(0).print();
	}

	/**
	 * Checks if the next token fits the 'E' type
	 * @param l : Integer - the Level of the current operation
	 * @param parent : MyNode - the parent of this node
	 * @return boolean - is this type or not
	 */
	private boolean E(Integer l, MyNode parent) {
		MyNode item = new MyNode(l + 1, "E ");
		parent.getChildren().add(item);
		return T(l + 1, item) && E_prime(l + 1, item);
	}

	/**
	 * Checks if the next token fits the 'E_prime' type
	 * @param l : Integer - the Level of the current operation
	 * @param parent : MyNode - the parent of this node
	 * @return boolean - is this type or not
	 */
	private boolean E_prime(Integer l, MyNode parent) {
		MyNode item = new MyNode(l + 1, "E'");
		parent.getChildren().add(item);

		int saveNext = next;
		//check if +TE'
		if (Term(Token.PLUS, l, item) && T(l + 1, item) && E_prime(l + 1, item)) {
			return true;
		} else {
			item.children.clear();
			next = saveNext;
			MyNode item2 = new MyNode(l, "e ");
			item.children.add(item2);
			return true;
		}
	}

	/**
	 * Checks if the next token fits the 'T' type
	 * @param l : Integer - the Level of the current operation
	 * @param parent : MyNode - the parent of this node
	 * @return boolean - is this type or not
	 */
	private boolean T(Integer l, MyNode parent) {
		MyNode item = new MyNode(l + 1, "T ");
		parent.getChildren().add(item);

		return F(l + 1, item) && T_prime(l + 1, item);
	}


	/**
	 * Checks if the next token fits the 'T_prime' type
	 * @param l : Integer - the Level of the current operation
	 * @param parent : MyNode - the parent of this node
	 * @return boolean - is this type or not
	 */
	private boolean T_prime(Integer l, MyNode parent) {
		MyNode item = new MyNode(l + 1, "T'");
		parent.getChildren().add(item);

		int saveNext = next;
		if (Term(Token.MULTIPLY, l, item) && F(l + 1, item)
				&& T_prime(l + 1, item)) {
			return true;
		} else {
			next = saveNext;
			item.children.clear();
			MyNode item2 = new MyNode(l, "e ");
			item.getChildren().add(item2);
			return true;
		}
	}

	/**
	 * Checks if the next token fits the 'F' type
	 * @param l : Integer - the Level of the current operation
	 * @param parent : MyNode - the parent of this node
	 * @return boolean - is this type or not
	 */
	private boolean F(Integer l, MyNode parent) {
		MyNode item = new MyNode(l + 1, "F ");
		parent.getChildren().add(item);
		int saveNext = next;

		if (Term(Token.LEFT_BRACKET, l, item) && E(l + 1, item)
				&& Term(Token.RIGHT_BRACKET, l, item)) {
			return true;
		} else {
			// Restore next pointer
			next = saveNext;
			item.children.clear();
			return Term(Token.INT, l, item);
		}
	}

	/**
	 * Checks if the next input matches a token. Increments next pointer
	 * regardless of matched or not.
	 * 
	 * @param tok
	 *            : Token - Token to match to
	 * @param l : Integer - level of the parse
	 * @param parent : MyNode - the parent node
	 * @return Boolean - Match sucsceeded
	 */
	private boolean Term(Token tok, Integer l, MyNode parent) {

		MyNode item;
		String t = tok.toString();
		if (t == "LEFT_BRACKET") {
			item = new MyNode(l, "( ");
		} else if (t == "RIGHT_BRACKET") {
			item = new MyNode(l, ") ");
		} else if (t == "MULTIPLY") {
			item = new MyNode(l, "* ");
		} else if (t == "PLUS") {
			item = new MyNode(l, "+ ");
		} else if (t == "INT") {
			item = new MyNode(l, "a ");
		} else {
			item = null;
		}
		parent.getChildren().add(item);

		return input.get(next++) == tok;
	}

}
