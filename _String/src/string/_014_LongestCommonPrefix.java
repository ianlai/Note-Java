package string;

public class _014_LongestCommonPrefix {

	public static void main(String[] args) {
		_014_LongestCommonPrefix obj = new _014_LongestCommonPrefix();
		String[] strs = new String[]{"aabbcc", "aabzze", "aaaaaaa"};
		String res = obj.longestCommonPrefix(strs);
		System.out.println(res);
	}

    public String longestCommonPrefix(String[] strs) {
        if(strs==null || strs.length==0) return "";
        if(strs.length==1) return strs[0];
        
        StringBuilder sb = new StringBuilder();
        
        /* i-th char */
        for(int i=0; i<strs[0].length(); i++){
            char first = strs[0].charAt(i);
                
            /* j-th String */
            for(int j=1; j<strs.length; j++){
                /* This char does NOT pass the test so return */
                if(i==strs[j].length() || strs[j].charAt(i)!=first){
                    return sb.toString();   
                }
            }
            /* This char passes the test so it can be added into sb*/
            sb.append(first);
        }
        return sb.toString();
    }
}