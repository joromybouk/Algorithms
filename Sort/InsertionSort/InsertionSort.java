import java.util.Arrays;

class InsertionSort
{

    void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i ++) {
            int current = array[i];
            int j = i-1;
            /*
                Keeps moving element left until it is bigger than the element
                to the left or until the element is at index 0
            */
            while (j >= 0 && current <= array[j]) {
                array[j+1] = array[j];
                j --;
            }
            array[j+1] = current;
        }
    }

    public static void main(String args[]) {
        String exampleInput = ", example input:\njava InsertionSort 10,1,3,8,17,9\n";
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

        InsertionSort insertionObject = new InsertionSort();
        insertionObject.insertionSort(array);
        System.out.println(Arrays.toString(array));
    }
}
