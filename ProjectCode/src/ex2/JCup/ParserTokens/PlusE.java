package ex2.JCup.ParserTokens;

public class PlusE extends E {
    E child1;
    T child2;

  public PlusE(E left, T right) {
    child1 = left;
    child2 = right;
  }

@Override
public
void print(String prefix, boolean isTail) {
	
    String type = "E";
	System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
    
	child1.print(prefix + (isTail ? "    " : "|   "), false);
	System.out.println(prefix + "    " + (isTail ?  "|-- " : "|-- ") + "+");
    child2.print(prefix + (isTail ?"    " : "|   "), true);
    
}

}