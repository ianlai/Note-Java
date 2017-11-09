package array;

public class _033_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		_033_SearchInRotatedSortedArray obj = new _033_SearchInRotatedSortedArray();
		int[] arr = new int[]{4,5,6,7,0,1,2};
		int target = 1;
		System.out.println(obj.search(arr, target));
	}
    public int search(int[] nums, int target) {
        if(nums.length==0) return -1;
        for(int i=0; i<nums.length; ++i){
            if(target==nums[i]) return i;
        }
        return -1;
    }
}
