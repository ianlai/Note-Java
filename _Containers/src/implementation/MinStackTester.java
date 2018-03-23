package implementation;
import java.util.Arrays;
import java.util.Stack;

import implementation.MinStack;
import implementation.MinStackSingleImpl;

/**
 * Your MinStack object will be instantiated and called as such: 
 * MinStack obj = new MinStack(); 
 * obj.push(x); 
 * obj.pop(); 
 * int param_3 = obj.top(); 
 * int param_4 = obj.getMin();
 */

/* Use two stacks to implement (simple) 
 * Check MinStackDoubleImpl.java to discuss more.*/ 

public class MinStackTester{
	public static void main(String[] args) {
		MinStack mss = new MinStackSingleImpl();
		MinStack msd = new MinStackDoubleImpl();
		
		test(mss, false);
		test(msd, false);
		
		mss.clear();
		msd.clear();
		
		test(mss, true);  /* Error! SingleImpl cannot handle duplicates */
		test(msd, true);
	}
	private static void init(MinStack ms){
		int[] arr = new int[]{6,3,5,2,7,1,9,4};
		System.out.println("INPUT: ");
		System.out.println("   " + Arrays.toString(arr));
		for(int e: arr){
			ms.push(e);
		}
		System.out.println();
	}
	
	/* single stack cannot handle multiple number yet */
	private static void inputDuplicate(MinStack ms){
		int[] arr = new int[]{3,1,4,2,5};
		System.out.println("DUP: ");
		System.out.println("   " + Arrays.toString(arr));
		for(int e: arr){
			ms.push(e);
		}
		System.out.println();
	}
	public static void test(MinStack ms, boolean isDup) {
		System.out.println("=====================================");
		System.out.println("===  " + ms.getClass().getSimpleName());
		System.out.println("=====================================");
		
		init(ms);
		System.out.println("After init:");
		ms.print();
		
		if(isDup){
			inputDuplicate(ms);
			System.out.println("After input duplicate:");
			ms.print();
		}
		
		/* Only feasible in MinStackDoubleImpl */
		if(ms instanceof MinStackDoubleImpl && ms.debug==true) {
			((MinStackDoubleImpl) ms).printSize();  //need to cast
		}
		
		ms.printTopAndMin();
		
		dprint(ms, "");
		dprint(ms, "After pop() 5 times: ");
		ms.pop();
		ms.pop();
		ms.pop();
		ms.pop();
		ms.pop();
		if(ms.debug) ms.print();
		
		ms.printTopAndMin();
	}
	private static void dprint(MinStack ms, String msg){
		if(ms.debug)
			System.out.println(msg);
	}
}

