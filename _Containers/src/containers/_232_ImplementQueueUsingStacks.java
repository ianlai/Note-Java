package containers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Use two stacks, modify the output (pop and peek) parts */

public class _232_ImplementQueueUsingStacks {

	public static void main(String[] args) {
		Queue<Integer> nativeQ = new LinkedList<>();
		MyQueue madeQ = new MyQueue();
		
		System.out.println("======== Native Queue ======== ");
		int a1, a2, a3;
		nativeQ.add(3);
		nativeQ.add(5);
		nativeQ.add(9);
		a1 = nativeQ.poll();
		nativeQ.add(10);
		a2 = nativeQ.poll();
		nativeQ.add(6);
		a3 = nativeQ.peek();
		System.out.println(a1 + " " + a2 + " " + a3);
		System.out.println(nativeQ);
		
		System.out.println("======== Implemented Queue ======== ");
		int b1, b2, b3;
		madeQ.push(3);
		madeQ.push(5);
		madeQ.push(9);
		b1 = madeQ.pop();
		madeQ.push(10);
		b2 = madeQ.pop();
		madeQ.push(6);
		b3 = madeQ.peek();
		System.out.println(b1 + " " + b2 + " " + b3);
		System.out.println(madeQ);
	}

}

class MyQueue {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue() {
        
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        stack1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!stack1.isEmpty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int first = stack2.pop();
        while(!stack2.isEmpty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return first;
    }
    
    /** Get the front element. */
    public int peek() {
         while(!stack1.isEmpty()){
            int temp = stack1.pop();
            stack2.push(temp);
        }
        int first = stack2.peek();
        while(!stack2.isEmpty()){
            int temp = stack2.pop();
            stack1.push(temp);
        }
        return first;
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
    
    public String toString(){
    	return stack1.toString();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */