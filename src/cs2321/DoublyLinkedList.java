package cs2321;
import java.util.Iterator;

import net.datastructures.Position;
import net.datastructures.PositionalList;


public class DoublyLinkedList<E> implements PositionalList<E> {
	
	private Node head, tail;
	private int size;
	
	/*
	 * Node class, implements Position to hold data. 
	 */
	private class Node implements Position<E>{
		Node previous, next;
		E value;
		
		public Node(Node previous, Node next, E value) {
			this.previous = previous;
			this.next = next;
			this.value = value;
		}

	    public Node(E value) {
	        this.value = value;
	    }
		
		@Override
		public E getElement() throws IllegalStateException {
			// TODO Auto-generated method stub
			return value;
		}
	}
	
	/*
	 * Default constructor, initialize default values and link head and tail
	 */
	@TimeComplexity("O(1)")
	public DoublyLinkedList() {
		/* TCJ
		 * Worst case time complexity is O(1) because 5 code statements
		 * are executed once.
		 */
		head = new Node(null);
		tail = new Node(null);
		head.next = tail;
		tail.previous = head;
		
		size = 0;
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
		return size;
	}

	/*
	 * Return whether or not the data set is currently empty.
	 */
	@TimeComplexity("O(1)")
	@Override
	public boolean isEmpty() {
		/* TCJ
		 * Worst case time complexity is O(1) because one code statement
		 * is executed once.
		 */
		return (size == 0);
	}

	/*
	 * Return the first element in the data set.
	 */
	@TimeComplexity("O(1)")
	@Override
	public Position<E> first() {
		/* TCJ
		 * Worst case time complexity is O(1) because three code statements
		 * are executed once.
		 */
		if (size == 0)
			return null;
		return head.next;
	}

	/*
	 * Return the last position in the data set.
	 */
	@TimeComplexity("O(1)")
	@Override
	public Position<E> last() {
		/* TCJ
		 * Worst case time complexity is O(1) because three code statements
		 * are executed once.
		 */
		if (size == 0)
			return null;
		return tail.previous;
	}

	/*
	 * Return the position in the node prior to p.
	 */
	@TimeComplexity("O(n)")
	@Override
	public Position<E> before(Position<E> p) throws IllegalArgumentException {
		/* TCJ
		 * Worst case the while loop will check n elements if the position
		 * it is looking for is in the last position. O(n)
		 */
		Node current = head.next;
		
		while (current != tail) {
			if (current == p)
				return current.previous;
			current = current.next;
		}
		
		throw new IllegalArgumentException();
	}

	@TimeComplexity("O(n)")
	@Override
	public Position<E> after(Position<E> p) throws IllegalArgumentException {
		/* TCJ
		 * Worst case the time complexity will be O(n). This is because worst case
		 * the while loop will traverse through n number of elements (all elements).
		 */
		Node current = head.next;
		
		while (current != tail) {
			if (current == p)
				return current.next;
			current = current.next;
		}
		
		throw new IllegalArgumentException();
	}
	
	/*
	 * Insert data e at the first position. Increase the size of the data set by
	 * one and link new nodes together.
	 */
	@TimeComplexity("O(1)")
	@Override
	public Position<E> addFirst(E e) {
		/* TCJ
		 * Worst case time complexity is O(1) because six code statements
		 * are executed once.
		 */
		Node oldFirst = head.next;
		Node newFirst = new Node(head, oldFirst, e);
		
		oldFirst.previous = newFirst;
		
		head.next = newFirst;
		
		size++;
		
		return newFirst;
	}

	/*
	 * Insert data e at the last position. Increase the size of the data set by
	 * one and link new nodes together.
	 */
	@TimeComplexity("O(1)")
	@Override
	public Position<E> addLast(E e) {
		// TODO Auto-generated method stub
		Node oldLast = tail.previous;
		Node newLast = new Node(tail.previous, tail, e);

		oldLast.next = newLast;
		
		tail.previous = newLast;
		
		size++;
		
		return newLast;
	}

	/*
	 * Insert a new node with data e at the position prior to p. Increase
	 * the size of the data set by 1.
	 */
	@TimeComplexity("O(n)")
	@Override
	public Position<E> addBefore(Position<E> p, E e)
			throws IllegalArgumentException {
		/* TCJ
		 * Worst case time complexity is O(n) because if p is located
		 * at the end of the data set the while loop will traverse
		 * through n number of elements. 
		 */
		Node current = head.next;
		
		while (current != tail) {
			if (current == p) {
				Node newPrevious = new Node(current.previous, current, e);
				
				current.previous = newPrevious;
				
				size++;
				
				return newPrevious;
			}
			current = current.next;
		}
		throw new IllegalArgumentException();
	}

	/*
	 * Insert a new node with data e at the position after to p. Increase
	 * the size of the data set by 1.
	 */
	@TimeComplexity("O(n)")
	@Override
	public Position<E> addAfter(Position<E> p, E e)
			throws IllegalArgumentException {
		/* TCJ
		 * Worst case time complexity is O(n) because if p is located
		 * at the end of the data set the while loop will traverse
		 * through n number of elements. 
		 */
		Node current = head.next;
		
		while (current != tail) {
			if (current == p) {
				Node newNext = new Node(current, current.next, e);
				
				current.next = newNext;
				
				size++;
				
				return newNext;
			}
			current = current.next;
		}
		throw new IllegalArgumentException();
	}

	/*
	 * Overwrite data at position p with e.
	 */
	@TimeComplexity("O(n)")
	@Override
	public E set(Position<E> p, E e) throws IllegalArgumentException {
		/* TCJ
		 * Worst case time complexity is O(n) because if p is located
		 * at the end of the data set the while loop will traverse
		 * through n number of elements. 
		 */
		Node current = head.next;
		
		while (current != tail) {
			if (current == p) {
				current.value = e;
				return current.value;
			}
			current = current.next;
		}
		throw new IllegalArgumentException();
	}

	/*
	 * Remove position in list at p and return the data stored there. 
	 * Decrease size by one. Correct all node links.
	 */
	@TimeComplexity("O(n)")
	@Override
	public E remove(Position<E> p) throws IllegalArgumentException {
		/* TCJ
		 * Worst case time complexity is O(n) because if p is located
		 * at the end of the data set the while loop will traverse
		 * through n number of elements. 
		 */
		Node current = head.next;
		
		while (current != tail) {
			if (current == p) {
				Node temp = current;
				current = current.next;
				return temp.getElement();
			}
			current = current.next;
		}
		
		throw new IllegalArgumentException();
	}

	@Override
	public Iterator<E> iterator() {
		class LocalIterator implements Iterator<E> {
			
			Node current = head.next;
			
			@Override
			public boolean hasNext() {
				if (current != tail)
					return true;
				return false;
			}

			@Override
			public E next() {
				// TODO Auto-generated method stub
				if (!hasNext()) {
					System.out.println("test");
					try {
						throw new Exception("No more valid elements");
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				Node temp = current;
				current = current.next;
				return temp.getElement();
			}
		}
		
		LocalIterator it = new LocalIterator();
		
		return it;
	}

	/*
	 * Create an iterable list of position elements to use with the iterator.
	 * Copy over all data elements into a new list and change the generic type
	 * that is stored.
	 */
	@TimeComplexity("O(n)")
	@Override
	public Iterable<Position<E>> positions() {
		/* TCJ
		 * Worst case time complexity is O(n) because all data elements
		 * are traversed.
		 */
		DoublyLinkedList <Position<E>> list = new DoublyLinkedList<Position<E>>();
		
		Node p = head.next;
		
		while (p != tail) {
			list.addLast(p);
			p = p.next;
		}
		
		return list;
	}
	
	/*
	 * Remove the first element if the first element is not the tail. Return 
	 * the data that was stored there.
	 */
	@TimeComplexity("O(1)")
	public E removeFirst() throws IllegalArgumentException {
		/* TCJ
		 * Worst case time complexity is O(1) because code statements
		 * are only executed once, there are no loops.
		 */
		if (head.next != tail) {
			Node temp = head.next;
			head.next = temp.next;
			return temp.getElement();
		}
		
		try {
			throw new Exception("The list is currently empty");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	/*
	 * Remove the last element in the linked list if it is not the head.
	 * Return the data that was stored there.
	 */
	@TimeComplexity("O(1)")
	public E removeLast() throws IllegalArgumentException {
		/* TCJ
		 * Worst case time complexity is O(1) because the code statements
		 * are only executed once, there are no loops.
		 */
		if (tail.previous != head) {
			Node temp = tail.previous;
			tail.previous = temp.previous;
			return temp.getElement();
		}
		
		try {
			throw new Exception("The list is currently empty");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
