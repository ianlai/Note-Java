package algo;
import java.util.List;
import java.util.ArrayList;

//Input: ["star", "rats", "car", "arc", "arts", "foo", "foo"]
//Output: [["star", "rats", "arts"], ["car", "arc"], ["foo"]]


public class _49_GroupAnagrams_slow {
	public void run(){
		String [] input = new String[]{"star", "rats", "car", "arc", "arts", "foo", "foo"};
		List<List<String>> result = groupAnagrams(input);
		
		System.out.println(result);
		//System.out.println(isSameAnagram("bca", "cab"));
	}
    public List<List<String>> groupAnagrams(String[] input) {
        List<List<String>> result = new ArrayList<List<String>>();
        List<String> list = new ArrayList<String>();
        list.add(input[0]);
        result.add(list);
        
        for(String e: input){
            for(List<String> l: result){
                if(isSameAnagram(l.get(0), e)){
//                     boolean has = false;
//                     for(String existing: l){
//                         if(e.equals(existing)){
//                           has = true; 
//                         }
//                     }
//                     if(has==false) 
                    l.add(e);
                }else{
                    List<String> temp = new ArrayList<String>();
                    temp.add(e);
                    result.add(temp);
                    break;
                }
            }
        }
        return result;
    }
    boolean isSameAnagram(String a, String b){
        byte[] alpha = new byte[26];
        byte[] alpha2 = new byte[26];
        
        for(byte e: alpha){
            e = 0;
        }
        //a->10
        for(int i=0; i<a.length(); ++i){
            int index = Character.getNumericValue(a.charAt(i)) - 10;
            alpha[index]++;
        }
        for(int i=0; i<b.length(); ++i){
            int index = Character.getNumericValue(b.charAt(i)) - 10;  
            alpha2[index]++;  
        }
        //for comparison
        for(int i=0; i<alpha.length; ++i){
            if(alpha[i] != alpha2[i])
                return false;
        }
        return true; 
    }
}