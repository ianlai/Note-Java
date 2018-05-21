package implementation;

import java.io.*;
import java.util.*;

public class CapacityQueue {

	/* Queue with capacity limitation */
	static class MyQueue {
		int mCapacity = 0;
		Queue<String> mQueue = new ArrayDeque<>();

		MyQueue(int capacity) {
			mCapacity = capacity;
		}

		public boolean offer(String s) {
			if (mQueue.size() < mCapacity) {
				mQueue.add(s);
				return true;
			}
			return false;
		}

		public String take() {
			return mQueue.poll();
		}

		public int size() {
			return mQueue.size();
		}
	}

	public static void main(String[] args) throws java.lang.Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();

		int commands = Integer.valueOf(input.split(" ")[0]);
		int size = Integer.valueOf(input.split(" ")[1]);
		// System.out.println("size:" + size);

		/* Initiate the queue */
		MyQueue q = new MyQueue(size);

		/* Read commands */
		while ((input = br.readLine()) != null) {
			String cmd = input.split(" ")[0];

			if (cmd.equals("OFFER")) {
				String data = input.split(" ")[1];
				System.out.println(q.offer(data));
			} else if (cmd.equals("TAKE")) {
				System.out.println(q.take());
			} else if (cmd.equals("SIZE")) {
				System.out.println(q.size());
			} else {
				/* Error case */
				System.out.println("ERROR: Command undefined.");
			}
		}
	}
}
