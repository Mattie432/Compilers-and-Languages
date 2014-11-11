package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer {
	String input;
	ArrayList<String> outputStr = new ArrayList<>();
	ArrayList<Token> outputTok = new ArrayList<>();
	
	/**
	 * Constructor for class, takes a string as an input.
	 * e.g. ( 5 + 4 )
	 * @param str : String - input string
	 */
	public Tokenizer(String str){
		input = str;
	}
	
	/**
	 * Start the tokenizer on the input string.
	 * @return boolean - Sucsess or not
	 * @throws Exception : Thrown if input invalid
	 */
	public boolean start() throws Exception{
		Scanner s = new Scanner(input);
		s.useDelimiter(" ");
		System.out.print("Parsed tokens = ");
		while (s.hasNext()){
			String item = s.next();
			System.out.print(item + ", ");
			outputStr.add(item);
			outputTok.add(determineToken(item));
		}
		s.close();
		return true;
	}

	/**
	 * Getter method for the tokenized output
	 * @return output : ArrayList<String> - the output.
	 */
	public ArrayList<String> getOutputStr(){
		return outputStr;
	}

	/**
	 * Getter method for the tokenised output
	 * @return output : ArrayList<Token> - tokenized output
	 */
	public ArrayList<Token> getOutputTok(){
		return outputTok;
	}
	
	/**
	 * Determines the type of token from the next character
	 * @param text : String - the input char
	 * @return Token - the ascociated token.
	 * @throws Exception 
	 */
	private Token determineToken(String text) throws Exception{
		if(text.equals("(")){
			return Token.LEFT_BRACKET;
		}else if(text.equals(")")){
			return Token.RIGHT_BRACKET;
		}else if(text.equals("+")){
			return Token.PLUS;
		}else if(text.equals("*")){
			return Token.MULTIPLY;
		}else if(isNumeric(text)){
			return Token.INT;
		}else{
			throw new Exception("ERROR: input '" + text + "' not valid!");
		}
	}
	
	
	/**
	 * Checks if the input string is a number
	 * @param str : String - string to check
	 * @return boolean - is numeric
	 */
	public static boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    @SuppressWarnings("unused")
		double d = Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	}
	
}
