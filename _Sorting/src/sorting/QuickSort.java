package sorting;

import java.util.Arrays;
/* 
 * Note: pivot is only a value, the index of pivot means nothing. 
 * 
 * round0 : [5, 8, 2, 7, 1, 4, 7, 2, 9, 3, 5, 2, 4]
 * 	 pivot: 7 (value)          ^
 * round1 : [5, 4, 2, 2, 1, 4, 5, 2, 3, 9, 7, 7, 8] 
 *                                      ^ 
 *          <-------------------------> <-------->
 *                less than pivot       greater or equals to pivot 
 *   index: 9 (index) 
 *   round2-1: sorting(0, 9-1)
 *   round2-2: sorting(9, 12)
 */

public class QuickSort extends Sort{
	public static void main(String[] args) {
		Sort obj = new QuickSort();
		obj.test();
	}
	@Override
	public void sorting(){
		sorting1(data, 0, data.length-1);
	}
	public void sorting1(){
		sorting1(data, 0, data.length-1);
	}
	public void sorting2(){
		sorting2(data, 0, data.length-1);
	}
	
	//Implementation1 - CTCI
	private void sorting1(int[] d, int start, int end){
		//System.out.println(start + " - " + end);
		int index = partition1(d, start, end);
		//System.out.println("Index: " + index);
		if(start < index-1){
			sorting1(d, start, index-1);
		}
		if(index < end){
			sorting1(d, index, end);
		}
	}
	private int partition1(int[] d, int l, int r){
		//int pivot = d[r];
		int pivot = d[(l+r)/2];
		//System.out.println("Pivot: " + pivot);
		while(l<=r){
			while(d[l]<pivot) l++;
			while(d[r]>pivot) r--;
			if(l<=r){
				swap(d, l, r);
				l++;
				r--;
			}
		}
		/**/
		//for(int i=0; i<data.length; i++){
		//	System.out.println(i + " : " + data[i]);
		//}
		return l;
	}
	
	//---------------------------------------------------------
	
	//Implementation2
	private void sorting2(int[] d, int start, int end){
		if(start<end){
			int pivotIndex = partition2(d, start, end);
			sorting2(d, start, pivotIndex-1);
			sorting2(d, pivotIndex+1, end);
		}
	}
	
	private int partition2(int[] d, int start, int end){
		int pivot = d[end];
		int i, j;
		i = start - 1;
		for(j=start; j<=end-1; j++){
			if(d[j]<=pivot){
				i++;
				swap(d, i, j);
			}
		}
		swap(d, i+1, j);
		return i+1;
	}
}
