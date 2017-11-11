package array;

import java.util.Arrays;

public class _238_ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		_238_ProductOfArrayExceptSelf obj = new _238_ProductOfArrayExceptSelf();
		
		int[] arr = new int[]{3,5,9};
		int[] res = obj.productExceptSelf(arr);
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(res));

	}

    public int[] productExceptSelf(int[] nums) {
        int result[] = new int[nums.length];
        
        /* forward */
        result[0]=1;
        for(int i=1; i<nums.length; ++i){
            result[i] = result[i-1] * nums[i-1];
        }

        /* backward */
        int temp = 1;
        for(int i=nums.length-2; i>=0; --i){
            temp *= nums[i+1];
            result[i] *= temp;
        }
        return result;
    }
}