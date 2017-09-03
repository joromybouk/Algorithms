import java.util.Arrays;

class BubbleSort
{

    int bubbleSort(int[] array) {
        boolean swapped = true;
        int count = 0;
        //keep iterating until no more swaps occur
        while(swapped) {
            swapped = false;
            count++;
            for (int i = 0; i < array.length-1; i ++) {
                //if next element is smaller, swap
                if (array[i+1] < array[i]) {
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    swapped = true;
                }
            }
        }
        return count;
    }

    public static void main(String args[]) {
        String exampleInput = ", example input:\njava BubbleSort 10,1,3,8,17,9\n";
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

        BubbleSort bubbleObject = new BubbleSort();
        int numberOfIterations = bubbleObject.bubbleSort(array);
        System.out.println(Arrays.toString(array));
        System.out.println("Number of iterations requried = " + numberOfIterations);
    }
}
