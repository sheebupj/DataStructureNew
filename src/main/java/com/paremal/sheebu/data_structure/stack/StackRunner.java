package com.paremal.sheebu.data_structure.stack;

public class StackRunner {
	public static void main(String[] args) {
		ArrayStack<Integer> stack= new ArrayStack<Integer>(100);
		stack.push(16);
		stack.push(8);
		stack.push(4);
		stack.push(2);
		stack.push(1);
		System.out.println("stack size"+stack.size());
		System.out.printf("[ ");
		while(stack.size()>0) {
			System.out.printf("%d ",stack.pop());
		}
		System.out.printf("]");
		System.out.println("stack size"+stack.size());
	}

}
