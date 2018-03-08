package sorting;

import java.util.Arrays;
import java.util.Random;

public class CountSort extends Sort{

	public static void main(String[] args) {
		test();
	}
	/* Basic test function */
	public static void test(){
		Sort obj = new CountSort();
		obj.data = new int[20];
		Random rand = new Random();
		for(int i=0; i<20; i++){
			obj.data[i] = rand.nextInt(100);
		}
		System.out.println(Arrays.toString(obj.data));
		obj.sorting();
		System.out.println(Arrays.toString(obj.data));
	}

	@Override
	public void sorting() {
		/* Need to find the max value of data */
		int max = Integer.MIN_VALUE;
		for(int e: data){
			max = Math.max(max, e);
		}
		//System.out.println("MAX:" + max);
		
		/* Create an array which's size equals to the max+1 */ 
		int count[] = new int[max+1];
		
		/* Counting*/
		for(int e: data){
			count[e]++;
		}
		
		/* Set the data array according to the count array */ 
		int index=0; 
		for(int i=0; i<count.length; i++){
			while(count[i]!=0){
				data[index]=i; 
				count[i]--;
				index++; 
			}
		}
		
	}

}
