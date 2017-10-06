package increasingSubsequences;
import java.util.List;
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class IncreaseSubsequences {

	public static void main(String[] args) {
		IncreaseSubsequences is = new IncreaseSubsequences();
		int[] nums = new int[]{1,1,2,2,3,4,1,1};
		List<List<Integer>> res = is.findSubsequences(nums);
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
    private void helper(int[] nums, int a, int b, int c, List<Integer> l, Set<List<Integer>> ll){
        if(b==c){
            l.add(nums[a]);
            l.add(nums[b]);
            ll.add(l);
        }else{
            Set<List<Integer>> templl = new HashSet<List<Integer>>();
            for(List<Integer> e : ll){
                List<Integer> newlist = new ArrayList<Integer>(e);
                if(newlist.get(newlist.size()-1) > nums[c]) continue;
                newlist.add(nums[c]);
                templl.add(newlist);
            }
            for(List<Integer> e : templl){
                ll.add(e);
            }
        }
        if(c!=nums.length-1)
            helper(nums, a, b, c+1, l, ll);  
    }
}