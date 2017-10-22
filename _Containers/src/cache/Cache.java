package cache;

/* API: 
 *    Constructor(capacity)
 * 	  .get(key)
 *       > exist: return value
 *       > no   : return -1
 * 	  .put(key,value)  
 *       > exist: set new value
 *       > no   : 
 *                >> if(reach capacity) --> insert --> *delete*
 *                >> else               --> insert 
 * 
 * 	  *delete* rule depends on different implementation (LRU, LFU) 
 */

public interface Cache {
	int get(int key);
	void put(int key, int value);
	void print();
	default void printClass(){  //Java 1.8 new feature
		System.out.println("=====" + getClass().getSimpleName() + "=====");
	}
}
