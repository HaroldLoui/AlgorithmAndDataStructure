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
    public int size() {
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

    /**
     * 向动态数组最后一个位置添加一个新的元素（暂未进行扩容操作！）
     * @param e 待添加的元素
     */
    public void addLast(int e) {
        add(e, size);
    }

    /**
     * 向动态数组指定位置添加一个新的元素
     * @param e 待添加的元素
     * @param index 指定的位置
     */
    public void add(int e, int index) {
        if (size == data.length) {
            throw new IllegalArgumentException("Add failed. ArrayList is full.");
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        for (int i = size - 1; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 向动态数组第一个位置添加一个新的元素（暂未进行扩容操作！）
     * @param e 待添加的元素
     */
    public void addFirst(int e) {
        add(e, 0);
    }

    /**
     * 获取指定位置的元素
     * @param index 指定的位置
     * @return 指定位置的元素
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        return data[index];
    }

    /**
     * 修改指定位置的元素为新的元素
     * @param e 新的元素
     * @param index 指定的位置
     */
    public void set(int e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 打印当前数组
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
