package ex3;

public class Node {

	private int data;
	private int left_pointer = -1;
	private int right_pointer = -1;
	private boolean active = true;
	private Node[] nodeList;
	private int index;

	/**
	 * Constructor for the node. Should already know the values of the data.
	 * 
	 * @param data
	 *            : Int - the data of the node
	 * @param left_pointer
	 *            : int - pointer to the left branch's node. (-1 if no branch)
	 * @param right_pointer
	 *            : int - pointer to the right branch's node. (-1 if no branch)
	 * @param nodeList
	 *            : Node[] - the binary tree's nodeList
	 * @param index
	 *            : Int - this nodes index in the binaryTree's nodeList
	 */
	public Node(int data, int left_pointer, int right_pointer, Node[] nodeList,
			int index) {
		this.setData(data);
		this.right_pointer = right_pointer;
		this.left_pointer = left_pointer;
		this.nodeList = nodeList;
		this.setIndex(index);
	}

	/**
	 * Getter for the node data
	 * 
	 * @return int - the data
	 */
	public int getData() {
		return data;
	}

	/**
	 * Sets the data of this node.
	 * 
	 * @param data
	 *            : int - data to set to
	 */
	public void setData(int data) {
		this.data = data;
	}

	/**
	 * getter for the left pointer. (-1 if node is a leaf)
	 * 
	 * @return int - gets the left pointer
	 */
	public int getLeft_pointer() {
		return left_pointer;
	}

	/**
	 * Setter for the left pointer
	 * 
	 * @param left_pointer
	 *            : int - left pointer value
	 */
	public void setLeft_pointer(int left_pointer) {
		this.left_pointer = left_pointer;
	}

	/**
	 * Getter for the right pointer (-1 if leaf node)
	 * 
	 * @return int - value of right pointer
	 */
	public int getRight_pointer() {
		return right_pointer;
	}

	/**
	 * Sets the right pointer value
	 * 
	 * @param right_pointer
	 *            : int - value of right pointer
	 */
	public void setRight_pointer(int right_pointer) {
		this.right_pointer = right_pointer;
	}

	/**
	 * Getter for the active state of the node
	 * 
	 * @return boolean - is node active
	 */
	public boolean getActive() {
		return active;
	}

	/**
	 * Setter for the active state of the node.
	 * 
	 * @param active
	 *            : Boolean - node active state
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Adds the index of a child to this node. This method will choose the first
	 * free pointer from right to left.
	 * 
	 * @param pointer : Int - the index to point to
	 * @throws Exception - thrown if both pointers full
	 */
	public void addPointer(int pointer) throws Exception {
		if (left_pointer == -1) {
			left_pointer = pointer;
		} else if (right_pointer == -1) {
			right_pointer = pointer;
		} else {
			throw new Exception("Error, both pointers of node are full.");
		}
	}

	/**
	 * Recursively print from this node.
	 */
	public void print() {
		print("", true);
	}

	/**
	 * Recursively prints this node and its children to the console.
	 * 
	 * @param prefix
	 *            : String - the prefix of the line
	 * @param isTail
	 *            : Boolean - is this a tail?
	 */
	private void print(String prefix, boolean isTail) {
		System.out.println(prefix + (isTail ? "└── " : "├── ") + data);

		// print left child
		if (left_pointer != -1 && right_pointer != -1) {
			nodeList[left_pointer].print(prefix + (isTail ? "    " : "│   "),
					false);
		} else if (left_pointer != -1) {
			nodeList[left_pointer].print(prefix + (isTail ? "    " : "│   "),
					true);
		}
		// print right child
		if (right_pointer != -1) {
			nodeList[right_pointer].print(prefix + (isTail ? "    " : "│   "),
					true);
		}
	}

	/**
	 * Getter for the index of the node
	 * @return index : int - the index of this node in the nodeList
	 */
	public int getIndex() {
		return index;
	}

	/**
	 * Sets the index of this node.
	 * @param index : int - the index of node
	 */
	public void setIndex(int index) {
		this.index = index;
	}
}
