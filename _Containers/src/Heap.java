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
		int l=left(i);
		int r=right(i);
		int smallest = i;
		
		if(l<=mSize && mHeap[l]<mHeap[i]){
			smallest = l;
		}
		if(r<=mSize && mHeap[r]<mHeap[smallest]){
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
	
	public void build(){
		
	}
	
	public void decreaseKey(int i, int key){
		
	}
	
	/* log(n) */ 
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
		for(int i=0; i<mSize; i++){
			System.out.print(mHeap[i] + ", ");
		}
		System.out.println();
//		System.out.println(Arrays.toString(mHeap));  //This will print out the unused part
	}
	
	public static void main(String[] args) {

		Heap h = new Heap(30);
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

		System.out.println("===after insert===");
		h.print();

		System.out.println("===extractMin()===");
		System.out.println(h.extractMin());
		h.print();
		System.out.println("===extractMin()===");
		System.out.println(h.extractMin());
		h.print();
		

	}

}
