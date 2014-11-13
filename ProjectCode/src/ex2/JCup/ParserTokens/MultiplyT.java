package ex2.JCup.ParserTokens;
public class MultiplyT extends T {
    T child1;
    F child2;

  public MultiplyT(T left, F right) {
    child1 = left;
    child2 = right;
  }
 
@Override
void print(String prefix, boolean isTail) {
	
    String type = "T";
	System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
    
	child1.print(prefix + (isTail ? "    " : "|   "), false);
	System.out.println(prefix + "    " + (isTail ?  "\\-- " : "|-- ") + "*");
    child2.print(prefix + (isTail ?"    " : "|   "), true);
    
}
}