package permutations;

import java.util.ArrayList;
import java.util.List;

public class _022_GenerateParentheses {

	public static void main(String[] args) {
		_022_GenerateParentheses obj = new _022_GenerateParentheses();
		
		List<String> list = obj.generateParenthesis(3);
		System.out.println(list.size());
		System.out.println(list);
		
		list = obj.generateParenthesis(4);
		System.out.println(list.size());
		System.out.println(list);
		
		list = obj.generateParenthesis(5);
		System.out.println(list.size());
		System.out.println(list);
	}
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, n, "", 0, 0);
        return list;
    }
    private void helper(List<String> list, int n, String str, int l, int r){
        if(str.length()==n*2){
            list.add(str);
            return;
        }
        if(l<n){  //left < max   (left bracket cannot be put more than n)
            helper(list, n, str+"(", l+1, r);
        }
        if(r<l){  //right < max  (right bracket can be put only when there are corresponding left bracket)
            helper(list, n, str+")", l, r+1);
        }
        return;
    }
    /*
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        Set<String>  cur = new HashSet<>();
        Set<String>  tmp = new HashSet<>();
        
        if(n==0) return ans;
        cur.add("()");  //1
        ans.add("()");
        if(n==1) return ans;
        
        for(int i=2; i<=n; i++){
            tmp = new HashSet();
            for(String s: cur){
                tmp.add("()"+s);
                tmp.add(s+"()");
                tmp.add("("+s+")");
            }    
            cur = tmp; 
        }
        //System.out.println(cur);
        ans = new ArrayList<>(cur);
        return ans;
    }
    */
}