package main.dataStructure;

public class ArrayQueue<E> implements Queue<E> {

    private ArrayList<E> array;

    public ArrayQueue(int capacity) {
        array = new ArrayList<>(capacity);
    }

    public ArrayQueue() {
        array = new ArrayList<>();
    }

    /**
     * 入队操作
     * @param e 入队元素
     */
    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    /**
     * 出队操作（会删除）
     * @return 队首元素
     */
    @Override
    public E dequeue() {
        return array.removeFirst();
    }

    /**
     * 查看队首元素
     * @return 队首元素
     */
    @Override
    public E getFront() {
        return array.getFirst();
    }

    /**
     * 队列中元素的个数
     * @return 元素的个数
     */
    @Override
    public int size() {
        return array.size();
    }

    /**
     * 队列是否为空
     * @return true：空 false：非空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 清空队列
     */
    @Override
    public void clear() {
        array.clear();
    }

    /**
     * 获取当前队列的容量
     * @return 队列的容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 打印当前队列，左边是队首，右边是队尾
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.size(); i++) {
            sb.append(array.get(i));
            if (i != array.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
