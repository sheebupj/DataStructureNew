package com.paremal.sheebu.algorithms;


public class MergeSort {
    public static void main(String[] args) {
        int[] arr= {1,8,4,9,4,6,7,5,2,3,0};
        int[] sorted=mergeSort(arr);
        for (int n:sorted){
            System.out.print(n+", ");
        }

    }

    public static int[] mergeSort(int[] arr) {
        if (arr.length < 2) return arr;

        int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
        return arr;
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) arr[k++] = left[i++];
            else arr[k++] = right[j++];
        }

        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }
}