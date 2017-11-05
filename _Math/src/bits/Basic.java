package bits;

public class Basic {

	public static void main(String[] args) {
		Basic obj = new Basic();
		obj.test_basic();
		obj.test_shift();
		//obj.test_countOne();
	}
	public void test_basic(){
		int x1=  10;
		int x2= -10;
		
		/* show in binary form */
		System.out.println(Integer.toBinaryString(x1));
		System.out.println(Integer.toString(x1,2));
		System.out.println(Integer.toString(x1,8));
		
		/* shift */
		int y1 = x2 << 3;   //signed
		int y2 = x2 >> 3;   //signed
		int y3 = x2 >>> 3;  //unsigned right shift 
		
		System.out.println("x2: " + Integer.toString(x2,2));
		System.out.println("y1: " + Integer.toString(y1,2));
		System.out.println("y2: " + Integer.toString(y2,2));
		System.out.println("y3: " + Integer.toString(y3,2));
		
		/* input binary form */
		int b1 = 0b01001; 
		System.out.println(b1);
		System.out.println(Integer.toString(b1,2));
	}
	public void test_shift(){
		int b1 = -0b1001110001100;
		int t1 = b1; 
		int t2 = b1; 
		System.out.println("["+ t1 + "]");
		while(t1!=0){
			System.out.println(Integer.toBinaryString(t1));
			t1>>>=1;
		}
		/* This will NOT stop (signed shift) */
		/*
		System.out.println("["+ t2 + "]");
		while(t2!=0){
			System.out.println(Integer.toBinaryString(t2));
			t2>>=1;
		}
		*/
	}
	public void test_countOne(){
		for(int i=0; i<20; i++){
			System.out.println(String.format("%2s", i) + ":" + countOne(i));
		}	
	}
	
	//--------------------------------------
	
	/* One '1' will be removed from the left each time*/ 
	int countOne(int n) {
		int count = 0;
	    while(n!=0) {
	        n = n&(n-1);
	        count++;
	    }
	    return count;
	}
}
