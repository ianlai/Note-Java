package sorting;
public class MergeSort extends Sort{
	public static void main(String[] args){
		Sort obj = new MergeSort();
		obj.test();
		
		//MergeSort local = new MergeSort();
		//local.localtest();
	}
	
	@Override
	public void sorting() {
		int[] helper = new int[data.length];
		mergesort(helper, 0, data.length-1);
	}
	
	private void localtest(){
		int[] input = new int[]{5,4,3,2,1};
		data = input;
		int[] helper = new int[data.length];
		System.out.println(data.length);
		System.out.println(helper.length);
		mergesort(helper, 0, data.length-1);
	}
	
	//1. copy to hp array first 
	//2. and copy back to data array in merge function
	//3. the remaining array of the "right" does not need to be copied (because data has it)
	//   the remaining array of the "left" has to copy to data array
	private void mergesort(int[] hp, int l, int h){
		//System.out.println(">>> mergesort: " + l + " " + h);
		if(l<h){
			int m = (l+h)/2;
			mergesort(hp, l, m);
			mergesort(hp, m+1, h);
			merge(hp, l, m, h);
		}
	}
	private void merge(int[] hp, int l, int m, int h){
		//System.out.println("merge: " + l + " " + m + " " + h);
		
		//1. copy to hp array first
		for(int i=0; i<data.length; ++i){
			hp[i] = data[i];
		}
		
		int hleft   = l;
		int hright  = m+1; 
		int current = l;
		
		//2. copy back to data array (merge)
		while(hleft<=m && hright<=h){
			if(hp[hleft] < hp[hright]){    //copy left 
				data[current] = hp[hleft];   
				hleft++;
			}else{
				data[current] = hp[hright]; 
				hright++;
			}
			current++;
		}
		
		//3. remaining left array 
		int remaining = m - hleft;
		for(int i=0; i<=remaining; i++){
			data[current+i] = hp[hleft+i];
		}
		
		//4. remaining right array (do nothing because they are already in data array)
	}
}
