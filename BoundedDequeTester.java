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
   several.addBack(i+1);
  for (int i=0; i<SIZE-1; i++)
   fullMinusOne.addBack(i);
  for (int i = 0; i<SIZE; i++)
   full.addFront(i);
 }
 
 public void testAddBack(){
  assertEquals(new Integer(1), one.peekBack());
 }

 protected void tearDown() throws Exception {
  super.tearDown();
 }

}
