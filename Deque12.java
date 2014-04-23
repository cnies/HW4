import java.util.*;

public class Deque12<E> implements BoundedDeque<E>{
 private int size;
 private int capacity;
 private int front;
 private int back;
 private ArrayList<E> elementArray;
 
 public Deque12(int capacityIn){
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
  // TODO Auto-generated method stub
  return false;
 }

 public int capacity() {
  return capacity;
 }

 public E peekBack() {
  return elementArray.get(back);
 }

 public E peekFront() {
  // TODO Auto-generated method stub
  return null;
 }

 public E removeBack() {
  return null;
 }

 public E removeFront() {
  // TODO Auto-generated method stub
  return null;
 }

 public int size() {
  return size;
 }

}
