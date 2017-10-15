import java.util.HashMap;
import java.util.Map;

public class _208_ImplementTrie {
	
	class Trie {
		TrieNode root;
		class TrieNode{
			char c; 
			boolean isLeaf = false;
			HashMap<Character, TrieNode> children = new HashMap<>();
			public TrieNode(){}
			public TrieNode(char c){
				this.c=c;
			}
		}
	    /** Initialize your data structure here. */
	    public Trie() {
	        root = new TrieNode();  //root is empty
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	    	Map<Character, TrieNode> children = root.children;
	    	TrieNode temp = null;
	        for(int i=0; i<word.length();i++){
	        	char c=word.charAt(i);
	        	if(children.containsKey(c)){
	        		temp = children.get(c);
	        	}else{
	        		temp = new TrieNode(c);
	        		children.put(c, temp);
	        	}
	        	children = temp.children; //get the map, not go down 
	        }
	        temp.isLeaf=true;
	    }
	    
	    /** Returns if the word is in the trie. (MUST end at the leaf)*/
	    public boolean search(String word) {
	    	TrieNode t = searchNode(word);
	    	if(t!=null && t.isLeaf) return true;
	    	else return false;
	    }

	    
	    /** Returns if there is any word in the trie that starts with the given prefix.
	     *  NOT necessary to end at the leaf (can end at any leaf) */
	    public boolean startsWith(String prefix) {
	        TrieNode t = searchNode(prefix);
	        if(t!=null) return true;
	        else return false;
	    }
	    
	    public TrieNode searchNode(String word) {
	    	Map<Character, TrieNode> children = root.children;
	    	TrieNode temp = null;
	    	for(int i=0;i<word.length();i++){
	    		char c=word.charAt(i);
	    		if(children.containsKey(c)){
	        		temp = children.get(c);
	        		children = temp.children;
	        	}else{
	        		return null;
	        	}
	    	}
	    	return temp;
	    }
	}

	/**
	 * Your Trie object will be instantiated and called as such:
	 * Trie obj = new Trie();
	 * obj.insert(word);
	 * boolean param_2 = obj.search(word);
	 * boolean param_3 = obj.startsWith(prefix);
	 */


	public static void main(String[] args) {
		_208_ImplementTrie obj = new _208_ImplementTrie();
		obj.run();
	}
	public void run(){
		Trie obj = new Trie();
	
		String word1 = "hello";
		String word2 = "moto";
		String word3 = "yoyo";
		String word4 = "helloian";
		String word5 = "hellomoto";
		String word6 = "motor";
		
		String word11 = "yoy";
		String word12 = "yoyoyo";
		String word13 = "hello";
		String word14 = "moty";

		
		System.out.println("Inserting...");
		obj.insert(word1);
		obj.insert(word2);
		obj.insert(word3);
		obj.insert(word4);
		obj.insert(word5);
		obj.insert(word6);
		
		System.out.println("Searching...");
		System.out.println(obj.search(word11) + "  :" + word11);
		System.out.println(obj.search(word12) + "  :" + word12);
		System.out.println(obj.search(word13) + "  :" + word13);
		System.out.println(obj.search(word14) + "  :" + word14);

		System.out.println("Startwith...");		
		System.out.println(obj.startsWith(word11) + "  :" + word11);
		System.out.println(obj.startsWith(word12) + "  :" + word12);
		System.out.println(obj.startsWith(word13) + "  :" + word13);
		System.out.println(obj.startsWith(word14) + "  :" + word14);

	}

}

