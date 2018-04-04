package string;

import java.util.HashMap;
import java.util.Map;

/*
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class _013_RomanToInteger {

	public static void main(String[] args) {
		_013_RomanToInteger obj = new _013_RomanToInteger();
		String s1 = "CMMDXIV";    //2414
		String s2 = "DCCCXLVIII"; //848
		System.out.println(s1 + ": " + obj.romanToInt(s1));
		System.out.println(s2 + ": " + obj.romanToInt(s2));
	}
    public int romanToInt(String s) {
        final int I =    1;
        final int V =    5; 
        final int X =   10;
        final int L =   50;
        final int C =  100;
        final int D =  500;
        final int M = 1000;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', I);
        map.put('V', V);
        map.put('X', X);
        map.put('L', L);
        map.put('C', C);
        map.put('D', D);
        map.put('M', M);
    
        int num = 0;
        for(int i=1; i<s.length(); i++){       //index 0 to index n-2
            char c1 = s.charAt(i-1);
            char c2 = s.charAt(i);
            int n1 = map.get(c1);
            int n2 = map.get(c2);
            if(n1>=n2) num+=n1;
            else num-=n1;
        }
        num+=map.get(s.charAt(s.length()-1));  //index n-1 (last char)
        return num;
    }
}