package stackandqueue;

public class MyQueue {
	Node front;
	Node rear;
	
	public void add(Node n) {
		if(rear != null) {
			rear.next = n;
			rear = n;
		}
		else {
			front = n;
			rear = n;
		}
	}
	
	public Node remove() {
		if(rear != null) {
			Node temp = front;
			front = front.next;
			
			if(front == null) {
				rear = null;
			}
			
			temp.next = null;
			return temp;
		}
		return null;
	}
	
	public Node peek() {
		return front;
	}
	
	public boolean isEmpty() {
		return rear != null ? false : true;
	}
}
