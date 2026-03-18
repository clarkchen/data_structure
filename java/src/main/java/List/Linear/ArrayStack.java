package List.Linear;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

/**
 * 基于动态数组的栈实现（LIFO）
 */
public class ArrayStack<E> {
    private final List<E> data = new ArrayList<>();

    public void push(E value) {
        data.add(value);
    }

    public E pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data.remove(data.size() - 1);
    }

    public E peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return data.get(data.size() - 1);
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    public int size() {
        return data.size();
    }
}
