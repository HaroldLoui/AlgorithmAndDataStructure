# 算法与数据结构学习

## 算法

### 一、查找算法：

#### 1、线性查找法 [LinearSearch.java](https://github.com/hanjinfeng0309/AlgorithmAndDataStructure/blob/main/src/main/algorithm/LinearSearch.java)

### 二、排序算法

#### 1、选择排序法 [SelectionSort.java](https://github.com/hanjinfeng0309/AlgorithmAndDataStructure/blob/main/src/main/algorithm/SelectionSort.java)

#### 2、插入排序法 [InsertionSort.java](https://github.com/hanjinfeng0309/AlgorithmAndDataStructure/blob/main/src/main/algorithm/InsertionSort.java)

> 对于插入排序法，当数组是有序的时候，时间复杂度将变成O(n)，而选择排序法一直是O(n^2)

测试用例：

```java
public class Main {

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

```

结果：

```txt
Random Array:
InsertionSort success, n = 10000 : 0.158684 s
SelectionSort success, n = 10000 : 0.116741 s
===================
Ordered Array:
InsertionSort success, n = 10000 : 0.000127 s
SelectionSort success, n = 10000 : 0.116045 s

Random Array:
InsertionSort success, n = 100000 : 9.009850 s
SelectionSort success, n = 100000 : 9.330485 s
===================
Ordered Array:
InsertionSort success, n = 100000 : 0.000577 s
SelectionSort success, n = 100000 : 8.880783 s
```

> 可以很明显的看出来，对于有序的数组，插入排序的效率比选择排序的效率要高得多

## 数据结构

### 一、线性结构：

#### 1、动态数组：[ArrayList.java](https://github.com/hanjinfeng0309/AlgorithmAndDataStructure/blob/main/src/main/dataStructure/ArrayList.java)

