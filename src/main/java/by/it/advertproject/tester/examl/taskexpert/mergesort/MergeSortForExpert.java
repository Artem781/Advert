package by.it.advertproject.tester.examl.taskexpert.mergesort;

import java.util.*;


public  class MergeSortForExpert {



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
        Integer[] intrgerArray = new Integer[a.size()];
        a.toArray(intrgerArray);
        intrgerArray = mergeSort(intrgerArray);
        List<Integer> integers = Arrays.asList(intrgerArray);
        a.clear();
        a.addAll(integers);
    }
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
    private Integer[] merge(Integer[] left, Integer[] right) {
        Integer[] result = new Integer[left.length + right.length];
        int leftPointer, rightPointer, resultPointer;
        leftPointer = rightPointer = resultPointer = 0;
        while (leftPointer < left.length || rightPointer < right.length) {
            if (leftPointer < left.length && rightPointer < right.length) {
                if (left[leftPointer] < right[rightPointer]) {
                    result[resultPointer++] = left[leftPointer++];
                } else {
                    result[resultPointer++] = right[rightPointer++];
                }
            }
            else if (leftPointer < left.length) {
                result[resultPointer++] = left[leftPointer++];
            }
            else if (rightPointer < right.length) {
                result[resultPointer++] = right[rightPointer++];
            }
        }
        return result;
    }




    public static void main(String args[]) {

        List<Object> objects = new ArrayList<>();
        HashSet<Object> objects1 = new HashSet<>();
        LinkedHashSet linkedHashSet = new LinkedHashSet();

//        ArrayList<Integer> arrayList1 = new ArrayList<>();
//        arrayList1.add(1);
//        arrayList1.add(3);
//        arrayList1.add(5);
//        ArrayList<Integer> arrayList2 = new ArrayList<>();
//        arrayList2.add(2);
//        arrayList2.add(6);
//        arrayList2.add(8);
//        MergeSortForExpert mergeSortForExpert = new MergeSortForExpert();
//        mergeSortForExpert.merge(arrayList1, arrayList2);

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
