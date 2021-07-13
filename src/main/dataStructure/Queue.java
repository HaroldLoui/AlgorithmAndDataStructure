package main.dataStructure;

/**
 * 先进先出（First In First Out）-FIFO
 * @param <E> 范型
 */
public interface Queue<E> {

    /**
     * 入队操作
     * @param e 入队元素
     */
    void enqueue(E e);

    /**
     * 出队操作（会删除）
     * @return 队首元素
     */
    E dequeue();

    /**
     * 查看队首元素
     * @return 队首元素
     */
    E getFront();

    /**
     * 队列中元素的个数
     * @return 元素的个数
     */
    int size();

    /**
     * 队列是否为空
     * @return true：空 false：非空
     */
    boolean isEmpty();

    /**
     * 清空队列
     */
    void clear();
}
