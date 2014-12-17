package ex3;

import java.util.ArrayList;

public class Main {

	static BinaryTree bt = new BinaryTree();

	public static void main(String[] args) {

		try {

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
			System.out.println("the element '10' is added. This is placed in the");
			System.out.println("position that '5' was at before it was deleted");
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

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

	private static void printArray() {
		System.out.print("Array  ");
		String str = "[ ";
		for (int i = 0; i < bt.getList().length; i++) {
			if (bt.getList()[i] != null) {
				str = str + bt.getList()[i].getData() + ", ";
			} else {
				str = str + "-, ";
			}
		}
		str = str + "]";
		System.out.println(str);
		System.out.print("In use ");
		str = "[ ";
		for (int i = 0; i < bt.getList().length; i++) {
			if (bt.getList()[i] != null && bt.getList()[i].getActive()) {
				str = str + "T, ";
			} else {
				str = str + "F, ";
			}
		}
		str = str + "]";
		System.out.println(str);

	}
}
