package bits;

public class _190_ReverseBits {
    // you need treat n as an unsigned value
//    public long reverseBits(long n) {
//        String s = Long.toBinaryString(n);
//        System.out.println(s);
//        int size = s.length();
//        StringBuilder sb = new StringBuilder();
//        for(int i=0; i<size; ++i){
//            sb.append(s.charAt(size-1-i));
//        }
//        String snew = sb.toString();
//        System.out.println(snew);
//        long result = Long.parseLong(snew, 2);
//        return result;
//    }
	
	public static void main(String[] args) {
		
		long l = 4294967295l;
		int result = (new _190_ReverseBits()).reverseBits(123);
		
	}
	public int reverseBits(int n) {
		System.out.println(n);
	    int result = 0;
	    for (int i = 0; i < 32; i++) {
	        result += n & 1;
	        n >>>= 1;   // CATCH: must do unsigned shift
	        if (i < 31) // CATCH: for last digit, don't shift!
	            result <<= 1;
	    }
	    System.out.println(result);
	    return result;
	}
    
}