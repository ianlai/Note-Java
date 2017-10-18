package containers;


import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapUse {
	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		map.put("dog", 1);
		map.put("cat", 1);
		map.put("lion", 1);
		map.put("fish", 1);
		System.out.println(map.get("iii"));  //null
		
		String ls = "ab cd efg hjiilk ppon";
		for(String s: ls.split(" ")){
			System.out.println(s);
		}
		
		Iterator it = map.entrySet().iterator();
		
		while(it.hasNext()){
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " --- " + pair.getValue());
			System.out.println(pair.getKey().getClass().getName() + " --- " + pair.getValue().getClass().getName());
		}
		
	    add("aa bb ccc dddd ee", "ccc bb ee");
	    
	    //------------------------------------------
		Map<Integer, Integer> mp1 = new HashMap<>();
		//Map<Integer, Integer> mp2 = new Map<>();                        //Map is an interface 
		//Map<Integer, Integer> mp2 = new AbstractMap<Integer,Integer>(); //AbstractMap is an abstract class 
		
		
	}
	
	static Map<String, Integer> magazineMap;
    static Map<String, Integer> noteMap;
	public static void add(String magazine, String note) {        
		magazineMap = new HashMap<String, Integer>();
		noteMap = new HashMap<String, Integer>();
		
        for(String s: magazine.split(" ")){
            System.out.println(s);
            if(!magazineMap.containsKey(s)){
                System.out.println("first added: " + s );
                magazineMap.put(s,1);
                
            }else{
                System.out.println("added: " + s + " " + magazineMap.get(s));
                int count = magazineMap.get(s);
                magazineMap.put(s, count+1);
            }
        }
        System.out.println(magazineMap.size());
        for(String s: note.split(" ")){
            if(noteMap.get(s)==null){
                noteMap.put(s,1);
            }else{
                int count = noteMap.get(s);
                noteMap.put(s, count+1);
            }
        }
        
        System.out.println(noteMap.size());
    }
}
