package List.Linear;

import java.util.NoSuchElementException;

/**
 * 循环数组队列（FIFO）
 */
public class ArrayQueue<E> {
    private Object[] data;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue() {
        this(8);
    }

    public ArrayQueue(int initialCapacity) {
        if (initialCapacity <= 0) {
            throw new IllegalArgumentException("initialCapacity must be > 0");
        }
        data = new Object[initialCapacity];
    }

    public void offer(E value) {
        ensureCapacity(size + 1);
        data[tail] = value;
        tail = (tail + 1) % data.length;
        size++;
    }

    @SuppressWarnings("unchecked")
    public E poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        E value = (E) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        size--;
        return value;
    }

    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return (E) data[head];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private void ensureCapacity(int requiredSize) {
        if (requiredSize <= data.length) {
            return;
        }
        int newCapacity = data.length * 2;
        while (newCapacity < requiredSize) {
            newCapacity *= 2;
        }

        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(head + i) % data.length];
        }
        data = newData;
        head = 0;
        tail = size;
    }
}
