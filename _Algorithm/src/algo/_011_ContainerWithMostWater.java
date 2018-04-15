package algo;

import java.util.Arrays;

/* Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 */

public class _011_ContainerWithMostWater {

	public static void main(String[] args) {
		_011_ContainerWithMostWater obj = new _011_ContainerWithMostWater();
		int[] a1 = new int[]{4,7,2,5,1,8,3};
		int[] a2 = new int[]{6,6,4,8,8,2,3,5,2,7};
		int area11 = obj.maxArea(a1);
		int area12 = obj.maxArea2(a1);
		int area21 = obj.maxArea(a2);
		int area22 = obj.maxArea2(a2);
		
		System.out.println(Arrays.toString(a1));
		System.out.println(area11);
		System.out.println(area12);
		
		System.out.println(Arrays.toString(a2));
		System.out.println(area21);
		System.out.println(area22);
	}
	/* O(n): Two pointers from the two ends */ 
    public int maxArea(int[] height) {
        if(height==null || height.length<=1) return 0;
        int n=height.length;
        int max = 0;
        int l=0;
        int r=n-1;
        while(l<r){
            int area = (r-l)*Math.min(height[l], height[r]);
            max = Math.max(max, area);
            
            /* Separate into two cases */ 
            // if(height[l]>=height[r]){
            //     r--;
            // }else{
            //     l++;
            // }  
            
            /* Separtate into three cases (even faster) */
            if(height[l]==height[r]){
                r--; 
                l++;
            }else if(height[l]>height[r]){
                r--;
            }else{
                l++;
            }  
        }
        return max;
    }
    
    /* O(n2): Not fast enough even doing some pruning */ 
    public int maxArea2(int[] height) {
        if(height==null || height.length<=1) return 0;
        int n=height.length;
        int max = 0;
        for(int i=0; i<n; i++){
            int cur = height[i];
            int lastLargerThanCurIndex = i; 
            for(int j=n-1; j>=0; j--){
                if(height[j]>cur){  //cur*w
                    lastLargerThanCurIndex = j;
                    break;
                }else{              //min*w
                    int w = j-i;
                    int h = height[j];
                    max = Math.max(max, w*h);
                }
            }
            max = Math.max(max, (lastLargerThanCurIndex-i)*cur);
        }
        return max;
    }
}