package stringMath;

import java.util.Arrays;

public class _066_PlusOne {

	public static void main(String[] args) {
		_066_PlusOne obj = new _066_PlusOne();
		int[] arr1 = new int[]{1,2,3};
		int[] arr2 = new int[]{5,9,9};
		int[] arr3 = new int[]{9,9,9};
		System.out.println(Arrays.toString(obj.plusOne(arr1)));
		System.out.println(Arrays.toString(obj.plusOne(arr2)));
		System.out.println(Arrays.toString(obj.plusOne(arr3)));

	}

    public int[] plusOne(int[] digits) {
        int round = 0;
        for(int i=digits.length-1; i>=0; i--){
            int r=0;
            if(i==digits.length-1)
                r = digits[i] + 1 + round;
            else
                r = digits[i] + round;
            
            round = (r>=10) ? 1 : 0;
            digits[i] = r%10;
        }
        if(round==1){
            int[] res = new int[digits.length+1];
            res[0] = 1;
            for(int i=0; i<digits.length; i++){
                res[i+1] = digits[i];
            }
            return res;
        }else{
            return digits;
        }
    }
}