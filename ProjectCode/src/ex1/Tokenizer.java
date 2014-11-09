package ex1;

import java.util.ArrayList;
import java.util.Scanner;

public class Tokenizer {
	String input;
	ArrayList<String> outputStr = new ArrayList<>();
	ArrayList<Token> outputTok = new ArrayList<>();
	
	public Tokenizer(String str){
		input = str;
	}
	
	public boolean start() throws Exception{
		Scanner s = new Scanner(input);
		s.useDelimiter(" ");
		while (s.hasNext()){
			String item = s.next();
			System.out.println("Item: " + item);
			outputStr.add(item);
			outputTok.add(determineToken(item));
		}
		s.close();
		return true;
	}

	public ArrayList<String> getOutputStr(){
		return outputStr;
	}

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
