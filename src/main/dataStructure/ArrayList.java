package main.dataStructure;

public class ArrayList {

    /**
     * 底层数组
     */
    private int[] data;

    /**
     * 当前动态数组中的元素个数
     */
    private int size;

    /**
     * 构造函数，初始化一个容量为capacity的动态数组
     * @param capacity 容量
     */
    public ArrayList(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    /**
     * 默认构造函数，初始化一个容量为10的动态数组
     */
    public ArrayList() {
        this(10);
    }

    /**
     * 获取当前动态数组中的元素个数
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取当前动态数组的容量
     * @return data.length
     */
    public int getCapacity() {
        return data.length;
    }

    /**
     * 当前动态数组是否为空
     * @return true：空 false：非空
     */
    public boolean isEmpty() {
        return size == 0;
    }
}
