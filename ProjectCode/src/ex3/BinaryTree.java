package ex3;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	// list[0] is always the 'root' node
	private Node[] list = new Node[30];

	public void addElement(int value) {
		Node node = new Node(value, -1, -1);
	}

	private int getNextFreeIndex() {
		// If no nodes present.
		if (list.length == 0) {
			return 0;
		} else {

		}
		return 0;
	}

	/**
	 * Searches for empty branches recurisvely. Returns a node with an empty branch.
	 * @param node : Node - a node with an empty branch
	 */
	private void searchTreeForFreeLeag(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		searchTreeForFreeLeaf(queue);
	}

	/**
	 * This function Eveluates each node in the queue and checks if it has an
	 * empty branch. It returns the first node it finds with an empty branch,
	 * the search is conducted top to bottom, left to right.
	 * 
	 * @param queue : Queue<Node> - the queue to search
	 * @return Node - the node with empty branch
	 */
	private Node searchTreeForFreeLeaf(Queue<Node> queue) {
		Node root = queue.poll();
		int pointer_left = root.getLeft_pointer();
		int pointer_right = root.getRight_pointer();

		if (pointer_left != -1 && pointer_right == -1) {
			// Right free
			return root;
		} else if (pointer_left == -1) {
			// Left free
			return root;
		} else {
			// Neither free

			// Add left & right nodes to queue to be searched
			queue.add(list[pointer_left]);
			queue.add(list[pointer_right]);

			return searchTreeForFreeLeaf(queue);

		}
	}

}
