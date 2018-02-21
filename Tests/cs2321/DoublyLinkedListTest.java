package cs2321;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import net.datastructures.Position;

public class DoublyLinkedListTest {

	DoublyLinkedList<String> list;
	Position<String> thirdPos;
	
	@Before
	public void setUp() throws Exception {
		list = new DoublyLinkedList<String>();
		list.addLast("A");
		list.addLast("B");
		thirdPos = list.addLast("C");
		list.addLast("D");
	}

	@Test
	public void testDoublyLinkedList() {
		DoublyLinkedList<String> test =  new DoublyLinkedList<String>();
		assertEquals(0, test.size());
	}

	@Test
	public void testSize() {
		assertEquals(4, list.size());
	}

	@Test
	public void testIsEmpty() {
		assertFalse(list.isEmpty());
	}

	@Test
	public void testFirst() {
		assertEquals("A", list.first().getElement());
	}

	@Test
	public void testLast() {
		assertEquals("D", list.last().getElement());
	}

	@Test
	public void testBefore() {
		assertEquals("B", list.before(thirdPos).getElement());
	}

	@Test
	public void testAfter() {
		assertEquals("D", list.after(thirdPos).getElement());
	}

	@Test
	public void testAddFirst() {
		list.addFirst("Z");
		assertEquals("Z", list.first().getElement());
	}

	@Test
	public void testAddLast() {
		list.addLast("Z");
		assertEquals("Z", list.last().getElement());
	}

	@Test
	public void testAddBefore() {
		list.addBefore(thirdPos, "Z");
		assertEquals("Z", list.before(thirdPos).getElement());
	}

	@Test
	public void testAddAfter() {
		list.addAfter(thirdPos, "Z");
		assertEquals("Z", list.after(thirdPos).getElement());
	}

	@Test
	public void testSet() {
		assertEquals("Z", list.set(thirdPos, "Z"));
	}

	@Test
	public void testRemove() {
		assertEquals("C", list.remove(thirdPos));
	}

	@Test
	public void testIterator() {
		while (list.iterator().hasNext()) {
			assertEquals(list.iterator().next(), list.removeFirst());
		}
	}

	@Test
	public void testPositions() {
		fail("Not yet implemented");
		// Do not know how to implement this. 
	}

	@Test
	public void testRemoveFirst() {
		assertEquals("A", list.removeFirst());
	}

	@Test
	public void testRemoveLast() {
		assertEquals("D", list.removeLast());
	}
	
	@Test(timeout=100)
	public void testEfficiencyLarge() {
		for (int i = 0; i < 10000; i++) {
			list.addLast("A");
		}
	}

	@Test
	public void testTime() {
		DoublyLinkedList[] list = new DoublyLinkedList[5000];
		
		for (int i = 0; i < 5000; i++) {
			DoublyLinkedList<String> newList = new DoublyLinkedList<String>();
			
			for (int j = 0; j < 100; j++) {
				newList.addLast("A");
			}
			
			list[i] = newList;
		}
		
		long total = 0;
		long startTime = 0, endTime = 0;
		
		ArrayList<String> totalTimes = new ArrayList<String>();
		
		for (int i = 0; i < 100; i++) {
			startTime = System.nanoTime();
			
			for (int j = 0; j < 5000; j++) {
				Position currentNode = list[j].after(list[j].first());
				int current = 0;
				while (current != i) {
					currentNode = list[j].after(currentNode);
					current++;
				}
			}
			
			endTime = System.nanoTime();
			total = ((endTime - startTime) / 5000);
			totalTimes.addLast(total + "");
		}
		
		for (String s : totalTimes) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testAddElements() {
		DoublyLinkedList[] list = new DoublyLinkedList[5000];
		
		long total = 0;
		long startTime = 0, endTime = 0;
		
		ArrayList<String> totalTimes = new ArrayList<String>();
		
		for (int i = 0; i < 200; i++) {
			for (int z = 0; z < 5000; z++) {
				DoublyLinkedList<String> newList = new DoublyLinkedList<String>();
				list[z] = newList;
			}
			
			startTime = System.nanoTime();
			for (int j = 0; j < 5000; j++) {
				for (int z = 0; z < i; z++) {
					list[j].addLast("A");
				}
			}
			endTime = System.nanoTime();
			total = ((endTime - startTime) / 5000);
			totalTimes.addLast(total + "");
		}
		
		for (String s : totalTimes) {
			System.out.println(s);
		}
	}
	
	@Test
	public void testAddElementsTwo() {
		DoublyLinkedList[] list = new DoublyLinkedList[5000];
		
		long total = 0;
		long startTime = 0, endTime = 0;
		
		ArrayList<String> totalTimes = new ArrayList<String>();
		
		for (int i = 0; i < 200; i++) {
			for (int z = 0; z < 5000; z++) {
				DoublyLinkedList<String> newList = new DoublyLinkedList<String>();
				list[z] = newList;
			}
			
			startTime = System.nanoTime();
			for (int j = 0; j < 5000; j++) {
				for (int z = 0; z < i; z++) {
					list[j].addFirst("A");
				}
			}
			endTime = System.nanoTime();
			total = ((endTime - startTime) / 5000);
			totalTimes.addLast(total + "");
		}
		
		for (String s : totalTimes) {
			System.out.println(s);
		}
	}
}