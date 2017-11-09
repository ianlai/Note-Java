package math;

public class _069_Sqrt {

	public static void main(String[] args) {
		_069_Sqrt obj = new _069_Sqrt();
		int x1 = 15; 
		int x2 = 64; 
		int x3 = 1000; 
		System.out.println(obj.mySqrt(x1));
		System.out.println(obj.mySqrt(x2));
		System.out.println(obj.mySqrt(x3));

	}
    public int mySqrt(int x) {
        if(x==0) return 0;
        if(x==1) return 1;
        if(x<0) return -1;
        
        long start = 100;
        int count = 0;
        int overFlag = -1;
        long result = 0;
        while(true){
            if(start*start>x){
                if(overFlag==0){
                    result = --start; 
                    break;
                }
                --start;
                overFlag = 1;
            }else if(start*start<x){
                if(overFlag==1){
                    result = start; 
                    break;
                }
                ++start;
                overFlag = 0;
                if(start>=Integer.MAX_VALUE) {
                    result = --start; 
                    break;
                }
            }else{
                result = start; 
                break;
            }
            ++count;
            if(count>100000) break;
        }
        return (int)result;
    }
}