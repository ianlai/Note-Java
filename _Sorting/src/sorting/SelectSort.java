package sorting;

import java.util.Arrays;
import java.util.Random;

public class SelectSort extends Sort{
	
	public static void main(String[] args) {
		SelectSort obj = new SelectSort();
		obj.test();
	}
	
	@Override
	public void sorting() {
		for(int i=0; i<data.length; i++){
			int min = Integer.MAX_VALUE;
			int min_index = -1; 
			for(int j=i; j<data.length; j++){
				/* Use "if" instead of min() because we need the index */
				if(data[j]<min){
					min = data[j];
					min_index = j;
				}
			}
			swap(data, i, min_index);
		}
	}
}
