package string;

/*
 * 1.     1
 * 2.     11   <-- in 1. there is one 1 
 * 3.     21   <-- in 2. there are two 1
 * 4.     1211 <-- in 3. there are one 2 and one 1
 * 5.     111221
 */
public class _038_CountAndSay {

	public static void main(String[] args) {
		_038_CountAndSay obj = new _038_CountAndSay();
		for(int i=1; i<=20; i++){
			String ans = obj.countAndSay(i);
			System.out.println(String.format("%-5s", i+":") + ans);
		}
	}
    public String countAndSay(int n) {
        if(n==1) return "1";
        
        String target = "1"; 
        for(int i=0; i<n-1 ; i++){
            int count = 1;
            char temp1 = target.charAt(0);
            StringBuilder sb = new StringBuilder();
            for(int j=1; j<target.length(); j++){
                char temp2 = target.charAt(j);
                if(temp1!=temp2){
                    sb.append(count);
                    sb.append(temp1);
                    temp1 = temp2; 
                    temp2 = '\u0000';
                    count = 1;
                }else{
                    count++;
                }
            }
            sb.append(count);
            sb.append(temp1);
            target = sb.toString();
        }
        return target; 
    }
}