package sum;

import java.util.Arrays;

public class _167_TwoSum2_InputArrayIsSorted {
	
	static _167_TwoSum2_InputArrayIsSorted obj = new _167_TwoSum2_InputArrayIsSorted();
	public static void main(String[] args) {
		
		int[] arr1 = new int[]{1,4,7,9};           int target1 = 8;
		int[] arr2 = new int[]{0,0,5,7};           int target2 = 0;
		int[] arr3 = new int[]{1,2,2,5,6,8,9};     int target3 = 4;
		int[] arr4 = new int[]{0,2,3,4,5,7,8,8,9}; int target4 = 15;
		int[] arr5 = new int[]{0,2,3,8,9};         int target5 = 7;
		run(arr1, target1);
		run(arr2, target2);
		run(arr3, target3);
		run(arr4, target4);
		run(arr5, target5);
	}
	public static void run(int[] A, int target){
		int[] ans = obj.twoSum(A, target);
		System.out.println(Arrays.toString(ans));
	}
    public int[] twoSum(int[] A, int target) {
        int i=0;
        int j=A.length-1;
        int[] ans = new int[2];
        while(i<j){
            int sum = A[i]+A[j];
            //System.out.println(i + "-" + j);
            if(sum==target){
                ans[0] = i+1;
                ans[1] = j+1;
                return ans;
            }else if(sum>target){
                j--;
            }else{
                i++;
            }
        }
        return null;
    }
}