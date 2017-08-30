package ds;
import java.util.*;

public class Input {

    private static void BinaryTreeInput(Scanner sc, String input, String message) {
        BinaryTree searchTree = new BinaryTree();
        System.out.print(message);
        while (!input.equals("quit")){
            input = sc.nextLine();
            if (input.contains("insert")) {
                input = input.toString().replaceAll("[^0-9]", "");
                searchTree.insert(Integer.parseInt(input));
            } else if (input.contains("print")) {
                searchTree.print();
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

    private static void LinkedListInput(Scanner sc, String input, String message) {
        LinkedList list = new LinkedList();
        System.out.print(message);
        while (!input.equals("quit")){
            input = sc.nextLine();
            if (input.contains("insert")) {
                input = input.toString().replaceAll("[^0-9]", "");
                list.insert(Integer.parseInt(input));
            } else if (input.contains("print")) {
                list.print();
            } else if (input.contains("find")) {
                input = input.toString().replaceAll("[^0-9]", "");
                System.out.println(list.find(Integer.parseInt(input)));
            } else if (input.contains("delete")) {
                input = input.toString().replaceAll("[^0-9]", "");
                System.out.println(list.delete(Integer.parseInt(input)));
            } else if(input.contains("clear")) {
                list = new LinkedList();
            }
            System.out.println("");
        }
    }

    public static void main(String args[]) {
        String input = "";
        Scanner sc = new Scanner(System.in);
        List options = Arrays.asList("LinkedList", "BinaryTree");;
        System.out.print("\nPlease choose a data structure by entering one of the following:\nBinaryTree\nLinkedList\n\n");

        while(!options.contains(input)) {
            input = sc.nextLine();
        }
        String message = "\n\nEnter quit to exit program\ninsert x will insert an integer x into the data structure\nfind x will return whether integer x is in the data structure\ndelete x will return whether integer x was deleted from the data structure\nprint will display the data structure\nclear will clear the data structure\n\n";
        switch(input) {
            case "BinaryTree":
                BinaryTreeInput(sc, input, message);
                break;
            case "LinkedList":
                LinkedListInput(sc, input, message);
                break;
            default:
                System.out.println("Incorrect data structure");
                break;
        }
    }
}