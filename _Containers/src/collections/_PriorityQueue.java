package collections;

import java.util.Queue;
import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class _PriorityQueue {
	public static void main(String[] args) {
		
		Queue<Integer> queue1 = new PriorityQueue<>();
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
		
		System.out.println("--------------------");
		
		Queue<String> queue2 = new PriorityQueue<>();
		
		//capacity, comparator 
		Queue<String> queue3 = new PriorityQueue<>(10, (String s1, String s2) -> s1.length()-s2.length());
		
		queue2.add("m");
		queue2.add("kkfff");
		queue2.add("dd");
		queue2.add("ccffkkicc");
		queue2.add("ww");
		while(!queue2.isEmpty()){
			System.out.println(queue2.poll());
		}
		
		System.out.println("--------------------");
		
		queue3.add("m");
		queue3.add("kkfff");
		queue3.add("dd");
		queue3.add("ccffkkicc");
		queue3.add("ww");
		while(!queue3.isEmpty()){
			System.out.println(queue3.poll());
		}
	}
}
