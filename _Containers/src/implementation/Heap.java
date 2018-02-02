package implementation;
import java.util.Arrays;

/* Definition: (1) Complete binary tree
 *             (2) Every node meets heap condition 
 *                 - min-heap: parent smaller than children
 *                 - max-heap: parent larger than children
 *           
 * Basic OP: 
 *        (1) sink up
 *        (2) sink down
 * API: 
 *        (1) build heap
 *        (2) insert
 *        (3) min
 *        (4) extract min
 *        (5) increase key 
 *        
 * Example:  Heapsort
 * 
 * http://www.growingwiththeweb.com/data-structures/binary-heap/overview/
 * 
 */
public class Heap {
	
	public int[] mHeap;
	private int mSize = 0;
	private int mCapacity = 0;
	final private boolean debug = false;
	
	/* All the index are used the array index, not heap index */
	private int parent(int i){
		return ((i+1)/2)-1; 
	}
	private int left(int i){
		return ((i+1)*2)-1;
	}
	private int right(int i){
		return (i+1)*2;
	}
	
	/* Iteratively sift-up, log(n), only one way */
	private void heapifyUp(int i){
		int temp = mHeap[i];
		debug("hup: [" + i + "] = " + mHeap[i]);
		while(i>=1 && temp<mHeap[parent(i)]){
			debug("swap:" + i + " " + parent(i));
			mHeap[i] = mHeap[parent(i)]; //current
			mHeap[parent(i)] = temp;     //parent
			i = parent(i);
		}
	}
	
	/* Recursively sift-down, log(n), choose the smaller child to swap */
	private void heapifyDown(int i){
		debug("hdn: [" + i + "] = " + mHeap[i]);
		int l=left(i);
		int r=right(i);
		int smallest = i;
		
		if(l<mSize && mHeap[l]<mHeap[i]){
			smallest = l;
		}
		if(r<mSize && mHeap[r]<mHeap[smallest]){
			smallest = r;
		}
		if(smallest!=i){
			swap(i, smallest);
			heapifyDown(smallest);
		}	
	}
	private void swap(int m, int n){
		int temp = mHeap[m];
		mHeap[m] = mHeap[n];
		mHeap[n] = temp;
	}
	private void debug(String msg){
		if(debug){
			System.out.println(msg);
		}
	}
	private void debug(int i){
		debug(i +"");
	}
	
	//=========== Public Functions ===========
	public Heap(int capacity){
		mHeap = new int[capacity + 1];
		mSize = 0;
		mCapacity = capacity;
	}
	
	/* This is O(n), not O(nlogn). 
	 * After the array filled up, do a build, which means let half nodes do the sink-down.
	 * It is NOT doing sink-up or sink-down each time after one element added in.
	 * An important thing is that it starts from the half node and do sift-down "forward" */
	public void build(int[] input){
		if(input.length > mCapacity)
			throw new IllegalStateException("Input array is too large.");
		for(int i=0;i<input.length;i++){
			mHeap[i] = input[i];
		}
		mSize = input.length;
		
		int half = (input.length+1)/2;
		for(int i=half;i>=0; i--){
			heapifyDown(i);
		}
	}
	
	/* sift-up, log(n) */
	public void decreaseKey(int i, int key){
		debug("decreaseKey: [" + i + "] = " + mHeap[i] + " -> " + key);
		if(key >= mHeap[i]){
			mHeap[i] = key;
		}else{
			mHeap[i] = key;
			heapifyUp(i);
		}
	}
	
	/* sift-up, log(n) */ 
	public void insert(int x){
		debug(mSize);
		debug(mCapacity);
		if(mSize==mCapacity)
			throw new IllegalStateException("Heap over flow!");
		mHeap[mSize++]=x;
		heapifyUp(mSize-1);
	}
	
	public int findMin(){
		return mHeap[0];
	}
	
	public int extractMin(){
		if(mSize==0){
			throw new IllegalStateException("Heap is empty!");
		}else{
			int min = mHeap[0];
			int last = mHeap[mSize-1];
			mHeap[0] = last; 
			mSize--;
			heapifyDown(0);
			return min;
		}
	}
	public void print(){
		System.out.println("Size: " + mSize);
		for(int i=0; i<mSize; i++){
			System.out.print(mHeap[i] + ", ");
		}
		System.out.println();
//		System.out.println(Arrays.toString(mHeap));  //This will print out the unused part
	}
	
	public static void heapsort(int[] input){
		int size = input.length;
		int[] temp = new int[size];
		System.arraycopy(input, 0, temp, 0, size);
		Heap heap = new Heap(size);
		heap.build(temp);
		for(int i=0;i<size;i++){
			input[i] = heap.extractMin();
		}
	}
	public static void main(String[] args) {

		Heap h = new Heap(30);
		Heap h2 = new Heap(30);
		h.insert(70);
		h.insert(90);
		h.insert(60);
		h.insert(30);

		h.insert(20);
		h.insert(10);
		h.insert(50);
		h.insert(40);

		h.insert(5);
		h.insert(8);
		h.insert(2);
		h.insert(4);

		System.out.println("=== insert ===");
		h.print();

		System.out.println("=== extractMin ===");
		System.out.println(h.extractMin());
		h.print();
		
		System.out.println("=== extractMin ===");
		System.out.println(h.extractMin());
		h.print();
		
		System.out.println("=== build heap2 ===");
		int[] arr2 = new int[]{70,90,60,30,20,10,50,40,5,8,2,4};
		System.out.println(Arrays.toString(arr2));
		h2.build(arr2);
		h2.print();
		
		System.out.println("=== decraseKey ===");
		h2.decreaseKey(10, 30);
		h2.print();
		h2.decreaseKey(9, 3);
		h2.print();
		
		System.out.println("=== heapsort ===");
		Heap.heapsort(arr2);
		System.out.println(Arrays.toString(arr2));
	}
}