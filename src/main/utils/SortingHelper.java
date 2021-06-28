package main.utils;

import java.lang.reflect.Method;

/**
 * 排序算法工具类
 */
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
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i - 1].compareTo(arr[i]) > 0 && arr[i].compareTo(arr[i + 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过反射机制调用排序方法测试该排序算法的性能，默认排序方法名称是“sort”
     * @param clazz 排序类
     * @param arr 测试的数组
     * @param <E> 范型
     */
    public static <E extends Comparable<E>> void sortTest(Class<?> clazz, E[] arr) {
        sortTest(clazz, "sort", arr);
    }

    /**
     * 通过反射机制调用排序方法测试该排序算法的性能
     * @param clazz 排序类
     * @param sortName 排序方法名称
     * @param arr 测试的数组
     * @param <E> 范型
     */
    public static <E extends Comparable<E>> void sortTest(Class<?> clazz, String sortName, E[] arr) {
        try {
            String className = clazz.getSimpleName();
            Method method = clazz.getDeclaredMethod(sortName, Comparable[].class);
            Object[] params = new Object[]{ arr };

            long startTime = System.nanoTime();
            method.invoke(null, params);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            if (!isSorted(arr)) {
                throw new RuntimeException(className + " failed");
            }
            System.out.printf("%s success, n = %d : %f s\n", className, arr.length, time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
