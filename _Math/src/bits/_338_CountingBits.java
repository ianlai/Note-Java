package bits;

import java.util.Arrays;

/* For num = 5 you should return [0,1,1,2,1,2] */ 

public class _338_CountingBits {

	public static void main(String[] args) {
		_338_CountingBits obj = new _338_CountingBits();
		int n = 20; 
		int[] res = obj.countBits(n);
		
		System.out.println(Arrays.toString(res));
		
		for(int i=0; i<n+1; i++){
			System.out.println(i + " : " + res[i]);
		}
	}
	
    public int[] countBits(int num) {
        int[] r = new int[num+1];
        if(num==0){
            r[0]=0; 
            return r;
        }
        if(num==1){
            r[0]=0; 
            r[1]=1;
            return r;
        }
        r[0]=0;
        r[1]=1;
        
        
        int interval = 1;
        Double intervalIndex = Math.pow(2,interval);    //2
        Double nextIndex     = Math.pow(2,interval+1);  //4
        
        /* INIT:
         * r[0] = 0
         * r[1] = 1
         * i == 2
         * interval      = 1 
         * intervalIndex = 2
         * nextIndex     = 4 
         * ----------------------------------
         * LOOP:
         * r[2] = r[0] + 1
         * r[3] = r[1] + 1 
         * i == 4
         * interval      = 2 
         * intervalIndex = 4
         * nextIndex     = 8 
         * r[4] = r[0] + 1
         * r[5] = r[1] + 1
         * r[6] = r[2] + 1
         * r[7] = r[3] + 1
         * i == 8
         * interval      = 3
         * intervalIndex = 8
         * nextIndex     = 16
         * r[8] = r[0] + 1 
         * ..... 
         */
        
        for(int i=2; i<=num; ++i){
            if(i==nextIndex.intValue()){
                ++interval;
                intervalIndex = Math.pow(2,interval);
                nextIndex     = Math.pow(2,interval+1);
                //System.out.println("*" + i + " " + interval + " " + intervalIndex + " " + nextIndex);
            }
 
            r[i] = r[i-intervalIndex.intValue()] +1;  
            //System.out.println(i + " " + (i-intervalIndex.intValue()));
        }
        return r;
    }

}
