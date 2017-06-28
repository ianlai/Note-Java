package permutation;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Permutation {
	boolean isDebug = true;
	/* Get all the permutations. Notice that all the input element should be distinct. */
	public List<List<Integer>> getPermutation(int[] arr){
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> input = new ArrayList<Integer>();
		if(arr.length==0) return result;
		for(int e: arr){
			input.add(e);
		}
		permutation(input, 0, result);
		return result;
	}
	private void permutation(List<Integer> arr, int k, List<List<Integer>> list){
		if(k==arr.size()-1){
			List l = new ArrayList(arr);
			//list.add(arr);  //No, we need to create a new list to put into the double list 
			list.add(l);
			return;
		}
		for(int i=k; i<arr.size(); ++i){
			Collections.swap(arr, i, k);
			permutation(arr, k+1, list);
			Collections.swap(arr, k, i);
		}
	}
	private void debug(String s){
		if(isDebug) System.out.println(s);
	}
}
