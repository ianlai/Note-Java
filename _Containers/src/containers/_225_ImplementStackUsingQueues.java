package containers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Use two queues, modify the input (push) part */

public class _225_ImplementStackUsingQueues {

	public static void main(String[] args) {
		Stack<Integer> nativeS = new Stack<>();
		MyStack madeS = new MyStack();
		
		System.out.println("======== Native Stack ======== ");
		int a1, a2, a3;
		nativeS.push(3);
		nativeS.push(5);
		nativeS.push(9);
		a1 = nativeS.pop();
		nativeS.push(10);
		a2 = nativeS.pop();
		nativeS.push(6);
		a3 = nativeS.peek();
		System.out.println(a1 + " " + a2 + " " + a3);
		System.out.println(nativeS);
		
		System.out.println("======== Implemented Stack ======== ");
		int b1, b2, b3;
		madeS.push(3);
		madeS.push(5);
		madeS.push(9);
		b1 = madeS.pop();
		madeS.push(10);
		b2 = madeS.pop();
		madeS.push(6);
		b3 = madeS.top();
		System.out.println(b1 + " " + b2 + " " + b3);
		System.out.println(madeS);
	}

}

class MyStack {

    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    /** Initialize your data structure here. */
    public MyStack() {
        
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()){
            q1.add(x);
        }else{
            while(!q1.isEmpty())
                q2.add(q1.poll());
            q1.add(x);
            while(!q2.isEmpty())
                q1.add(q2.poll());
        }   
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.poll();
    }
    
    /** Get the top element. */
    public int top() {
        return q1.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty();
    }
    
    public String toString(){
    	return q1.toString();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */