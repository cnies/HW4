/*
NAME: Christopher Nies
ID: A11393577
LOGIN: cs12sfl
*/
public class Stack12<E> implements BoundedStack<E>{
	private Deque12<E> theStack;

	public Stack12(int capacityIn){
		theStack = new Deque12<E>(capacityIn);
	}

	@Override
	public int capacity(){
		return theStack.capacity();
	}

	@Override
	public E peek(){
		return theStack.peekBack();
	}

	@Override
	public E pop(){
		return theStack.removeBack();
	}

	@Override
	public boolean push(E element){
		return theStack.addBack(element);
	}

	@Override
	public int size(){
		return theStack.size();
	}

}
