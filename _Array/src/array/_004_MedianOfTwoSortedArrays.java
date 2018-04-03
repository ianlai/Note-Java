package array;

import java.util.Arrays;

/*
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 * 
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 */
public class _004_MedianOfTwoSortedArrays {

	public static void main(String[] args) {
		_004_MedianOfTwoSortedArrays obj = new _004_MedianOfTwoSortedArrays();
		int[] A1 = new int[]{1,2,3};
		int[] A2 = new int[]{4,5,6,7,8,9};
		int[] A3 = new int[]{2,4,5,16,27,39};
		int[] A4 = new int[]{7,8,19,22};
		
		obj.test(A1, A2);
		obj.test(A1, A4);
		obj.test(A2, A3);
		obj.test(A3, A4);
	}
	private void test(int[] A, int[] B){
		System.out.println(Arrays.toString(A));
		System.out.println(Arrays.toString(B));
		System.out.println(findMedianSortedArrays(A, B));
		System.out.println();
	}
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int p=m+n;
        int half=p/2;
        int mod =p%2;
        
        int[] combine = new int[p];
        int i=0;
        int j=0;
        int k=0;
        
        /* If we use this condition, it will leaf loop when either of them finish.
          (this is not correct if it does not yet reaching (m+n/2) )*/
        //while(i<m && j<n && k<p){  
        while(k<p){
            if(i==m){        //nums1 finished 
                combine[k] = nums2[j];
                j++;
            }else if(j==n){  //nums2 finished 
                combine[k] = nums1[i];
                i++;
            }else{           //either of them not finished yet 
                
                /* put nums2[j] into array */
                if(nums1[i]>nums2[j]){
                    combine[k] = nums2[j];
                    j++;
                /* put nums1[i] into array */
                }else{
                    combine[k] = nums1[i];
                    i++;
                }
            }
            k++; 
            
            if(k==half+1 && mod==0){
                return (double)(combine[k-1]+combine[k-2])/2;  //cast to double is necessary, or it will be round down
            }
            if(k==half+1 && mod==1){
                return combine[k-1];
            }
        }
        return -1; //never fall to here   
    }
}