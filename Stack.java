package eecs2011.project;

public class Stack<E> extends DoublyLinkedList<E> {

	//attributes
	private DoublyLinkedList<E> stk;
	
	//constructors
	public Stack(){
		stk = new DoublyLinkedList();
	}
	
	
	//methods
	
	public int size() {
		return stk.size();
	}
	
	public boolean isEmpty() {
		return (stk.size()==0);
	}
	
	public void push(E e) {
		stk.addFirst(e);
	}
	
	public E peek() {
		return stk.first();
	}
	
	public E pop() {
		return stk.removeFirst();
	}
	
	public boolean contains(E elem) {
		return (elem == stk.first());
	}
	
	
}
