package com.example.kotlinbasics;

import android.graphics.Color;

public class Test1 {
    public static void main(String[] args) {

//        int number = 371, originalNumber, remainder = 0, result = 0;
//        originalNumber = number;
//        while (originalNumber != 0) {
//            remainder = originalNumber % 10;
//        }
//        result += Math.pow(remainder, 3);
//        originalNumber /= 10;
//        if (result == number) System.out.println(number + " is an Armstrong number.");
//        else System.out.println(number + " is not an Armstrong number.");

//        int[] arr = {12, 4, 5, 2, 7};
//        int size = arr.length;
//        quickSort(arr, 0, size - 1);
//        System.out.println("Sorted array: ");
//        printArray(arr, size);

        System.out.println(Color.parseColor("#6CC654"));
    }

//    // A utility function to swap two elements
//    static void swap(int[] arr, int i, int j) {
//        int temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    /* This function takes last element as pivot, places
//    the pivot element at its correct position in sorted
//    array, and places all smaller (smaller than pivot)
//    to left of pivot and all greater elements to right
//    of pivot */
//    static int partition(int[] arr, int low, int high) {
//        // pivot
//        int pivot = arr[high];
//        // Index of smaller element and indicates the right position of pivot found so far
//        int i = (low - 1);
//
//        for (int j = low; j <= high - 1; j++) {
//            // If current element is smaller than the pivot
//            if (arr[j] < pivot) {
//                // Increment index of smaller element
//                i++;
//                swap(arr, i, j);
//            }
//        }
//        swap(arr, i + 1, high);
//        return (i + 1);
//    }
//
//    /* The main function that implements QuickSort
//          arr[] --> Array to be sorted,
//          low --> Starting index,
//          high --> Ending index
//    */
//    static void quickSort(int[] arr, int low, int high) {
//        if (low < high) {
//            // partitionIndex is partitioning index, arr[p] is now at right place
//            int partitionIndex = partition(arr, low, high);
//
//            // Separately sort elements before partition and after partition
//            quickSort(arr, low, partitionIndex - 1);
//            quickSort(arr, partitionIndex + 1, high);
//        }
//    }
//
//    static void printArray(int[] arr, int size) {
//        for (int i = 0; i < size; i++)
//            System.out.print(arr[i] + " ");
//        System.out.println();
//    }
}
