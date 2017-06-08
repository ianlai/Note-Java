package lrucache;

import java.util.LinkedHashMap;
import java.util.Map;

//public class LRUCacheJava<Integer, Integer> extends LinkedHashMap<Integer, Integer> {
public class LRUCacheJava<K, V> extends LinkedHashMap<K, V> {
	private int cacheSize;

	public LRUCacheJava(int cacheSize) {
		super(16, 1, true);
		this.cacheSize = cacheSize;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > cacheSize;
	}
	
//	@Override
//	public Integer get(Integer key) {
//		return super.get(key);
//	}
//	
//	@Override
//	public Integer put(Integer key, Integer value) {
//		return super.put(key, value);
//	}
}
