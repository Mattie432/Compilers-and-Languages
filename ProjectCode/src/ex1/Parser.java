package ex1;

import java.util.ArrayList;
import java.util.LinkedList;

public class Parser {

	int next = 0;
	ArrayList<Tuple> opt = new ArrayList<Tuple>();

	private ArrayList<Token> input;

	public Parser(ArrayList<Token> tokenizedInput) {
		this.input = tokenizedInput;
	}

	public boolean Start() {
		System.out.println();
		System.out.println("Result = " + F(0));
		System.out.println();

		
			int lvl = -1;
		while(!opt.isEmpty()){
			ArrayList<Tuple>toBeRemoved = new ArrayList<Tuple>();
			
			for(Tuple<String,Integer> t : opt){
				if(t.y == lvl){
					System.out.print(t.x);
					toBeRemoved.add(t);
				}
			}
			System.out.println();
			opt.removeAll(toBeRemoved);
			lvl++;
		}

		
		return true;
		
	}

	private boolean E(Integer l) {
			opt.add(new Tuple<String, Integer>("E, " , l-1));
			return T(l+1) && E_prime(l+1);
	}
	
	private boolean E_prime(Integer l){
		opt.add(new Tuple<String, Integer>("E', ", l-1));
		int saveNext = next;
		if(Term(Token.PLUS,l) && T(l+1) && E_prime(l+1)){
			return true;
		}else{
			opt.remove(opt.get(opt.size()-1));
			next = saveNext;
			return true;
		}
	}

	private boolean T(Integer l) {
		opt.add(new Tuple<String, Integer>("T, ",l-1));
		return F(l+1) && T_prime(l+1);
	}
	
	private boolean T_prime(Integer l){
		opt.add(new Tuple<String, Integer>("T', ", l-1));
		int saveNext = next;
		if(Term(Token.MULTIPLY,l) && F(l+1) && T_prime(l+1)){
			return true;
		}else{
			opt.remove(opt.get(opt.size()-1));
			next = saveNext;
			return true;
		}
	}

	private boolean F(Integer l) {
		opt.add(new Tuple<String, Integer>("F, ",l-1));
		int saveNext = next;
		
		if (Term(Token.INT,l)) {
			return true;
		} else {
			opt.remove(opt.get(opt.size()-1));
			// Restore next pointer
			next = saveNext;
			return Term(Token.LEFT_BRACKET, l) && E(l+1) && Term(Token.RIGHT_BRACKET, l);
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
	private boolean Term(Token tok, Integer l) {
		opt.add(new Tuple<String, Integer>(tok.toString() + ", ",l));
		return input.get(next++) == tok;
	}

}
