package doublelinkedque;
/**
 * a double ended queue that can add and remove node objects from both the ends of the que
 * and each node point to both the node infront and behind it in the que order
 * @author Daniel Segura
 *
 * @param <T>
 */
public abstract class doubleLinkQue<T> implements DequeInterface<T> {
	private DLNode head;// variable for the front for the que
	private DLNode tail;// variable for the back of the que
	
public doubleLinkQue() {//constructor for the main class
	head = null;//sets the front pointer to null
	tail = null;//sets back pointer to null
	
}

public void addToFront(T newEntry){//method to add to the front of the deque

DLNode newNode = new DLNode(null, newEntry, head);//creates new node object setting the data and what is is pointing to.

		if (isEmpty()) {//checks if the deque is empty
			head = newNode;// makes the head point to the new node object
			head = tail;// sets tail to point to the same object as the head
		}
		else {
			head.setPreviousNode(newNode);//sets the current head to point to the new node object
			head = newNode;// sets the head to point the new node object
		}
}

public void addToBack(T newEntry){// adds to the back of the deque
	
	DLNode newNode = new DLNode(tail, newEntry, null);//creates new node object setting it's data and what is pointing at it
	
		if (isEmpty()) {//checks if the deque is empty
			tail = newNode;//sets the tail to point to the new node object
			tail = head;//sets the head to point to the same value as the tail
		}
		else {
			tail.setNextNode(newNode);// sets the current tail to point to the new node object
			tail = newNode;/// sets the tail to point to the new node object
		}
			
}

public T removeFromFront(T newEntry){//removes node form the front of the dequeu
	
	T front = getFront(); // sets get front equel to the front 
			assert head != null; //makes sure the head is not pointing to null
			head = head.getNextNode();//has the head point to the next node in the deque
		if(head == null)/**
		if the head is now pointing to null then the tail is also now pointing to null
			*/tail = null;
		else
			head.setPreviousNode(null);//sets the previous in the new head to null
			return front;
}

public T removeFromBack(T newEntry){//removes node from the back of deque
	
	T back = getBack();//set the getback to the back
		assert tail != null;//makes sure the tail is not pointing to null
			tail = tail.getPreviousNode();// sets the tail to point to the current tails previous
			if (tail == null)//if the tail is now pointing to null so is the head
				head = null;
			else
				tail.setNextNode(null);// the tails next entry is now equel to null
			return back;
}

public T getFront(){
	if(isEmpty())//checks if the deque is empty
		throw new EmptyQueueException();
	else
		return head.getData();//returns the data of the head
}

public T getBack(){
	if(isEmpty())//checks if the deque is empty
		throw new EmptyQueueException();
	else
		return tail.getData();//returns thr data of the tail
}

public boolean isEmpty(){
		
	return(head == null) && (tail == null);//if both the head and tail are pointing to null returns isEmpty
}

public void clear(){//clears the deque of all nodes
	while(head != null) {//while the head is not pointing to null sets the data to null, moves to the previou node and sets the next node to null
	head.data = null;
	head.next.previous = null;
	head = head.next;	
	}
	
	head = null;
	tail =null;
}


private class DLNode{// private class that defins the nodes
	
	private T data; // deque entry
	private DLNode next; // link to next node
	private DLNode previous;// link to previous node
	
	@SuppressWarnings("unchecked")
	public DLNode(Object object, T newEntry, doubleLinkQue<T>.DLNode head) {
		data = (T)new Object();// sets the new node objects data
		next = null;// sets the next to null by default
		previous = null;// sets the previous to null by default
	}
	
	public doubleLinkQue<T>.DLNode getNextNode() {
		// TODO Auto-generated method stub
		return next;
	} // Link to previous node

	public T getData() {
		// TODO Auto-generated method stub
		return data;
	}
	
	public T setData() {
		// TODO Auto-generated method stub
		return data;
	}

	public doubleLinkQue<T>.DLNode getPreviousNode() {
		// TODO Auto-generated method stub
		return previous;
	}

	public void setPreviousNode(doubleLinkQue<T>.DLNode newNode) {
		// TODO Auto-generated method stub
		
	}

	public void setNextNode(doubleLinkQue<T>.DLNode newNode) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
}