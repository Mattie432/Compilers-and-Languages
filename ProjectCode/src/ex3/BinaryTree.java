package ex3;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	int rootIndex = -1;
	private Node[] list = new Node[30];
	Queue<Integer> freeIndexList = new LinkedList<Integer>();

	public BinaryTree() {
		// Initiate the free index queue
		for (int i = 0; i < list.length; i++) {
			freeIndexList.add(i);
		}
	}

	/**
	 * Adds an new node with a value into the tree. This is stored in a free
	 * space in the list array and is appended to a free branch in the tree.
	 * 
	 * @param value
	 *            : Int - the value to store
	 * @throws Exception
	 */
	public void addElement(int value) throws Exception {
		
		//Check if there is any free space
		if (!freeIndexList.isEmpty()) {
			
			// Create new node with value
			Node node = new Node(value, -1, -1);

			// Find free index
			int index = freeIndexList.poll();

			// assign node to free index in array
			list[index] = node;

			// Check if this is a root node
			if (rootIndex == -1) {
				// Is a root node
				rootIndex = index;
			} else {
				// Is not a root node

				// Search for node with free branch
				Node nodeWithEmptyBranch = searchTreeForFreeBranch(list[rootIndex]);

				// Add this node to the tree
				nodeWithEmptyBranch.addPointer(index);

			}
		} else {
			//No free space
			throw new Exception("No free space to store the value");
		}
	}

	public void deleteNode() {
		// need to look for pointers pointing to the index of the item to be
		// deleted
		// if last node set rootIndex = -1
	}

	/**
	 * Searches for empty branches recurisvely. Returns a node with an empty
	 * branch.
	 * 
	 * @param node
	 *            : Node - a node with an empty branch
	 * @return Node - the node with empty branch
	 */
	private Node searchTreeForFreeBranch(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(node);
		return searchTreeForFreeBranch(queue);
	}

	/**
	 * This function Eveluates each node in the queue and checks if it has an
	 * empty branch. It returns the first node it finds with an empty branch,
	 * the search is conducted top to bottom, left to right.
	 * 
	 * @param queue
	 *            : Queue<Node> - the queue to search
	 * @return Node - the node with empty branch
	 */
	private Node searchTreeForFreeBranch(Queue<Node> queue) {
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

			return searchTreeForFreeBranch(queue);

		}
	}

}
