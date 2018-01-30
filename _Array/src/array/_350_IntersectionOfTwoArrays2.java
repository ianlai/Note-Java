package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/* Given two arrays, write a function to compute their intersection.
 * 
 * Example:
 * Given nums1 = [1, 2, 5, 2, 3, 1], nums2 = [2, 2, 1, 4, 5], return [1, 2, 2, 5].
 * 
 * - Each element in the result should appear as many times as it shows in both arrays.
 * - The result can be in any order.
 */
public class _350_IntersectionOfTwoArrays2 {
	public static void main(String[] args){
		_350_IntersectionOfTwoArrays2 obj = new _350_IntersectionOfTwoArrays2();
		int[] arr1 = new int[]{1,1,2,2,2,3,3,6,7,7,8};
		int[] arr2 = new int[]{2,2,1,1,1,6,6,7,3};
		int[] res  = obj.intersect(arr1, arr2);
		System.out.println("array1:      " + Arrays.toString(arr1));
		System.out.println("array2:      " + Arrays.toString(arr2));
		System.out.println("intersection:" + Arrays.toString(res));
	}
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m1 = new HashMap<>();  //(num, occurrence)
        Map<Integer, Integer> m2 = new HashMap<>();  //(num, occurrence)
        int total = 0; //sum of (num * occurrence) in m2 
        
        /* traverse nums1, calculate the occurrence and put into m1 */
        for(int i=0; i<nums1.length; i++){
            if(m1.containsKey(nums1[i])){
                m1.put(nums1[i], m1.get(nums1[i])+1);  //occurrence++
            }else{
                m1.put(nums1[i], 1);                   //new number
            }
        }
        
        /* traverse nums2, add common element and calculate the common occurrence */
        for(int i=0; i<nums2.length; i++){
            int n = nums2[i];
            if(m1.containsKey(n)){
                if(m2.containsKey(n) && m2.get(n)<m1.get(n)){
                    m2.put(n, m2.get(n)+1);      //occurrence++ 
                    total++;
                }else if(!m2.containsKey(n)){
                    m2.put(n, 1);                //new number
                    total++;
                }else{
                    //m2.get >= m1.get (do nothing)
                }
            }else{
                // m1 doesn't contain n (do nothing) 
            }
        }
        
        /* create answer array */
        int[] ans = new int[total];
        
        /* traverse m2 to put into answer array (enhanced-loop) */
        int i = 0;
        for(Map.Entry<Integer, Integer> e: m2.entrySet()){
            int num = e.getKey();
            int occ = e.getValue();
            for(int j=0; j<occ; j++){
                ans[i] = num;
                i++;
            }
        }
        return ans;
    }
}