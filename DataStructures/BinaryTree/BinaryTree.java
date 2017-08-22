package binaryst;

class Node {
    int data;
	Node left;
	Node right;	

	public Node(int data){
		this.data = data;
		left = null;
		right = null;
	}

}

public class BinaryTree {
    public static Node root;

	public BinaryTree(){
		this.root = null;
	}

    public void insert(int val) {
        Node newNode = new Node(val);
        if (root == null) {
            root = newNode; 
            return;
        }
    }

    public static void main(String args[]) {
        
    }

}