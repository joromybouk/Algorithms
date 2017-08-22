package binaryst;


class Example {

    public static void main(String args[]) {
        BinaryTree searchTree = new BinaryTree();
        searchTree.insert(5);
        searchTree.insert(7);
        searchTree.insert(3);
        System.out.println (searchTree.find(3));
        System.out.println (searchTree.delete(3));
        System.out.println (searchTree.find(3));
    }
}