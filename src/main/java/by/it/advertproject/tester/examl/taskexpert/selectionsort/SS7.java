package by.it.advertproject.tester.examl.taskexpert.selectionsort;

public class SS7 {

    private static void printArray(int[] array) {

        for(int i: array) {
            System.out.print(i + " ");
        }

        System.out.println();

    }

    private static void swap(int[] array, int left, int right) {

        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;

    }

    private static void selectionSort(int[] array) {

        int min;

        for(int i=0; i < array.length - 1; i++) {

            min = i;

            for(int j=i + 1; j < array.length; j++) {

                if(array[j] < array[min]) {

                    min = j;

                }

            }

            if(min != i) {

                swap(array, i, min);

            }

        }

    }

    public static void main(String args[]) {

        int [] array = {5, 4, 3, 2, 1};
        printArray(array);

        selectionSort(array);
        printArray(array);

    }
}
