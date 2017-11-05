package bits;

public class _342_PowerOfFour {

	public static void main(String[] args) {
		_342_PowerOfFour obj = new _342_PowerOfFour();
		obj.test_isPowerOfFour();
	}
	
	public void test_isPowerOfFour(){
		for(int i=0; i<70; i++){
			System.out.println(String.format("%2s", i) + ":" + isPowerOfFour(i));
		}	
	}
	
	/* pow(4,1):  4   //100
	 * pow(4,2): 16   //10000
	 * pow(4,3): 64   //1000000   
	 * Rule: one '1' and even number of '0'
	 */
	boolean isPowerOfFour(int n) {
		int count0 = 0;
		int count1 = 0;
		while(n>0){
			if((n&1)==1){
				count1++;  //LSB is 1 
			}else{
				count0++;  //LSB is 0
			}
			n>>=1; 
		}
		return count1==1 && count0%2==0;
	}
}
