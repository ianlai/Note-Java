package algo;

public class _287_FindTheDuplicateNumber {

	public static void main(String[] args) {
		_287_FindTheDuplicateNumber obj = new _287_FindTheDuplicateNumber();
		int[] arr = new int[]{4,7,2,6,5,7,9,1};
		int res = obj.findDuplicate(arr);
		System.out.println(res);
	}

    public int findDuplicate(int[] nums) {
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