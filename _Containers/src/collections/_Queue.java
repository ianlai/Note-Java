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
 *  Queue<Integer> q = new LinkedList<>();   //Queue is an interface only
 *  .add()  .offer()      //exception or not  if not able to add 
 * 	.poll() .remove()     //null or exception if empty
 * 	.peek()               //only check but not remove
 * 	.isEmpty()
 */

public class _Queue {

	public static void main(String[] args) {
		testQueue();
		testDeque();
		testSorted();
	}
	private static void testQueue(){
		System.out.println("============= Queue =============");
		
		/* Basic bevaviors of the two are the same */
		Queue<Integer> q1 = new ArrayDeque<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();  //LinkedList also implement List 
		//Queue<Integer> q3 = new Queue<Integer>();      //Queue is an interface 
				
		q1.add(1);
		q1.add(2);
		q1.add(3);
		q1.add(4);
		q1.add(5);
		q1.add(3);
		
		
		System.out.println("peek 3 times: ");
		System.out.println(q1.peek());
		System.out.println(q1.peek());
		System.out.println(q1.peek());
		
		System.out.println("poll until empty: ");
		while(!q1.isEmpty()){
			System.out.println(q1.poll());
		}
		System.out.println(q1.poll());  //null
		
		q1.add(6);
		q1.add(7);
		q1.add(8);
		q1.add(9);
		q1.add(10);
		
		System.out.println("remove until empty: ");
		while(!q1.isEmpty()){
			System.out.println(q1.remove());
		}
		//System.out.println(q1.remove());  //exception
		
		//--------------------
		q2.add(1);
		q2.add(2);
		q2.add(3);
		q2.add(4);
		q2.add(5);

		System.out.println("peek 3 times: ");
		System.out.println(q2.peek());
		System.out.println(q2.peek());
		System.out.println(q2.peek());

		System.out.println("poll until empty: ");
		while (!q2.isEmpty()) {
			System.out.println(q2.poll());
		}
		System.out.println(q2.poll()); // null

		q2.add(6);
		q2.add(7);
		q2.add(8);
		q2.add(9);
		q2.add(10);

		System.out.println("remove until empty: ");
		while (!q2.isEmpty()) {
			System.out.println(q2.remove());
		}
		//System.out.println(q2.remove()); // exception
	}
	private static void testDeque(){
		System.out.println("============= Deque =============");
		
		/* Basic bevaviors of the two are the same */
		Deque<Integer> q1 = new ArrayDeque<Integer>();
		Deque<Integer> q2 = new LinkedList<Integer>();  //LinkedList also implement List 
		
		q1.add(1);   //add() equals to addLast()
		q1.add(2);
		q1.addLast(3);
		q1.addLast(4);
		q1.addLast(5);
		
		System.out.println("peek 3 times: ");
		System.out.println(q1.peek());
		System.out.println(q1.peekFirst());  //peek() equals to peekFirst()
		System.out.println(q1.peekFirst());
		
		q1.addFirst(7);
		q1.addFirst(8);
		q1.addFirst(9);
		
		System.out.println("poll until empty: ");
		while (!q1.isEmpty()) {
			System.out.println(q1.pollLast());  //poll() equals to pollFirst(), like a queue
			                                    //if we use pollLast() instead, it will be a stack
		}
	}		
	private static void testSorted(){
		System.out.println("============= Sorted sth =============");
		
		System.out.println("[TreeSet]");
		Set<Integer> set = new TreeSet<Integer>();
		set.add(3);
		set.add(1);
		set.add(2);
		set.add(5);
		set.add(4);
		set.add(2);
		set.add(2);
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			System.out.println(it.next());   //sorted, but it cannot handle redundant elements 
		}
		
		System.out.println("[PriorityQueue]");
		Queue<Integer> pq = new PriorityQueue<Integer>();
		pq.add(3);
		pq.add(1);
		pq.add(2);
		pq.add(5);
		pq.add(4);
		pq.add(2);
		pq.add(2);
		
		//Neither Enhanced for loop nor iterator are not nature order guarantee
		System.out.println("Enhanced For loop:");
		for(Integer e: pq){
			System.out.print(e + " ");
		}
		System.out.println();
		System.out.println("Iterator:");
		Iterator<Integer> it2 = pq.iterator();
		while(it2.hasNext()){
			System.out.print(it2.next() + " ");
		}
		System.out.println();
		System.out.println("Poll (only this is nature order guarantee):");
		while(!pq.isEmpty()) {
		    System.out.print(pq.poll() + " ");
		}
		
	}
}
