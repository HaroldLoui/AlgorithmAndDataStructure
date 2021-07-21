package main.dataStructure;

/**
 * 循环队列
 * @param <E> 范型
 */
public class LoopQueue<E> implements Queue<E> {

    /**
     * 底层数组
     */
    private Object[] data;

    private int front, tail;
    private int size;

    /**
     * 构造一个指定容量的循环队列
     * @param capacity 指定容量
     */
    public LoopQueue(int capacity) {
        // 会浪费一个空间
        data = new Object[capacity + 1];
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 构造一个容量为10的循环队列
     */
    public LoopQueue() {
        this(10);
    }

    /**
     * 获取当前循环队列的容量
     * @return 循环队列的容量
     */
    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 入队操作
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        // 判断队列是否已满
        if ((tail + 1) % data.length == front) {
            // 扩容
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        // 入队只需维护tail
        tail = (tail + 1) % data.length;
        size++;
    }

    /**
     * 出队操作（会删除）
     * @return 队首元素
     */
    @SuppressWarnings("unchecked")
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E res = (E) data[front];
        data[front] = null;
        // 出队只需维护front
        front = (front + 1) % data.length;
        size--;
        // 是否需要缩容
        if (size == getCapacity() / 4 && getCapacity() / 2 > 0) {
            resize(getCapacity() / 2);
        }
        return res;
    }

    /**
     * 查看队首元素
     * @return 队首元素
     */
    @SuppressWarnings("unchecked")
    @Override
    public E getFront() {
        if (isEmpty()) {
            return null;
        }
        return (E) data[front];
    }

    /**
     * 队列中元素的个数
     * @return 元素的个数
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * 队列是否为空
     * @return true：空 false：非空
     */
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * 清空队列
     */
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[(i + front) % data.length] = null;
        }
        front = 0;
        tail = 0;
        size = 0;
    }

    /**
     * 打印循环队列，左边是队首，右边是队尾
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // 循环队列的遍历方式2
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            // 不是最后一个位置
            if ((i + 1) % data.length != tail) {
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
        Object[] newData = new Object[newCapacity + 1];
        // 循环队列的遍历方式1
        for (int i = 0; i < size; i++) {
            // data[front]是newData[0]，data[tail]是newData[size - 1]
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        // 维护一下front和tail
        front = 0;
        tail = size;
    }
}
