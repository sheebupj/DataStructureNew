package com.paremal.sheebu.data_structure.linkedList;

public class LinkedList2 {
    Node first;
    Node last;


    private static class Node {
        Integer data;
        Node next;

        Node(Integer data) {
            this.data = data;
            this.next = null;
        }

    }

    void add(Integer data) {
        Node newNode = new Node(data);

        if (first == null) {
            first = newNode;

        } else {
            add(newNode,first.next);
        }
    }
    private void add(Node node,Node current){
        if(current!=null) {
            if (current.next == null) current.next = node;
            else add(node, current.next);
        }
    }


    void insertAtBeginning(Integer data) {
        Node newNode = new Node(data);
        newNode.next = first;
        first = newNode;
    }
    void insertAt(Integer pos, Integer data) {
        Node newNode = new Node(data);

        if (first == null) {
            System.out.println("Empty linked list...Can not insert, aborting");
            return;
        }

        insertAt(newNode,first,pos);

    }
    private void insertAt(Node data,Node current, Integer pos){
        if(current.next==null){
            if(pos>0){
                System.out.println("Insert position greater than LinkedList length , adding  data:"+data.data+ " at end of the LinkedList");
                current.next=data;
            }
            else if(pos==0) current.next=data;
            return;



        }
        insertAt(data,current.next,--pos);

    }
    void deleteFirstNode(){
        if(first==null){
            System.out.println("Empty linkedList Nothing to delete");
            return;
        }
        if(first.next!=null) {
            first = first.next;
        }
        else{
            first=null;
            last=null;
        }
    }
    void deleteAtPosition(Integer position){
        if(position==1){
            deleteFirstNode();
            return;
        }
        int count=1;
        Node current=first;
        while(count<position-1&&current.next!=null){
            current=current.next;
            count++;
        }


        if(current.next!=null) current.next=current.next.next;
    }


    void printNodes() {
        Node node = first;
        System.out.printf("\n[ ");
        while (node != null) {
            System.out.printf(node.data + " ");
            node = node.next;
        }
        System.out.printf("]");

    }
    public static void main(String[] args) {
        LinkedList2 LinkedList2 = new LinkedList2();
        LinkedList2.deleteFirstNode();
        LinkedList2.insertAt(1,8);
        LinkedList2.add(1);
        LinkedList2.add(9);
        LinkedList2.add(0);
        LinkedList2.insertAtBeginning(100);
        LinkedList2.insertAt(2, 2);
        LinkedList2.insertAt(3, 3);
        LinkedList2.insertAt(10, 6);
        LinkedList2.printNodes();
        LinkedList2.deleteFirstNode();
        LinkedList2.printNodes();
        LinkedList2.deleteAtPosition(1);
        LinkedList2.printNodes();
        LinkedList2.deleteAtPosition(5);
        LinkedList2.printNodes();
    }
}

