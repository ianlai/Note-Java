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

public class _49_GroupAnagrams_fast {
	public void run(){
		String [] input = new String[]{"star", "rats", "car", "arc", "arts", "foo", "foo"};
		List<List<String>> result = groupAnagrams(input);
		
		System.out.println(result);
	}
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
//    public List<List<String>> groupAnagrams(String[] input) {
//    	if(input.length==0) return null;
//    	Map<byte[], List<String>> map = new HashMap<byte[], List<String>>();
//    	for(String s: input){
//    		byte[] currentBA = stringToByteArr(s);
//    		System.out.println(s + ":" +Arrays.toString(currentBA));
//    		
//    		if(!map.containsKey(currentBA)){
//    			map.put(currentBA, new ArrayList<String>(Arrays.asList(s)));  //create a new BA, and add the string into it
//    		}else{
//    			map.get(currentBA).add(s);  //add the string to an existing BA
//    		}
//    	}
//    	//Transform the map to the output format 
//    	List<List<String>> result = new ArrayList<List<String>>();
//    	for(Map.Entry<byte[], List<String>> anagram: map.entrySet()){
//    		//result.add(anagram.getValue());
//    		System.out.println(anagram.getValue());
//    	}
//        return result;
//    }
//    byte[] stringToByteArr(String s){
//    	byte[] alpha = new byte[26];
//    	for(int i=0; i<s.length(); ++i){
//            int index = Character.getNumericValue(s.charAt(i)) - 10;
//            ++alpha[index];
//        }
//    	return alpha;
//    }
}