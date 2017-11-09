package math;

public class _007_ReverseInteger {

	public static void main(String[] args) {
		_007_ReverseInteger obj = new _007_ReverseInteger();
		int n1 = 12345;
		int n2 = 150;
		int n3 = -580;
		System.out.println(obj.reverse(n1));
		System.out.println(obj.reverse(n2));
		System.out.println(obj.reverse(n3));
	}

    public int reverse(int x) {
        if(x==0) return 0;
        int sign = x>0 ? 1 : -1;
        
        int[] arr = new int[10];
        int result = 0;
        int digit = 0;
        for(int i=0;i<10;++i){
            arr[i] = x%10;
            x/=10;
            ++digit;
            if(x==0) break;
        }
        //System.out.println(Arrays.toString(arr));
        for(int i=0;i<digit;++i){
            long temp = (long) (arr[i] * Math.pow(10, digit-i-1));
            if(sign==1 && temp > Integer.MAX_VALUE) return 0;
            if(sign==-1 && temp < Integer.MIN_VALUE) return 0;
            result += temp;
        }
        if(sign==1 && result < 0) return 0;
        if(sign==-1 && result > 0) return 0;
        
        return result;
    }
}