package algo;

import java.util.Random;

public class _326_PowerOfThree {

	public static void main(String[] args) {
		int[] arr = random(20);
		for(int e: arr){
			System.out.print(e + ": ");
			System.out.print(isPowerOfThree1(e) + " -- ");
			System.out.print(isPowerOfThree2(e));
			System.out.println();
		}
	}
	private static int[] random(int n){
		Random rand = new Random();
		int[] arr = new int[n];
		for(int i=0; i<n; i++){
			arr[i] = rand.nextInt();
		}
		arr[n-1] = (int) Math.pow(3, rand.nextInt()%15);
		arr[n-2] = (int) Math.pow(3, rand.nextInt()%15);
		return arr;
	}
    public static boolean isPowerOfThree1(int n) {
        if(n==0) return false;
        while(n%3==0){
            n/=3; 
        }
        return n==1;
    }
    public static boolean isPowerOfThree2(int n) {
        if(n==0) return false;
        int maxPow3         = 1_162_261_467;
        //Integer.MAX_VALUE = 2_147_483_647;
        //  maxPow3 * 3     = 3_486_784_401;
        return (maxPow3 % n == 0 && n > 0); 
    }
}
