package ex2.JCup.ParserTokens;

public class FBRACKET extends F {
    E child1;
    public FBRACKET(E e) {
      child1 = e;
    }
	@Override
    void print(String prefix, boolean isTail) {
    	
        String type = "F";
		System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
        
		System.out.println(prefix + "    " + (isTail ?  "|-- " : "|-- ") + "(");
		child1.print(prefix + (isTail ? "    " : "|   "), false);
		System.out.println(prefix + "    " + (isTail ?  "\\-- " : "|-- ") + ")");
        
    }
}