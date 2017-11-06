package bits;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _260_SingleNumber3 {

	public static void main(String[] args) {
		_260_SingleNumber3 obj = new _260_SingleNumber3();
		int[] arr = new int[] {2,3,5,6,3,1,2,5,4,6,8,4}; // [1,8]
		int[] ans = obj.singleNumber(arr);
		System.out.println(Arrays.toString(ans)); 
	}
	public int[] singleNumber(int[] nums){
	
		/* 1. Find the xor value of the single two */
		int xor = _singleNumber(nums);
		
		/* 2. Find the rightest set bit (1-bit) of the xor value*/
		int index = _findRightOne(xor);
		
		List<Integer> bitSetList = new ArrayList<>();
		List<Integer> bitUnsetList = new ArrayList<>();
		
		/* 3. Separate the elements into two group based on whether 
		 *    the index-bit is set (1) or not (0) 
		 */
		for(int i=0; i<nums.length; i++){
			if(_indexBitSet(nums[i], index)){
				bitSetList.add(nums[i]);
			}else{
				bitUnsetList.add(nums[i]);
			}
		}
		
		int[] ans = new int[2];
		int[] bitSetArr = new int[bitSetList.size()];
		int[] bitUnsetArr = new int[bitUnsetList.size()];
		for(int i=0; i<bitSetList.size(); i++){
			bitSetArr[i] = bitSetList.get(i);
		}
		for(int i=0; i<bitUnsetList.size(); i++){
			bitUnsetArr[i] = bitUnsetList.get(i);
		}
		
		/* 4. Do the find single number to the two arrays, and
		 *    we can find the two numbers from the two arrays respectively.
		 */
		ans[0] = _singleNumber(bitSetArr);
		ans[1] = _singleNumber(bitUnsetArr);
		return ans;
	}
	private boolean _indexBitSet(int n, int index){
		n>>=index;
		return (n&1)==1 ? true : false;
	}
	private int _findRightOne(int n){
		int count = 0;  //index from right
		while(n>0){
			if((n&1)==0){
				count++;
			}else{
				return count;
			}
			n>>=1;
		}
		return -1; 
	}
	private int _singleNumber(int[] nums){
		int res = 0;
		for(int e: nums){
			res^=e;
		}
		return res; 
	}
}
