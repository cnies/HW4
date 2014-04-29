/*
NAME: Christopher Nies
ID: A11393577
LOGIN: cs12sfl
*/
public class Queue12<E> implements BoundedQueue<E>{
	private Deque12<E> theQ;

	public Queue12(int capacityIn){
		theQ = new Deque12<E>(capacityIn);
	}

	@Override
	public int capacity(){
		return theQ.capacity();
	}

	@Override
	public E dequeue(){
		return theQ.removeFront();
	}

	@Override
	public boolean enqueue(E element){
		return theQ.addBack(element);
	}

	@Override
	public E peek(){
		return theQ.peekFront();
	}

	@Override
	public int size(){
		return theQ.size();
	}
}
