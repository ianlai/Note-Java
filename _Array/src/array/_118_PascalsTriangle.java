package array;

import java.util.ArrayList;
import java.util.List;

public class _118_PascalsTriangle {
	public static void main(String[] args) {
		_118_PascalsTriangle obj = new _118_PascalsTriangle();
		System.out.println(obj.generate(5));
		System.out.println(obj.generate(10));
	}
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ll = new ArrayList<>();
        if(numRows==0) return ll;
        
        List<Integer> l = new ArrayList<>();
        l.add(1);
        ll.add(l);
        if(numRows==1) return ll;
        
        //l.clear();
        l = new ArrayList<>();
        l.add(1); 
        l.add(1);
        ll.add(l);
        if(numRows==2) return ll;
        
        for(int i=3; i<=numRows; i++){
            //System.out.println(i + " " + ll.size());
            List<Integer> pre = ll.get(ll.size()-1);
            List<Integer> now = new ArrayList<>();
            now.add(1);
            for(int j=0; j<i-2; j++){
                int t = pre.get(j)+pre.get(j+1);
                now.add(t);
            }
            now.add(1);
            //System.out.println(now);
            ll.add(now);
        }
        return ll;
    }
}