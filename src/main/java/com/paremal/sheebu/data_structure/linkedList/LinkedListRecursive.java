package com.paremal.sheebu.data_structure.linkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Node {
    Integer data;
    Node next;

    public Node(Integer data) {
        this.data = data;
    }
}


public class LinkedListRecursive {
    Node head;

    public LinkedListRecursive() {

    }

    void add(Integer data) {
        if (head == null) {
            head = addData(head, data);
        } else {
            addData(head, data);
        }

    }

    private Node addData(Node head, Integer data) {
        if (head == null) {
            head = new Node(data);
        } else head.next = addData(head.next, data);

        return head;
    }
    void insertAtPositon(Integer pos,Integer data){
        head= insertDataAtPosition(pos,data,head);
    }

    private Node insertDataAtPosition(Integer pos, Integer data, Node node) {
        if(pos==0){
            Node tmp= node;
            node=new Node(data);
            node.next=tmp;
        }
        else if(node.next!=null){
            node.next=insertDataAtPosition(--pos,data,node.next);
        }
        else{
            System.out.println("End of list encountered");

        }
        return node;
    }
    public long get(int index){
        return getData(index,head);

    }

    private Integer getData(int index, Node node) {
        if(node!=null) {
            if (index == 0) {
                return node.data;
            } else {
                return getData(--index, node.next);
            }
        }
        return null;
    }


    void inOrder() {
        inOrderData(head);
        System.out.println();
    }

    private void inOrderData(Node head) {
        if (head != null) {
            System.out.print(head.data + "  ");
            inOrderData(head.next);
        }
    }
    void remove(Integer data){
        head=removeData(head,data);
    }

    private Node removeData(Node node, Integer data) {
        if(Objects.equals(node.data, data)){
            return node.next;
        }
        else{
            node.next=removeData(node.next,data);
        }
        return node;

    }

    List<Integer> collect(){
        List<Integer>collectorList=null;
        return collectDatatList(head,collectorList);
        // return collectorList;
    }

    private List<Integer> collectDatatList(Node node, List<Integer> collectorList) {
        if(node.next==null) {
            collectorList=new ArrayList<>();
            collectorList.add(node.data);
        }
        else{
            collectorList= collectDatatList(node.next,collectorList);
            collectorList.add(node.data);

        }
        return collectorList;
    }


    public static void main(String[] args) {
        LinkedListRecursive list = new LinkedListRecursive();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.inOrder();
        list.remove(10);
        list.inOrder();
        list.remove(40);
        list.inOrder();
        list.remove(50);
        list.inOrder();
        list.insertAtPositon(1,110);
        list.inOrder();
        list.insertAtPositon(2,330);
        list.inOrder();
        list.add(550);
        list.insertAtPositon(4,660);
        list.inOrder();
        list.collect().forEach(System.out::println);

    }
}
