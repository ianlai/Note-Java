package algo;

/* There are 1000 buckets, one and only one of them contains poison, the rest are filled with water. 
 * They all look the same. If a pig drinks that poison it will die within 15 minutes. 
 * What is the minimum amount of pigs you need to figure out which bucket contains the poison within one hour.
 * Answer this question, and write an algorithm for the follow-up general case.
 * 
 * Follow-up:
 * If there are n buckets and a pig drinking poison will die within m minutes, 
 * how many pigs (x) you need to figure out the "poison" bucket within p minutes? 
 * There is exact one bucket with poison.
 */

public class _458_PoorPigs {

	public static void main(String[] args) {
		_458_PoorPigs obj = new _458_PoorPigs();
		System.out.println(obj.poorPigs(10, 15, 15));  //2 states to represent 10, how many bits? -> 4
		System.out.println(obj.poorPigs(10, 15, 30));  //3 states to represent 10, how many bits? -> 3
		System.out.println(obj.poorPigs(100, 15, 15));  //2^6=64   2^7=128   -> 7
		System.out.println(obj.poorPigs(100, 15, 30));  //3^4=81   3^5=243   -> 5
		System.out.println(obj.poorPigs(100, 15, 40));  //3^4=81   3^5=243   -> 5
		System.out.println(obj.poorPigs(5000, 15, 70)); //5^5=3125 5^6=15625 -> 6
	}
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
        int rounds = (int)Math.floor(minutesToTest/minutesToDie)+1;
        int pigs = (int)Math.ceil(Math.log(buckets)/Math.log(rounds));
        return pigs;
    }
}
