package string;
/*
 * You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.
 * The letters in J are guaranteed distinct, and all characters in J and S are letters. 
 * Letters are case sensitive, so "a" is considered a different type of stone from "A".
 * 
 * Example 1:
 * Input: J = "aA", S = "aAAbbbb"
 * Output: 3
 * 
 * Example 2:
 * Input: J = "z", S = "ZZ"
 * Output: 0
 * 
 * Note:
 * S and J will consist of letters and have length at most 50.
 * The characters in J are distinct.
 */
public class _771_JewelsAndStones {

	public static void main(String[] args) {
		_771_JewelsAndStones obj = new _771_JewelsAndStones();
		String J = "aBbA";
		String S = "ammnoBBbbaAAAmmMMOOwww";
		System.out.println(J);
		System.out.println(S);
		System.out.println(obj.numJewelsInStones(J, S));
	}
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for(int i=0; i<J.length(); i++){
            char jewel = J.charAt(i);
            for(int j=0; j<S.length(); j++){
                char stone = S.charAt(j);
                if(jewel==stone) count++;
            }
        }
        return count; 
    }
}