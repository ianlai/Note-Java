package syntax;
import java.math.BigInteger;
import java.lang.StackTraceElement;
import static java.lang.System.*;

public class _Math {

	public static void main(String[] args) {
		_Math obj = new _Math();
		obj.testMax();
		obj.testNegative();
		obj.testBigNumber();
	}
	private void testBigNumber(){
		printSeparate();
		//long l1 = 12_345_678_987_654_321;   
		long l2 = 12_345_678_987_654_321L;      //Long needs to be explicitly pointed out 
		//long l3 = 155_312_345_678_987_654_321L; //out of long's range
		
		BigInteger b1 = new BigInteger("155312345678987654321"); //convert String to BigInteger 
		BigInteger b2 = new BigInteger("855312345678987654321"); 
		System.out.println("b1   :" + b1);
		System.out.println("b2   :" + b2);
		System.out.println("b1+b2:" + b1.add(b2));
	}
	private void testMax(){
		printSeparate();
		System.out.println(Integer.MAX_VALUE);  //2,147,483,647             (2^31-1 = 10^10)
		System.out.println(Long.MAX_VALUE);     //9,223,372,036,854,775,807 (2^63-1 = 10^19)
		
		System.out.println(Integer.MAX_VALUE+10);  //become negative (overflow)
		if(Integer.MAX_VALUE+10 > Integer.MAX_VALUE){
			System.out.println("Over");
		}else{
			System.out.println("NOT Over");  //cannot detect the overflow
		}
	}
	private void testNegative(){
		printSeparate();
		int i = -2345;
		System.out.println(i%10);  //-5
		System.out.println(i/10);  //-234
	}
	private void printSeparate(){
		//[0]: getStackTrace
		//[1]: printSeparate
		//[2]: the caller's name
		String curr = Thread.currentThread().getStackTrace()[2].getMethodName();
		out.println("--------" + curr + "--------");
	}
}
