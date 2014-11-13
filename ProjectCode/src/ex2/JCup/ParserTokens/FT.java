package ex2.JCup.ParserTokens;

public class FT extends T {
    F child1;

  public FT(F child) {
    child1 = child;
  }

@Override
void print(String prefix, boolean isTail) {
    String type = "T";
	System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
	//child1.print(prefix + (isTail ? "    " : "|   "), false);
    child1.print(prefix + (isTail ?"    " : "|   "), true);
    
}
}