package ex2.JCup.ParserTokens;
public class TE extends E {
    T child1;

  public TE(T child) {
    child1 = child;
  }

@Override
public
void print(String prefix, boolean isTail) {
	
    String type = "E";
	System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
    child1.print(prefix + (isTail ?"    " : "|   "), true);
    
}
 
}