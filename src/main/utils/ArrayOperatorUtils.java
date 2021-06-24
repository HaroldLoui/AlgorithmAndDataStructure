package main.utils;

/**
 * 数组操作工具类
 */
public class ArrayOperatorUtils {

    private ArrayOperatorUtils() {}

    /**
     * 生成n个有序的数组
     * @param n 数组大小
     * @return 生产的数组
     */
    public static Integer[] generateOrderedArray(int n) {

        Integer[] array = new Integer[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        return array;
    }

    /**
     * 交换数组两下标的数据
     * @param arr 数组
     * @param i 第一个下标
     * @param j 第二个下标
     */
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
