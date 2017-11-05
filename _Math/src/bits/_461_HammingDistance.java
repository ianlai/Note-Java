package bits;

public class _461_HammingDistance {

	public static void main(String[] args) {
		_461_HammingDistance obj = new _461_HammingDistance();
		int x1 =  5, y1 =  9;
		int x2 = 35, y2 = 14;
		
		int r1 = obj.hammingDistance(x1, y1);
		int r2 = obj.hammingDistance(x2, y2);
		
		System.out.println(x1 + "---" + y1 + " = "+ r1);
		System.out.println(x2 + "---" + y2 + " = "+ r2);
		
	}
    public int hammingDistance(int x, int y) {
        int t = x^y; 
        int count = 0;
        while(t>0){
        	if((t&1)==1) count++;
        	t>>=1;
        }
        return count;
    }
}
