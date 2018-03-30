package math;

/* Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class _172_FactorialTrailingZeroes {

	public static void main(String[] args) {
		_172_FactorialTrailingZeroes obj = new _172_FactorialTrailingZeroes();
		System.out.println(obj.trailingZeroes(160));
		System.out.println(obj.trailingZeroes(3000));
		System.out.println(obj.trailingZeroes(1_000_000));

		int a1 = Integer.MAX_VALUE/5+100; 
		System.out.println(obj.trailingZeroes(a1));  //overflow if there is no avoiding if-break
	}
    public int trailingZeroes(int n) {
        /* 5, 10, 15, 20, 25, 30, ..., 50, ..,125, ............... 1 
                          25, ......., 50, ..,125, ............... 2
                                              125, ... , 250, .... 3
         */
        int sum = 0;
        int base = 5;
        while(n>=base){
            sum += n/base;
            if(base>Integer.MAX_VALUE/5) break; //overflow will happen
            base*=5;
        }
        return sum;                          
    }
}