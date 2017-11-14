package stackandqueue;

public class TestQueue {
	public static void main(String[] args) {
		Node<Integer> n1 = new Node(12);
		Node<Integer> n2 = new Node(2);
		Node<Integer> n3 = new Node(33);
		Node<Integer> n4 = new Node(45);
		
		MyQueue queue = new MyQueue();
		System.out.println(queue.isEmpty());
		queue.add(n1);
		queue.add(n2);
		System.out.println(queue.isEmpty());
		System.out.println(queue.peek());
		queue.add(n3);
		queue.add(n4);
		System.out.println(queue.peek());
		queue.remove();
		queue.remove();
		System.out.println(queue.peek());
		queue.remove();
		queue.remove();
		System.out.println(queue.peek());

		
	}
}
