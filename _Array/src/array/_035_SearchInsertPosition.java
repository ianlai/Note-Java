package array;
/*
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 */
public class _035_SearchInsertPosition {

	public static void main(String[] args) {
		_035_SearchInsertPosition obj = new _035_SearchInsertPosition();
		int[] arr1 = new int[]{4,7,13,17,25,38};
		int[] arr2 = new int[]{2,3,6,7,8,10};
		
		System.out.println(obj.searchInsert(arr1, 2));   //0
		System.out.println(obj.searchInsert(arr1, 10));  //2
		System.out.println(obj.searchInsert(arr1, 30));  //5
		
		System.out.println(obj.searchInsert(arr2, 5));   //2
		System.out.println(obj.searchInsert(arr2, 12));  //6
	}
    /* Linear search */ 
    public int searchInsert(int[] nums, int target) {
        if(target<=nums[0]) return 0;
        for(int i=1; i<nums.length; i++){
            if(nums[i-1]<=target && target<=nums[i]) return i;
        }
        return nums.length;
    }
}