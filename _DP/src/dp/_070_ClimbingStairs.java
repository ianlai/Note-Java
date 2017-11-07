package dp;

public class _070_ClimbingStairs {

	public static void main(String[] args) {
		_070_ClimbingStairs obj = new _070_ClimbingStairs();
		int a1=10;
		int a2=20;
		System.out.println(a1 + ": " + obj.climbStairs(a1));
		System.out.println(a2 + ": " + obj.climbStairs(a2));
	}
    public int climbStairs(int n) {
        if(n==1) return n;
        
        int a1=1, a2=2; 
        for(int i=3; i<=n; ++i){
            int temp;
            temp=a1+a2;
            a1=a2;
            a2=temp;
        }
        return a2;
    }
}
