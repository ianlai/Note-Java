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

public class LFUCache {
	int mCapacity;
	int mSize=0;
	Map<Integer, Node> map;
	Node head;
	Node tail;

	class Node {
		int mKey;
		int mValue;
		int mOccurrence = 1;
		Node next;
		Node prev;

		Node(int k, int v) {
			mKey = k;
			mValue = v;
		}
		Node(int k, int v, int o) {
			mKey = k;
			mValue = v;
			mOccurrence = o;
		}
		public void print(){
			System.out.print("(" + mKey + ":" + mValue + ":" + mOccurrence + ")");
		}
	}

	public LFUCache(int capacity) {
		mCapacity = capacity;
		map = new HashMap<Integer, Node>();
		head = new Node(0, 0, -1);
		tail = new Node(0, 0, -1);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		System.out.println("get " + key);
		Node n = map.get(key);
		if (n != null) { // exist
			int result = n.mValue;
			addOccurrence(n);
			Node hoso = getHeadOfSameOccurence(n);
			deleteNode(n);
			moveToHeadOfSameOccurence(n, hoso);
			// moveToHead(n);
			return result;
		}
		return -1; // not exist
	}

	public void put(int key, int value) {
		System.out.println("put " + key);
		Node resultNode = map.get(key);
		if (resultNode != null) { // exist
			Node n = resultNode;
			n.mValue = value;
			addOccurrence(n);
			Node hoso = getHeadOfSameOccurence(n);
			deleteNode(n);
			moveToHeadOfSameOccurence(n, hoso);
			// moveToHead(n);

		} else { // not exist
			Node n = new Node(key, value);
			map.put(key, n);
			
			if(map.size()==0){
				moveToHeadOfSameOccurence(n, head);
			}else{
				Node hoso = getHeadOfSameOccurence();
				if(hoso==tail.prev && map.size() > mCapacity){ //last one
					removeFromTail();
					hoso = getHeadOfSameOccurence();
					moveToHeadOfSameOccurence(n, hoso.prev);
					return;
				}
			}
			// moveToHead(n);
			if (map.size() > mCapacity) {
				removeFromTail();
			}
			++mSize;
		}
	}

	public void print() {
		// System.out.println("Capacity: " + mCapacity);
		// System.out.println(map);
		Node n = head.next;
		while (n != tail) {
			n.print();
			System.out.print("->");
			n = n.next;
		}
		System.out.println();
		System.out.println();
	}

	//For new node
	private Node getHeadOfSameOccurence() {
		// head of same occurence
		// ex. head -> 4 -> 3 -> 3 -> 2 -> [2] -> 1 -> 1 ->  tail
		//                                  |                
		//                                 hoso              
		Node hoso = tail.prev;
		int v = 1;
		//System.out.println(v);
		while (true) {
			if (hoso.mOccurrence > v || hoso == head) {
				break;
			}
			hoso = hoso.prev;
		}
		System.out.print("hoso* : ");
		hoso.print();
		System.out.println();
		return hoso;
	}
	//For existing node
	private Node getHeadOfSameOccurence(Node n) {
		// head of same occurence
		// ex. head -> [4] -> 3 -> 3 -> [2] -> 2 -> tail
		//              |                |
		//             hoso              n
		Node hoso = n;
		int v = hoso.mOccurrence;
		while (true) {
			if (hoso.mOccurrence > v || hoso == head) {
				break;
			}
			hoso = hoso.prev;
		}
		//System.out.print("hoso  : ");
		//hoso.print();
		//System.out.println();
		return hoso;
	}

	private void moveToHeadOfSameOccurence(Node n, Node hoso) {
		// move to the position AFTER hoso
		n.next = hoso.next; // after
		hoso.next.prev = n; // after
		hoso.next = n; // before
		n.prev = hoso; // before
	}

	private void moveToHead(Node n) { // This is for LRU
		n.next = head.next;
		n.next.prev = n;
		head.next = n;
		n.prev = head;
	}

	private void deleteNode(Node n) {
		n.prev.next = n.next;
		n.next.prev = n.prev;
	}

	private void removeFromTail() {
		Node n = tail.prev;
		if (n != head) { // not empty
			deleteNode(n);
			map.remove(n.mKey); // key is unique
		}
	}

	private void addOccurrence(Node n) {
		++n.mOccurrence;
	}
}
