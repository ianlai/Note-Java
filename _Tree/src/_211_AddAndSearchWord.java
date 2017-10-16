import java.util.HashMap;
import java.util.Map;

/* void addWord(word)
 * bool search(word)
 * 
 * search(word) can search a literal word or a regular expression string containing only letters a-z or '.' 
 * A '.' means it can represent any one letter.
 */


public class _211_AddAndSearchWord {

	public static void main(String[] args) {
		WordDictionary trie = new WordDictionary();
		
		//String[] ss = {"a", "b", "c"};
		//String[] input1 = {"WordDictionary","addWord","addWord","addWord","addWord","addWord","addWord","addWord","addWord","search","search","search","search","search","search","search","search","search","search"];
        //String[] input2 = {[],["ran"],["rune"],["runner"],["runs"],["add"],["adds"],["adder"],["addee"],["r.n"],["ru.n.e"],["add"],["add."],["adde."],[".an."],["...s"],["....e."],["......."],["..n.r"];

//		trie.addWord("bad");
//		trie.addWord("dad");
//		
//		System.out.println(trie.search("bad"));
//		System.out.println(trie.search("da"));
//		System.out.println(trie.search("dad"));
//		
//		System.out.println(trie.search("pad"));
//		System.out.println(trie.search(".ad"));
//		System.out.println(trie.search("..d"));
//		System.out.println(trie.search(".pp"));
		
		trie.addWord("a");
		trie.addWord("ran");
		trie.addWord("rune");
		trie.addWord("runner");
		trie.addWord("runs");
		trie.addWord("add");
		trie.addWord("adds");
		trie.addWord("adder");
		trie.addWord("addee");
		
//		System.out.println(trie.search("r.n"));
//		System.out.println(trie.search("ru.n.e"));
//		System.out.println(trie.search("add"));
//		System.out.println(trie.search("add."));
//		System.out.println(trie.search("adde."));
//		System.out.println(trie.search(".an."));
//		System.out.println(trie.search(".an."));
//		System.out.println(trie.search("...s"));
//		System.out.println(trie.search("....e."));
//		System.out.println(trie.search("....."));
		System.out.println(trie.search("......."));  //null pointer
		System.out.println(trie.search("..n.r"));
	}
}
class WordDictionary {

    TrieNode root;
	class TrieNode{
		Map<Character, TrieNode> dic = new HashMap<>();
		char c; 
		boolean isLeaf = false; 
		TrieNode(){
			
		}
		TrieNode(char c){
			this.c = c ;
		}
	}
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();  //root is empty
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
       Map<Character, TrieNode> cur = root.dic;
		TrieNode t = null;
		for(int i=0; i<word.length();i++){
			char c = word.charAt(i);
			if(cur.containsKey(c)){
				t = cur.get(c);
			}else{
				t = new TrieNode(c);
				cur.put(c, t);  //this node's map 
			}
			cur = t.dic;    //go to next node's map
		}
		t.isLeaf = true; //last node 
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        //System.out.println("===============" + word + "===============");
        Map<Character, TrieNode> cur = root.dic;
		TrieNode t = null;
        return dfs(word, 0, cur);
    }
    boolean dfs(String word, int start, Map<Character, TrieNode> cur){
		TrieNode t = null;

        if(start == word.length()){
            if(cur.size()==0){
                //System.out.println("T1");
                return true; 
            }else{
                //System.out.println("F1");
                return false;
            }
        }
 
        char c = word.charAt(start);   
                
        if(c=='.'){  //dfs
            boolean result = false;
            for(Map.Entry<Character, TrieNode> entry: cur.entrySet()){
			    t = entry.getValue();
                cur = t.dic;
                if(start==word.length()-1 && t.isLeaf){
                    //System.out.println("T-dot");
                    return true;
                }
                if(dfs(word, start+1, cur)) result = true;
            }
            return result; 
                
        }else if(cur.containsKey(c)){
            t = cur.get(c);
            cur = t.dic;    //go to next node's map
            if(start==word.length()-1 && t.isLeaf){
                //System.out.println("T-normal");
                return true;
            }
            return dfs(word, start+1, cur);
        }else{
            //System.out.println("F-nomatch");
            return false;        
        }
	}
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */