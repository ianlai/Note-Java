package sorting;
import java.util.Arrays;
import java.util.Random;
import java.lang.System;
import java.util.concurrent.TimeUnit;
//--- My own package ---
import containers.Heap;

public class Main {
	final static int number = 30000;
	final static int numberRange = 10000;
	final static Random rand = new Random();
	final static boolean debug = false;

	public static void main(String[] args) {

		//int data[] = new int[]{16,53,80,24,1,56,45,57,17,54};
		// int data[] = new int[] { 2, 3, 8, 7, 1, 6, 5 };
		int data[] = new int[number];
		initailize(data);

		// ================================================================

		long startTime1 = System.nanoTime();
		BubbleSort bubblesort = new BubbleSort();
		bubblesort.putData(data.clone());

		System.out.println("-------- Before Bubble Sorting --------");
		if (debug)
			bubblesort.printData(false);
		bubblesort.sorting();

		System.out.println("-------- After Bubble Sorting --------");
		if (debug)
			bubblesort.printData(false);
		long endTime1 = System.nanoTime();

		// ================================================================

		long startTime2 = System.nanoTime();
		QuickSort quicksort = new QuickSort();
		quicksort.putData(data.clone());

		System.out.println("-------- Before Quick Sorting 1--------");
		if (debug)
			quicksort.printData(false);

		quicksort.sorting1();

		System.out.println("-------- After Quick Sorting 1--------");
		if (debug)
			quicksort.printData(false);
		long endTime2 = System.nanoTime();

		// ================================================================

		long startTime3 = System.nanoTime();

		quicksort.putData(data.clone());

		System.out.println("-------- Before Quick Sorting 2--------");
		if (debug)
			quicksort.printData(false);

		quicksort.sorting2();

		System.out.println("-------- After Quick Sorting 2--------");
		if (debug)
			quicksort.printData(false);
		long endTime3 = System.nanoTime();

		// ================================================================

		long startTime4 = System.nanoTime();
		Sort mergesort = new MergeSort();

		mergesort.putData(data.clone());

		System.out.println("-------- Before Merge Sorting --------");
		if (debug)
			mergesort.printData(false);

		mergesort.sorting();

		System.out.println("-------- After Merge Sorting --------");
		if (debug)
			mergesort.printData(false);
		long endTime4 = System.nanoTime();

		// ================================================================

		long startTime5 = System.nanoTime();

		InsertionSort insertionsort = new InsertionSort();
		insertionsort.putData(data.clone());

		System.out.println("-------- Before Insertion Sorting --------");
		if (debug)
			insertionsort.printData(false);

		insertionsort.sorting();

		System.out.println("-------- After Insertion Sorting --------");
		if (debug)
			insertionsort.printData(false);
		long endTime5 = System.nanoTime();
	
		// ================================================================
		
		long startTime6 = System.nanoTime();
		int arr[] = data.clone();
		System.out.println("-------- Before Heap Sorting --------");
		if(debug)
			System.out.println(Arrays.toString(arr));
	
		System.out.println("-------- After Heap Sorting --------");
		Heap.heapsort(arr);
		if(debug)
			System.out.println(Arrays.toString(arr));
		long endTime6 = System.nanoTime();
		
		// ================================================================

		long elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		long elapsedTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
		long elapsedTime3 = TimeUnit.NANOSECONDS.toMillis(endTime3 - startTime3);
		long elapsedTime4 = TimeUnit.NANOSECONDS.toMillis(endTime4 - startTime4);
		long elapsedTime5 = TimeUnit.NANOSECONDS.toMillis(endTime5 - startTime5);
		long elapsedTime6 = TimeUnit.NANOSECONDS.toMillis(endTime6 - startTime6);

		if (!Arrays.equals(bubblesort.data, quicksort.data)) {
			System.out.println("[Error] Sorting result mismatch.");
		}

		System.out.println("Bubble    Sort time    (ms): " + elapsedTime1);
		System.out.println("Quick     Sort-1 time  (ms): " + elapsedTime2);
		System.out.println("Quick     Sort-2 time  (ms): " + elapsedTime3);
		System.out.println("Merge     Sort time    (ms): " + elapsedTime4);
		System.out.println("Insertion Sort time    (ms): " + elapsedTime5);
		System.out.println("Heap      Sort time    (ms): " + elapsedTime6);

	}

	static void initailize(int[] data) {
		for (int i = 0; i < number; i++) {
			data[i] = rand.nextInt(numberRange);
		}
	}
}
