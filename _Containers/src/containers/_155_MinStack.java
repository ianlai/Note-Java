package containers;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such: 
 * MinStack obj = new MinStack(); 
 * obj.push(x); 
 * obj.pop(); 
 * int param_3 = obj.top(); 
 * int param_4 = obj.getMin();
 */

/* Use two stacks to implement (simple) 
 * Check MinStackDoubleImpl.java to discuss more.*/ 

public class _155_MinStack{

	public static void main(String[] args) {
		_155_MinStack msd = new _155_MinStack();
		test(msd);
	}
	public static void test(_155_MinStack ms) {
		ms.push(6); 
		ms.push(3);
		ms.push(5);
		ms.push(2);
		ms.push(7);
		ms.push(4);
		ms.push(9);
		ms.push(1);
		ms.push(5);
		
		ms.print();

		System.out.println(ms.getMin());
		System.out.println(ms.top());
		ms.pop();
		ms.pop();
		ms.pop();
		ms.pop();
		ms.pop();
		System.out.println(ms.getMin());
		System.out.println(ms.top());

	}
	/** initialize your data structure here. */
	Stack<Integer> s1;
	Stack<Integer> s2;

	public _155_MinStack() {
		s1 = new Stack<>();
		s2 = new Stack<>();
	}

	public void push(int x) {
		s1.push(x);
		if (s2.isEmpty() || x <= getMin())
			s2.push(x);
	}

	public void pop() {
		int last = s1.pop();
		if (last == getMin())
			s2.pop();
	}

	public int top() {
		return s1.peek();
	}

	public int getMin() {
		return s2.peek();
	}
	
	public void print() {
		System.out.println(">> Normal stack (s1): " );
		System.out.println("   " + s1);
		
		System.out.println(">> Min stack    (s2): " );
		System.out.println("   " + s2);
	}
	/* only for double */
	public void printSize() {
		System.out.println("   S1->" + s1.size() + "  S2->" + s2.size());
	}
}

