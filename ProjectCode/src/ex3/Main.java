package ex3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {

	static BinaryTree bt = new BinaryTree();
	static BufferedReader br = new BufferedReader(new InputStreamReader(
			System.in));

	public static void main(String[] args) {

		try {

			/**
			 * Runs three tests and outputs them to the console. Each has a
			 * description of what the test involves.
			 */

			System.out.println("---------- Test 1 ----------");
			System.out.println("This test shows that the garbage ");
			System.out.println("collector works, The element '5' ");
			System.out.println("is not in use after its deletion ");
			System.out.println("(as shown by the F) but it is still ");
			System.out.println("in the array (it is able to be overwritten).");
			System.out.println();
			test1();
			System.out.println();
			bt = new BinaryTree();
			System.out.println("---------- Test 2 ----------");
			System.out.println("This test shows that the elements that");
			System.out.println("have been deleted CAN be overwritten. The");
			System.out.println("Element '5' is deleted from the tree and then");
			System.out
					.println("the element '10' is added. This is placed in the");
			System.out
					.println("position that '5' was at before it was deleted");
			System.out.println("This proves that the garbage collector works.");
			System.out.println();
			test2();
			System.out.println();
			bt = new BinaryTree();
			System.out.println("---------- Test 3 ----------");
			System.out.println("This test removes 6 elements from the tree");
			System.out.println("and then adds 6 elements back.");
			System.out.println();
			test3();

			// create a new tree for users input
			bt = new BinaryTree();
			bt.addElement(1);
			bt.addElement(2);
			bt.addElement(3);
			bt.addElement(4);
			bt.addElement(5);
			bt.addElement(6);
			bt.addElement(7);
			bt.addElement(8);
			bt.addElement(9);
			System.out.println();

			printHelp();
			userInput();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints the help text for the users input.
	 */
	private static void printHelp() {
		System.out.println("---------- User Input ----------");
		System.out.println("List of commands: X is an int value");
		System.out.println();
		System.out.println("add X      - adds an element with int value X");
		System.out.println("del X      - deletes element with value X");
		System.out.println("check X    - is element in the tree? true/false");
		System.out.println("printTree  - prints the tree");
		System.out.println("printArray - prints the array");
		System.out.println("newTree    - creates a new empty tree");
		System.out.println("help       - prints list of commands");
		System.out.println("exit       - Exit the program");
		System.out.println();
	}

	/**
	 * This method accepts and parses the users input. Depending on the
	 * arguments the user supplies the program will perform the appropriate
	 * task.
	 */
	private static void userInput() {

		Scanner sc = new Scanner(System.in);

		for (prompt(); sc.hasNextLine(); prompt()) {

			String line = sc.nextLine().replaceAll("\n", "");

			// return pressed
			if (line.length() == 0)
				continue;

			// split line into arguments
			String[] args = line.split(" ");

			try {

				// process arguments
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("exit")) {
						System.exit(0);
					} else if (args[0].equalsIgnoreCase("help")) {
						printHelp();
					} else if (args[0].equalsIgnoreCase("newTree")) {
						bt = new BinaryTree();
					} else if (args[0].equalsIgnoreCase("printTree")) {
						bt.printTree();
					} else if (args[0].equalsIgnoreCase("printArray")) {
						printArray();
					} else {
						System.out.println("Error: Invalid command");
					}
				} else if (args.length == 2) {
					// do stuff with parameters
					if (args[0].equalsIgnoreCase("add")) {
						bt.addElement(Integer.parseInt(args[1]));
					} else if (args[0].equalsIgnoreCase("del")) {
						bt.deleteNode(Integer.parseInt(args[1]));
					} else if (args[0].equalsIgnoreCase("check")) {
						boolean check = bt.checkTreeForValue(Integer
								.parseInt(args[1]));
						System.out.print("Item " + args[1] + " ");
						if (check) {
							System.out.println("is present");
						} else {
							System.out.println("is NOT present.");
						}
					} else {
						System.out.println("Error: Invalid command");
					}
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}

			userInput();
		}
		sc.close();
	}

	/**
	 * Prints the prompt to the command line.
	 */
	private static void prompt() {
		System.out.print(">> ");
	}

	/**
	 * Test 1. This will add one element to the tree and remove it. The tree is
	 * printed before and after each action.
	 * 
	 * @throws Exception
	 */
	private static void test1() throws Exception {
		// bt.addElement(1);
		// bt.addElement(2);
		// bt.addElement(3);
		// bt.addElement(4);
		bt.addElement(5);
		// bt.addElement(6);
		// bt.addElement(7);
		// bt.addElement(8);
		// bt.addElement(9);
		// System.out.println();

		System.out.println("Initial state of the tree.");
		bt.printTree();
		printArray();
		System.out.println();

		bt.deleteNode(5);
		bt.printTree();
		printArray();
		System.out.println();

		bt.addElement(10);
		System.out.println("Printing tree after new addition");
		bt.printTree();
		printArray();
		System.out.println();
	}

	/**
	 * This test adds 9 elements to the tree and removes elements in the middle
	 * of the tree to check that the deletion garbage colletion works fine.
	 * 
	 * @throws Exception
	 */
	private static void test2() throws Exception {
		bt.addElement(1);
		bt.addElement(2);
		bt.addElement(3);
		bt.addElement(4);
		bt.addElement(5);
		bt.addElement(6);
		bt.addElement(7);
		bt.addElement(8);
		bt.addElement(9);
		System.out.println();

		System.out.println("Initial state of the tree.");
		bt.printTree();
		printArray();
		System.out.println();

		bt.deleteNode(5);
		bt.printTree();
		printArray();
		System.out.println();

		bt.addElement(10);
		System.out.println("Printing tree after new addition");
		bt.printTree();
		printArray();
		System.out.println();
	}

	/**
	 * The final test expands on the second test, it removes 6/10 of the
	 * elements and readds them. This is to check that the garbage collection is
	 * working okay.
	 * 
	 * @throws Exception
	 */
	private static void test3() throws Exception {
		bt.addElement(1);
		bt.addElement(2);
		bt.addElement(3);
		bt.addElement(4);
		bt.addElement(5);
		bt.addElement(6);
		bt.addElement(7);
		bt.addElement(8);
		bt.addElement(9);
		System.out.println();

		System.out.println("Initial state of the tree.");
		bt.printTree();
		printArray();
		System.out.println();

		bt.deleteNode(5);
		bt.deleteNode(1);
		bt.deleteNode(2);
		bt.deleteNode(7);
		bt.deleteNode(4);
		bt.deleteNode(9);
		bt.printTree();
		printArray();
		System.out.println();

		bt.addElement(10);
		bt.addElement(11);
		bt.addElement(12);
		bt.addElement(13);
		bt.addElement(14);
		bt.addElement(15);
		System.out.println("Printing tree after new addition");
		bt.printTree();
		printArray();
		System.out.println();
	}

	/**
	 * Prints the array of node values to the console. Also prints an list of
	 * which elements are active and which are not active.
	 */
	private static void printArray() {
		System.out.print("Array  ");
		String str1 = "[ ";
		String str2 = "[ ";
		for (int i = 0; i < bt.getList().length; i++) {
			if (bt.getList()[i] != null) {
				str1 = str1 + bt.getList()[i].getData() + ", ";

				// gets the max length of the int value
				// only used to correct spacing.
				int valueLength = String.valueOf(bt.getList()[i].getData())
						.length();
				String spacing = "";
				for (int j = 0; j < valueLength - 1; j++) {
					spacing += " ";
				}

				if (bt.getList()[i] != null && bt.getList()[i].getActive()) {
					str2 = str2 + spacing + "T, ";
				} else {
					str2 = str2 + "F, ";
				}

			} else {
				str1 = str1 + "-, ";
				str2 = str2 + "F, ";
			}
		}
		str1 = str1 + "]";
		str2 = str2 + "]";

		System.out.println(str1);
		System.out.print("In use ");
		System.out.println(str2);

	}
}
