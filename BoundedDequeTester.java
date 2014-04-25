/*
NAME: Christopher Nies
ID: A11393577
LOGIN: cs12sfl
*/
import junit.framework.TestCase;


public class BoundedDequeTester extends TestCase {
	private Deque12<Integer> empty;
	private Deque12<Integer> one;
	private Deque12<Integer> several;
	private Deque12<Integer> fullMinusOne;
	private Deque12<Integer> full;
	static final int SIZE = 15;


	public BoundedDequeTester() {
		super();
	}

	protected void setUp() throws Exception {
		super.setUp();
		empty = new Deque12<Integer>(SIZE);
		one = new Deque12<Integer>(SIZE);
		several = new Deque12<Integer>(SIZE);
		fullMinusOne = new Deque12<Integer>(SIZE);
		full = new Deque12<Integer>(SIZE);
		one.addBack(new Integer(1));
		for (int i =0; i<6; i++)
			several.addBack(new Integer(i+1));
		for (int i=0; i<SIZE-1; i++)
			fullMinusOne.addBack(new Integer(i));
		for (int i = 0; i<SIZE; i++)
			full.addBack(new Integer(i));
	}

	//Tests that addBack in the setup worked
	public void testAddBack(){
		assertEquals(new Integer(1), one.peekBack());
		assertEquals(new Integer(6), several.peekBack());
		assertEquals(new Integer(13), fullMinusOne.peekBack());
		assertEquals(new Integer(14), full.peekBack());
	}

	//Make sure addBack returns false on a full
	public void testAddBackOnFull(){
		assertTrue(!full.addBack(new Integer(4)));
	}

	//Makes sure addBack changes size appropriately
	public void testAddBackSize(){
		one.addBack(4);
		empty.addBack(1);
		assertEquals(1, empty.size());
		assertEquals(2, one.size()); 
	}

	//Tests the removeBack method in a simple case
	public void testRemoveBack(){
		assertEquals(null, empty.removeBack());
		assertTrue(0 == empty.size());
		assertTrue(1 == one.removeBack());
		assertTrue(0 == one.size());
		assertEquals(one.getFront(), one.getBack());
	}
	
	//Tests addFront method in simple cases
	public void testAddFront(){
		one.addFront(5);
		assertEquals(new Integer(5), one.peekFront());
		assertEquals(15, one.getFront());
		fullMinusOne.addFront(50);
		assertEquals(15, fullMinusOne.size());
		assertEquals(new Integer(50), fullMinusOne.peekFront());
		assertEquals(15, fullMinusOne.getFront());
		assertTrue(!fullMinusOne.addFront(new Integer(17)));
	}

	public void testFull(){
		fullMinusOne.addBack(50);
		assertTrue(!fullMinusOne.addFront(45));
		for (int i = 0; i<fullMinusOne.capacity(); i++)
			fullMinusOne.removeFront();
		assertEquals(0, fullMinusOne.size());
		fullMinusOne.addBack(50);
		fullMinusOne.addFront(5);
		fullMinusOne.addBack(4);
		fullMinusOne.addBack(2);
		assertEquals(new Integer(5), fullMinusOne.removeFront());
		assertEquals(new Integer(2), fullMinusOne.removeBack());
		assertEquals(new Integer(4), fullMinusOne.removeBack());
		assertEquals(new Integer(50), fullMinusOne.removeFront());
	}

	//Tests peeks on their own
	public void testPeekFront(){
		assertEquals(1, one.peekFront().intValue());
		assertEquals(1, one.peekBack().intValue());
		one.addFront(3);
		one.addBack(5);
		assertEquals(3, one.peekFront().intValue());
		assertEquals(5, one.peekBack().intValue());
}


	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
