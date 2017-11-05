package bits;

import java.util.Arrays;

public class _338_CountingBits {

	public static void main(String[] args) {
		_338_CountingBits obj = new _338_CountingBits();
		int[] res1 = obj.countBits(10);
		System.out.println(Arrays.toString(res1));
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
