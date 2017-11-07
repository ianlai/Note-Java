package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class _018_4Sum {

	public static void main(String[] args) {
		//int[] arr = {1, 0, -1, 0, -2, 2};
		//int target = 0;
		
		//int[] arr = {-1,0,1,2,-1,-4};
		//int target = -1;
		
		int[] arr = {-1,0,-5,-2,-2,-4,0,1,-2};
		int target = -9;
				
		long startTime1 = System.nanoTime();
		List<List<Integer>> answer1 = fourSum(arr, target);
		System.out.println("Quesion: " + Arrays.toString(arr) + " target: " + target);
		System.out.println("Answer : " + answer1);
		long endTime1 = System.nanoTime();
		long elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		System.out.println("Elapsed time (ms): " + elapsedTime1);
	}
    public static List<List<Integer>> fourSum(int[] a, int t1) {
    	int size = a.length;
    	List<List<Integer>> ans = new ArrayList<List<Integer>>();
    	Arrays.sort(a);
    	//System.out.println(Arrays.toString(a));
    	for(int i=0; i<size; ++i){
    		if(i>0 && a[i-1]==a[i]) continue;
    		int t2 = t1-a[i];
    		for(int j=i+1; j<size; ++j){
    			//System.out.println(">" + i + " "+ j + " t2: " + t2);
    			if(j>i+1 && a[j-1]==a[j]) continue;
    			int m = j+1;
    			int n = size-1;
    			while(m<n){
    				int sum = a[j] + a[m] + a[n];
    				if(sum>t2){
    					--n;
    				}else if (sum<t2){
    					++m;
    				}else{
    					//System.out.println(">>" + i + " "+ j + " " + m + " " + n);
    					List<Integer> temp = new ArrayList<Integer>();
    					temp.add(a[i]);
    					temp.add(a[j]);
    					temp.add(a[m]);
    					temp.add(a[n]);
    					ans.add(temp);
    					--n;
        				++m;
        				while(a[m-1]==a[m] && m<size-1) ++m;
        				while(a[n]==a[n+1] && n>0) --n;
    				}
    			}
    		}
    	}
    	return ans;
    }
}
