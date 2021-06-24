package main.algorithm;

import main.utils.ArrayOperatorUtils;

public class LinearSearch {

    private LinearSearch() {}

    /**
     * 在数组data中查找target，并返回对应下标，未找到返回-1
     * @param data 数组
     * @param target 目标
     * @param <E> 范型
     * @return 返回对应下标，未找到返回-1
     */
    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int[] dataSize = {1000000, 10000000};
        for (int n : dataSize) {
            Integer[] data = ArrayOperatorUtils.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int i = 0; i < 100; i++) {
                LinearSearch.search(data, n);
            }
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + " s");
        }
    }
}
