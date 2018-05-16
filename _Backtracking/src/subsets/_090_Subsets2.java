package subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class _090_Subsets2 {

	public static void main(String[] args) {
		_090_Subsets2 obj = new _090_Subsets2();
		int[] arr = new int[]{1,2,2,1}; 
		System.out.println(Arrays.toString(arr));
		
		/* Comparator by numbers inside */
		//Java7
		Comparator<List<Integer>> numComp = new Comparator<List<Integer>>(){
			@Override
			public int compare(List<Integer> a1, List<Integer> a2) {
				if(a1.size()==a2.size()) {
					StringBuilder sb1 = new StringBuilder();
					for(int e: a1) {
						sb1.append(e);
					}
					StringBuilder sb2 = new StringBuilder();
					for(int e: a2) {
						sb2.append(e);
					}
					return Integer.parseInt(sb1.toString()) - Integer.parseInt(sb2.toString());
				}else {
					return a1.size() - a2.size();
				}
			}
		};
		
		/* Wrong answer */
		System.out.println("=========== subsets1 ===========");
		List<List<Integer>> ll1 = obj.subsets1(arr);
		
		
		/* Wrong answer ; same concept as subsetsWithDup2 */ 
		System.out.println("=========== subsets2 ===========");
		List<List<Integer>> ll2 = obj.subsets2(arr);
		
		/* Correct answer */
		List<List<Integer>> lld1 = obj.subsetsWithDup1(arr);
		System.out.println("=========== subsetsWithDup1 ===========");
		
		/* Correct answer */
		System.out.println("=========== subsetsWithDup2 ===========");
		List<List<Integer>> lld2 = obj.subsetsWithDup2(arr);

		/* Sort the answer by size and numbers (not required, just for easier debugging) */
		Collections.sort(ll1, numComp);
		Collections.sort(ll2, numComp);
		Collections.sort(lld1, numComp);
		Collections.sort(lld2, numComp);
		
		/* Print out */
		System.out.println(ll1);
		System.out.println(ll1.size());
		
		System.out.println(ll2);
		System.out.println(ll2.size());
		
		System.out.println(lld1);
		System.out.println(lld1.size());
		
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
		}
		/* Add empty list */
		answer.add(new ArrayList<Integer>());
		return answer;
	}
	
	//----------------------------------------------------
	/* Backtrack: Same concept with subsetsWithDup2 (IMPORTANT) */
    public List<List<Integer>> subsets2(int[] nums) {
        if(nums==null || nums.length==0) return null;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<>();
        dfsNo(nums, 0, cur, ans);
        return ans;
    }
    private void dfsNo(int[] n, int index, List<Integer> cur, List<List<Integer>> ans){
        ans.add(cur);  /* addAll is not needed because each time we add one list by this line.
         			    * dfsNo is called by 2^size times. 
                        */ 
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
	/* Backtrack: Same concept with subsets2 (IMPORTANT), only added two lines to skip the redundancy */
    public List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        dfs(nums,0,new ArrayList<Integer>(),result);
        return result;
    }
    
    public void dfs(int[] nums,int index,List<Integer> path,List<List<Integer>> result){
        result.add(path);

        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
            	continue;
            }
            List<Integer> nPath= new ArrayList<>(path);
            nPath.add(nums[i]);
            dfs(nums,i+1,nPath,result);
        }
    }
}
