
//BinaryHeap sorts and stores values in a designated order. Allows for reordering and removing of
//values, heighest priorities removed first. Implements Priority Queue.
public class BinaryHeap implements PriorityQueue{
	private double[] heapArray;
	private int size;
	
	
	/**
	 * Constructs a new BinaryHeap with a certain starting size
	 */
	public BinaryHeap() {
		heapArray = new double[10];
		size = 0;
	}
	
	
	/**
	 * Returns true if priority queue has no elements
	 *
	 * @return true if the priority queue has no elements
	 */
	public boolean isEmpty() {
		return (size == 0);
	}
	
	
	/**
	 * Returns the number of elements in this priority queue.
	 *
	 * @return the number of elements in this priority queue.
	 */
	public int size() {
		return size;
	}
		
	
	/**
	 * Returns the minimum element in the priority queue
	 *
	 * @return the minimum element 
         * @throws EmptyPQException if priority queue contains no elements
	 */
	public double findMin(){
		 if(isEmpty()) {
			 throw new EmptyPQException("Empty");
		 }
		return heapArray[1];
	}

	
	/**
	 * Inserts a new element into the priority queue.
	 * Duplicate values ARE allowed.
	 *
	 * @param x element to be inserted into the priority queue.
	 */
	public void insert(double x) {
		if (size >= heapArray.length-1) {
	        double[] temp = new double[heapArray.length * 2];
	        for (int i = 1; i <= size; i++) {
	            temp[i] = heapArray[i];
	        }
	        heapArray = temp;
		}
		size++;
	    int i = percolateUp(size, x);
	    heapArray[i] = x;
	}
	
	
	/**
	 *Rearranges the ordering of the values to be in sorted order
	 *
	 * @param double val to be inserted into the priority queue, and int hole to be the insertion location.
	 * @return the correct insertion location int hole
	 */
	private int percolateUp(int hole, double val) {
		while(hole > 1 && val < heapArray[hole/2]) {
				heapArray[hole] = heapArray[hole/2];
				hole = hole / 2;
		 } 
		 return hole; 
	} 
	
	/**
	 * Removes and returns the minimum element from the priority queue.
	 *
	 * @return the minimum element
         * @throws EmptyPQException if priority queue contains no elements
	 */
	public double deleteMin() { 
		 if(isEmpty()) {
			 throw new EmptyPQException("Empty");
		 }
		 double i = heapArray[1]; 
		 int hole = percolateDown(1, heapArray[size]);
		 heapArray[hole] = heapArray[size]; 
		 size--; 
		 return i; 
		} 
	
	
	/**
	 *Rearranges the ordering of the values to be in sorted order
	 *
	 * @param double val to be inserted into the priority queue, and int hole to be the insertion location.
	 * @return the correct insertion location int hole
	 */
	private int percolateDown(int hole, double val) {
		int target;
		while(2 * hole <= size) { 
			int left = 2 * hole;
			int right = left + 1; 
			if(right > size || heapArray[left] < heapArray[right]) {
				target = left;
			} else { 
				target = right;
			}
			//
			if(heapArray[target] < val) { 
				heapArray[hole] = heapArray[target];
				hole = target; 
			}
			else {
				break; 
			}
	 } 
	 return hole; 
	}

	
	/**
	 * Resets the priority queue to appear as not containing
	 * any elements.
	 */
	public void makeEmpty() {
	 size = 0;
	 System.out.println("Array after resize: ");
		for(int i = 0; i < size; i++) {
			System.out.print(heapArray[i] + ", ");
		}
	}
	
}
