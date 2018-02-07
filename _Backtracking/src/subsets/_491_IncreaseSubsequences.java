package subsets;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 * Given an integer array, find all the different possible increasing subsequences 
 * of the given array, and the length of an increasing subsequence should be at least 2.
 * 
 * 1. The length of the given array will not exceed 15.
 * 2. The range of integer in the given array is [-100,100].
 * 3. The given array may contain duplicates, and two equal integers 
 *    should also be considered as a special case of increasing sequence.
 * 
 * Ex. 
 * Input: [4,7,7,2,5,9]
 * Output: [[7,7],[4,5],[4,7,7],[7,9],[4,7],[2,5],[4,7,9],[2,5,9],[5,9],[4,9],[4,5,9],[7,7,9],[2,9],[4,7,7,9]]
 * 
 * Note: Both increasing or equal should be counted. 
 */
public class _491_IncreaseSubsequences {

	public static void main(String[] args) {
		_491_IncreaseSubsequences is = new _491_IncreaseSubsequences();
		int[] nums = new int[]{1,4,7,7,2,5,9};
		
		List<List<Integer>> res = is.findSubsequences(nums);
		
		/* Sorting is not necessary. Just for easier to check the output */
		Comparator<List> sizeComp = (a,b) -> a.size() - b.size();
		Collections.sort(res, sizeComp);
		
		for(List<Integer> l: res){
			System.out.println(l);
		}
	}
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<List<Integer>>();
        int size = nums.length;
        
        for(int i=0; i<size; i++){
            for(int j=i+1; j<size; j++){
                if(nums[i] > nums[j]) continue; 
                
                //System.out.println(nums[i] + " " + nums[j]);
                
                Set<List<Integer>> ll = new HashSet<List<Integer>>();
                
                /* Choose the first two element (nums[i], nums[j]) 
                 * and then find the rest of the elements which is equal to or larger than nums[j]
                 */
                helper(nums, i, j, j, new ArrayList<Integer>(), ll);
                
                //System.out.println(ll);
                //System.out.println();
                for(List<Integer> e: ll){
                    res.add(e);
                }
            }
        }
        List result = new ArrayList(res);
        return result;
    }
    /* a,b,c are the indices ; nums[a] < nums[b] ; starting from b==c and then c++ in each round */ 
    private void helper(int[] nums, int a, int b, int c, List<Integer> l, Set<List<Integer>> ll){
    	
    	/* First round */
        if(b==c){
            l.add(nums[a]);
            l.add(nums[b]);
            ll.add(l);
        }else{
            Set<List<Integer>> templl = new HashSet<List<Integer>>();
            for(List<Integer> e : ll){
            	/* Clone a new list from the list in ll */
                List<Integer> newlist = new ArrayList<Integer>(e);
 
                /* If the last element in newlist larger than nums[c], skip it */
                if(newlist.get(newlist.size()-1) > nums[c]) continue; 
                
                newlist.add(nums[c]);
                templl.add(newlist);
            }
            /* Add the templl back to ll */ 
            for(List<Integer> e : templl){
                ll.add(e);
            }
        }
        /* recursive */
        if(c!=nums.length-1) helper(nums, a, b, c+1, l, ll);  
    }
}