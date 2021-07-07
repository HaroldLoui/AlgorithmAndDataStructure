package main.dataStructure;

public class ArrayStack<E> implements Stack<E> {

    /**
     * 基础动态数组实现
     */
    private ArrayList<E> array;

    /**
     * 构造一个指定容量的栈
     * @param capacity 指定容量
     */
    public ArrayStack(int capacity) {
        array = new ArrayList<>(capacity);
    }

    /**
     * 构造一个容量为10的栈
     */
    public ArrayStack() {
        array = new ArrayList<>();
    }

    /**
     * 入栈操作
     * @param e 入栈元素
     */
    @Override
    public void push(E e) {
        array.addLast(e);
    }

    /**
     * 出栈操作（会删除）
     * @return 栈顶元素
     */
    @Override
    public E pop() {
        return array.removeLast();
    }

    /**
     * 查看栈顶元素（不会删除）
     * @return 栈顶元素
     */
    @Override
    public E peek() {
        return array.getLast();
    }

    /**
     * 栈中元素的个数
     * @return 元素的个数
     */
    @Override
    public int size() {
        return array.size();
    }

    /**
     * 栈是否为空
     * @return true：空 false：非空
     */
    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取当前动态数组的容量
     * @return 动态数组的容量
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    /**
     * 清空栈
     */
    public void clear() {
        array.clear();
    }

    /**
     * 打印当前栈，右边是栈顶
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
        return sb.toString();
    }
}
