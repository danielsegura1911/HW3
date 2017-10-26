package singleLink;
/**
 * a double ended queue that can add from both the front and the back of the queue
 * and each node points to one node next to it. 
 * @author Daniel Segura
 *
 * @param <T>
 */

public abstract class singleLinked<T> implements Dequeue<T>{
	private Node head;//creates the pointer head
	private Node tail;//creates the pointer tail
	
public singleLinked(){
	head = null;//sets the head to point to null
	tail = null;//sets the tail to point to null
	
}
	
	public void addToFront(T newEntry) {
		Node newNode = new Node(newEntry, head);// creates a new node object

		if (isEmpty()) {//checks if the deque is empty
			head = newNode; //sets the head to point to the new node object
			head = tail;// sets the tail to point to the same node as the head
		}
		else {
			head = newNode;// the head now points to the new node object
		}
}

	public void addToBack(T newEntry) { // adds to the back of the deque
		Node newNode = new Node(tail, newEntry);//creats new node object
		
		if (isEmpty()) {//checks if the node is empty 
			tail = newNode;//sets the tail to point to the new node object
			tail = head;//sets the head to point to the same node as the tail
		}
		else {
			tail.setNextNode(newNode);// sets the current tail to point to the new node object
			tail = newNode;// sets the tail to point to the new node object
		}
		
	}

	public T removeFront() {// removes node from the front of the deque
		T front = getFront(); 
		assert head != null;// makes sure the head is not pointing to null
		head = head.getNextNode();//sets the  head to point to the current heads next node
	if(head == null)//if the head is pointing to null so will the tail
		tail = null;
		return front;
	}

	public T removeBack() {//removes node from the back of the dequeue
		T back = getBack();
		assert tail != null;// makes sure the tail is not pointing to null
			if (tail == null)// if the tail is now pointing to nul so will the head 
				head = null;
			else
				tail.setNextNode(null);// sets the tails next node to null
			return back;
	}

	public T getFront() {
		if(isEmpty())// checks if the deque is empty
			throw new EmptyQueueException();
		else
			return head.getData();// returns head data
	}

	public T getBack() {
		if(isEmpty())// checks if the deque is empty
			throw new EmptyQueueException();
		else
			return tail.getData();// returns tail data
	}

	public boolean isEmpty() {
	return(head == null) && (tail == null);// if both head and tail are pointing to null returns isempty()
	}
	
	public void clear() {
		while(head != null) {//while the head is not pointing to null sets the heads data to null and ssets the next node to head
			head.data = null;
			head = head.next;	
			}
			
			head = null;
			tail =null;
	}
	private class Node{// private class that defines the nods
		private T data; // dequeue entry
		private Node next; // link to next nod
		
		@SuppressWarnings("unchecked")
		public Node() {//constructor for the node class
			data = (T)new Object();
			next = null;
		}
		public Node( T newEntry, singleLinked<T>.Node head) {
			// TODO Auto-generated constructor stub
		}
		public Node(singleLinked<T>.Node tail, T newEntry) {
			// TODO Auto-generated constructor stub
		}
		public singleLinked<T>.Node getNextNode() {
			// TODO Auto-generated method stub
			return next;
		} // Link to previous node

		public T getData() {
			// TODO Auto-generated method stub
			return data;
		}
		
		@SuppressWarnings("unused")
		public void setData(T newObject) {
			this.data = newObject;
			
		}

		public void setNextNode(singleLinked<T>.Node newNode) {
			// TODO Auto-generated method stub
			
		}	
		
		
		
		
		
	}

}
