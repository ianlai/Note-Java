package implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class MyHashMap<K, V> {
	
//========================= 1. Testing =========================
	public static void main(String[] args) {
		//simpleTest();
		
		/* Create two lists storing random strings as the test answer */
		List<String> keyList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		testPrepare(keyList, valueList, 5000); 
		
		int expNum = 1000000;
		
		/* Start the test for customized hashmap and original hashmap */
		testMyHashMap(keyList, valueList, expNum, 10);    //groupSize = 10
		testMyHashMap(keyList, valueList, expNum, 100);   //groupSize = 100
		testMyHashMap(keyList, valueList, expNum, 1000);  //groupSize = 1000
		testMyHashMap(keyList, valueList, expNum, 10000); //groupSize = 10000
		
		System.out.println();
		testHashMap(keyList, valueList, expNum);
		
	}
	/* Test MyHashMap works fine */
	static void simpleTest(){
		MyHashMap<String,String> m1 = new MyHashMap<String,String>(5);
		
		String k1 = "abc"; 
		String v1 = "12345";
		
		String k2 = "qqpprr"; 
		String v2 = "789";
		
		m1.put(k1, v1);
		System.out.println(m1.get(k1));
		m1.put(k2, v2);
		System.out.println(m1.get(k2));	
	}
	/* Use UUID.randomUUID() to create random String */
	static String randomString(){
		String s = UUID.randomUUID().toString();
		//System.out.println(s);
		return s;
	}
	
	/* 
	 * size: # of Strings to be put into the testing map
	 */
	static void testPrepare(List<String> keyList, List<String>valueList, int size){
		for(int i=0; i<size; i++){
			keyList.add(randomString());
			valueList.add(randomString());
		}
	}
	
	/* expNum   : # of experiment round
	 * groupSize: # of bucket of MyHashMap  
	 */
	static void testMyHashMap(List<String> keyList, List<String>valueList, int expNum, int groupSize){
		System.out.println("===== MyHashMap test started =====");
		long startTime = System.nanoTime();
		Random r = new Random();
		int size = keyList.size();
		boolean result = true;
		MyHashMap<String,String> map = new MyHashMap<String,String>(groupSize);
		
		/* put the key value pairs */
		for(int i=0; i<size; i++){
			map.put(keyList.get(i), valueList.get(i));
		}
		
		/* start to test */
		for(int i=0; i<expNum; i++){
			int index = r.nextInt(size);
			result = valueList.get(index).equals(map.get(keyList.get(index)));
			//System.out.println(i + ":" );
			//System.out.print(valueList.get(index) + " ");
			//System.out.println(map.get(keyList.get(index)));
		}
		
		/* show the test result */
		if(result)
			System.out.println("OK, test passed!!");
		else 
			System.out.println("No, test failed...");
		
		long endTime = System.nanoTime();
		long elapsedTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println("Input size      : " + size);
		System.out.println("Test round      : " + expNum);
		System.out.println("Group size      : " + groupSize);
		System.out.println("Elapsed time(ms): " + elapsedTime );
		
	}
	static void testHashMap(List<String> keyList, List<String>valueList, int expNum){
		System.out.println("===== HashMap test started =====");
		long startTime = System.nanoTime();
		Random r = new Random();
		int size = keyList.size();
		boolean result = true;
		Map<String,String> map = new HashMap<String,String>();
		
		/* put the key value pairs */
		for(int i=0; i<size; i++){
			map.put(keyList.get(i), valueList.get(i));
		}
		
		/* start to test */
		for(int i=0; i<expNum; i++){
			int index = r.nextInt(size);
			result = valueList.get(index).equals(map.get(keyList.get(index)));
		}
		
		/* show the test result */
		if(result)
			System.out.println("OK, test passed!!");
		else 
			System.out.println("No, test failed...");
		
		long endTime = System.nanoTime();
		long elapsedTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);
		System.out.println("Input size      : " + size);
		System.out.println("Test round      : " + expNum);
		System.out.println("Elapsed time(ms): " + elapsedTime );
	}

	//========================= 2. MyHashMap Implementation =========================	
	/* Define the key pair entry */
	class MyEntry<K, V>{
		K key;
		V value; 
		MyEntry(K key, V value){
			this.key = key;
			this.value = value;
		}
	}
	/* Define two members mGroup and mMap for MyHashMap 
	 * mGroup is the number of buckets
	 * mMap is a list of list. 
	 * The outer one is an ArrayList representing the buckets. 
	 * The inner one is a LinkedList representing the elements with the same hash value.
	 * */
	private int mGroup;
	List<List<MyEntry>> mMap; 
	MyHashMap(int group){
		mGroup = group; 
		mMap = new ArrayList<>();
		for(int i=0; i<mGroup; i++){
			mMap.add(new LinkedList<MyEntry>());
		}
	}
	void put(K key, V value){
		int groupNumber = hash(key);
		List<MyEntry> selected = mMap.get(groupNumber);
		for(MyEntry entry: selected){
			/* existed */
			if(entry.key==key){
				entry.value = value;  //update
				return;
			}
		}
		/* new one */
		selected.add(new MyEntry(key, value));	
	}
	V get(K key){
		int groupNumber = hash(key);
		List<MyEntry> selected = mMap.get(groupNumber);
		for(MyEntry<K,V> entry: selected){
			/* existed */
			if(entry.key==key){
				return entry.value;  //found 
			}
		}
		return null; //not found 
	}
	int hash(K key){
		int hashValue = Math.abs(key.hashCode()%mGroup);  //return the index of outer ArrayList
		if(hashValue<0){
			System.out.println("Error: Hashvalue < 0");
		}
		if(hashValue>mGroup){
			System.out.println("Error: Hashvalue > " + mGroup);
		}
		return hashValue;
	}
}

//================= 3. Testing Output =================
/*
===== MyHashMap test started =====
OK, test passed!!
Input size      : 5000
Test round      : 1000000
Group size      : 10
Elapsed time(ms): 2195
===== MyHashMap test started =====
OK, test passed!!
Input size      : 5000
Test round      : 1000000
Group size      : 100
Elapsed time(ms): 367
===== MyHashMap test started =====
OK, test passed!!
Input size      : 5000
Test round      : 1000000
Group size      : 1000
Elapsed time(ms): 140
===== MyHashMap test started =====
OK, test passed!!
Input size      : 5000
Test round      : 1000000
Group size      : 10000
Elapsed time(ms): 113

===== HashMap test started =====
OK, test passed!!
Input size      : 5000
Test round      : 1000000
//Elapsed time(ms): 92
*/