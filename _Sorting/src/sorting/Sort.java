package sorting;

import java.util.Arrays;

public abstract class Sort {
	int[] data;
	abstract public void sorting();
	public void putData(int[] d){
		data = d;
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
}
