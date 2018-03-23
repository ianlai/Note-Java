package implementation;

public interface MinStack {
	void push(int x);
	void pop();
	int top();      //peek(), only check the top one but not extract it 
	int getMin();   //not in regular stack, only check the min but not extract it 
	void print();
	//=============
	void clear();
	default void printTopAndMin(){
		System.out.println();
		System.out.println("getMin(): " + getMin());
		System.out.println("top()   : " + top());
	}
	boolean debug = false;
}