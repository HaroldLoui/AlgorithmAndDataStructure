package main.dataStructure;

public interface Stack<E> {

    /**
     * 入栈操作
     * @param e 入栈元素
     */
    void push(E e);

    /**
     * 出栈操作（会删除）
     * @return 栈顶元素
     */
    E pop();

    /**
     * 查看栈顶元素（不会删除）
     * @return 栈顶元素
     */
    E peek();

    /**
     * 栈中元素的个数
     * @return 元素的个数
     */
    int size();

    /**
     * 栈是否为空
     * @return true：空 false：非空
     */
    boolean isEmpty();
}
