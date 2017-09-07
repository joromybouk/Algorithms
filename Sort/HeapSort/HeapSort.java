import java.util.Arrays;

class HeapSort {


    private void heap(int array[], int n, int i)
    {
        //Since a Binary Heap is a Complete Binary Tree, it can be represented as an array
        //Therefore for an element with index i in the heap:
        //Left of index i is 2*i + 1 and right of index i is 2*i + 2
        int currentMax = i;
        int leftIndex = 2*i + 1;  // left = 2*i + 1
        int rightIndex = 2*i + 2;  // right = 2*i + 2
 
        //If current max is less than left, swap.
        if ((leftIndex < n) && (array[leftIndex] > array[currentMax])) {
            currentMax = leftIndex;
        }
        // If current max is less than right, swap
        if ((rightIndex < n) && (array[rightIndex] > array[currentMax])) {
            currentMax = rightIndex;
        }
        // If current max is not the root element then swap
        if (currentMax != i) {
            int temp = array[i];
            array[i] = array[currentMax];
            array[currentMax] = temp;

            // Keep creating max heap until the root is the current max
            heap(array, n, currentMax);
        }
    }
    private void heapSort(int[] array, int n) {
        //Create max heap, starting from center element of array and decrement
        //This way the top element of the heap at the end of the loop will be the max
        //We do not need to iterate through the right half of the array as they are the leaves of the tree
        for (int i = n/2 - 1; i >= 0; i--) {
            heap(array, n, i);
        }
        // Iterate through each element and remove from heap
        for (int i = n-1; i >= 0; i--) {
            // Move current root ie, first in array and so the max value in the heap, to end of array
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;
            // get max heap of new array
            heap(array, i, 0);
        }
    }
 
    public static void main(String args[]) {
        String exampleInput = ", example input:\njava HeapSort 10,1,3,8,17,9\n";
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
        heapObject.heapSort(array, array.length);
        System.out.println(Arrays.toString(array));
    }

}