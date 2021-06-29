package main.algorithm;

import main.utils.ArrayGenerator;
import main.utils.SortingHelper;

import java.util.Arrays;

public class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort1(E[] arr) {
        // arr[i...n) 未排序
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置，保持arr[0...i) 已排序
            for (int j = i; j > 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
                SortingHelper.swap(arr, j, j - 1);
            }
        }
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // arr[i...n) 未排序
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置，保持arr[0...i) 已排序
            // 优化插入排序的交换操作，改为赋值操作
            E e = arr[i];
            int j;
            for (j = i; j > 0 && e.compareTo(arr[j - 1]) < 0; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    public static void main(String[] args) {
        int[] dataSize = { 10000, 100000 };
        for (int n : dataSize) {

            System.out.println("Random Array:");

            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(InsertionSort.class, arr);
            SortingHelper.sortTest(SelectionSort.class, arr1);

            System.out.println("===================");
            System.out.println("Ordered Array:");

            arr = ArrayGenerator.generateOrderedArray(n);
            arr1 = Arrays.copyOf(arr, arr.length);
            SortingHelper.sortTest(InsertionSort.class, arr);
            SortingHelper.sortTest(SelectionSort.class, arr1);
            System.out.println();
        }
    }
}
