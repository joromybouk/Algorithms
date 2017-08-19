import java.util.Arrays;

class MergeSort 
{
    
    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
   }
   
    private int[] createSubArray(int[] array, int leftIndex, int rightIndex, int subArrayLength) {
        int[] subArray = new int[subArrayLength];
        for (int i = 0; i < subArray.length; i ++) {
            subArray[i] = array[i + leftIndex];
        }
        return subArray;
    }

    private void appendRemaining(int[] subArray, int subArrayIndex, int array[], int arrayIndex) {
        while(subArrayIndex < subArray.length) {
            array[arrayIndex] = subArray[subArrayIndex];
            subArrayIndex ++;
            arrayIndex ++;
        }
    }

    private void merge(int[] array, int leftIndex, int middleIndex, int rightIndex) {
        //Copy array data into two subarrays, split into left and right
        int[] leftSubArray = createSubArray(array, leftIndex, middleIndex, middleIndex - leftIndex + 1);
        int[] rightSubArray = createSubArray(array, middleIndex + 1, rightIndex, rightIndex - middleIndex);
        //Merge the two sub arrays and update the parent array
        int leftArrayIndex = 0, rightArrayIndex = 0, arrayIndex = leftIndex;
        while ((leftArrayIndex < leftSubArray.length) && (rightArrayIndex < rightSubArray.length)) {
            if (leftSubArray[leftArrayIndex] <= rightSubArray[rightArrayIndex]) {
                array[arrayIndex] = leftSubArray[leftArrayIndex];
                leftArrayIndex ++;
            }
            else {
                array[arrayIndex] = rightSubArray[rightArrayIndex];
                rightArrayIndex ++;
            }
            arrayIndex ++;
        }
        //If there are any remaining elements in the subarrays, append to end of parent array
        appendRemaining(leftSubArray, leftArrayIndex, array, arrayIndex);
        appendRemaining(rightSubArray, rightArrayIndex, array, arrayIndex);
    }


    private void mergeSort(int[] array, int leftIndex, int rightIndex) {
        //check to ensure the array can be split
        if (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            mergeSort(array, leftIndex, middleIndex);
            mergeSort(array, middleIndex + 1, rightIndex);
            //merge the two sorted arrays
            merge(array, leftIndex, middleIndex, rightIndex);
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
        MergeSort mergeObject = new MergeSort();
        mergeObject.mergeSort(array, 0, array.length - 1);
        printArray(array);
    }
}