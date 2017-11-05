package bits;

/* Cannot use '+' or '-' operator 
 * Use bit manipulation 
 */
public class _371_SumOfTwoIntegers {

	public static void main(String[] args) {
		_371_SumOfTwoIntegers obj = new _371_SumOfTwoIntegers();
		int x1=15, y1=12; 
		int x2=18, y2=33;
		int ans1 = obj.getSum(x1,y1);
		int ans2 = obj.getSum(x2,y2);
		System.out.println(x1 + " + " + y1 + " = " + ans1);
		System.out.println(x2 + " + " + y2 + " = " + ans2);
	}
	private int getSum(int a, int b){
		int res   = a^b;      //without carry
		int carry = (a&b)<<1; //carry
		if(carry==0){
			return res;
		}else{
			return getSum(res, carry);
		}
	}
}
