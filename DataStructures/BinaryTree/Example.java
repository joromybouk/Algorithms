package binaryst;
import java.util.*;

class Example {

    public static void printTree(BinaryTree searchTree) {
        if (searchTree.root == null) {
            System.out.println("No information to print");
            return;
        }
        List<Node> currentLevel = new ArrayList<Node>();
        currentLevel.add(searchTree.root);
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
        BinaryTree searchTree = new BinaryTree();
        String input = "";
        Scanner sc = new Scanner(System.in);
        System.out.print("\n\nEnter quit to exit program\ninsert x will insert an integer x into the binary tree\nfind x will return whether integer x is in the tree\ndelete x will return whether integer x was deleted from the tree\nprint will display the values of each level of the tree\nclear will clear the binary tree\n\n");
        while (!input.equals("quit")){
            input = sc.nextLine();
            if (input.contains("insert")) {
                input = input.toString().replaceAll("[^0-9]", "");
                searchTree.insert(Integer.parseInt(input));
            } else if (input.contains("print")) {
                printTree(searchTree);
            } else if (input.contains("find")) {
                input = input.toString().replaceAll("[^0-9]", "");
                System.out.println(searchTree.find(Integer.parseInt(input)));
            } else if (input.contains("delete")) {
                input = input.toString().replaceAll("[^0-9]", "");
                System.out.println(searchTree.delete(Integer.parseInt(input)));
            } else if(input.contains("clear")) {
                searchTree = new BinaryTree();
            }
            System.out.println("");
        }
    }
}