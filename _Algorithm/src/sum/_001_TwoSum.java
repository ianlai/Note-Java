package sum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Points: 
//  1. Return indices, so we need to keep the original array (copy)

public class _001_TwoSum {

	public static void main(String[] args) {
		_001_TwoSum s = new _001_TwoSum();
		int[] n = {3,9,1,15,7};
		
		int[] ans1 = s.twoSum1(n, 24);
		int[] ans2 = s.twoSum2(n, 24);
	
		System.out.println(Arrays.toString(ans1));
		System.out.println(Arrays.toString(ans2));
	}
	
	/* Hashmap: faster */
	public int[] twoSum1(int[] nums, int target){
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();  //(target-num, index) 
		int[] answer = new int[2];
		for(int i=0; i<nums.length; ++i){
			if(map.containsKey(nums[i])){
				answer[0] = i;
				answer[1] = map.get(nums[i]);
			}
			//System.out.println(map);
			map.put(target-nums[i], i);
		}
		return answer;
	}
	
	/* Sorting: slower */
	public int[] twoSum2(int[] nums, int target) {
        int[] sorted = new int[nums.length];
        System.arraycopy(nums,0,sorted,0,nums.length);
        Arrays.sort(sorted);
        int m=0, n=sorted.length-1;
        while(m<n){
            int sum = sorted[m]+sorted[n];
            if(sum<target){
                m++;
            }else if(sum>target){
                n--;
            }else{
                int[] answer = new int[2];
                int m_ori=-1, n_ori=-1;
                for(int i=0;i<nums.length;i++){
                    if(sorted[m]==nums[i]){
                        m_ori=i;
                        break;
                    }
                }
                for(int j=nums.length-1; j>=0; j--){
                    if(sorted[n]==nums[j]){
                        n_ori=j;
                        break;
                    }
                }
                answer[0] = (m_ori < n_ori) ? m_ori : n_ori;
                answer[1] = (m_ori > n_ori) ? m_ori : n_ori;
                return answer; 
            }
        }
        return nums;
    }

}
