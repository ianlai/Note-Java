package collections;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

//1. Stack (push at last, pull at last)
//2. Queue (add at last, poll at first)
//3. Deque (add at both sides, poll at both sides)

/*
 *  Stack<Integer> s = new Stack<>();   //Stack is a class
 * 	.push()
 * 	.pop()   
 * 	.peek()   //only check but not remove
 * 	.isEmpty()
 */

public class _Stack {

	public static void main(String[] args) {
		testStack();
	}
	
	private static void testStack(){
		System.out.println("============= Stack =============");
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		System.out.println("peek 3 times: ");
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		
		System.out.println("pop until empty: ");
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
	}
}
