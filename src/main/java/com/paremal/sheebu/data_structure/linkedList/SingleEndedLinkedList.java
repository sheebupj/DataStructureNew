package com.paremal.sheebu.data_structure.linkedList;



public class SingleEndedLinkedList {

	private Node head;
	private int length;

	public SingleEndedLinkedList() {
		super();
		// TODO Auto-generated constructor stub
		this.head = null;
		this.length = 0;
	}

	public void insertItem(int dta) {

		Node newNode = new Node(dta);
		if (head == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}

		length++;

	}

	public void insertEnd(int data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;

		} else {
			Node n = head;
			while (n.next != null) {
				n = n.next;
			}

			n.next = newNode;

		}
		length++;
	}

	public void insertAtPos(int data, int pos) {
		if (pos < 0) {
			System.out.println("invalid position");
			return;
		}
		if (pos == 1) {
			insertItem(data);
		} else if (pos > length) {
			insertEnd(data);
		} else {
			Node n = head;
			int i = 1;
			while (n.next != null) {
				i++;
				if (i == pos) {
					break;
				}
				n = n.next;
			}
			Node newNode = new Node(data);
			newNode.next = n.next;
			n.next = newNode;

		}
	}

	public void deleteNode() {
		if (head == null) {
			System.out.println("linked list is empty");
		} else {
			head = head.next;
			length--;
		}
	}

	public void deleteEnd() {
		if (head == null) {
			System.out.println("linked list is empty");
		} else if (head.next == null) {
			head = null;
			length = 0;
			
		} else {
			Node n = head;
			while (n.next.next != null) {
				n = n.next;
			}
			n.next = null;
			length--;
		}

	}
	public void deleteNodeAtPosition(int pos) {
		if (pos<0) {
			System.out.println("linked list is empty");
		} else if (pos==1) {
			deleteNode();
		}
		else if(pos>length) {
			deleteEnd();
			
		}
		else {
			int i=1;
			Node n=head;
			while(n.next!=null){
				i++;
				if(i==pos) {
					break;
				}
				n=n.next;
			}
			n.next=n.next.next;
			length--;
		}
		
	}
	public void display() {
		Node n= head;
		while(n!=null) {
			System.out.print(n.data + " ");
			n=n.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		SingleEndedLinkedList sl = new SingleEndedLinkedList();

		sl.insertItem(10);
		sl.insertItem(20);
		sl.insertItem(30);
		sl.insertItem(40);
		
		sl.insertAtPos(60,5);
		sl.insertAtPos(5,5);

		sl.display();
		sl.deleteNode();;
		sl.display();
		sl.deleteEnd();
		sl.display();
		sl.deleteNodeAtPosition(2);
		sl.display();
	}

}
