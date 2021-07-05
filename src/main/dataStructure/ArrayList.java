package main.dataStructure;

public class ArrayList<E> {

    /**
     * 底层数组
     */
    private Object[] data;

    /**
     * 当前动态数组中的元素个数
     */
    private int size;

    /**
     * 构造函数，初始化一个容量为capacity的动态数组
     * @param capacity 容量
     */
    public ArrayList(int capacity) {
        data = new Object[capacity];
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
    public void addLast(E e) {
        add(e, size);
    }

    /**
     * 向动态数组指定位置添加一个新的元素
     * @param e 待添加的元素
     * @param index 指定的位置
     */
    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        // 扩容
        if (size == data.length) {
            resize(2 * data.length);
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
    public void addFirst(E e) {
        add(e, 0);
    }

    /**
     * 获取指定位置的元素
     * @param index 指定的位置
     * @return 指定位置的元素
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        return (E) data[index];
    }

    /**
     * 修改指定位置的元素为新的元素
     * @param e 新的元素
     * @param index 指定的位置
     */
    public void set(E e, int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Add failed. Index is illegal.");
        }
        data[index] = e;
    }

    /**
     * 查询动态数组中是否包含元素e
     * @param o 元素e
     * @return true：包含 false：不包含
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 查询动态数组中第一个指定元素e的下标
     * @param o 指定元素e
     * @return 第一个指定元素e的下标，不包含元素e则返回-1
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 查询动态数组中最后一个指定元素e的下标
     * @param o 指定元素e
     * @return 最后一个指定元素e的下标，不包含元素e则返回-1
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (data[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(data[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 删除动态数组中指定索引位置的元素，并返回该元素
     * @param index 指定的索引
     * @return 指定索引位置的元素
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }
        E res = (E) data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        data[size] = null;

        // 缩容（除以4是防止复杂度震荡）
        if (size == data.length / 4 && data.length / 2 > 0) {
            resize(data.length / 2);
        }
        return res;
    }

    /**
     * 删除动态数组中第一个位置的元素，并返回该元素
     * @return 指定索引位置的元素
     */
    public E removeFirst() {
        return remove(0);
    }

    /**
     * 删除动态数组中最后一个位置的元素，并返回该元素
     * @return 指定索引位置的元素
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 从动态数组删除指定的元素，并查询是否成功删除了该元素
     * @param o 指定的元素
     * @return true：删除成功 false：删除失败
     */
    public boolean removeElement(Object o) {
        int index = indexOf(o);
        if (index != -1) {
            remove(index);
            return true;
        }
        return false;
    }

    /**
     * 从动态数组删除所有指定的元素
     * @param o 指定的元素
     */
    public void removeAll(Object o) {
        int index;
        while ((index = indexOf(o)) != -1) {
            remove(index);
        }
    }

    /**
     * 打印当前数组
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
//        sb.append(String.format("size = %d, capacity = %d", size, data.length)).append("\n");
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

    /**
     * 改变容量操作
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }
}
