package array;

import java.util.Arrays;
/*Given an array of 2n integers, 
 * your task is to group these integers into n pairs of integer, 
 * say (a1, b1), (a2, b2), ..., (an, bn) 
 * which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 * 
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 */

public class _561_ArrayPartition1 {

	public static void main(String[] args) {
		_561_ArrayPartition1 obj = new _561_ArrayPartition1();
		int[] arr = new int[]{6,3,1,9,2,5};
		int res = obj.arrayPairSum(arr);
		System.out.println(res);
	}
    public int arrayPairSum(int[] nums) {
        int sum=0;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++){
            if(i%2==0) sum+=nums[i];
        }
        return sum;
    }
}