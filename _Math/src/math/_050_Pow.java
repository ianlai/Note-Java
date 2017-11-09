package math;

public class _050_Pow {

	public static void main(String[] args) {
		_050_Pow obj = new _050_Pow();
		int x = 7;
		int n = 6; 
		System.out.println(obj.myPow(x, n));
	}

    public double myPow(double x, int n) {
		if(n==0) return 1;
		if(n<0){
		    if(n==Integer.MIN_VALUE){
		        n++;
		        x = 1/x;
	    		n = -n;
	    			if(n%2==0){
            			return x*myPow(x*x, n/2);
            		}else{
            			return x*x*myPow(x*x, n/2);
            		}
		    }
            else{    	
        		x = 1/x;
	    		n = -n;
            }
		}
		if(n%2==0){
			return myPow(x*x, n/2);
		}else{
			return x*myPow(x*x, n/2);
		}
    }
}