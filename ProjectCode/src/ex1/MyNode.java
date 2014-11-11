package ex1;

import java.util.ArrayList;

public class MyNode {
	String type;
	ArrayList<MyNode> children = new ArrayList<MyNode>();
	int level = -1;
	
	/**
	 * Getter for the children of the node
	 * @return children : ArrayList<MyNode> - the nodes children
	 */
	public ArrayList<MyNode> getChildren() {
		return children;
	}
	
	/**
	 * Constructor for class.
	 * @param level : Int - the level of the node
	 * @param type : String - node type (e.g. (,+,a,e,T'
	 */
	public MyNode(int level, String type){
		this.level = level;
		this.type = type;
	}
	
	/**
	 * Print the tree from this node.
	 */
	public void print(){
		print("",true);
	}
	
	/**
	 * Print method to recursively print from this node
	 * @param prefix : String - prefix the string to print
	 * @param isTail : boolean - is it the tail?
	 */
    private void print(String prefix, boolean isTail) {
    	
        System.out.println(prefix + (isTail ?  "\\-- " : "|-- ") + type);
        for (int i = 0; i < children.size() - 1; i++) {
            children.get(i).print(prefix + (isTail ? "    " : "|   "), false);
        }
        if (children.size() > 0) {
            children.get(children.size() - 1).print(prefix + (isTail ?"    " : "|   "), true);
        }
    }

	
}
