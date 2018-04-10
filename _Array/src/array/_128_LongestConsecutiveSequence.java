package array;

import java.util.HashMap;
import java.util.Map;

/* Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * Your algorithm should run in O(n) complexity.
 */ 

public class _128_LongestConsecutiveSequence {

	public static void main(String[] args) {
		_128_LongestConsecutiveSequence obj = new _128_LongestConsecutiveSequence();
		int[] a1 = new int[]{4,7,15,6,3,16,5,18};                           //3-7   -> 5
		int[] a2 = new int[]{4,7,15,6,6,6,6,3,16,5,18,2,17,19,14,12,13,20}; //12-20 -> 9
 		System.out.println(obj.longestConsecutive(a1));
		System.out.println(obj.longestConsecutive(a2));
	}
    public int longestConsecutive(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        int max = 1;
        for(int e: nums){
            if(map.containsKey(e)) continue; //remove redundant
            if(map.containsKey(e-1) && map.containsKey(e+1)){
                int l = map.get(e-1);
                int r = map.get(e+1);
                int val = l+r+1;
                map.put(e, val);
                map.put(e-l, val);
                map.put(e+r, val);
                max = Math.max(val,max);
            }else{
                if(map.containsKey(e-1)){
                    int l = map.get(e-1);
                    map.put(e, l+1);
                    map.put(e-l, l+1);
                    max = Math.max(l+1,max);
                }else if(map.containsKey(e+1)){
                    int r = map.get(e+1);
                    map.put(e, r+1);
                    map.put(e+r, r+1);
                    max = Math.max(r+1, max);
                }else{
                    map.put(e,1);
                }
            }            
        }
        return max;
    }
}