package array;

import java.util.ArrayList;
import java.util.List;

public class _448_FindAllNumbersDisappearedInAnArray {

	public static void main(String[] args) {
		_448_FindAllNumbersDisappearedInAnArray obj = new _448_FindAllNumbersDisappearedInAnArray();
		int[] arr1 = new int[]{4,5,2,5,1,6,4,3};  //7,8
		int[] arr2= new int[]{1,4,6,7,7,4,2};     //3,5
		
		System.out.println(obj.findDisappearedNumbers(arr1));
		System.out.println(obj.findDisappearedNumbers(arr2));

	}

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums==null || nums.length==0) return ans;
        for(int i=0; i<nums.length; i++){
            int index = Math.abs(nums[i])-1;
            if(nums[index]>0){
                nums[index] = -nums[index];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i]>0){
                ans.add(i+1);
            }
        }
        return ans;
    }
}