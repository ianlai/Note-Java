package implementation;

import java.util.Stack;

public class MinStackSingleImpl implements MinStack{
	Stack<Integer> mStack = new Stack<>();
	int mMin = Integer.MAX_VALUE;
	public void push(int x) {
		if(mStack.isEmpty()) {
			mMin = x; 
			mStack.push(x);
		}else {
			if(x<=mMin) {
				mStack.push(mMin);  //Add one more min if input smaller than min (important)
				mMin = x;	
			}
			mStack.push(x);         //Add input 
		}
		if(debug) print(); 
	}

	public void pop() {
		int pop = mStack.pop();
		if(pop==mMin) {
			if(debug) System.out.println("pop the min!");
			mMin = mStack.pop();
		}
		if(debug) print(); 
	}
	public int top() {
		return mStack.peek();
	}
	public int getMin() {
		return mMin;
	}
	public void print() {
		System.out.println(">> " + mStack + "  min: " + mMin);		
	}

	@Override
	public void clear() {
		mStack.clear();
		mMin = Integer.MAX_VALUE;
	}
}
