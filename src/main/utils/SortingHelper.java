package main.utils;

public class SortingHelper {

    private SortingHelper() {}

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

    /**
     * 检查数组是否排好序
     * @param arr 数组
     * @param <E> 范型
     * @return true：排序成功 false：排序失败
     */
    public static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }
        return true;
    }
}
