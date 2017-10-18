package sorting;

public class BubbleSort extends Sort{
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
