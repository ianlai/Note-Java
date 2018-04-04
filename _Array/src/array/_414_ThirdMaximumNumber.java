package array;

/*
 * Given a non-empty array of integers, return the third maximum number in this array. 
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 * 
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * 
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * 
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * 
 */
public class _414_ThirdMaximumNumber {
	public static void main(String[] args) {
		_414_ThirdMaximumNumber obj = new _414_ThirdMaximumNumber();
		int m = Integer.MIN_VALUE;
		int[] a1 = new int[]{7,2,5,9};     //5
		int[] a2 = new int[]{7,7,7,5};     //7
		int[] a3 = new int[]{m,1,2,3,m};   //1
		int[] a4 = new int[]{m,m,5,m};     //5
		System.out.println(obj.thirdMax(a1));
		System.out.println(obj.thirdMax(a2));
		System.out.println(obj.thirdMax(a3));
		System.out.println(obj.thirdMax(a4));
	}
    public int thirdMax(int[] nums) {
        //int m1 = Integer.MIN_VALUE;
        //int m2 = Integer.MIN_VALUE;
        //int m3 = Integer.MIN_VALUE;
        Integer m1 = null;
        Integer m2 = null;
        Integer m3 = null;
        byte diff = 0;
        for(int i=0; i<nums.length; i++){
            int a = nums[i];
            if(m1!=null&&a==m1) continue;
            if(m1==null||a>m1){
                m3=m2;
                m2=m1;
                m1=a;
                continue;
            }
            if(m2!=null&&a==m2) continue;
            if(m2==null||a>m2){
                m3=m2;
                m2=a;
                continue;
            }
            if(m3==null||a>m3){
                m3=a;
                continue;
            }
        }
        return m3!=null ? m3 : m1;
    }
}