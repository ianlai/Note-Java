package array;

import java.util.Arrays;

/*
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 */
public class _189_RotateArray {

	public static void main(String[] args) {
		_189_RotateArray obj = new _189_RotateArray();
		int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
		obj.rotate(arr, 3);
		System.out.println(Arrays.toString(arr));
		obj.rotate(arr, 14);
		System.out.println(Arrays.toString(arr));
	}
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        int[] tmp = new int[n];
        System.arraycopy(nums, 0, tmp, 0, n);
        for(int i=0; i<n-k; i++){
            nums[i+k] = tmp[i];
        }
        for(int i=n-k; i<n; i++){
            nums[i-n+k]=tmp[i];
        }
    }
}