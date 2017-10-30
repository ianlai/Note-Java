package combinations;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class _77_Combinations {

	public static void main(String[] args) {
		_77_Combinations obj = new _77_Combinations();
		List<List<Integer>> ll = obj.combine(4,3);
		printList(ll);
	}
	public static void printList(List<List<Integer>> ll) {
		for (int i = 0; i < ll.size(); ++i) {
			System.out.println(i + 1 + ": " + ll.get(i));
		}
		System.out.println("------------------------");
	}
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int[] nums = new int[n];
        boolean [] used = new boolean[n];
        for(int i=1; i<=n ;i++){
        	nums[i-1] = i;
        }
        /* special case */
        if(n==k){
        	for(int e: nums){
        		cur.add(e);
        	}
        	res.add(cur);
        	return res;
        }
        /* normal case */
        backtracking(res, cur, nums, 0, k);
        //backtracking(res, cur, nums, used, k);
        return res;
    }
    //private void backtracking(List<List<Integer>> ll, List<Integer> cur, int[] nums, boolean[] used, int left){
    private void backtracking(List<List<Integer>> ll, List<Integer> cur, int[] nums, int index, int left){
    	if(left==0){
    		ll.add(new ArrayList<Integer>(cur));
    	}else{
    		for(int i=index; i<nums.length; i++){
    			//if(used[i]==true) continue;
    			cur.add(nums[i]);
    			//used[i] = true;
    			//backtracking(ll, cur, nums, index+nums[i], left-1);
    			//backtracking(ll, cur, nums, index+1, left-1);
    			backtracking(ll, cur, nums, nums[i], left-1);
    			                            //^ here is important
    			cur.remove(cur.size()-1);
    			//used[i] = false;
    		}
    	}
    }

}
