package algo;
import java.util.Arrays;
import java.util.Comparator;

public class _179_LargestNumber {

	public static void main(String[] args) {
		_179_LargestNumber sol = new _179_LargestNumber();
		String s = sol.largestNumber(new int[]{999999998,999999997,999999999});
		System.out.println(s);
	}
	
    public String largestNumber(int[] nums) {
        //Integer[] numsObject = ArrayUtils.toObject(nums);
        
        Integer[] numsObject = new Integer[nums.length];
        for(int i=0; i<nums.length; i++){
            numsObject[i] = nums[i];
        }
        
        Comparator<Integer> c = new Comparator<Integer>(){
            @Override
            public int compare(Integer n1, Integer n2){
                String s1 = n1 + "" + n2; 
                String s2 = n2 + "" + n1;
                System.out.println(s1);
                System.out.println(s2);
                return (int) (Long.parseLong(s2) - Long.parseLong(s1));
            }
        };
        
        Arrays.sort(numsObject, c);
        StringBuilder sb = new StringBuilder();
        for(Integer e: numsObject){
            sb.append(e + ", " );
        }
        return sb.toString();
    }
}