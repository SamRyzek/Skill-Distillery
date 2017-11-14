package stackandqueue;

public class MyStack {

	Node top;
	
	public void push(Node n) {
		if(top != null) {
			n.next = top;
		}
		
		top = n;
	}
	
	public Node pop() {
		if(top != null) {
			Node temp = top;			
			top = top.next;
			
			temp.next = null;
			return temp;
		}
		
		return null;
	}
	
	public Node peek() {
		return top;
	}
	
	public boolean isEmpty() {
//		if(top != null) {
//			return false;
//		}
//		else {
//			return true;
//		}
		
		return top != null ? false : true;
	}
}
