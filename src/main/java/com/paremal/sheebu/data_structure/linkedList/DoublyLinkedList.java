package com.paremal.sheebu.data_structure.linkedList;

/**
 * 
 * @author Sheebu PJ sheebupj@gmail.com
 * 
 * Doubly link list implemention
 *
 */



/**
 * 
 * @author Sheebu PJ sheebupj@gmail.com
 * 
 * Doubly linked list implementation class
 *
 */
public class DoublyLinkedList {

	Node_D head;
	int length;

	public DoublyLinkedList() {
		// TODO Auto-generated constructor stub
		this.head = null;
		this.length = 0;
	}

	/**
	 * Adding node to first position of linked list
	 * @param value
	 */
	public void addFirst(Node_D node) {

		
		if (head == null) {
			head = node;
		} else {
			node.next = head;
			head.previous = node;
			head = node;

		}
		this.length++;
	}

	/**
	 * Adding node to last position of linked list
	 * @param value
	 */
	public void addLast(Node_D node) {
		
		if (head == null) {
			this.head = node;
		} else {
			Node_D n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = node;
			node.previous=n;
		}
		this.length++;
	}
	
	/**
	 * print content of nodes in order
	 */
	public void print() {
		Node_D n=head;
		System.out.printf("[");
		while(n.next!=null) {
			System.out.printf("%d, ",n.data);
			n=n.next;
		}
		System.out.printf("%d] ",n.data);
		
		
	}
	
	/**
	 * print content of nodes in reverse  order
	 */
	public void printRevers() {
		if(head==null) {
			System.out.println("linked list is empty");
		}
		Node_D n=head;
		while(n.next!=null) {
			n=n.next;
		}
		System.out.printf("[%d,",n.data);
		while(n.previous!=null) {
			n=n.previous;
		System.out.printf("%d,",n.data);
		}
		System.out.println("]");
	}
	/**
	 * main 
	 * @param args
	 */
	public static void main(String[] args) {
		
		DoublyLinkedList ddl= new DoublyLinkedList();
		Node_D dlln1=new Node_D(1);
		Node_D dlln2=new Node_D(2);
		Node_D dlln3=new Node_D(4);
		Node_D dlln4=new Node_D(8);
		Node_D dlln5=new Node_D(15);
		ddl.addFirst(dlln1);
		ddl.addFirst(dlln2);
		ddl.addFirst(dlln3);
		ddl.addFirst(dlln4);
		ddl.addFirst(dlln5);
		ddl.print();
		ddl.printRevers();
		
	}
}
/**
 * 
 * @author Sheebu PJ sheebupj@gmail.com
 * Node class for linked list
 */
class Node_D {
	int data;
	Node_D next;
	Node_D previous;

	Node_D(int d) {
		this.data = d;
		this.next = null;
		this.previous = null;

	}

	
	/**
	 * to string
	 */
	@Override
	public String toString() {
		return "Node_D [data=" + data + "]";
	}
}
	

