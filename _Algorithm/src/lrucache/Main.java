package lrucache;

public class Main {

	public static void main(String[] args) {
		//LRUCache cache = new LRUCache(3);
		//LRUCacheJava cacheJ = new LRUCacheJava(3);
		
		LFUCache fcache = new LFUCache(2);
//		fcache.put(1,10); fcache.print(); 
//		fcache.put(2,20); fcache.print();
//		fcache.put(3,30); fcache.print();
//		fcache.put(2,25); fcache.print();
//		fcache.put(2,25); fcache.print();
//		fcache.put(2,25); fcache.print();
//		fcache.put(1,11); fcache.print();
//		fcache.put(1,11); fcache.print();
//		fcache.put(3,33); fcache.print();
//		fcache.put(4,40); fcache.print();
//		System.out.println(fcache.get(1)); fcache.print();


		
		fcache.put(1,1); fcache.print();
		fcache.put(2,2); fcache.print();
		fcache.get(1); fcache.print();
		fcache.put(3,3); fcache.print();
		fcache.get(2); fcache.print();
		fcache.get(3); fcache.print();
		fcache.put(4,4); fcache.print();
		fcache.get(1); fcache.print();
		fcache.get(3); fcache.print();
		fcache.get(4); fcache.print();
		
//		cache.put(1,10); 
//		cache.put(2,20);
//		System.out.println(cache.get(1));
//		cache.put(3,30);
//		cache.put(4,40);
//		cache.put(5,50);
//		cache.put(4,41);
//		cache.print();
//		
//		cacheJ.put(1,10); 
//		cacheJ.put(2,20);
//		System.out.println(cacheJ.get(1));
//		cacheJ.put(3,30);
//		cacheJ.put(4,40);
//		cacheJ.put(5,50);
//		cacheJ.put(4,41);
//		System.out.println(cacheJ);
		
//		cache.put(3,31);
//		cache.print();
//		
//		cache.put(2,21);
//		cache.print();
//		
//		System.out.println(cache.get(4));
//		cache.print();
//		
//		System.out.println(cache.get(1));
//		cache.print();
//		
//		System.out.println(cache.get(3));
//		cache.print();
//		
//		cache.put(5,50);
//		cache.print();
	}

}
