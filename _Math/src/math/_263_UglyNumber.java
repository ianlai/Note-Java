package math;
/*
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * 
 * Note:
 * 1 is typically treated as an ugly number.
 * Input is within the 32-bit signed integer range.
 */
public class _263_UglyNumber {

	public static void main(String[] args) {
		_263_UglyNumber obj = new _263_UglyNumber();
		System.out.println(obj.isUgly(100));    //true
		System.out.println(obj.isUgly(70));     //false
		System.out.println(obj.isUgly(78564));  //false
		System.out.println(obj.isUgly(17280));  //true
	}
    public boolean isUgly(int num) {
        if(num==0) return false;
        if(num==1) return true;
        while(num%2==0){
            num/=2;
        } 
        while(num%3==0){
            num/=3;
        } 
        while(num%5==0){
            num/=5;
        } 
        if(num==1) return true;
        else return false;
    }
}