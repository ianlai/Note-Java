package permutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/*
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 
 * Given n and k, return the kth permutation sequence.
 * Note:
 * Given n will be between 1 and 9 inclusive.
 * Given k will be between 1 and n! inclusive.
 * 
 * Example 1:
 * Input: n = 3, k = 3
 * Output: "213"
 * 
 * Example 2:
 * Input: n = 4, k = 9
 * Output: "2314"
 */

public class _060_PermutationSequence {

	public static void main(String[] args) {
		_060_PermutationSequence obj = new _060_PermutationSequence();
		
		System.out.println("Method1 (divide)");
		long startTime1 = System.nanoTime();
		System.out.println(obj.getPermutation(5, 27));
		System.out.println(obj.getPermutation(5, 120));
		System.out.println(obj.getPermutation(10, 8000));
		System.out.println(obj.getPermutation(20, 900000));
		long endTime1 = System.nanoTime();
		long elapsedTime1 = TimeUnit.NANOSECONDS.toMillis(endTime1 - startTime1);
		System.out.println("-----------------");
		
		System.out.println("Method2 (linear)");
		long startTime2 = System.nanoTime();
		System.out.println(obj.getPermutation2(5, 27));
		System.out.println(obj.getPermutation2(5, 120));
		System.out.println(obj.getPermutation2(10, 8000));
		System.out.println(obj.getPermutation2(20, 900000));
		long endTime2 = System.nanoTime();
		long elapsedTime2 = TimeUnit.NANOSECONDS.toMillis(endTime2 - startTime2);
		System.out.println("-----------------");
		
		System.out.println("Time-1:" + elapsedTime1);
		System.out.println("Time-2:" + elapsedTime2);
	}
	/* ========================================================================*/
	public String getPermutation(int n, int k) {
		int[] factarr = new int[n];
		factor(factarr);
		List<String> orilist = new ArrayList<>();
		List<String> anslist = new ArrayList<>();
		for(int i=1; i<=n; i++){
			orilist.add(Integer.toString(i));
		}
		/* Initialize the anslist. 
		 * This lets the size of the list become n and lets us be able to set the value */
		for(int i=1; i<=n; i++){
			anslist.add("0");
		}
		for(int i=0; i<n ; i++){
			int divide = (n-i-2>=0) ? factarr[n-i-2]  : 1;
			int outer = ((k-1)/divide)%(n-i);
			anslist.set(i,orilist.get(outer));
			orilist.remove(outer);
		}
		/* Make the String output */
		/* join method is from java 1.8; the parameter needs to be an iterable like list */
		String ans = String.join("", anslist);  
		return ans;
	}
	public void factor(int[] f){
		f[0] = 1;
		for(int i=1; i<f.length; i++){
			f[i]=f[i-1]*(i+1); 
		}
	}	
	/* ========================================================================*/
	/* Backtracking to list all the permutation. Then find it linearly. (slow) */
    public String getPermutation2(int n, int k) {        
        int[] arr = new int[n];
        for(int i=1; i<=n ; i++){
            arr[i-1] = i;
        }
        Set<Integer> set = new LinkedHashSet<>(); //keep the order
        List<List<Integer>> ll = new ArrayList<List<Integer>>();
        int[] param = new int[2];  //count, k
        param[1] = k;
        helper(arr, set, ll, param);
        //System.out.println(ll);
        StringBuilder sb = new StringBuilder();
        List<Integer> ansList = ll.get(k-1); 
        for(int i=0; i<ansList.size(); i++){
            sb.append(ansList.get(i));   
        }
        return sb.toString();
    }
    public boolean helper(int[] arr, Set<Integer> set, List<List<Integer>> ll, int[] param){
        //System.out.println(set);
        if(param[0]==param[1]){
            return true; 
        }
        if(arr.length==set.size()){
            ll.add(new ArrayList(set));
            param[0]++;

        }else{
            for(int e: arr){
                if(set.add(e)){
                    if(helper(arr, set, ll, param)) return true;
                    set.remove(e);
                }
            }
        }
        return false;  //not yet finish
    }
}
