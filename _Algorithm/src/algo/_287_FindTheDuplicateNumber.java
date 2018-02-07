package algo;

/*
 * Given an array nums containing n + 1 integers where 
 * each integer is between 1 and n (inclusive), 
 * prove that at least one duplicate number must exist. 
 * Assume that there is only one duplicate number, find the duplicate one.
 * 
 * Note:
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.              <- We cannot use a Set! 
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class _287_FindTheDuplicateNumber {

	public static void main(String[] args) {
		_287_FindTheDuplicateNumber obj = new _287_FindTheDuplicateNumber();
		int[] arr1 = new int[]{4,7,2,6,5,7,3,1};      //n=8,  value=1~7
		int[] arr2 = new int[]{6,4,3,9,2,7,5,1,8,3};  //n=10, value=1~9
		int res1 = obj.findDuplicate(arr1);
		int res2 = obj.findDuplicate2(arr2);
		System.out.println(res1);
		System.out.println(res2);
	}

	/* Effective Index:   3,6,1,5,4,6,2,0
	 * Input Array    :  [4,7,2,6,5,7,3,1]
	 * Its Index      :   0 1 2 3 4 5 6 7
	 * So, the graph will be like (all are indices), 
	 * 0 -> 3 -> 5 -> 6 -> 2 -> 1 -> 6
	 *                             (ring) 
	 * To detect and to find the start of the ring,
	 * we can use the slow-fast points to achieve this. 
	 * 1. Check slow and fast points meet
	 * 2. Slow2 point goes from the start and slow point goes from the meeting point.
	 *    It is the start of the ring when slow meets slow2. 
	 */
	
	/* Find ring */
    public int findDuplicate(int[] nums) {
        if(nums.length==0) return -1;
        int slow = 0;
        int fast = 0;
        while(true){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow==fast) break;
        }
        int slow2 = 0;
        while(true){
            slow  = nums[slow];
            slow2 = nums[slow2];
            if(slow==slow2) return slow;
        }
    }
    
    /* Find ring */
	 public int findDuplicate2(int[] nums) {
	     if(nums.length==0) return -1;
	     int slow = nums[0];
	     int fast = nums[nums[0]];
	     while(true){
	         if(slow==fast) break;
	         slow = nums[slow];
	         fast = nums[nums[fast]];
	     }
	     fast = 0;
	     while(true){
	         if(slow==fast) return slow;
	         slow = nums[slow];
	         fast = nums[fast];
	     }
	 }
}