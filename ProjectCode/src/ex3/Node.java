package ex3;

public class Node {

	private int data;
	private int left_pointer = -1;
	private int right_pointer = -1;
	private boolean active = true;
	private Node[] nodeList;
	private int index;

	public Node(int data, int left_pointer, int right_pointer, Node[] nodeList, int index) {
		this.setData(data);
		this.right_pointer = right_pointer;
		this.left_pointer = left_pointer;
		this.nodeList = nodeList;
		this.setIndex(index);
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public int getLeft_pointer() {
		return left_pointer;
	}

	public void setLeft_pointer(int left_pointer) {
		this.left_pointer = left_pointer;
	}

	public int getRight_pointer() {
		return right_pointer;
	}

	public void setRight_pointer(int right_pointer) {
		this.right_pointer = right_pointer;
	}

	public boolean getActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public void addPointer(int pointer) throws Exception{
		if(left_pointer == -1){
			left_pointer = pointer;
		}else if(right_pointer == -1){
			right_pointer = pointer;
		}else{
			throw new Exception("Error, both pointers of node are full.");
		}
	}
	
	/**
	 * Recursively print from this node.
	 */
	public void print(){
		print("",true);
	}
	
	/**
	 * Recursively prints this node and its children to the console.
	 * @param prefix : String - the prefix of the line
	 * @param isTail : Boolean - is this a tail?
	 */
	private void print(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + data);

        //print left child
        if (left_pointer != -1 && right_pointer != -1) {
            nodeList[left_pointer].print(prefix + (isTail ?"    " : "│   "), false);
        }else if(left_pointer != -1){
            nodeList[left_pointer].print(prefix + (isTail ?"    " : "│   "), true);
        }
        //print right child
        if (right_pointer != -1) {
            nodeList[right_pointer].print(prefix + (isTail ?"    " : "│   "), true);
        }
    }

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}

