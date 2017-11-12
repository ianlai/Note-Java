package array;

import java.util.Arrays;

/* Objective: 
 *   Merge the two sorted array into the first array (assume the size is enough).
 */
public class _088_MergeSortedArray {

	public static void main(String[] args) {
		_088_MergeSortedArray obj = new _088_MergeSortedArray();
		int[] arr1 = new int[]{1,4,5,7,0,0,9,9,9};
		int[] arr2 = new int[]{2,3,5,9,11,16};
		int m = 4;  //only care to arr1[m-1] 
		int n = 5;  //only care to arr2[n-1]
		obj.merge(arr1,m,arr2,n);
		System.out.println(Arrays.toString(arr1));
	}

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n==0) return;
        
        /* Create the third array to hold the merged part (not necessary actually) */
        int[] nums3 = new int[m+n];
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        
        /* Merge to nums3[] */
        for(int i=0; i<m+n; i++){
        	
            //System.out.println(i + " " + i1 + " " + i2 + " " + i3);
            if(i1==m){
                nums3[i3] = nums2[i2];
                i2++;
            }else if(i2==n){
                nums3[i3] = nums1[i1];
                i1++;
            }else{
                if(nums1[i1] < nums2[i2] ){
                    nums3[i3] = nums1[i1];
                    i1++;
                }else{
                    nums3[i3] = nums2[i2];
                    i2++;
                }
            }
            i3++;
        }
        
        /* Copy num3[] back to num1[] */
        for(int i=0; i<m+n; i++){
            nums1[i] = nums3[i];
        } 
    }
}