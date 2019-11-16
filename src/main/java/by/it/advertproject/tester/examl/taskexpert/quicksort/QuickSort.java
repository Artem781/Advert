//package by.it.advertproject.tester.examl.taskexpert.quicksort;
//
//public class QuickSort {
//    private static int[] array;
//
//    QuickSort(int[] newArray) {
//        array = newArray;
//    }
//
//    protected int[] getArray() {
//        return array;
//    }
//
//    protected void run(int left, int right) {
//
//        if(right - left <= 0) {
//            return;
//        }
//
//        else {
//
//            int pivot = array[right];
//
//            int pivotLocation = new PartitionArray(array).run(left, right, pivot);
//
//            run(left, pivotLocation-1);
//            run(pivotLocation+1, right);
//
//        }
//
//    }
//}
