package bits;

public class _191_NumberOf1Bits_hammingWeight {
	public static void main(String[] args) {
		System.out.println(hammingWeight(3));     //2
		System.out.println(hammingWeight(8));     //1
		System.out.println(hammingWeight(18));    //2
		System.out.println(hammingWeight(35));    //3
		System.out.println(hammingWeight(33798)); //4
	}
	
    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {
        int count = 0;
        for(int i=0; i<32; ++i){
            int x = n&1;
            if(x==1) ++count;
            n = n>>1;
            if(n==0) break;
        }
        return count;
    }
}
