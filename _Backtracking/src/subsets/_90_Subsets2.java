package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _90_Subsets2 {

	public static void main(String[] args) {
		_90_Subsets2 obj = new _90_Subsets2();
		int[] arr = new int[]{1,2,2,1,3}; 
		System.out.println(Arrays.toString(arr));
		
		
		System.out.println("=========== subsets1 ===========");
		List<List<Integer>> ll1 = obj.subsets1(arr);
		System.out.println(ll1);
		System.out.println(ll1.size());
		
		/* Same concept as subsetsWithDup2 */ 
		System.out.println("=========== subsets2 ===========");
		List<List<Integer>> ll2 = obj.subsets2(arr);
		System.out.println(ll2);
		System.out.println(ll2.size());
		
		
		List<List<Integer>> lld1 = obj.subsetsWithDup1(arr);
		System.out.println("=========== subsetsWithDup1 ===========");
		System.out.println(lld1);
		System.out.println(lld1.size());
		
		/* Partially understood */ 
		System.out.println("=========== subsetsWithDup2 ===========");
		List<List<Integer>> lld2 = obj.subsetsWithDup2(arr);
		System.out.println(lld2);
		System.out.println(lld2.size());
	}

	public List<List<Integer>> subsets1(int[] nums) {

		/* Iterative */
		if (nums == null || nums.length == 0)
			return null;
		List<List<Integer>> answer = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length; i++) {

			List<List<Integer>> temp = new ArrayList<List<Integer>>();
			for (List<Integer> l : answer) {
				List<Integer> lwithNew = new ArrayList<Integer>(l);
				lwithNew.add(nums[i]);
				temp.add(lwithNew);
			}

			List<Integer> single = new ArrayList<Integer>();
			single.add(nums[i]);
			temp.add(single);

			answer.addAll(temp);
			//System.out.println(i + ": " + answer);
		}
		/* Add empty list */
		answer.add(new ArrayList<Integer>());
		return answer;
	}
	
	//----------------------------------------------------
	/* IMPORTANT */
	/* Same concept with subsetsWithDup2 */
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums==null || nums.length==0) return null;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        dfsNo(nums, 0, cur, ans);
        return ans;
    }
    private void dfsNo(int[] n, int index, List<Integer> cur, List<List<Integer>> ans){
        ans.add(cur);
        for(int i=index; i<n.length;i++){
            List<Integer> next = new ArrayList<>(cur);
            next.add(n[i]);
            //dfsNo(n, index+1, next, ans);  //NO
            dfsNo(n, i+1, next, ans);
        }
    }
	
  //----------------------------------------------------
    
    /* Not dive into it yet */
	public List<List<Integer>> subsetsWithDup1(int[] nums) {
	    Arrays.sort(nums);
	    List<List<Integer>> res = new ArrayList<>();
	    List<Integer> each = new ArrayList<>();
	    helper(res, each, 0, nums);
	    return res;
	}
	public void helper(List<List<Integer>> res, List<Integer> each, int pos, int[] n) {
//		System.out.println("---------");
//		System.out.println("n[" + pos + "]");
//		System.out.println(res);
//		System.out.println(each);
		
	    if (pos <= n.length) {
	        res.add(each);
	    }
	    int i = pos;
	    while (i < n.length) {
	    	//System.out.println("while");
	        each.add(n[i]);
	        helper(res, new ArrayList<>(each), i + 1, n);
	        each.remove(each.size() - 1);
	        i++;
	        while (i < n.length && n[i] == n[i - 1]) {i++;}
	    }
	    return;
	}
	//----------------------------------------------------
	
	/* IMPORTANT */
	/* Partially understood */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
		//System.out.println("---------");
		//System.out.println("n[" + index + "]");

        result.add(path);
        //System.out.println(path);
        //System.out.println(result);

        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
            	//result.add(new ArrayList<>(Arrays.asList(-1))); //for debug
            	continue;
            }
            List<Integer> nPath= new ArrayList<>(path);
            //System.out.println("i: " + i + "^ nPath:" + nPath);
            nPath.add(nums[i]);
            //System.out.println("i: " + i + "v nPath:" + nPath);
            dfs(nums,i+1,nPath,result);
        }
        //System.out.println(result);
    }
}
