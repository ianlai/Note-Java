package collections;

import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

/* PriorityQueue can sort the elements natural order or with the comparator we assigned. 
 * One more advantage is that it can handle duplicates (compared with TreeSet).
 * However, to keep the natural order (or other order), we can only iterate the elements by poll().
 *  - poll()           //YES
 *  - Directly println //NO
 *  - Enhanced loop    //NO
 *  Be careful that after we iterate the PriorityQueue with poll(), it will become empty. 
 */
public class _PriorityQueue {
	public static void main(String[] args) {
		
		Queue<Integer> queue1 = new PriorityQueue<>();  //Integer
		
		/* The original comparator will do sorting alphabetically */ 
		Queue<String>  queue2 = new PriorityQueue<>();  //String
		
		/* Arguments: capacity, comparator */ 
		/* Define a comparator which compares the length of the String only */ 
		Queue<String>  queue3 = new PriorityQueue<>(10, (String s1, String s2) -> s1.length()-s2.length());
		
		System.out.println("--------- queue1 (Integer, sorting with ascenting order---------");
		queue1.add(5);
		queue1.add(2);
		queue1.add(8);
		queue1.add(3);
		queue1.add(5);
		queue1.add(3);
		queue1.add(4);
		while(!queue1.isEmpty()){
			System.out.println(queue1.poll());
		}
		
		System.out.println("--------- queue2 (String, sorting alphabetically) ---------");
		
		queue2.add("m");
		queue2.add("kkfff");
		queue2.add("dd");
		queue2.add("ccffkkicc");
		queue2.add("ww");
		while(!queue2.isEmpty()){
			System.out.println(queue2.poll());
		}
		
		System.out.println("--------- queue3 (String, sorting by length) ---------");
		
		queue3.add("m");
		queue3.add("kkfff");
		queue3.add("dd");
		queue3.add("ccffkkicc");
		queue3.add("ww");
		while(!queue3.isEmpty()){
			System.out.println(queue3.poll());
		}
		
		System.out.println("--------- PriorityQueue vs TreeSet ---------");
		/* 
		 * Both         : sort with nature order
		 * PriorityQueue: can handle duplicates    ; cannot print directly ; access with poll (becoming empty)
		 * TreeSet      : cannot handle duplicates ; print directly        ; access with enhanced-loop
		 */
		Queue<Integer> queue = new PriorityQueue<>();  //Integer
		Set<Integer> set = new TreeSet<>();            //Integer
		int[] arr = new int[] {5,2,4,7,1,5,3,24,19,31,28,6,8};         //5 is a duplicate  
		for(int i=0; i<arr.length; i++) {
			queue.add(arr[i]);
			set.add(arr[i]);
		}
		
		/* Default print */
		System.out.println("[PriorityQueue]");
		System.out.println(queue);   //no: not sorted (but duplicates still there) 
		System.out.println("[TreeSet]");
		System.out.println(set);     //ok: sorted (but duplicates disappear) 
		
		System.out.println();
		System.out.println();
		
		/* WRONG!! PriorityQueue will lose its nature order if accessing with an enhanced-loop */
		System.out.println("[PriorityQueue - Enhanced Loop]");
		for(int e: queue) {
			System.out.print(e + " ");
		}
		System.out.println();System.out.println();
		
		/* We can use enhanced-loop to access the TreeSet but be careful that the duplicates will disappear */
		System.out.println("[TreeSet - Enhanced Loop]      ");
		for(int e: set) {
			System.out.print(e + " ");
		}
		System.out.println();System.out.println();
		
		/* We should poll the element if we want to keep it's nature order in PriorityQueue
		 * Note that the PriorityQueue will become empty if we poll all the elements out. */
		System.out.println("[PriorityQueue - Poll]");
		while(!queue.isEmpty()){
			System.out.print(queue.poll() + " ");
		}
		System.out.println();System.out.println();
		
		System.out.println("[PriorityQueue - Empty]");
		System.out.println(queue);   //became empty
	}
}
