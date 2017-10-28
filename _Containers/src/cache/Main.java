package cache;

public class Main {

	public static void main(String[] args) {
		test(new LFUCache(4));
		test(new LRUCache(4));
	}
	
	public static void test(Cache cache){
		cache.printClass();
		cache.put(1,1); cache.print();
		cache.put(2,2); cache.print();
		cache.get(1);   cache.print();
		cache.put(3,3); cache.print();
		cache.get(2);   cache.print();
		cache.get(3);   cache.print();
		cache.put(4,4); cache.print();
		
		cache.get(1);   cache.print();
		cache.put(5,5); cache.print();
		cache.put(6,6); cache.print();
		cache.put(7,7); cache.print();
		cache.put(8,8); cache.print();
		cache.put(9,9); cache.print();
		cache.get(6);   cache.print();
		cache.get(6);   cache.print();
		cache.put(6,1); cache.print();
		cache.get(9);   cache.print();
		cache.put(9,1); cache.print();
		cache.get(6);   cache.print();
		
		cache.get(2);   cache.print();
		cache.get(3);   cache.print();
		cache.get(2);   cache.print();
		cache.get(3);   cache.print();
		cache.get(3);   cache.print();
		cache.get(3);   cache.print();
		cache.get(2);   cache.print();
		cache.get(2);   cache.print();
		cache.get(5);   cache.print();
		
		cache.put(6,2); cache.print();
		cache.put(4,1); cache.print();
		cache.get(1);   cache.print();
		cache.put(7,1); cache.print();
		cache.get(3);   cache.print();
		cache.get(4);   cache.print();
	}
}
