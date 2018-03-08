package sorting;

public class InsertionSort extends Sort{
	public static void main(String[] args){
		Sort obj = new InsertionSort();
		obj.test();
	}

	@Override
	public void sorting() {
		for(int i=1; i<data.length; i++){
			int key = data[i];
			int j=i-1;
			while(j>=0 && data[j]>key){
				data[j+1] = data[j];
				j--;
			}
			data[j+1] = key; 
		}
	}

}
