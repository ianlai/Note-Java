package collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class _Deque {

	public static void main(String[] args) {
		/* Normal queue */
		/* Since the reference type is Queue, it cannot call addLast, addFirst, etc. */
		Queue<Integer> q1 = new ArrayDeque<>();
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.poll();
		System.out.println(q1);  //2,3
		
		/* Deque */
		/* We can call addFirst, addLast, pollFirst, pollLast, peekFirst, peekLast */
		Deque<Integer> q2 = new ArrayDeque<>();
		q2.addAll(q1);
		System.out.println(q2);  //2,3
		
		q2.addFirst(9);
		q2.addLast(4);
		q2.addLast(5);
		q2.addFirst(8);         
		q2.pollLast();          
		System.out.println(q2);  //8,9,2,3,4
	}
}
