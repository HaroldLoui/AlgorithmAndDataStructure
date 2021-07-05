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
     * 查询动态数组中是否包含元素e
     * @param e 元素e
     * @return true：包含 false：不包含
     */
    public boolean contains(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查询动态数组中第一个指定元素e的下标
     * @param e 指定元素e
     * @return 第一个指定元素e的下标，不包含元素e则返回-1
     */
    public int indexOf(int e) {
        for (int i = 0; i < size; i++) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 查询动态数组中最后一个指定元素e的下标
     * @param e 指定元素e
     * @return 最后一个指定元素e的下标，不包含元素e则返回-1
     */
    public int lastIndexOf(int e) {
        for (int i = size - 1; i >= 0; i--) {
            if (data[i] == e) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除动态数组中指定索引位置的元素，并返回该元素
     * @param index 指定的索引
     * @return 指定索引位置的元素
     */
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        int res = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        return res;
    }

    /**
     * 删除动态数组中第一个位置的元素，并返回该元素
     * @return 指定索引位置的元素
     */
    public int removeFirst() {
        return remove(0);
    }

    /**
     * 删除动态数组中最后一个位置的元素，并返回该元素
     * @return 指定索引位置的元素
     */
    public int removeLast() {
        return remove(size - 1);
    }

    /**
     * 从动态数组删除指定的元素，并查询是否成功删除了该元素
     * @param e 指定的元素
     * @return true：删除成功 false：删除失败
     */
    public boolean removeElement(int e) {
        int index = indexOf(e);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 从动态数组删除所有指定的元素
     * @param e 指定的元素
     */
    public void removeAll(int e) {
        int index;
        while ((index = indexOf(e)) != -1) {
            remove(index);
        }
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
