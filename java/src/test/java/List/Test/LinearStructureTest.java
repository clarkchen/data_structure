package List.Test;

import List.Linear.ArrayQueue;
import List.Linear.ArrayStack;
import org.junit.Test;

import static org.junit.Assert.*;

public class LinearStructureTest {

    @Test
    public void testArrayStackLifo() {
        ArrayStack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testArrayQueueFifoAndResize() {
        ArrayQueue<Integer> queue = new ArrayQueue<>(2);
        assertTrue(queue.isEmpty());

        queue.offer(1);
        queue.offer(2);
        queue.offer(3); // 触发扩容

        assertEquals(3, queue.size());
        assertEquals(Integer.valueOf(1), queue.peek());
        assertEquals(Integer.valueOf(1), queue.poll());
        assertEquals(Integer.valueOf(2), queue.poll());

        queue.offer(4);
        queue.offer(5);

        assertEquals(Integer.valueOf(3), queue.poll());
        assertEquals(Integer.valueOf(4), queue.poll());
        assertEquals(Integer.valueOf(5), queue.poll());
        assertTrue(queue.isEmpty());
    }
}
