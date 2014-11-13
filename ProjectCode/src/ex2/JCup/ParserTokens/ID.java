package ex2.JCup.ParserTokens;


public class ID extends F{
    Integer var;

    public ID(Integer s) {
       var = s;
    }

	@Override
	void print(String prefix, boolean isTail) {
		
	    String type = "F";
		System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
	    
		System.out.println(prefix + "    " + (isTail ?  "\\-- " : "|-- ") + "ID");
	    
	}
}