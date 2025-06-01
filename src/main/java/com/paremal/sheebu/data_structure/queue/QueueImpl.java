package com.paremal.sheebu.data_structure.queue;

/**
 * Simple implementation for queue that have enqueue and dqueue methods
 * 
 * @author Sheebu PJ
 *
 */
public class QueueImpl {
	/**
	 * underlying array to hold elements for this queue
	 */
	private Object[] queue;

	
	/**
	 * It indicate how much elements can be hold by this queue
	 */
	private int maxCapacity;

	/**
	 * first position of queue
	 */
	private int first;

	/**
	 * last index position of last elements
	 */
	private int last;

	/**
	 * 
	 * @param maxCapacity
	 *            It indicate how much elements can be hold by this queue
	 */
	public QueueImpl(int maxCapacity) {
		super();
		this.maxCapacity = maxCapacity;
		queue = new Object[maxCapacity];
		first = 0;
		last = 0;
	}

	/**
	 * 
	 * @return size of the queue
	 */
	public int size() {
		return last-first;
	}

	/**
	 * 
	 * @return true if queue is empty
	 */
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * @param Object
	 * @return true if element added to queue else false
	 */
	public boolean enqueue(Object o) {
		if (size() < maxCapacity) {
			queue[last++] = o;
			return true;
		}
		return false;
	}
	/**
	 * 
	 * @return element if queue is not empty
	 */
	public Object dqueue() {
		if (!isEmpty()) {
			Object o= queue[first];
			adjustArray();
			last--;
			return o;
		}
		return null;
	}
	/**
	 * left shift all contends of array
	 */
	private void adjustArray(){
		for(int i=0;i<9;i++){
			queue[i]=queue[i+1];
		}
		
	}

}
