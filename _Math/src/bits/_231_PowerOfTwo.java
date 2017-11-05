package bits;

public class _231_PowerOfTwo {
	public static void main(String[] args) {
		_231_PowerOfTwo obj = new _231_PowerOfTwo();
		obj.test();
	}
	
	public void test(){
		for(int i=0; i<10; i++){
			System.out.println(String.format("%2s", i) + ":" + isPowerOfTwo(i));
		}	
	}
	
    public boolean isPowerOfTwo(int n) {
    	int numOfOne = 0; 
        while(n>0){
        	if((n&1)==1){
        		numOfOne++;
        	}
        	n>>=1; 
        }
        return numOfOne==1 ? true : false;
    }
}
