
/**
 * Implement Queue ADT using a fixed-length array in circular fashion 
 *
 * @author ruihong-adm
 * @param <E> - formal type 
 *
 */

package cs2321;

import net.datastructures.Queue;

@SuppressWarnings("unchecked")
public class CircularArrayQueue<E> implements Queue<E> {
	
	public E[] array;
	
	public int currentSize, currentStart, lastIndex;
	
	/*
	 * Initialize data for a new queue, starting queue size required.
	 */
	@TimeComplexity("O(1)")
	public CircularArrayQueue(int queueSize) {
		/* TCJ
		 * Worst case time complexity is O(1) because 4 code statements
		 * are executed once.
		 */
		currentSize = 0;
		currentStart = 0;
		lastIndex = 0;
		
		array = (E[]) new Object[queueSize];
	}
	
	/*
	 * Return the current size of the data set.
	 */
	@TimeComplexity("O(1)")
	@Override
	public int size() {
		/* TCJ
		 * Worst case time complexity is O(1) because one code statement
		 * is executed once.
		 */
		return currentSize;
	}

	/* 
	 * Returns whether or not the queue is empty
	 */
	@TimeComplexity("O(1)")
	@Override
	public boolean isEmpty() {
		/* TCJ
		 * Worst case time complexity is O(1) because one code statement
		 * is executed once.
		 */
		return currentSize == 0;
	}

	
	/* Add data e to the end of the queue */
	@TimeComplexity("O(1)")
	@Override
	public void enqueue(E e) throws IllegalStateException {
		/* TCJ
		 * Worst case time complexity is O(1) because 4 code statements
		 * are executed once.
		 */
		if (currentSize < array.length) {
			array[lastIndex++] = e;
			currentSize++;
		} else {
			throw new IllegalStateException();
		}
	}

	/*
	 * Return the element at the start of the queue.
	 */
	@TimeComplexity("O(1)")
	@Override
	public E first() {
		/* TCJ
		 * Worst case time complexity is O(1) because one code statement
		 * is executed once.
		 */
		return array[currentStart];
	}

	/*
	 * Return and remove the element at the front of the queue. If removing the last item
	 * reset the values of the queue to defaults.
	 */
	@TimeComplexity("O(1)")
	@Override
	public E dequeue() {
		/* TCJ
		 * Worst case time complexity is O(1) because 7 code statements
		 * are executed once.
		 */
		E temp = array[currentStart];
		
		if (array[currentStart + 1] == null) {
			currentSize = 0;
			currentStart = 0;
			lastIndex = 0;
		}
		
		array[currentStart++] = null;
		
		return temp;
	}
}
