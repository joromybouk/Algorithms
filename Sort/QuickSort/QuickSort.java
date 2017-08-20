import java.util.Arrays;

class QuickSort {

    private void quickSort(int[] array, int leftIndex, int rightIndex) {
        int pivotIndex = leftIndex + ((rightIndex - leftIndex) / 2);
        int pivotValue = array[pivotIndex];
        int i = leftIndex, j = rightIndex;
        // Numbers on the left side of the pivot that are greater than the 
        // pivot value will move to the right of the pivot. 
        // Numbers on the right side of the pivot that are less than the 
        // pivot value will move to the left of the pivot.
        while (i <= j) {
            while (array[i] < pivotValue) {
                i ++;
            }
            while (array[j] > pivotValue) {
                j --;
            }
            if (i <= j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i ++;
                j --;
            }
        }
        //Recursively quicksort until the a partition cannot be made
        if (leftIndex < j) {
            quickSort(array, leftIndex, j);
        }
        if (rightIndex >= i) {
            quickSort(array, i, rightIndex);
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
        QuickSort mergeObject = new QuickSort();
        mergeObject.quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

}