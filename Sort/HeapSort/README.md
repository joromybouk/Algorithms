Time complexity:
O(nlogn)

Compile HeapSort file with the command:
javac HeapSort.java

Run heap sort with command:
java HeapSort <Comma Seperated numbers>
e.g :
java HeapSort 10,1,3,8,30

Algorithm works in these steps:

1. Build a max heap from the input data.

2. At this point, the largest item is stored at the root of the heap. Replace it with the last item of the heap followed by reducing the size of heap by 1. Finally, heapify the root of tree.

3. Repeat above steps while size of heap is greater than 1.
