package cs2321;

import java.util.Iterator;

import net.datastructures.List;

@SuppressWarnings("unchecked")
public class ArrayList<E> implements List<E> {

	E[] array;
	int capacity, size;
	
	/*
	 * Initialize the array with the default capacity and current size
	 * of the data set
	 */
	@TimeComplexity("O(1)")
	public ArrayList() {
		/* TCJ
		 * Worst case three code statements are executed once so O(1).
		 */
		array = (E[]) new Object[16];
		capacity = 16;
		size = 0;
	}

	/*
	 * Return the current size of the data set.
	 */
	@TimeComplexity("O(1)")
	@Override
	public int size() {
		/* TCJ
		 * Worst case one code statement is executed once so O(1).
		 */
		return size;
	}

	/*
	 * Returns whether or not the array is empty.
	 */
	@TimeComplexity("O(1)")
	@Override
	public boolean isEmpty() {
		/*
		 * Worst case O(1) only one code statement executed once.
		 */
		return (size == 0);
	}

	/*
	 * Return the element at index i.
	 */
	@TimeComplexity("O(1)")
	@Override
	public E get(int i) throws IndexOutOfBoundsException {
		/* TCJ
		 * Worst case the time complexity is O(1) because all the code
		 * statements are executed only once.
		 */
		if (i <= capacity - 1) {
			return array[i];
		} else
			throw new IndexOutOfBoundsException();
	}

	/*
	 * Set the element at index i to e. Return e.
	 */
	@TimeComplexity("O(1)")
	@Override
	public E set(int i, E e) throws IndexOutOfBoundsException {
		/* TCJ
		 * Worst case the time complexity is O(1) all lines are only
		 * executed one time.
		 */
		if (i > size - 1) {
			throw new IndexOutOfBoundsException();
		} else {
			array[i] = e;
		}
		
		return e;
	}
	
	/*
	 * Shift all elements at index i forward to the right one. Set index i
	 * to e.
	 */
	@TimeComplexity("O(n)")
	@Override
	public void add(int i, E e) throws IndexOutOfBoundsException {
		/* TCJ
		 * Worst case the data needs to be iterated through 3 times total.
		 * The time complexity will be O(n) because constants in Big O notation
		 * are dopped.
		 */
		if (i > size) {
			throw new IndexOutOfBoundsException();
		} else {
			if (size + 1 >= capacity) {
				capacity = capacity * 2;
				
				E[] tempData = (E[]) new Object[capacity];
				
				for (int j = 0; j < size; j++) {
					tempData[j] = array[j];
				}
				
				array = (E[]) new Object[capacity];
					
				for (int j = 0; j < size; j++) {
					array[j] = tempData[j];
				}
			}
			
			for (int j = size - 1; j > i; j--) {
				array[j] = array[j - 1];
			}
			
			array[i] = e;
			
			size++;
		}
	}
	
	/*
	 * Take value at index i, remove it from the array. Shift all data at i + 1 forward back one position.
	 * Return value that was originally at i.
	 */
	@TimeComplexity("O(n)")
	@Override
	public E remove(int i) throws IndexOutOfBoundsException {
		/* TCJ
		 * Worst case if i = 0 all elements n need to be shifted to the left one.
		 */
		
		E value = array[i];
		
		for (int j = i; j < size; j++) {
			array[j] = array [j + 1];
		}
		
		size--;
		
		return value;
	}

	/*
	 * Create a new iterator for the data set. hasNext() checks whether or not
	 * there is another element of data after the current indexed element.
	 * next() returns the next element if there is one.
	 * Return a reference to the iterator.
	 */
	@TimeComplexity("O(1)")
	@Override
	public Iterator<E> iterator() {
		/*
		 * TCJ
		 * Worst case every line is executed once in each method within the class.
		 */
		
		class LocalIterator implements Iterator<E> {
				
			int currentIndex = 0; // Starting element position
			
			@Override
			public boolean hasNext() {
				if (currentIndex < capacity) {
					return true;
				}
				
				return false;
			}

			@Override
			public E next() {
				if (!hasNext()) {
					try {
						throw new Exception("No more elements in the array");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				return array[currentIndex++];
			}
		}
		
		LocalIterator it = new LocalIterator();
		
		return it;
	}

	/*
	 * Put element e into the first position of the array. If it increases
	 * the size of the array to capacity, double the capacity of the array
	 * then add the data in.
	 */
	@TimeComplexity("O(n)")
	public void addFirst(E e) throws IndexOutOfBoundsException {
		/* TCJ
		 * The number of elements n is copied twice throughout two separate for loops
		 * worst case if the size needs to be increased, making the time complexity O(n).
		 */
		if (size + 1 >= capacity) {
			capacity = capacity * 2;
			
			E[] tempData = (E[]) new Object[capacity];
			
			for (int j = 0; j < size; j++) {
				tempData[j] = array[j];
			}
			
			array = (E[]) new Object[capacity];
				
			for (int j = 0; j < size; j++) {
				array[j] = tempData[j];
			}
		}
		
		for (int i = size - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		
		array[0] = e;
		
		size++;
	}
	
	/*
	 * Put element e into the last position of the array. If it increases
	 * the size of the array to capacity, double the capacity of the array
	 * then add the data in.
	 */
	@TimeComplexity("O(n^2)")
	public void addLast(E e) throws IndexOutOfBoundsException {
		/* TCJ
		 * The number of elements n is copied twice throughout two separate for loops
		 * worst case if the size needs to be increased, making the time complexity O(n^2).
		 */
		if (size + 1 >= capacity) {
			capacity = capacity * 2;
			
			E[] tempData = (E[]) new Object[capacity];
			
			for (int j = 0; j < size; j++) {
				tempData[j] = array[j];
			}
			
			array = (E[]) new Object[capacity];
				
			for (int j = 0; j < size; j++) {
				array[j] = tempData[j];
			}
		}
		array[size] = e;
		
		size++;
	}
	
	/*
	 * Remove and return the first element of data in the array.
	 */
	@TimeComplexity("O(n)")
	public E removeFirst() throws IndexOutOfBoundsException {
		/* TCJ
		 * The time complexity will always be O(n) because all of the elements
		 * n in the data set need to be shifted to the right one.
		 */
		E result = array[0];
		
		for (int i = 0; i < size; i++) {
			array[i] = array[i + 1];
		}
		
		size--;
		
		return result;
	}
	
	/*
	 * Remove and return the last element of data in the array.
	 */
	public E removeLast() throws IndexOutOfBoundsException {
		/* TCJ
		 * The time complexity will always be O(n) becuase all of the elements 
		 * n in the data set need to be shifted to the left one.
		 */
		E result = array[size - 1];
		
		for (int i = size - 1; i > 0; i--) {
			array[i] = array[i - 1];
		}
		
		size--;
		
		return result;
	}
}
