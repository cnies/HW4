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
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
