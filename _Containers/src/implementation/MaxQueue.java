package implementation;

import java.io.*;
import java.util.*;

public class MaxQueue {
	
	static class MQueue {
		Queue<Integer> q1 = new ArrayDeque<>();
		Deque<Integer> q2 = new ArrayDeque<>();

		int mMax = Integer.MIN_VALUE;
		boolean debug = true;

		private void add(int x) {
		}

		private int poll() {
		}

		private int peek() {
		}

		public int getMax() {
			return mMax;
		}
		
		public void printMax(){
			System.out.println(getMax());
		}

		public void print() {
			System.out.println("q1:");
			System.out.println(q1);
			System.out.println("q2:");
			System.out.println(q2);
			System.out.println("max:" + getMax());
			System.out.println("==============");
		}
	}
	// ============================================================

	public static void main(String[] args) throws java.lang.Exception {
		test();
	}
	public static void test(){
		MQueue q = new MQueue();
		q.add(1);
		q.add(2);
		q.add(3);
		
		q.poll();
		q.poll();

		q.add(8);
		q.poll();
		q.add(5);
		
		q.poll();
		q.poll();
		
		q.add(3);
		q.add(7);
		
		q.poll();  
		q.poll();
		
		q.add(6);
	}
}
