package ex1;

import java.util.ArrayList;

public class Parser {
	
	int next = 0;
	
	private ArrayList<Token> input;

	public Parser(ArrayList<Token> tokenizedInput){
		this.input = tokenizedInput;
	}
	
	public boolean Start(){
		F();
		
		if(next == input.size()){
			System.out.println("true");
			return true;
		}else{
			System.out.println("false");
			return false;
		}
	}
	
	
	private boolean E(){
		int saveNext = next;
		if(E_1()){
			return true;
		}else{
			//Restore next pointer
			next = saveNext;
			return E_2();
		}
	}
	
	private boolean E_1(){
		return E() && Term(Token.PLUS) && T();
	}
	
	private boolean E_2(){
		return T();
	}
	
	private boolean T(){
		int saveNext = next;
		if(T_1()){
			return true;
		}else{
			//Restore next pointer
			next = saveNext;
			return T_2();
		}
	}
	
	private boolean T_1(){
		return T() && Term(Token.MULTIPLY) && F();
	}
	
	private boolean T_2(){
		return F();
	}
	
	private boolean F(){
		int saveNext = next;
		if(F_1()){
			return true;
		}else{
			//Restore next pointer
			next = saveNext;
			return F_2();
		}
	}
	
	private boolean F_1(){
		return Term(Token.LEFT_BRACKET) && E() && Term(Token.RIGHT_BRACKET);
	}
	
	private boolean F_2(){
		return Term(Token.INT);
	}
	
	/**
	 * Checks if the next input matches a token.
	 * Increments next pointer regardless of matched or not.
	 * @param tok : Token - Token to match to
	 * @return Boolean - Match sucsceeded
	 */
	private boolean Term(Token tok){
		return input.get(next++) == tok;
	}
	
}
