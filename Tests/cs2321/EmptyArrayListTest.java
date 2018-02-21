package cs2321;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmptyArrayListTest {

	ArrayList<String> list;
	
	@Before
	public void setUp() throws Exception {
		list = new ArrayList<String>();
		list.addFirst("A");
		list.add(1, "B");
		list.add(2, "C");
		list.add(3, "D");
	}

	@Test
	public void testSize() {
		assertEquals(4, list.size());
	}
	
	@Test(timeout = 100)
	public void testTime() {
		for (int i = 0; i < 10000; i++) {
			list.add(i, "a");
		}
	}

	@Test
	public void testAdd() {
		assert(list.get(0).equals("A"));
	}
	
	@Test
	public void testRemove() {
		assert(list.remove(1).equals("B") && list.get(1).equals("C"));
	}
	
	@Test
	public void testIsEmpty() {
		assertEquals(false, list.isEmpty());
	}
	
	@Test
	public void testGet() {
		assertEquals("A", list.get(0));
		assertEquals("B", list.get(1));
		assertEquals("C", list.get(2));
	}
	
	@Test
	public void testSet() {
		list.set(0, "Z");
		assertEquals("Z", list.get(0));
	}
	
	@Test
	public void testIterator() {
		ArrayList<String> test = new ArrayList<String>();
		
		while (list.iterator().hasNext()) {
			test.addLast(list.iterator().next());
		}
		
		for (int i = 0; i < test.size() ; i ++) {
			assertTrue(test.get(i) == list.get(i));
		}
	}
	
	@Test
	public void testAddLast() {
		list.addLast("Z");
		assertEquals("Z", list.get(4));
	}
	
	@Test
	public void testArrayList() {
		ArrayList<String> newList = new ArrayList<String>();
		assertEquals(16, newList.capacity);
		assertEquals(0, newList.size);
		for (int i = 0; i < 16; i++) {
			assertEquals(null, newList.get(i));
		}
	}
	
	@Test
	public void testRemoveFirst() {
		assertEquals("A", list.removeFirst());
	}
	
	@Test
	public void testRemoveLast() {
		assertEquals("D", list.removeLast());
	}
	
	@Test
	public void testTimer() {
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		for (int i = 0; i < 5000; i++) {
			ArrayList<String> newList = new ArrayList<String>();
			list.addLast(newList);
			
			for (int j = 0; j < 100; j++) {
				list.get(i).addLast("A");
			}
		}
		
		long total = 0;
		long startTime = 0, endTime = 0;
		
		ArrayList<String> totalTimes = new ArrayList<String>();
		
		for (int i = 0; i < 100; i++) {
			startTime = System.nanoTime();
			
			for (int j = 0; j < 5000; j++) {
				list.get(j).get(i);
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
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		long total = 0;
		long startTime = 0, endTime = 0;
		
		ArrayList<String> totalTimes = new ArrayList<String>();
		
		for (int i = 0; i < 200; i++) {
			for (int z = 0; z < 5000; z++) {
				ArrayList<String> newList = new ArrayList<String>();
				list.addLast(newList);
			}
			
			startTime = System.nanoTime();
			for (int j = 0; j < 5000; j++) {
				for (int z = 0; z < i; z++) {
					list.get(j).addLast("A");
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
		ArrayList<ArrayList<String>> list = new ArrayList<ArrayList<String>>();
		
		long total = 0;
		long startTime = 0, endTime = 0;
		
		ArrayList<String> totalTimes = new ArrayList<String>();
		
		for (int i = 0; i < 200; i++) {
			for (int z = 0; z < 5000; z++) {
				ArrayList<String> newList = new ArrayList<String>();
				list.addFirst(newList);
			}
			
			startTime = System.nanoTime();
			for (int j = 0; j < 5000; j++) {
				for (int z = 0; z < i; z++) {
					list.get(j).addFirst("A");
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