package ex1;

public class Main {

	public static void main(String[] args) throws Exception {
		String str = "( 4 + 4 )";
		Tokenizer t = new Tokenizer(str);
		t.start();
		
		Parser p = new Parser(t.getOutputTok());
		p.Start();
				
	}

}
