package sorting;

import java.util.Arrays;

public class _075_SortColors {

	public static void main(String[] args) {
		_075_SortColors obj = new _075_SortColors();
		int[] colors = new int[]{1,2,2,0,1,2,2,0,0,1,2,2,1,1,2,1};
		System.out.println(Arrays.toString(colors));
		obj.sortColors(colors);
		System.out.println(Arrays.toString(colors));

	}
    public void sortColors(int[] nums) {
        int[] count = new int[3];   //<--need to input
        for(int e: nums){
            ++count[e];
        }
        int k=0;
        for(int i=0; i<count.length; ++i){
            while(count[i]!=0){
                nums[k]=i;
                --count[i];
                ++k;
            }
        }
    }
}
