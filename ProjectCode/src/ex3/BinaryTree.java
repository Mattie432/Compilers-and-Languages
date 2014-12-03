package ex3;

public class BinaryTree {
	//list[0] is always the 'root' node
	private Node[] list = new Node[30];
	
	public void addElement(int value){
		Node node = new Node(value, -1, -1);
	}
	
	private int getNextFreeIndex(){
		//If no nodes present.
		if(list.length == 0){
			return 0;
		}else{
			Node n = list[0];
			
		}
	}
	
	
	private int searchTreeForFreeLeaf(Node root){
		
		
		return 0;
	}
	
}
