package ex1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) {
		
		try {
			askForInput();
		}catch (IndexOutOfBoundsException e){
			System.out.println();
			System.out.println("Invalid input!!!");
		} catch (Exception e) {
			System.out.println();
			System.out.println(e.getMessage());
		}
	}

	private static void askForInput() throws Exception{

		System.out
				.println("Please enter an expression with a space between each item.");
		System.out.println("e.g. '( 5 + 4 )' or '( 5 )'");
		System.out.print("Enter your Expression: ");

		// open up standard input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String input = null;

		// read the username from the command-line; need to use try/catch with
		// the
		// readLine() method
		try {
			input = br.readLine();
		} catch (IOException ioe) {
			System.out.println("IO error trying to read your name!");
			System.exit(1);
		}
		System.out.println();

		Tokenizer t = new Tokenizer(input);
		t.start();

		Parser p = new Parser(t.getOutputTok());
		boolean succeeded = p.Start();
		if (succeeded) {
			p.printTree();
		}
		
	}
}
