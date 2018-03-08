package sorting;
import java.util.Arrays;
import java.util.Random;
import java.lang.System;
import java.util.concurrent.TimeUnit;
//--- My own package ---
import containers.Heap;

public class Main {
	final static int number = 100000;
	final static int numberRange = 10000;
	final static Random rand = new Random();
	final static boolean debugBefore = false;
	final static boolean debugAfter = false;

	public static void main(String[] args) {
		
		int data[] = new int[number];
		initailize(data);

		// ================================================================

		long startTime1 = System.nanoTime();
		BubbleSort bubblesort = new BubbleSort();
		bubblesort.putData(data.clone());
		
		if (debugBefore){
			System.out.println("-------- Before Bubble Sorting --------");
			bubblesort.printData(false);
		}
			
		bubblesort.sorting();

		System.out.println("-------- After Bubble Sorting --------");
		if (debugAfter)
			bubblesort.printData(false);
		long endTime1 = System.nanoTime();

		// ================================================================

		long startTime2 = System.nanoTime();
		QuickSort quicksort = new QuickSort();
		quicksort.putData(data.clone());

		if (debugBefore){
			System.out.println("-------- Before Quick Sorting 1--------");
			quicksort.printData(false);
		}
		quicksort.sorting1();

		System.out.println("-------- After Quick Sorting 1--------");
		if (debugAfter)
			quicksort.printData(false);
		long endTime2 = System.nanoTime();

		// ================================================================

		long startTime3 = System.nanoTime();

		quicksort.putData(data.clone());

		if (debugBefore){
			System.out.println("-------- Before Quick Sorting 2--------");
			quicksort.printData(false);
		}

		quicksort.sorting2();

		System.out.println("-------- After Quick Sorting 2--------");
		if (debugAfter)
			quicksort.printData(false);
		long endTime3 = System.nanoTime();

		// ================================================================

		long startTime4 = System.nanoTime();
		Sort mergesort = new MergeSort();

		mergesort.putData(data.clone());

		if (debugBefore){
			System.out.println("-------- Before Merge Sorting --------");
			mergesort.printData(false);
		}
		mergesort.sorting();

		System.out.println("-------- After Merge Sorting --------");
		if (debugAfter)
			mergesort.printData(false);
		long endTime4 = System.nanoTime();

		// ================================================================

		long startTime5 = System.nanoTime();

		InsertionSort insertionsort = new InsertionSort();
		insertionsort.putData(data.clone());

		if (debugBefore){
			System.out.println("-------- Before Insertion Sorting --------");
			insertionsort.printData(false);
		}
		insertionsort.sorting();

		System.out.println("-------- After Insertion Sorting --------");
		if (debugAfter)
			insertionsort.printData(false);
		long endTime5 = System.nanoTime();
	
		// ================================================================
		
		long startTime6 = System.nanoTime();
		int arr[] = data.clone();
		
		if(debugBefore){
			System.out.println("-------- Before Heap Sorting --------");
			System.out.println(Arrays.toString(arr));
		}
	
		System.out.println("-------- After Heap Sorting --------");
		Heap.heapsort(arr);
		if(debugAfter)
			System.out.println(Arrays.toString(arr));
		long endTime6 = System.nanoTime();
		
		// ================================================================
		long startTime7 = System.nanoTime();

		Sort selectsort = new SelectSort();
		selectsort.putData(data.clone());

		if (debugBefore){
			System.out.println("-------- Before Select Sorting --------");
			selectsort.printData(false);
		}

		selectsort.sorting();

		System.out.println("-------- After Select Sorting --------");
		if (debugAfter)
			insertionsort.printData(false);
		long endTime7 = System.nanoTime();
	
		// ================================================================

		long elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		long elapsedTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
		long elapsedTime3 = TimeUnit.NANOSECONDS.toMillis(endTime3 - startTime3);
		long elapsedTime4 = TimeUnit.NANOSECONDS.toMillis(endTime4 - startTime4);
		long elapsedTime5 = TimeUnit.NANOSECONDS.toMillis(endTime5 - startTime5);
		long elapsedTime6 = TimeUnit.NANOSECONDS.toMillis(endTime6 - startTime6);
		long elapsedTime7 = TimeUnit.NANOSECONDS.toMillis(endTime7 - startTime7);

		if (!Arrays.equals(bubblesort.data, quicksort.data)) {
			System.out.println("[Error] Sorting result mismatch.");
		}

		System.out.println();
		System.out.println("(1) Bubble    Sort time    (ms): " + elapsedTime1);
		System.out.println("(2) Select    Sort time    (ms): " + elapsedTime7);
		System.out.println("(3) Insertion Sort time    (ms): " + elapsedTime5);
		
		System.out.println("(4) Merge     Sort time    (ms): " + elapsedTime4);
		System.out.println("(5) Heap      Sort time    (ms): " + elapsedTime6);
		System.out.println("(6) Quick     Sort-1 time  (ms): " + elapsedTime2);
		System.out.println("(7) Quick     Sort-2 time  (ms): " + elapsedTime3);
	}

	static void initailize(int[] data) {
		for (int i = 0; i < number; i++) {
			data[i] = rand.nextInt(numberRange);
		}
	}
}
