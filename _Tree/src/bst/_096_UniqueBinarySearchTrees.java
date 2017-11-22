package bst;

public class _096_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		_096_UniqueBinarySearchTrees obj = new _096_UniqueBinarySearchTrees();
		int n = 5; 
		System.out.println(obj.numTrees(n));
	}
	
    public int numTrees(int n) {
        if(n==0 || n==1) return 1;
        int[] arr = new int[n+1];
        arr[0] = 1;
        arr[1] = 1;
        for(int i=2; i<n+1; i++){
        	for(int j=0; j<i; j++){
        		arr[i]+=arr[j]*arr[i-j-1]; 
        	}
        	//System.out.println(i + " : " + arr[i]);
        }
        return arr[n];
    }
}
