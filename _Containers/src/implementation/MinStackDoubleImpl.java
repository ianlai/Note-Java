package implementation;
import java.util.Arrays;
import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such: 
 * MinStack obj = new MinStack(); 
 * obj.push(x); 
 * obj.pop(); 
 * int param_3 = obj.top(); 
 * int param_4 = obj.getMin();
 */

public class MinStackDoubleImpl implements MinStack{
	
	Stack<Integer> s1;
	Stack<Integer> s2;

	public MinStackDoubleImpl() {
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
		System.out.println(">> Normal stack (s1): / Min stack (s2): ");
		System.out.println("   " + s1 + " / " + s2);
	}
	/* only for double */
	public void printSize() {
		System.out.println("   S1->" + s1.size() + "  S2->" + s2.size());
	}

	@Override
	public void clear() {
		s1.clear();
		s2.clear();
	}
}