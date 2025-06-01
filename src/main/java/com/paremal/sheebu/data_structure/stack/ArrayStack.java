package com.paremal.sheebu.data_structure.stack;

public class ArrayStack<E> implements Stack<E> {
	
	/**
	 * Capacity
	 */
	public static final int CAPACITY=1000;
	/**
	 * internal storage array for stack
	 */
	private E[] data;
	/**
	 * position indicator for stack
	 */
	private int t=-1;
	
	

	/**
	 * default constructor
	 */
	public ArrayStack() {
	
		this(CAPACITY);
	}
	
	/**
	 * constructor with capacity argument
	 * @param capacity
	 */
	public ArrayStack(int capacity) {
		super();
		data=(E[]) new Object[capacity];
	}

	/**
	 * returns size of stack
	 */
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return t+1;
	}
	/**
	 * check whethor stack is empty or not
	 */
	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return (t==-1);
	}



	/**
	 * returns top elements in the stack
	 */
	@Override
	public E top() {
		// TODO Auto-generated method stub
		if(isEmpty())return null;
		
		return data[t];
	}
	
	/**
	 * method for pushing elements in the stack
	 */
	@Override
	public void push(E e)throws IllegalStateException  {
		// TODO Auto-generated method stub
		if(data.length== CAPACITY){
			throw new IllegalStateException("stack is full");
		}
		data[++t]=e;

	}

	/**
	 * return element from stack
	 */
	@Override
	public E pop() {
		// TODO Auto-generated method stub
		if(isEmpty()){
			return null;
		}
		E e=data[t];
		data[t]=null;
		t--;
		return e;
	}

}
