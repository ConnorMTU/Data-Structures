package cs2321;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CircularArrayQueueTest {

	CircularArrayQueue<String> queue;
	
	@Before
	public void setUp() throws Exception {
		queue = new CircularArrayQueue(16);
		queue.enqueue("A");
		queue.enqueue("B");
		queue.enqueue("C");
		queue.enqueue("D");
	}

	@Test
	public void testCircularArrayQueue() {
		CircularArrayQueue newQueue = new CircularArrayQueue(16);
		
		assertEquals(0, newQueue.currentSize);
		assertEquals(0, newQueue.currentStart);
		assertEquals(0, newQueue.lastIndex);
		assertEquals(16, newQueue.array.length);
	}

	@Test
	public void testSize() {
		assertEquals(4, queue.size());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(queue.isEmpty());
	}

	@Test
	public void testEnqueue() {
		queue.enqueue("E");
		queue.enqueue("F");
		assertEquals(6, queue.size());
		for (int i = 0; i < 4; i++)
			queue.dequeue();
		assertEquals("E", queue.first());
		queue.dequeue();
		assertEquals("F", queue.first());
	}

	@Test
	public void testFirst() {
		assertEquals("A", queue.first());
	}

	@Test
	public void testDequeue() {
		assertEquals("A", queue.dequeue());
		assertEquals("B", queue.dequeue());
	}

}
