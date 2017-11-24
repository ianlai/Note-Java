package syntax;

public class _Math {

	public static void main(String[] args) {
		_Math obj = new _Math();
		obj.testMax();
		obj.testNegative();
	}
	private void testMax(){
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
		int i = -2345;
		System.out.println(i%10);  //-5
		System.out.println(i/10);  //-234
	}
}
