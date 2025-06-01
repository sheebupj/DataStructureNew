package com.paremal.sheebu.data_structure.queue;

/**
 * 
 * @author Sheebu PJ sheebupj@gmail.com
 * queue implemenation class
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {
	
	/*
	 * internal storage array for queue
	 */
	private E[] data;
	/*
	 * queue front position inded
	 */
	private int f=0;
	/*
	 * size of queue
	 */
	private int sz=0;
	
	
	

	/**
	 * default construtor
	 */
	public ArrayQueue() {
		this(10);
	}
	

	/**
	 * constructor with capacity as argument
	 * @param capacity
	 */
	public ArrayQueue(int capacity) {
		super();
		data= (E[]) new Object[capacity];
	}


	/**
	 * return size of queue
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return sz;
	}

	/**
	 * return whether queue empty or not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (sz==0);
	}

	@Override
	public void enqueue(E e)throws IllegalStateException {
		// TODO Auto-generated method stub
		if(sz==data.length){
			throw new IllegalStateException("queue is full");
		}
		int avail=(f+sz)%data.length;
		data[avail]=e;
		sz++;

	}

	
	@Override
	/**
	 * returns first element
	 */
	public E first() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		return data[f];
	}
	/**
	 * return first element in the queue
	 */
	@Override
	public E dequeue() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		E e=data[f];
		data[f]=null;
		f=(f+1)%data.length;
		sz--;
		return e;
	}

}
