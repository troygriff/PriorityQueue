

//MyPQ sorts and stores values in a designated order. Allows for reordering and removing of
//values, heighest priorities removed first. Implements Priority Queue.
public class MyPQ implements PriorityQueue {
	private double[] pq;
	private int size;

	/**
	 * Constructs a new pq with a certain starting size
	 */
	public MyPQ(){
		pq = new double[10];
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
	public double findMin() {
		 if(isEmpty()) {
			 throw new EmptyPQException("Empty");
		 }
		int idx = 0;
		double temp = pq[0];
		for (int i = 0; i < size; i++) {
			if (pq[i] < temp) {
				temp = pq[i];
				idx = i;
			}
		}
		return pq[idx];
	}


	/**
	 * Inserts a new element into the priority queue.
	 * Duplicate values ARE allowed.
	 *
	 * @param x element to be inserted into the priority queue.
	 */
	public void insert(double x) {
		if (size >= pq.length - 1) {
	        double[] temp = new double[pq.length * 2];
	        for (int i = 0; i <= size; i++) {
	            temp[i] = pq[i];
	        }
	        pq = temp;
		}
		pq[size] = x;
		size++;
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
		double min = findMin();
		double temp[] = new double[size - 1];
		int j = 0;
		int count = 0;
		for (int i = 0; i < size; i++) {
			if (pq[i] != min || count > 0) {
				temp[j++] = pq[i];
			} else {
				count++;
			}
		}
		size--;
		pq = temp;
		return min;
	}
			
	
	/**
	 * Resets the priority queue to appear as not containing
	 * any elements.
	 */
	public void makeEmpty() {
		size = 0;
	}
}
