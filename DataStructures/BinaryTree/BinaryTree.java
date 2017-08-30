package ds;
import java.util.*;



public class BinaryTree {
    class Node {
        int data;
        Node left;
        Node right;	

        private Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    
    public static Node root;

    public BinaryTree(){
        this.root = null;
    }

    public Node getSuccesssorNode(Node deleteNode) {
        Node currentNode = deleteNode.right;
        Node successsorNode = null;
		Node successsorParentNode = null;
        // iterate till the node to replace the deleted node is found
        // this node is the smallest (furthest left) of the right side of the node to be deleted
        while (currentNode != null) {
            successsorParentNode = successsorNode;
			successsorNode = currentNode;
			currentNode = currentNode.left;
        }
        //If node to be sucessor has a node to it's right, the sucessor's parent
        //will replace the successor on it's left with this node
        if (successsorNode != deleteNode.right) {
            successsorParentNode.left = successsorNode.right;
            successsorNode.right = deleteNode.right;
        }
        return successsorNode;
    }

    public boolean delete(int val) {
        Node currentNode = root;
        Node parentNode = root;
        boolean leftOfParent = false;

        //Base case, check if node value exists before attempting to delete it
        while (true) {
            if (currentNode == null) {
                return false;
            } else if (val == currentNode.data) {
                break;
            } else if (val < currentNode.data) {
                parentNode = currentNode;
                currentNode = currentNode.left;
                leftOfParent = true;
            } else {
                parentNode = currentNode;
                currentNode = currentNode.right;
                leftOfParent = false;
            }
        }
        //Case 1: node to delete has no children
        if (currentNode.right == null && currentNode.left == null) {
            if (currentNode == root) {
                root = null;
            } else if (leftOfParent) {
                parentNode.left = null;
            } else {
                parentNode.right = null;
            }
        }
        //Case 2: node to be deleted has one child, child is on left
        else if(currentNode.right == null) {
            if (currentNode == root) {
                root = currentNode.left;
            } else if (leftOfParent) {
                parentNode.left = currentNode.left;
            } else {
                parentNode.right = currentNode.left;
            }
        }
        //Case 2: node to be deleted has one child, child is on right
        else if(currentNode.left == null) {
            if (currentNode == root) {
                root = currentNode.right;
            } else if (leftOfParent) {
                parentNode.left = currentNode.right;
            } else {
                parentNode.right = currentNode.right;
            }
        }
        //Case 3: node to be deleted has both children 
        else if(currentNode.right != null && currentNode.left != null) {
            Node successorNode = getSuccesssorNode(currentNode);
            if (currentNode == root) {
                root = successorNode;
            } else if (leftOfParent) {
                parentNode.left = successorNode;
            } else {
                parentNode.right = successorNode;
            }
            successorNode.left = currentNode.left;
        }
        return true;
    }

    public boolean find(int val) {
        Node currentNode = root;
        //iterate till the value is found or there are no more nodes to search through
        while (currentNode != null) {
            if (val == currentNode.data) {
                return true;
            } else if (val < currentNode.data) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }
        return false;
    }

    public void insert(int val) {
        Node newNode = new Node(val);
        //initalize root node if not yet initalized
        if (root == null) {
            root = newNode; 
            return;
        } 
        Node currentNode = root;
        //iterate through tree to find relevant position of new value
        while (true) {
            if (val < currentNode.data) {
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    return;
                }
                currentNode = currentNode.left;
            } else {
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    return;
                }
                currentNode = currentNode.right;
            }
        }
    }

    public static void print() {
        if (root == null) {
            System.out.println("No information to print");
            return;
        }
        List<Node> currentLevel = new ArrayList<Node>();
        currentLevel.add(root);
        printTreeLevels(currentLevel);
    }

    public static void printTreeLevels(List<Node> currentLevel) {
        if (currentLevel.size() == 0) {
            return;
        }
        List<Node> nextLevel = new ArrayList<Node>();
        Node currentNode;
        while (currentLevel.size() > 0) {
            currentNode = currentLevel.get(0);
            System.out.print(currentNode.data + " ");
            if (currentNode.left != null) {
                nextLevel.add(currentNode.left);
            }
            if (currentNode.right != null) {
                nextLevel.add(currentNode.right);
            }
            currentLevel.remove(0);
        }
        System.out.println("");
        printTreeLevels(nextLevel);
    }

    public static void main(String args[]) {
        
    }

}