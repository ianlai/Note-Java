package lrucache;

import java.util.HashMap;
import java.util.Map;

//LRUCache cache = new LRUCache( 2 /* capacity */ );
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // returns 1
//cache.put(3, 3);    // evicts key 2
//cache.get(2);       // returns -1 (not found)
//cache.put(4, 4);    // evicts key 1
//cache.get(1);       // returns -1 (not found)
//cache.get(3);       // returns 3
//cache.get(4);       // returns 4

public class LRUCache {
	int mCapacity;
	Map<Integer, Node> map;
	Node head;
	Node tail;
	class Node {
		int mKey;
		int mValue;
		Node next;
		Node prev;

		Node(int k, int v) {
			mKey = k;
			mValue = v;
		}
	}

	public LRUCache(int capacity) {
		mCapacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node(0, 0);
		tail = new Node(0, 0);
		head.next = tail;
		tail.prev = head;
	}
    public int get(int key) {
    	Node n = map.get(key);
        if(n!=null){  //exist
        	int result = n.mValue;
        	deleteNode(n);
        	moveToHead(n);
        	return result;
        }
        return -1;    //not exist
    }
    
    public void put(int key, int value) {
    	Node resultNode = map.get(key);
        if(resultNode!=null){  //exist
        	Node n = resultNode;
        	n.mValue = value;
        	deleteNode(n);
        	moveToHead(n);
        	
        }else{                 //not exist
        	Node n = new Node(key,value);
        	map.put(key, n);
        	moveToHead(n);
        	if(map.size()>mCapacity){
        		removeFromTail();
        	}
        }
    }
	public void print(){
		//System.out.println("Capacity: " + mCapacity);
		//System.out.println(map);
		Node n = head.next;
		while(n!=tail){
			System.out.print( "("+ n.mKey + ":" +n.mValue + ") -> ");
			n = n.next;
		}
		System.out.println();
	}
	private void moveToHead(Node n){
		n.next = head.next;
		n.next.prev = n;
		head.next = n;
		n.prev = head;
	}
	private void deleteNode(Node n){
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}
	private void removeFromTail(){
		Node n = tail.prev;
		if(n!=head){  //not empty
			deleteNode(n);
			map.remove(n.mKey);  //key is unique
		}
	}
}
