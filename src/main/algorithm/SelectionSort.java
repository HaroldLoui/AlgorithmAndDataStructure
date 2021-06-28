package main.algorithm;

import main.common.Student;
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
        int n = 10000;
        Integer[] arr = ArrayOperatorUtils.generateRandomArray(n, n);
        long startTime = System.nanoTime();
        SelectionSort.sort(arr);
        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;
        System.out.println(time + " s");
    }
}
