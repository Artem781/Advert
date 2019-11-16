package by.it.advertproject.tester.examl.taskexpert.insertsort;

public class IS7 {

    private static void printArray(int[] array) {

        for(int i: array) {
            System.out.print(i + " ");
        }

        System.out.println();

    }

    private static void insertionSort(int[] array) {

        int key, value;

        for(int i=1; i < array.length; i++) {

            key = i;
            value = array[i];

            while(key > 0 && value < array[key - 1]) {

                array[key] = array[key - 1];
                key--;

            }

            array[key] = value;

        }

    }

    public static void main(String args[]) {

        int[] array = { 5, 4, 3, 2, 1 };
        printArray(array);

        insertionSort(array);
        printArray(array);

    }
}
