package containers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/* Use two stacks with two implementations. 
 * 1. modify the input (push) part
 * 2. modify the output (pop and peek) parts 
 * */

public class _232_ImplementQueueUsingStacks {

	public static void main(String[] args) {
		Queue<Integer> nativeQ = new LinkedList<>();
		MyQueue1 q1 = new MyQueue1();
		MyQueue2 q2 = new MyQueue2();
		
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
		
		System.out.println("======== Implemented Queue-1 ======== ");
		int b1, b2, b3;
		q1.push(3);
		q1.push(5);
		q1.push(9);
		System.out.println(q1);
		
		b1 = q1.pop();
		q1.push(10);
		b2 = q1.pop();
		q1.push(6);
		b3 = q1.peek();
		System.out.println(b1 + " " + b2 + " " + b3);
		System.out.println(q1);
		
		System.out.println("======== Implemented Queue-2 ======== ");
		q2.push(3);
		q2.push(5);
		q2.push(9);
		System.out.println(q2);
		
		b1 = q2.pop();
		q2.push(10);
		b2 = q2.pop();
		q2.push(6);
		b3 = q2.peek();
		System.out.println(b1 + " " + b2 + " " + b3);
		System.out.println(q2);
	}

}

//===================================== Modify when doing push() =====================================
class MyQueue1 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    /** Initialize your data structure here. */
    public MyQueue1() {
        
    }
    public void push(int x){
        if(stack1.isEmpty()){
            stack1.push(x);
        }else{
            while(!stack1.isEmpty()) stack2.push(stack1.pop());
            stack1.add(x);
            while(!stack2.isEmpty()) stack1.push(stack2.pop());
        }
    }
    public int pop(){
        return stack1.pop();
    }
    public int peek(){  
        return stack1.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty();
    }
    
    public String toString(){
    	return stack1.toString();
    }
}

//===================================== Modify when doing pop() and peek() =====================================
class MyQueue2 {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
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