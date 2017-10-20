package _Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class TwoArrayIntersection {
	public static void main(String[] args) {
		int[] n1 = new int[]{4,6,1,2,1,2,5,6,2,3,5,2,2,5,6,8,3};
		int[] n2 = new int[]{3,1,0,0,3,2,1,0,12,14,22,5,6,5,3,7,8,3};
		int[] intersection;
		intersection = intersection(n1,n2);
		System.out.println(Arrays.toString(intersection));
	}

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> m1 = new HashSet<Integer>();
        Set<Integer> m2 = new HashSet<Integer>();
        
        for(int i=0; i<nums1.length; ++i){
            m1.add(nums1[i]);
        }
        for(int i=0; i<nums2.length; ++i){
            if(m1.contains(nums2[i])){
                m2.add(nums2[i]);
            }
        }
        int[] ans = new int[m2.size()];
        Iterator<Integer> it = m2.iterator();
        int i=0;
        while(it.hasNext()){
            ans[i]=it.next();
            i++;
        }
        return ans;
    }
}