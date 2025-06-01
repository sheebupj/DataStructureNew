package com.paremal.sheebu.algorithms;

import java.util.Arrays;

public class SelectionSort {

    int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int index = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] a = {5, 4, 3, 2, 1, 0, -1, -2, 8};
        SelectionSort selsort = new SelectionSort();
        int[] insertSorted = selsort.insertionSort(a, a.length);
        Arrays.stream(insertSorted).forEach(System.out::println);
        int[] selectiontSorted = selsort.selectionSort(a);
        Arrays.stream(selectiontSorted).forEach(System.out::println);

    }

    int[] selsrt(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int selection = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[selection] > arr[j]) {
                    selection = j;
                }
            }
            int temp = arr[selection];
            arr[selection] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }

    int[] insertionSort(int[] arr, int n) {
        int i, key, j;
        for (i = 1; i < n; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
        return arr;
    }
}



