package by.it.advertproject.tester.examl.taskexpert.quicksort;

public class PartitionArray {

    private static int[] array;
    private static int arraySize;

    PartitionArray(int newArraySize) {

        arraySize = newArraySize;
        array = new int[arraySize];

    }

    PartitionArray(int[] newArray) {

        arraySize = newArray.length;
        array = newArray;

    }

    protected void printArray() {

        for(int x: array) {
            System.out.print(x + " ");
        }

        System.out.println("\n");
    }

    private static void swapValues(int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    protected void run(int pivot) {

        int leftPointer = -1;
        int rightPointer = arraySize;

        while(true) {

            while(leftPointer < (arraySize-1) && array[++leftPointer] < pivot) {
                ;
            }

            while(rightPointer > 0 && array[--rightPointer] > pivot) {
                ;
            }

            if(leftPointer >= rightPointer) {
                break;
            }
            else {
                swapValues(leftPointer, rightPointer);
            }

            printArray();

        }

    }

}
