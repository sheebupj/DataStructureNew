package com.paremal.sheebu.data_structure_practice.linked_list;

public class LinkedList {
    Node head;
    Integer length;

    public LinkedList() {
        head = null;
        length = 0;
    }

    public void insertNodeAtBegining(Integer data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;

        }
        length++;

    }

    public void insertNodeAtEnd(Integer dta) {
        if (head == null) {
            Node newNode = new Node(dta);
            head = newNode;

        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            Node newNode = new Node(dta);
            n.next = newNode;

        }
        length++;
    }

    public void insertAtPos(int pos, Integer dta) {
        if (pos < 0) {
            System.out.println("invalid data");
            return;
        }
        if (pos == 1) {
            insertNodeAtBegining(dta);
        }
        if (pos > length) {
            insertNodeAtEnd(dta);
        }
        else{
            Node newNode= new Node(dta);
            Node n= head;
            int count=2;
            while(n.next!=null){

               if(count==pos) break;
               n=n.next;
                count++;

            }
            newNode.next=n.next;
            n.next=newNode;
        }
    }

    public void display() {
        Node n = head;
        while (n != null) {
            System.out.println(n);
            n = n.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insertNodeAtEnd(10);
        linkedList.insertNodeAtEnd(20);
        linkedList.insertNodeAtEnd(30);
        linkedList.insertNodeAtEnd(40);
        linkedList.insertNodeAtEnd(50);
        linkedList.insertNodeAtBegining(0);
      //  linkedList.insertAtPos(1,105);
        linkedList.insertAtPos(3,55);
        linkedList.display();
    }
}

class Node {
    Integer data;
    Node next;

    public Node(Integer d) {
        data = d;
        next = null;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
