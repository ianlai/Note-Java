package string;

import java.util.Stack;

/*
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * 
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 * 
 * Example 1:
 * Input: "()"
 * Output: true
 * 
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 * 
 * Example 3:
 * Input: "(]"
 * Output: false
 * 
 * Example 4:
 * Input: "([)]"
 * Output: false
 * 
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class _020_ValidParentheses {

	public static void main(String[] args) {
		_020_ValidParentheses obj = new _020_ValidParentheses();
		boolean r1 = obj.isValid("[[()]]");   //true
		boolean r2 = obj.isValid("[[(}}}");   //false
		boolean r3 = obj.isValid("]]");       //false
		
		System.out.println(r1);
		System.out.println(r2);
		System.out.println(r3);
	}

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            switch (c){
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                default:
                    if(stack.isEmpty()) return false;
                    char inside = stack.pop();
                    if(c=='}' && inside=='{') continue;
                    if(c==']' && inside=='[') continue;
                    if(c==')' && inside=='(') continue;
                    return false;
            }
        }
        return stack.isEmpty();
    }
}