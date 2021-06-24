package main.algorithm;

public class SectionSort {

    private SectionSort() {}

    public static void sort(int[] arr) {
        // arr[0...i) 已排序
        for (int i = 0; i < arr.length - 1; i++) {
            // 查找当前数组的最小值
            int minIndex = i;
            // arr[i...n) 未排序
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 若最小值就是arr[i]，则无需进行交换操作
            if (minIndex == i) {
                continue;
            }
            // 交换arr[i]与arr[minIndex]，将最小值放到arr[i]的位置上，保证arr[0...i) 已排序
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {6, 4, 2, 3, 1, 5};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
