package combinations;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		System.out.println(combine(2,6));
		
	}
	// return the combinations choosing k from 1~n, that is, nCk 
	public static List<List<Integer>> combine(int n, int k){
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if(n==0) return list;
		if(n==k){
			List<Integer> sub = new ArrayList<Integer>();
			for(int i=1; i<=n; ++i){
				sub.add(i);
			}
			list.add(sub);
		}else{
			List<Integer> sub = new ArrayList<Integer>();
			for(int i=1; i<=n; ++i){
				
			}		
		}
		
		return list;
	}

}
