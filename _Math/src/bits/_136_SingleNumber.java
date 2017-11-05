package bits;

/* All elements in the array appear TWICE except one element. Find it.*/ 
public class _136_SingleNumber {
	public static void main(String[] args) {
		_136_SingleNumber obj = new _136_SingleNumber();
		int[] arr = new int[]{3,5,5,2,7,6,1,1,3,2,6};
		System.out.println(obj.singleNumber(arr));
	}
    public int singleNumber(int[] nums) {
        int r=0;
        for(int e: nums){
            r ^= e;
        }
        return r;
    }
}
