package algo;

import java.util.HashMap;
import java.util.Map;

/* Many ways can do this. Here I use the hashmap. */
public class _169_MajorityElement {

	public static void main(String[] args) {
		_169_MajorityElement obj = new _169_MajorityElement();
		int[] arr = new int[]{5,1,5,5,4,5,4,1,5,5};
		System.out.println(obj.majorityElement(arr));
	}

    public int majorityElement(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int half = nums.length/2; 
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; ++i){
            if(map.containsKey(nums[i])){
                int n = nums[i];
                int count = map.get(n);
                if(count+1>half) return n;
                map.put(n, count+1);
            }else{
                map.put(nums[i], 1);
            }
        }
        return -1;
    }
}
