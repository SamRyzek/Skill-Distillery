package stackandqueue;

public class TestStack {
	public static void main(String[] args) {
		Node <String> n1 = new Node("Andrew");
		Node <String> n2 = new Node("Kris");
		Node <String> n3 = new Node("Erin");
		Node <String> n4 = new Node("Bruce");
		
		MyStack stack = new MyStack();
		
		System.out.println("isEmpty: " + stack.isEmpty());
		stack.push(n1);
		stack.push(n2);
		System.out.println("isEmpty: " + stack.isEmpty());
		System.out.println(stack.peek());
		stack.push(n3);
		stack.push(n4);
		System.out.println(stack.peek());
		Node poppedNode = stack.pop();
		System.out.println(poppedNode);
		System.out.println(stack.peek());


	}
}
