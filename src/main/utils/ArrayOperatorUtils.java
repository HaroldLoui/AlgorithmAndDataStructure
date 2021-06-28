package main.utils;

import java.util.Random;

/**
 * 数组操作工具类
 */
public class ArrayOperatorUtils {

    private ArrayOperatorUtils() {}

    /**
     * 生成n个有序的数组
     * @param n 数组大小
     * @return 生成的数组
     */
    public static Integer[] generateOrderedArray(int n) {

        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * 生成n个随机数的数组
     * @param n 数组大小
     * @param bound 数组每个数据的最大值（达不到）
     * @return 生成的数组
     */
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] arr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            // 生产[0...bound)之间的随机数
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    /**
     * 交换数组两下标的数据
     * @param arr 数组
     * @param i 第一个下标
     * @param j 第二个下标
     */
    public static <E> void swap(E[] arr, int i, int j) {
        E temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
