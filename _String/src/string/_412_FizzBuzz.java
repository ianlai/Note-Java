package string;

import java.util.ArrayList;
import java.util.List;

public class _412_FizzBuzz {

	public static void main(String[] args) {
		_412_FizzBuzz obj = new _412_FizzBuzz();
		List<String> list = obj.fizzBuzz(15);
		System.out.println(list);
	}

	public List<String> fizzBuzz(int n) {
		List<String> list = new ArrayList<>();
        for(int i=1; i<=n ; i++){
        	String s = null;
        	if(i%3==0){
        		s = "Fizz";
        	}
        	else if(i%5==0){
        		s = "Buzz";
        	}
        	else{
        		s = Integer.toString(i);
        	}
        	if(i%15==0){
        		s = "FizzBuzz";
        	}
        	list.add(s);
        }
        return list;
    }
}
