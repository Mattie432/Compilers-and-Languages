
//----------------------------------------------------
// The following code was generated by CUP v0.11a beta 20060608
// Thu Nov 13 19:13:51 GMT 2014
//----------------------------------------------------

package ex2.JCup;

import java_cup.runtime.*;
import ex2.JCup.ParserTokens.*;

/** CUP v0.11a beta 20060608 generated parser.
  * @version Thu Nov 13 19:13:51 GMT 2014
  */
public class parser extends java_cup.runtime.lr_parser {

  /** Default constructor. */
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\012\000\002\002\005\000\002\002\004\000\002\002" +
    "\005\000\002\002\003\000\002\003\005\000\002\003\005" +
    "\000\002\003\003\000\002\004\005\000\002\004\003\000" +
    "\002\004\003" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\010\010\010\012\011\013\004\001\002\000" +
    "\016\002\ufff8\004\ufff8\005\ufff8\006\ufff8\007\ufff8\011\ufff8" +
    "\001\002\000\016\002\ufffe\004\ufffe\005\ufffe\006\020\007" +
    "\017\011\ufffe\001\002\000\016\002\ufffb\004\ufffb\005\ufffb" +
    "\006\ufffb\007\ufffb\011\ufffb\001\002\000\010\002\024\004" +
    "\014\005\015\001\002\000\010\010\010\012\011\013\004" +
    "\001\002\000\016\002\ufff9\004\ufff9\005\ufff9\006\ufff9\007" +
    "\ufff9\011\ufff9\001\002\000\010\004\014\005\015\011\013" +
    "\001\002\000\016\002\ufffa\004\ufffa\005\ufffa\006\ufffa\007" +
    "\ufffa\011\ufffa\001\002\000\010\010\010\012\011\013\004" +
    "\001\002\000\010\010\010\012\011\013\004\001\002\000" +
    "\016\002\uffff\004\uffff\005\uffff\006\020\007\017\011\uffff" +
    "\001\002\000\010\010\010\012\011\013\004\001\002\000" +
    "\010\010\010\012\011\013\004\001\002\000\016\002\ufffd" +
    "\004\ufffd\005\ufffd\006\ufffd\007\ufffd\011\ufffd\001\002\000" +
    "\016\002\ufffc\004\ufffc\005\ufffc\006\ufffc\007\ufffc\011\ufffc" +
    "\001\002\000\016\002\001\004\001\005\001\006\020\007" +
    "\017\011\001\001\002\000\004\002\000\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\022\000\010\002\006\003\004\004\005\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\002" +
    "\001\001\000\010\002\011\003\004\004\005\001\001\000" +
    "\002\001\001\000\002\001\001\000\002\001\001\000\006" +
    "\003\022\004\005\001\001\000\006\003\015\004\005\001" +
    "\001\000\002\001\001\000\004\004\021\001\001\000\004" +
    "\004\020\001\001\000\002\001\001\000\002\001\001\000" +
    "\002\001\001\000\002\001\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 1;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}





    /* Change the method report_error so it will display the line and
       column of where the error occurred in the input as well as the
       reason for the error which is passed into the method in the
       String 'message'. */
    public void report_error(String message, Object info) {

        /* Create a StringBuilder called 'm' with the string 'Error' in it. */
        StringBuilder m = new StringBuilder("Error");

        /* Check if the information passed to the method is the same
           type as the type java_cup.runtime.Symbol. */
        if (info instanceof java_cup.runtime.Symbol) {
            /* Declare a java_cup.runtime.Symbol object 's' with the
               information in the object info that is being typecasted
               as a java_cup.runtime.Symbol object. */
            java_cup.runtime.Symbol s = ((java_cup.runtime.Symbol) info);

            /* Check if the line INT in the input is greater or
               equal to zero. */
            if (s.left >= 0) {
                /* Add to the end of the StringBuilder error message
                   the line INT of the error in the input. */
                m.append(" in line "+(s.left+1));
                /* Check if the column INT in the input is greater
                   or equal to zero. */
                if (s.right >= 0)
                    /* Add to the end of the StringBuilder error message
                       the column INT of the error in the input. */
                    m.append(", column "+(s.right+1));
            }
        }

        /* Add to the end of the StringBuilder error message created in
           this method the message that was passed into this method. */
        m.append(" : "+message);

        /* Print the contents of the StringBuilder 'm', which contains
           an error message, out on a line. */
        System.err.println(m);
    }

    /* Change the method report_fatal_error so when it reports a fatal
       error it will display the line and column INT of where the
       fatal error occurred in the input as well as the reason for the
       fatal error which is passed into the method in the object
       'message' and then exit.*/
    public void report_fatal_error(String message, Object info) {
        report_error(message, info);
        System.exit(1);
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // F ::= ID 
            {
              F RESULT =null;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Integer s = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new ID(s); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("F",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // F ::= INT 
            {
              F RESULT =null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		Integer i = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new INT(i); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("F",2, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // F ::= LPAREN E RPAREN 
            {
              F RESULT =null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		E e = (E)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new FBRACKET(e); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("F",2, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // T ::= F 
            {
              T RESULT =null;
		int fleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int fright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		F f = (F)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new FT(f); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // T ::= T DIVIDE F 
            {
              T RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		T l = (T)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		F r = (F)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new DivideT(l,r); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // T ::= T TIMES F 
            {
              T RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		T l = (T)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		F r = (F)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new MultiplyT(l,r); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("T",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // E ::= T 
            {
              E RESULT =null;
		int tleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int tright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		T t = (T)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new TE(t); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // E ::= E MINUS T 
            {
              E RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		E l = (E)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		T r = (T)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new MinusE(l,r); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= E EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		E start_val = (E)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // E ::= E PLUS T 
            {
              E RESULT =null;
		int lleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int lright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		E l = (E)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int rleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int rright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		T r = (T)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = new PlusE(l,r); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("E",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

