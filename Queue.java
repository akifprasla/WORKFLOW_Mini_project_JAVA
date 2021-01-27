package eecs2011.project;

public class Queue<E> extends DoublyLinkedList<E>  {
	
	//attributes
	private DoublyLinkedList<E> q;
	
	//constructor
	public Queue(){
		q = new DoublyLinkedList();
	}
	//methods
	public int size() {
		return q.size();
	}
	
	public boolean isEmpty() {
		return (q.size()==0);
	}
	
	public void enqueue(E e) {
		q.addLast(e);
	}
	
	public E first() {
		return q.first();
	}
	
	public E dequeue() {
		return q.removeFirst();
	}
	
	
	
}
