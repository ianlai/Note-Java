package bits;

public class _268_MissingNumber {

	public static void main(String[] args) {
		_268_MissingNumber obj = new _268_MissingNumber();
		int[] arr = new int[]{0,1,2,3,4, 6,7,8,9};
		System.out.println(obj.missingNumber(arr));
	}
    public int missingNumber(int[] nums) {
        int x = 0;
        for(int i=0; i<nums.length; ++i){
            x ^= i ^ nums[i];
        }
        return x ^ nums.length;  //add the last one 
    }
}
