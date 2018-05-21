package implementation;

import java.io.*;
import java.util.*;

public class MaxQueue {
	
      /* MaxQueue 
         - add()
         - poll()
         - getMax()
         
         The MaxQueue is implemented with two stacks. 
         
         [Implement Queue]
           Each add() will trigger 
             (1) moving the elements from stack1 to stack2
             (2) adding the input element into stack1
             (3) moving the elements from stack2 back to stack1 
           This is for implementing Queue with two Stacks. 
         
         [Implement Queue with getMax]
           Each add() will compare the input element is larger than current mMax or not.
           add() will add "mMax" again and then add "input" to record the max value. 
           
           Besides, poll() will compare the output element is the same as mMax or not.
           If yes, it will poll out the elements twice to compensate the extra input in add().
      */
	
	static class MQueue {
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();

		int mMax = Integer.MIN_VALUE;

		private void add(int x) {
			if (stack1.isEmpty()) {
				mMax = x;
				stack1.push(x);
			} else {
				while (!stack1.isEmpty())
					stack2.push(stack1.pop());
				/* Insert max and x */
				if (x >= mMax) {
					stack1.push(mMax);
					stack1.push(x);
					mMax = x;
				}
				/* Insert x only */
				else {
					stack1.push(x);
				}
				while (!stack2.isEmpty())
					stack1.push(stack2.pop());
			}
		}

		private int poll() {
			int pop = stack1.pop(); // pop
			if (pop == mMax) {
				mMax = stack1.pop(); // one more pop
			}
			return pop;
		}

		private int peek() {
			return stack1.peek();
		}

		public int getMax() {
			return mMax;
		}

		public void print() {
			System.out.println("s1:");
			System.out.println(stack1);
			System.out.println("s2:");
			System.out.println(stack2);
			System.out.println("max:" + getMax());
		}
	}
	// ============================================================

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println(input);

		/* Read window size */
		int w = Integer.parseInt(input);
		int counter = 0;

		/* Initiate the MaxQueue */
		MQueue q = new MQueue();

		/* Read commands */
		while ((input = br.readLine()) != null) {
			int num = Integer.parseInt(input);
			if (counter < w) { /* not need to poll in the beginning */
				q.add(num);
				counter++; /* counter will stop when reaching w */
				// System.out.println(q.getMax());
			} else { /* need to poll in the beginning */
				q.poll();
				q.add(num);
				System.out.println(q.getMax());
			}
		}
	}
}
