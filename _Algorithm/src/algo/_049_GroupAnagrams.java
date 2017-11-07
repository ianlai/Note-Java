package algo;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

//Input: ["star", "rats", "car", "arc", "arts", "foo", "foo"]
//Output: [["star", "rats", "arts"], ["car", "arc"], ["foo"]]

//Note: 
//   (new int[] { 1, 2 }).equals(new int[] { 1, 2 }) //false 
//   map.put(new int[]{1,2}, "aa"); 
//   map.containsKey(new int[]{1,2});   //false again! 
//   https://stackoverflow.com/questions/2627889/java-hashmap-with-int-array
//   >> 1. Use something like List<Integer> that does define equals in terms of the values they contain
//   >> 2. Implement own equals() and hashCode() functions

public class _049_GroupAnagrams {
	public static void main(String[] args) {
		_049_GroupAnagrams obj = new _049_GroupAnagrams();
		String [] input = new String[]{"star", "rats", "car", "arc", "arts", "foo", "foo"};
		List<List<String>> result1 = obj.groupAnagrams(input);
		List<List<String>> result2 = obj.groupAnagramsSlow(input);
		
		System.out.println(result1);  //fast
		System.out.println(result2);  //slow
	}
	public void run(){
		
	}
	/* ========================= Fast ========================= */
    public List<List<String>> groupAnagrams(String[] input) {
    	if(input.length==0) return null;
    	Map<List<Integer>, List<String>> map = new HashMap<List<Integer>, List<String>>();
    	for(String s: input){
    		List<Integer> currentBA = stringToByteArr(s);
    		//System.out.println(s + ": " + currentBA);
    		
    		if(!map.containsKey(currentBA)){
    			map.put(currentBA, new ArrayList<String>(Arrays.asList(s)));  //create a new BA, and add the string into it
    		}else{
    			map.get(currentBA).add(s);  //add the string to an existing BA
    		}
    	}
    	//Transform the map to the output format 
    	List<List<String>> result = new ArrayList<List<String>>();
    	for(Map.Entry<List<Integer>, List<String>> anagram: map.entrySet()){
    		result.add(anagram.getValue());
    		//System.out.println(anagram.getValue());
    	}
        return result;
    }
    List<Integer> stringToByteArr(String s){
    	List<Integer> alpha = new ArrayList<Integer>(Collections.nCopies(26, 0));
    	for(int i=0; i<s.length(); ++i){
            int index = Character.getNumericValue(s.charAt(i)) - 10; 
            alpha.set(index, alpha.get(index)+1);
        }
    	return alpha;
    }
    
    /* ========================= Slow ========================= */

    public List<List<String>> groupAnagramsSlow(String[] input) {
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