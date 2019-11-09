package by.it.advertproject.tester.examl.taskexpert.mergesort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSort {


    // Helper method to print out the integer array.
    private static void printArray(Integer[] array) {
        for (Integer i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    private static void printList (List<Integer> list){
        for (Integer element :
                list) {
            System.out.print("\t" + element);
        }
        System.out.println();
    }

    void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        a.addAll(b);

        System.out.println("Initial Array: ");
        printList(a);

        Integer[] sourceArray = new Integer[a.size()];
        a.toArray(sourceArray);
        sourceArray = mergeSort(sourceArray);

        List<Integer> integers = Arrays.asList(sourceArray);
        a.clear();
        a.addAll(integers);

        System.out.println("Sorted Array: ");
        printList(a);
    }



    // Breaks down the array to single or null elements in array.   source array
    private Integer[] mergeSort(Integer[] sourceArray) {
        if (sourceArray.length <= 1) {
            return sourceArray;
        }
        Integer[] left = new Integer[sourceArray.length / 2];
        Integer[] right = new Integer[sourceArray.length - left.length];
        System.arraycopy(sourceArray, 0, left, 0, left.length);
        System.arraycopy(sourceArray, left.length, right, 0, right.length);
        left = mergeSort(left);
        right = mergeSort(right);
        return merge(left, right);
    }

    // Merges the left and right array in ascending order.
    private Integer[] merge(Integer[] left, Integer[] right) {
        // Merged result array.
        Integer[] result = new Integer[left.length + right.length];
        // Declare and initialize pointers for all arrays.
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        // While there are items in either array...
        while (leftPointer < left.length || rightPointer < right.length) {
            // If there are items in BOTH arrays...
            if (leftPointer < left.length && rightPointer < right.length) {
                // If left item is less than right item...
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            // If there are only items in the left array...
            else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }
            // If there are only items in the right array...
            else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }




//
//    // Breaks down the array to single or null elements in array.   source array
//    private int[] mergeSort(int[] sourceArray) {
//        if (sourceArray.length <= 1) {
//            return sourceArray;
//        }
//        int[] left = new int[sourceArray.length / 2];
//        int[] right = new int[sourceArray.length - left.length];
//        System.arraycopy(sourceArray, 0, left, 0, left.length);
//        System.arraycopy(sourceArray, left.length, right, 0, right.length);
//        left = mergeSort(left);
//        right = mergeSort(right);
//        return merge(left, right);
//    }
//
//    // Merges the left and right array in ascending order.
//    private int[] merge(int[] left, int[] right) {
//        // Merged result array.
//        int[] result = new int[left.length + right.length];
//        // Declare and initialize pointers for all arrays.
//        int leftPointer, rightPointer, resultPointer;
//        leftPointer = rightPointer = resultPointer = 0;
//        // While there are items in either array...
//        while (leftPointer < left.length || rightPointer < right.length) {
//            // If there are items in BOTH arrays...
//            if (leftPointer < left.length && rightPointer < right.length) {
//                // If left item is less than right item...
//                if (left[leftPointer] < right[rightPointer]) {
//                    result[resultPointer++] = left[leftPointer++];
//                } else {
//                    result[resultPointer++] = right[rightPointer++];
//                }
//            }
//            // If there are only items in the left array...
//            else if (leftPointer < left.length) {
//                result[resultPointer++] = left[leftPointer++];
//            }
//            // If there are only items in the right array...
//            else if (rightPointer < right.length) {
//                result[resultPointer++] = right[rightPointer++];
//            }
//        }
//        return result;
//    }

    public static void main(String args[]) {
        ArrayList<Integer> arrayList1 = new ArrayList<>();
        arrayList1.add(1);
        arrayList1.add(3);
        arrayList1.add(5);
        ArrayList<Integer> arrayList2 = new ArrayList<>();
        arrayList2.add(2);
        arrayList2.add(6);
        arrayList2.add(8);
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(arrayList1, arrayList2);

        // Initial array with print out.
//        int[] array = { 5, 4, 3, 2, 1 };
//        int[] array = { 2, 3, 1, 4, 9 };
//        int[] array = { 1, 3, 5, 2, 6, 8 };
//        System.out.println("Initial Array: ");
//        printArray(array);
//
//        // Sorted and merged array with print out.
//        array = mergeSort.mergeSort(array);
//        System.out.println("Sorted Array: ");
//        printArray(array);

    }
}
