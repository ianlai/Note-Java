package algo;

import java.util.Map;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class _347_TopKFrequentElements {

	public static void main(String[] args) {
		int[] nums = new int[]{4,5,7,2,3,1,2,2,3,3,1,1,2,4,5,6,2,3,4,5,7,2,9};
		int k = 4;
		
		System.out.println("Original:");
		System.out.println(Arrays.toString(nums));
		System.out.println("=================");
		
		List<Integer> l = topKFrequent(nums, k);
		
		System.out.println("Top K Frequent:");
		System.out.println(l);
	}

    public static List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length==0 || k==0) return null;
        Map<Integer, Integer> hm = new HashMap<>();
        TreeMap<Integer, List<Integer>> tm = new TreeMap<>();
        List<Integer> ans = new ArrayList<>();
        
        /* Scan the original array, calculate the frequency, put into a hashmap <element, freq> */
        for(int i=0; i<nums.length; ++i){
            if(hm.containsKey(nums[i])){
                hm.put(nums[i], hm.get(nums[i])+1); //existed 
            }else{
                hm.put(nums[i], 1);                 //just added 
            }
        }
        
        System.out.println("Calculation:");
        System.out.println(hm);
        System.out.println("=================");
        
        /* Iterate the hashmap, put into a treemap <freq, element list> */
        for(int key: hm.keySet()){
            int freq = hm.get(key);
            int value = key;
            if(tm.containsKey(freq)){
                tm.get(freq).add(value);
            }else{
                List<Integer> l = new ArrayList<>();
                l.add(value);
                tm.put(freq, l);
            }
        }
        System.out.println("Sorted freq:");
        System.out.println(tm);
        System.out.println("=================");
        
        /* Get the element from treemap's tail (last) */
        
        /* Sol-1: use addAll(), it sometimes will input too many elements */
//        while(ans.size()<k){
//            List<Integer> l = tm.pollLastEntry().getValue();
//            if(l!=null) ans.addAll(l);
//        }
        
        /* Sol-2: use add() */
         Map.Entry<Integer, List<Integer>> p ;
         while(k>0){
             p = tm.pollLastEntry();
             List<Integer> l = p.getValue();
             for(int j=0; j<l.size();++j){
                 ans.add(l.get(j));
                 k--;
                 if(k==0) return ans;
             }            
         }
        return ans;   
    }
}