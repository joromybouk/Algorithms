package ds;

public class LinkedList {
    class Node {
        int data;
        Node next;
        private Node(int data) {
            this.data = data;
            next = null;
        }
    }
    public static Node head;
    public static Node tail;

	public LinkedList(){
		this.head = null;
        this.tail = null;
	}

    public void insert(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public boolean delete(int val) {
        Node current = head;
        Node parent = head;
        while (current != null) {
            if (current.data == val) {
                if (current == head) {
                    if (current == tail) {
                        head = null;
                        tail = null;
                    } else {
                        head = current.next;
                    }
                } else if (current == tail) {
                    parent.next = null;
                    tail = parent;
                } else {
                    parent.next = current.next;
                }
                return true;
            }
            parent = current;
            current = current.next;
        }
        return false;
    }

    public boolean find(int val) {
        Node current = head;
        while (current != null) {
            if (current.data == val) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public static void print() {
        if (head == null) {    
            System.out.println("No information to print");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println("");
    }

    public static void main(String args[]) {
    }
}