package ex3;

public class Node {

	private int data;
	private int left_pointer;
	private int right_pointer;
	private boolean active = true;

	public Node(int data, int left_pointer, int right_pointer) {
		this.setData(data);
		this.setLeft_pointer(left_pointer);
		this.setRight_pointer(right_pointer);
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
	
	
}

