package combinations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _077_Combinations {

	public static void main(String[] args) {
		_077_Combinations obj = new _077_Combinations();
		List<List<Integer>> ll1 = obj.combine(4,3);
		List<List<Integer>> ll2 = obj.combine(5,2);
		printList(ll1);
		printList(ll2);
	}
	public static void printList(List<List<Integer>> ll) {
		for (int i = 0; i < ll.size(); ++i) {
			System.out.println(String.format("%3s: %s", i, ll.get(i)));
		}
		System.out.println("------------------------");
	}
	
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int[] nums = new int[n];
        boolean [] used = new boolean[n];
        
        /* Initialization (according to the quiz)
         * Ex. n=4 -> [1,2,3,4]  
         */
        for(int i=1; i<=n ;i++){
        	nums[i-1] = i;
        }
        
        /* Special case: Just copy the arr to result */
        if(n==k){
        	for(int e: nums){
        		cur.add(e);
        	}
        	res.add(cur);
        	return res;
        }
        
        /* Normal case: Backtracking is needed */
        backtracking(res, cur, nums, 0, k);
        //backtracking(res, cur, nums, used, k);
        return res;
    }
    
    /* We don't need a used array to record the whole array because combination*/ 
    /* The output will be sorted because the order does not matter */
    private void backtracking(List<List<Integer>> ll, List<Integer> cur, int[] nums, int index, int left){
    	if(left==0){
    		ll.add(new ArrayList<Integer>(cur));
    	}else{
    		for(int i=index; i<nums.length; i++){
    			cur.add(nums[i]);
    			backtracking(ll, cur, nums, i+1, left-1);
    			                            //^ here is important
    			cur.remove(cur.size()-1);
    		}
    	}
    }
    
    /* backtracking function for #47 Permutation2 (for comparison) */
	private void backtrackPermutation2(List<List<Integer>> list, List<Integer> tempList, int[] nums, boolean[] used) {
		if (tempList.size() == nums.length) {
			list.add(new ArrayList<>(tempList));
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (used[i])                                   //skip1: This is the normal permute 
					continue;
				if (i > 0 && nums[i]==nums[i-1] && !used[i-1]) //skip2: Handle duplicates 
					continue;                                  
				used[i] = true;
				tempList.add(nums[i]);
				backtrackPermutation2(list, tempList, nums, used);
				used[i] = false;
				tempList.remove(tempList.size() - 1);
			}
		}
	}
}
