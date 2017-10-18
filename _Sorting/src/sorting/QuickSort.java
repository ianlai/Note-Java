package sorting;

public class QuickSort extends Sort{
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
		while(l<=r){
			while(d[l]<pivot) l++;
			while(d[r]>pivot) r--;
			if(l<=r){
				swap(d, l, r);
				l++;
				r--;
			}
		}
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
