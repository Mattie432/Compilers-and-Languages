package ex2;

/*
  This example comes from a short article series in the Linux 
  Gazette by Richard A. Sevenich and Christopher Lopes, titled
  "Compiler Construction Tools". The article series starts at

  http://www.linuxgazette.com/issue39/sevenich.html

  Small changes and updates to newest JFlex+Cup versions 
  by Gerwin Klein
*/

/*
  Commented By: Christopher Lopes
  File Name: Main.java
  To Create: 
  After the scanner, lcalc.flex, and the parser, ycalc.cup, have been created.
  > javac Main.java
  
  To Run: 
  > java Main test.txt
  where test.txt is an test input file for the calculator.
*/
   
import java.io.*;

import ex2.JCup.parser;
import ex2.JCup.ParserTokens.E;
import ex2.JFlex.*;
   
public class Main {
  static public void main(String argv[]) {    
    /* Start the parser */
    try {
    	String testFile = "src\\ex2\\test.txt";
      Lexer lexedInput = new Lexer(new FileReader(testFile));
      parser p = new parser(lexedInput);
      E result = (E) p.parse().value;
      System.out.println();
      System.out.println();
      result.print("",true);
      
@SuppressWarnings("unused")
int i = 0;   
    } catch (Exception e) {
      /* do cleanup here -- possibly rethrow e */
      e.printStackTrace();
    }
  }
}