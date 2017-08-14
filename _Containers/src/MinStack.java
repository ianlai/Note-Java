import java.util.Stack;

/**
 * Your MinStack object will be instantiated and called as such: 
 * MinStack obj = new MinStack(); 
 * obj.push(x); 
 * obj.pop(); 
 * int param_3 = obj.top(); 
 * int param_4 = obj.getMin();
 */

public class MinStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinStack ms = new MinStack();
		
		ms.push(6); 
		ms.push(3);
		ms.push(5);
		ms.push(2);
		ms.push(7);
		ms.push(4);
		ms.push(2);
		ms.push(9);
		ms.push(1);
		ms.push(5);
		
		ms.traverse();
		
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());

		System.out.println(ms.top());
		System.out.println(ms.top());
		System.out.println(ms.top());
		
		ms.pop();
		ms.pop();
		ms.pop();
		ms.pop();
		ms.pop();
		
		ms.traverse();
		
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());
		System.out.println(ms.getMin());

		System.out.println(ms.top());
		System.out.println(ms.top());
		System.out.println(ms.top());
	}

	/** initialize your data structure here. */
	Stack<Integer> s1;
	Stack<Integer> s2;

	public MinStack() {
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
	
	public void traverse(){
		System.out.println("Normal stack (s1): " );
		for(int i=0; i<s1.size(); ++i) 
			System.out.print(s1.get(i) + " ");
		System.out.println();
		
		System.out.println("Min stack    (s2): " );
		for(int i=0; i<s2.size(); ++i) 
			System.out.print(s2.get(i) + " ");	
		System.out.println();
	}
}
