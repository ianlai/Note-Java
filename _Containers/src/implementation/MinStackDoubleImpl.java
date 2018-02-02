package implementation;
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

	public static void main(String[] args) {
		MinStack mss = new MinStackSingleImpl();
		MinStack msd = new MinStackDoubleImpl();
		test(mss);
		test(msd);
	}
	public static void test(MinStack ms) {
		if(ms instanceof MinStackSingleImpl) {
			System.out.println("----- Single -----");
		}else if(ms instanceof MinStackDoubleImpl) {
			System.out.println("----- Double -----");
		}
		ms.push(6); 
		ms.push(3);
		ms.push(5);
		ms.push(2);
		ms.push(7);
		ms.push(4);
		//ms.push(2);  //single stack cannot handle multiple number yet
		ms.push(9);
		ms.push(1);
		ms.push(5);
		
		ms.print();
		if(ms instanceof MinStackDoubleImpl) {
			((MinStackDoubleImpl) ms).printSize();  //need to cast
		}

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
	
	public void traverse(){

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

class MinStackSingleImpl implements MinStack{
	Stack<Integer> mStack = new Stack<>();
	int mMin = Integer.MAX_VALUE;
	public void push(int x) {
		if(mStack.isEmpty()) {
			mMin = x; 
			mStack.push(x);
		}else {
			if(x<mMin) {
				mStack.push(mMin);  //important
				mMin = x;	
			}
			mStack.push(x);
		}
		//System.out.println("push(" + x + ")");
	}

	public void pop() {
		int pop = mStack.pop();
		//System.out.println("pop(): " + pop);
		if(pop==mMin) {
			mMin = mStack.pop();
			//System.out.println(">> pop(): " + mMin);
		}
	}
	public int top() {
		return mStack.peek();
	}
	public int getMin() {
		return mMin;
	}
	public void print() {
		System.out.println(">> " + mStack);		
	}
}
