package ex3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	int rootIndex = -1;
	private Node[] list = new Node[9];
	Queue<Integer> freeIndexList = new LinkedList<Integer>();

	/**
	 * Constructor initializes the freeIndexList to each free index in list.
	 */
	public BinaryTree() {
		// Initiate the free index queue
		for (int i = 0; i < list.length; i++) {
			freeIndexList.add(i);
		}
	}

	public Node[] getList() {
		return list;
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
		System.out.println("Adding element, " + value + ", to the list.");
		// Check if there is any free space
		if (freeIndexList.isEmpty()) {
			throw new Exception("ERROR: no free space in the tree.");
		} else if (checkTreeForValue(value)) {
			throw new Exception("Element '" + value
					+ "' is already in the tree");
		} else {

			// Find free index
			int index = freeIndexList.poll();

			// Create new node with value
			Node node = new Node(value, -1, -1, list, index);

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
		}
	}

	/**
	 * Deletes a node by removing all pointer references to it. It replaces it
	 * with the last node in the tree.
	 * 
	 * @param value
	 *            : Int - the value to remove
	 * @throws Exception
	 *             - Throws exceotion if value dosent exist.
	 */
	public void deleteNode(int value) throws Exception {
		System.out.println("Deleting value, " + value);
		if (checkTreeForValue(value)) {

			ArrayList<Node> orderedNodeList = getOrderedNodes();
			Node lastNode = orderedNodeList.get(orderedNodeList.size() - 1);

			if (list[rootIndex].getData() == value) {
				// item to del is root node

				// set pointers of last node to the root node
				lastNode.setLeft_pointer(list[rootIndex].getLeft_pointer());
				lastNode.setRight_pointer(list[rootIndex].getRight_pointer());

				// remove pointers to the last node
				for (Node n : list) {
					if(n != null){
						if (n.getLeft_pointer() == lastNode.getIndex()) {
							n.setLeft_pointer(-1);
						} else if (n.getRight_pointer() == lastNode.getIndex()) {
							n.setRight_pointer(-1);
						}
					}
				}

				// null the pointers of the first node
				list[rootIndex].setLeft_pointer(-1);
				list[rootIndex].setRight_pointer(-1);

				// set node deleted to inactive
				list[rootIndex].setActive(false);

				// add index to free list
				freeIndexList.add(rootIndex);
				freeIndexList.remove(lastNode.getIndex());
				rootIndex = lastNode.getIndex();

				// check if the last node is the one to delete
			} else if (lastNode.getData() != value) {

				// Serch for node which points to the value
				for (Node n : orderedNodeList) {
					if (n.getLeft_pointer() != -1
							&& list[n.getLeft_pointer()].getData() == value) {
						// points to the value to be removed

						// search for pointer to the last node
						for (Node n2 : orderedNodeList) {

							// null this pointer
							if (n2.getLeft_pointer() == lastNode.getIndex()) {
								n2.setLeft_pointer(-1);
							} else if (n2.getRight_pointer() == lastNode
									.getIndex()) {
								n2.setRight_pointer(-1);
							}
						}

						// Set the pointers of the last node to the pointers of
						// the node thats being deleted
						lastNode.setLeft_pointer(list[n.getLeft_pointer()]
								.getLeft_pointer());
						lastNode.setRight_pointer(list[n.getLeft_pointer()]
								.getRight_pointer());

						/*
						 * Below is the garbage collection. Here the deleted
						 * node is set to inactive (this is unimportant to the
						 * program and is only used when printing the state of
						 * the array).
						 * 
						 * The index of the deleted node is added to the free
						 * index array (but the elemnt is not removed, it can
						 * now be overwritten though).
						 * 
						 * sets the pointer of the node which points to the
						 * deleted node to its replacement (the last node in the
						 * tree)
						 */

						// set node deleted to inactive
						list[n.getLeft_pointer()].setActive(false);

						// add index to free list
						freeIndexList.add(n.getLeft_pointer());

						// sets pointer of the orig node to the last node
						n.setLeft_pointer(lastNode.getIndex());

						// remove the lastNode from teh free list
						// freeIndexList.remove(lastNode.getIndex());

					} else if (n.getRight_pointer() != -1
							&& list[n.getRight_pointer()].getData() == value) {
						// points to the value to be removed

						// search for pointer to the last node
						for (Node n2 : orderedNodeList) {

							// null this pointer
							if (n2.getLeft_pointer() == lastNode.getIndex()) {
								n2.setLeft_pointer(-1);
							} else if (n2.getRight_pointer() == lastNode
									.getIndex()) {
								n2.setRight_pointer(-1);
							}
						}

						// Set the pointers of the last node to the pointers of
						// the node thats being deleted
						lastNode.setLeft_pointer(list[n.getRight_pointer()]
								.getLeft_pointer());
						lastNode.setRight_pointer(list[n.getRight_pointer()]
								.getRight_pointer());
						/*
						 * Below is the garbage collection. Here the deleted
						 * node is set to inactive (this is unimportant to the
						 * program and is only used when printing the state of
						 * the array).
						 * 
						 * The index of the deleted node is added to the free
						 * index array (but the elemnt is not removed, it can
						 * now be overwritten though).
						 * 
						 * sets the pointer of the node which points to the
						 * deleted node to its replacement (the last node in the
						 * tree)
						 */

						// set node deleted to inactive
						list[n.getRight_pointer()].setActive(false);

						// add index to free list
						freeIndexList.add(n.getRight_pointer());

						// sets pointer of the orig node to the last node
						n.setRight_pointer(lastNode.getIndex());

						// remove the lastNode from teh free list
						// freeIndexList.remove(lastNode.getIndex());
					}
				}
			} else {
				// node to del is last node.
				if (orderedNodeList.size() == 1) {

					// node to delete is the only node
					rootIndex = -1;
					freeIndexList.add(lastNode.getIndex());
					lastNode.setActive(false);

				} else {

					for (Node n : orderedNodeList) {
						if (n.getLeft_pointer() == lastNode.getIndex()) {
							n.setLeft_pointer(-1);
						} else if (n.getRight_pointer() == lastNode.getIndex()) {
							n.setRight_pointer(-1);
						}
					}

					// add index to the free list
					freeIndexList.add(lastNode.getIndex());
					lastNode.setActive(false);
				}
			}

		} else {
			// item does not exist
			throw new Exception("Item to delete, " + value
					+ ", does not exist.");
		}

	}

	/**
	 * Print the entire binary tree to the console.
	 */
	public void printTree() {
		if (rootIndex == -1) {
			System.out.println("Tree is empty");
		} else {
			list[rootIndex].print();
		}
	}

	/**
	 * Searches for empty branches recurisvely. Returns a node with an empty
	 * branch.
	 * 
	 * @param node
	 *            : Node - the root node to start the seach
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

	/**
	 * Checks to see if the binary tree has the value in it.
	 * 
	 * @param value
	 *            : Int - the value to check for
	 * @return Boolean - Is it there?
	 */
	public boolean checkTreeForValue(int value) {
		for (int i = 0; i < list.length; i++) {
			Node item = list[i];
			if (item != null && item.getData() == value) {
				return true;
			}
		}

		return false;
	}

	// TODO
	public ArrayList<Node> getOrderedNodes() throws Exception {
		if (rootIndex != -1) {
			ArrayList<Node> queue = new ArrayList<Node>();
			queue.add(list[rootIndex]);
			getOrderedNodes(queue, 0);
			return queue;
		}
		throw new Exception("Root node empty, cannot search tree");
	}

	// TODO
	private void getOrderedNodes(ArrayList<Node> nodeList, int currIndex) {
		// get elem from top of queue
		Node item = nodeList.get(currIndex);

		if (item.getLeft_pointer() != -1) {
			nodeList.add(list[item.getLeft_pointer()]);
		}

		if (item.getRight_pointer() != -1) {
			nodeList.add(list[item.getRight_pointer()]);
		}

		if (currIndex + 1 < nodeList.size()) {
			// repeat
			getOrderedNodes(nodeList, currIndex + 1);
		}

	}
}
