package main.algorithm;

import main.utils.ArrayOperatorUtils;

public class SelectionSort {

    private SelectionSort() {}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // arr[0...i) 已排序
        for (int i = 0; i < arr.length - 1; i++) {
            // 查找当前数组的最小值
            int minIndex = i;
            // arr[i...n) 未排序
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) <= 0) {
                    minIndex = j;
                }
            }
            // 若最小值就是arr[i]，则无需进行交换操作
            if (minIndex == i) {
                continue;
            }
            // 交换arr[i]与arr[minIndex]，将最小值放到arr[i]的位置上，保证arr[0...i) 已排序
            ArrayOperatorUtils.swap(arr, i, minIndex);
        }
    }

    public static void main(String[] args) {
        Integer[] arr = {6, 4, 2, 3, 1, 5};
        SelectionSort.sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
