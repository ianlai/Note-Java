package algo;

public class Palindrome {
    public boolean isPalindrome(String s) {
        System.out.println(">>> " + s);
        
        if(s.length()==0) return true;
        int head=0;
        int tail=s.length()-1;
        while(true){
            //if(head>=tail) return true;
            while(head<s.length()-1){
            	char a = s.charAt(head);
                //if(Character.isLetter(a) || Character.isDigit(a)) break; //head points to a letter
            	if(Character.isLetterOrDigit(a)) break; //head points to a letter
                else ++head;
            }
            while(tail>0){
            	char b = s.charAt(tail);
                if(Character.isLetter(b) || Character.isDigit(b)) break; //tail points to a letter
                else --tail;
            }
            System.out.println(">>> head: " + head);
            System.out.println(">>> tail: " + tail);
            
            if(!isSame(s, head, tail)) return false;
            //if(head==tail) return !Character.isLetter(s.charAt(head));
            if(head>=tail) return true;
            
            ++head;
            --tail;
        }  
    }
    private boolean isSame(String s, int h, int t){
    	Character a = s.charAt(h);
        Character b = s.charAt(t);
    	if(Character.isLetter(a) && Character.isLetter(b)){
    		if(Character.toUpperCase(a)!=Character.toUpperCase(b)) return false; //only care this 
    	} else if(Character.isDigit(a) && Character.isDigit(b)){
    		if(a!=b) return false;                                               //only care this 
    	} else if((Character.isDigit(a) && Character.isLetter(b)) || 
    		      (Character.isLetter(a) && Character.isDigit(b))){
    		return false;
    	}
    	return true;
    }
}