package permutations;

import java.util.ArrayList;
import java.util.List;

/* [a,b,c] n=3
 * All combination and permutation to form a n=3 array (redundant is allowed)
 * 1. aaa / bbb / ccc   3
 * 2. aab / aac         3+3
 *    bba / bbc         3+3
 *    cca / ccb         3+3
 * 3. abc               3!=6
 * Total: 3+6+6+6+6=27 
 * 
 * Math Calculation:   3^3=27
 */

public class _AllPermutations {

	public static void main(String[] args) {
		int[] nums1 = new int[]{1,2,3};
		List<List<Integer>> ll1 = allPermutations(nums1);
		for(int i=0; i<ll1.size(); i++){
			System.out.println(i + ": " + ll1.get(i));
		}
	}
	public static List<List<Integer>> allPermutations(int[] nums){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		helper(nums, ans, new ArrayList<Integer>(), 0);
		return ans;
	}
	public static void helper(int[] nums, List<List<Integer>> ll, List<Integer> l, int k){
		if(k==nums.length){
			ll.add(new ArrayList<Integer>(l));
			return;
		}
		for(int i=0; i<nums.length; i++){
			l.add(nums[i]);
			helper(nums, ll, l, k+1);
			l.remove(l.size()-1);
		}
	}
}
