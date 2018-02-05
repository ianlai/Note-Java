package algo;

import java.util.HashSet;
import java.util.Set;

public class _202_HappyNumber {

	public static void main(String[] args) {
		_202_HappyNumber obj = new _202_HappyNumber();
		int n1 = 19;
		int n2 = 35;
		int n3 = 41;
		int n4 = 998;
		int n5 = 723;
		
		System.out.println(n1 + "  :" + obj.isHappy(n1));
		System.out.println(n2 + "  :" + obj.isHappy(n2));
		System.out.println(n3 + "  :" + obj.isHappy(n3));
		System.out.println(n4 + " :" + obj.isHappy(n4));
		System.out.println(n5 + " :" + obj.isHappy(n5));
		
		System.out.println("======================");
		
		System.out.println(n1 + "  :" + obj.isHappy2(n1));
		System.out.println(n2 + "  :" + obj.isHappy2(n2));
		System.out.println(n3 + "  :" + obj.isHappy2(n3));
		System.out.println(n4 + " :" + obj.isHappy2(n4));
		System.out.println(n5 + " :" + obj.isHappy2(n5));

	}

    /* Fast-Slow pointers: 2ms (faster) */
    public int digitSquareSum(int n) {
       int sum = 0;
        while (n > 0) {
            sum += (n % 10) * (n % 10);
            n /= 10;
        }
        return sum;
    }
    
    public boolean isHappy2(int n) {
        int slow = n;
        int fast = n;
        while (slow > 1) {
            slow = digitSquareSum(slow);
            fast = digitSquareSum(digitSquareSum(fast));
            if (slow == 1 || fast == 1) return true;
            if (slow == fast) return false; // loop found
        }
        return true;
    }

    //=======================================================================
    /* Set: 4ms */ 
    public boolean isHappy(int n) {
        Set<Integer> used = new HashSet<>();
        int next = 0;
        
        while(true){
            /* Calculate the next number */
            while(n!=0){
                int lsb = n%10;
                n/=10;
                next += lsb*lsb; 
            } 
            //if(used.contains(next)) return false; //This check is not necessary, we can check when doing add
            
            if(next==1) return true; /* Happy number */
            
            /* Go to the next round */
            if(!used.add(next)) return false;
            n=next;
            next=0;
        }
    }
}