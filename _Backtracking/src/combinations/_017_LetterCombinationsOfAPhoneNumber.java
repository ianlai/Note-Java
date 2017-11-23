package combinations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _017_LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		_017_LetterCombinationsOfAPhoneNumber obj = new _017_LetterCombinationsOfAPhoneNumber();
		List<String> ans1 = obj.letterCombinations("23");
		List<String> ans2 = obj.letterCombinations("458");
		System.out.println(ans1);
		System.out.println(ans2);
	}
    public List<String> letterCombinations(String digits) {
        List<String> ls = new ArrayList<>();
        Map<Integer, String> map = new HashMap<>();
        if(digits==null || digits.length()==0) return ls;
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        return backtracking(ls, map, digits, 0);
    }
    private List<String> backtracking(List<String> ls, Map<Integer, String> map, String d, int k){
        if(k==d.length()) return ls;
        //System.out.println(d.charAt(k));
        
        List<String> nls = new ArrayList<>();
        int groupCode = d.charAt(k)-48;
        //System.out.println("GC: " + groupCode);
        String group = map.get(groupCode);
        
        /* still empty */
        if(ls.size()==0){
            for(int i=0; i<group.length(); i++){
                String nstr = Character.toString(group.charAt(i));
                nls.add(nstr);
            }
        }else{       /* not empty */
            for(String s: ls){
                for(int i=0; i<group.length(); i++){
                    String nstr = Character.toString(group.charAt(i));
                    nls.add(s+nstr);
                }
            }
        }
        //System.out.println(nls);
        return backtracking(nls, map, d, k+1);
    }
}