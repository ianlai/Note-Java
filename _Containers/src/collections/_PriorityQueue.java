package collections;

import java.util.PriorityQueue;

public class _PriorityQueue {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue1 = new PriorityQueue<>();
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
		
		PriorityQueue<String> queue2 = new PriorityQueue<>();
		
		//capacity, comparator 
		PriorityQueue<String> queue3 = new PriorityQueue<>(10, (String s1, String s2) -> s1.length()-s2.length());
		
		queue2.add("aab");
		queue2.add("kkfff");
		queue2.add("dd");
		queue2.add("cccc");
		queue2.add("aa");
		while(!queue2.isEmpty()){
			System.out.println(queue2.poll());
		}
		
		System.out.println("--------------------");
		
		queue3.add("aab");
		queue3.add("kkfff");
		queue3.add("dd");
		queue3.add("cccc");
		queue3.add("aa");
		while(!queue3.isEmpty()){
			System.out.println(queue3.poll());
		}
	}
}
