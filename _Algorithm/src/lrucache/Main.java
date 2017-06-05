package lrucache;

public class Main {

	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		
		cache.put(1,10);
		cache.put(2,20);
		cache.put(3,30);
		cache.put(4,40);
		cache.print();
		
		cache.put(3,31);
		cache.print();
		
		cache.put(2,21);
		cache.print();
		
		System.out.println(cache.get(4));
		cache.print();
		
		System.out.println(cache.get(1));
		cache.print();
		
		System.out.println(cache.get(3));
		cache.print();
		
		cache.put(5,50);
		cache.print();
	}

}
