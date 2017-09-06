import java.util.Arrays;

class HeapSort {
    class Node {
        int value;
        Node left;
        Node right;
        private Node(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }
   

    public static void main(String args[]) {
        String exampleInput = ", example input:\njava MergeSort 10,1,3,8,17,9\n";
        if (args.length == 0) {
            System.out.println("\nNo input detected".concat(exampleInput));
            System.exit(49);
        } else if (args.length > 1) {
            System.out.println("\nToo many inputs found".concat(exampleInput));
            System.exit(50);
        }
        String[] inputNumbers = args[0].split(",");
        int[] array = new int[inputNumbers.length];
        for (int i = 0; i < inputNumbers.length; i ++) {
            array[i] = Integer.parseInt(inputNumbers[i]);
        }
        HeapSort heapObject = new HeapSort();
        // mergeObject.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}