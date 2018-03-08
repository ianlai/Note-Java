package sorting;

public class BubbleSort extends Sort{
	public static void main(String[] args){
		Sort obj = new BubbleSort();
		obj.test();
	}
	@Override
	public void sorting(){
		int length=data.length;
		for(int k=length-1; k>0 ;k--){
			for(int j=0; j<k; j++){
				if(data[j]>data[j+1]){
					swap(data,j,j+1);
				}
			}
		}
	}
}
