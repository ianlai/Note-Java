package algo;

public class _326_PowerOfThree {

	public static void main(String[] args) {
		
		System.out.println(isPowerOfThree(1162261467));

	}
    public static boolean isPowerOfThree(int n) {
        if(n==0) return false;
        
        int compare = 1;
        while(true){
            if(compare==n) return true;
            compare *= 3;
            if(compare>Integer.MAX_VALUE || compare>n) return false;
        }
    }
    
    public boolean isPowerOfThreeFast(int n) {
        if(n==0) return false;
        int maxPow3         = 1_162_261_467;
        //Integer.MAX_VALUE = 2_147_483_647;
        //  maxPow3 * 3     = 3_486_784_401;
        return (maxPow3 % n == 0 && n > 0); 
    }
}
