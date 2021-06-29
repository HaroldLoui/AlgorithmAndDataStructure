package main.algorithm;

import main.utils.ArrayGenerator;
import main.utils.SortingHelper;

public class InsertionSort {

    private InsertionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // arr[i...n) 未排序
        for (int i = 0; i < arr.length; i++) {
            // 将arr[i]插入到合适的位置，保持arr[0...i) 已排序
            for (int j = i; j > 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SortingHelper.swap(arr, j, j - 1);
                } else break;
            }
        }
    }

    public static void main(String[] args) {
        int[] dataSize = { 10000, 100000 };
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest(InsertionSort.class, arr);
        }
    }
}
