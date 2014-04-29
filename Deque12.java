/*
NAME: Christopher Nies
ID: A11393577
LOGIN: cs12sfl
*/
import java.util.*;

public class Deque12<E> implements BoundedDeque<E>{
	private int size;
	private int capacity;
	private int front;
	private int back;
	private ArrayList<E> elementArray;

	public Deque12(int capacityIn) throws IllegalArgumentException{
		if (capacityIn<0) throw new IllegalArgumentException();
		elementArray = new ArrayList<E>();
		for (int i = 0; i<=capacityIn; i++){
			elementArray.add(null);
		}
		this.size = 0;
		this.capacity = capacityIn;
		this.front = 0;
		this.back = 0;
	}

	public boolean addBack(E element) throws NullPointerException{
		if (element == null)
			throw new NullPointerException();
		if (size == capacity)
			return false;
		if (elementArray.get(back)==null){
			elementArray.set(back, element);
			size++;
			return true;
		}
		back = (back+1)%elementArray.size();
		elementArray.set(back, element);
		size++;
		return true;
	}

	public boolean addFront(E element) {
		if (element == null)
			throw new NullPointerException();
		if (size == capacity)
			return false;
		if (elementArray.get(front)==null){
			elementArray.set(front, element);
			size++;
			return true;
		}
		front = (front +elementArray.size()-1)%elementArray.size();
		elementArray.set(front, element);
		size++;
		return true;
	}

	public int capacity() {
		return capacity;
	}

	public E peekBack() {
		return elementArray.get(back);
	}

	public E peekFront() {
		return elementArray.get(front);
	}

	public E removeBack() {
		E toRemove = elementArray.get(back);
		elementArray.set(back, null);
		if (size>1) back=(back+elementArray.size()-1)%elementArray.size();
		if (size>0) size--;
		return toRemove;
	}

	public E removeFront() {
		E toRemove = elementArray.get(front);
		elementArray.set(front, null);
		if (size>1) front=(front+1)%elementArray.size();
		if (size>0) size--;
		return toRemove;
	}

	public int size() {
		return size;
	}

}
