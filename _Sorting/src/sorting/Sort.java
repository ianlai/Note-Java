package sorting;

import java.util.Arrays;
import java.util.Random;

public abstract class Sort {
	int[] data = new int[]{5,8,2,7,1,4,7,2,9,3,5,2,4};
	//int[] data = new int[]{5,4,3,2};
	//int[] data = new int[]{5,4,3,2,1};
	abstract public void sorting();
	public void putData(int[] d){
		data = d;
	}
	public void printData(){
		printData(false);
	}
	public void printData(boolean isIndex){
		if(isIndex){
			for(int i=0; i<data.length; i++){
				System.out.println(i + " : " + data[i]);
			}
		}else{
			System.out.println(Arrays.toString(data));	
		}
	}
	protected void swap(int[] d, int i, int j){
		int temp;
		temp = d[j];
		d[j] = d[i];
		d[i] = temp;
	}
	public void test(){
		System.out.println("[" + this.getClass().getSimpleName() + "]\n");
		System.out.println("Before sorting:");
		printData();
		System.out.println();
		sorting();
		System.out.println("After  sorting:");
		printData();
	}
}
