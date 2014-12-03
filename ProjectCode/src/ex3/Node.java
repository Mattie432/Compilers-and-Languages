package ex3;

public class Node {

	private int data;
	private int left_pointer = -1;
	private int right_pointer = -1;
	private boolean active = true;

	public Node(int data) {
		this.setData(data);
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
}

