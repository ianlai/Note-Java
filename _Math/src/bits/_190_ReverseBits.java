package bits;

public class _190_ReverseBits {
	
	/* Reverse bit of unsigned int */
	
	public static void main(String[] args) {
		int n1 = 43261596;
		int n2 = 1;
		int n3 = 0x9000_0000;
		
		_190_ReverseBits obj = new _190_ReverseBits();
		
		obj.test(n1);
		obj.test(n2);
		obj.test(n3);
		
		System.out.println("=====================");
		
		obj.testSigned(n1);
		obj.testSigned(n2);
		obj.testSigned(n3);
		
		System.out.println("Conclusion: Both signed shift and unsigned shift can pass!");
	}
	public void test(int n){
		int r = reverseBits(n);
		
		System.out.println("Input:  " + n); 
		
		System.out.print(String.format("%30s", Integer.toHexString(n))); 
		System.out.print(" ---> ");
		System.out.println(String.format("%10s", Integer.toHexString(r))); 
		
		System.out.println("Output: " + r); 
		System.out.println();
	}
	public void testSigned(int n){
		int r = reverseBits(n);
		
		System.out.println("Input:  " + n); 
		
		System.out.print(String.format("%30s", Integer.toHexString(n))); 
		System.out.print(" ---> ");
		System.out.println(String.format("%10s", Integer.toHexString(r))); 
		
		System.out.println("Output: " + r); 
		System.out.println();
	}
	public int reverseBits(int n) {
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result |= n & 1;
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	    }
	    return result;
	}
	public int reverseBitsWrong(int n) {
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result |= n & 1;
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	        n >>= 1;   // TEST: if use signed shift
	    }
	    return result;
	}
    
}