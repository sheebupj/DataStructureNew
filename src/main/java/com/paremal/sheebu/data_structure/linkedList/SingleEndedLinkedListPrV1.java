package com.paremal.sheebu.data_structure.linkedList;


public class SingleEndedLinkedListPrV1 {
	
	Node head;
	
	public SingleEndedLinkedListPrV1() {
		this.head=null;
		
	}
	
	
	public void addLast(Node nde) {
		if(head==null) {
			head=nde;
		}
		else {
			Node n=head;
			while(n.next!=null) {
				n=n.next;
			}
			n.next=nde;
		}
	}
	public void addFirst(Node nde) {
		if(head==null) {
			head=nde;
		}
		else {
			nde.next=head;
			head=nde;
		}
	}
	public void addAtPosition(int position,Node nde) {
		if(head==null) {
			head=nde;
			return;
		}
		if(position==1) {
			addFirst(nde);
			return;
		}
		Node n=head;
		Node previous=n;
		for(int p=1;p<position;p++) {
			 previous=n;
			if(n.next==null) {
				System.out.println("linked list size < "+position);
				return;
			}
			n=n.next;
		}
		previous.next=nde;
		nde.next=n;
		
		
	}
	
	public void removeFirst() {
		if(head==null) {
			System.out.println("linedList is empty");
			
		}
		else {
			if(head.next==null) {
				head=null;
			}
			else {
				head=head.next;
			}
		}
	}
	
	public void removeLast() {
		if(head==null) {
			System.out.println("linedList is empty");
			
		}
		else {
			Node n=head;
			while(n.next.next!=null) {
				n=n.next;
			}
			n.next=null;
			
		}
	}
	
	public void removeAtPosition(int pos) {
		if(head==null) {
			System.out.println("linedList is empty");
			
		}
		if(pos==1) {
			removeFirst();
			return;
		}
		Node n=head;
		Node previous=n;
		for(int p=1;p<pos;p++) {
			previous=n;
			if(n.next==null) {
				System.out.println("linked list size < "+pos);
				return;
			}
			n=n.next;
			
		}
		previous.next=n.next;
		
	}
	public void display() {
		Node n=head;
		System.out.printf("[");
		while(n.next!=null) {
			System.out.printf("%d, ",n.data);
			n=n.next;
		}
		System.out.printf("%d] ",n.data);
		
		
	}
	
	public static void main(String[] args) {
		
		Node n1= new Node(1);
		Node n2= new Node(2);
		Node n3= new Node(4);
		Node n4= new Node(8);
		Node n5= new Node(16);
		Node n6= new Node(32);
		SingleEndedLinkedListPrV1 sll= new SingleEndedLinkedListPrV1();
		sll.addFirst(n1);
		
		sll.addFirst(n2);
		sll.removeFirst();
		sll.display();
		sll.addLast(n3);
		sll.addLast(n4);
		sll.display();
		sll.addLast(n5);
		sll.display();
		sll.removeLast();
		sll.display();
		sll.addAtPosition(2, n6);
		sll.addAtPosition(3, n5);
		sll.display();
		sll.removeAtPosition(1);
		sll.display();
		sll.addAtPosition(1, n1);
		sll.display();
		
		
		
		
		
	}
}
