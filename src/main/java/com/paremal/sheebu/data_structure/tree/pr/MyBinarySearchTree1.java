package com.paremal.sheebu.data_structure.tree.pr;

public class MyBinarySearchTree1 {
    Node1 root;

    public MyBinarySearchTree1() {
        root=null;
    }

    public void insert(Integer data){
        root=insertData(root,data);
    }

    private Node1 insertData(Node1 root, Integer data) {
        if(root==null) {
            root = new Node1(data);
            return root;
        }
        if(data<root.data) root.left=insertData(root.left,data);
        else if(data> root.data)root.right= insertData(root.right,data);
        return root;
    }
    public void inorder(){
        inorderData(root);
    }

    private void inorderData(Node1 root) {
        if(root!=null) {
            inorderData(root.left);
            System.out.print(root.data + " ");
            inorderData(root.right);
        }

    }
    void find(Integer key){
        if(findData(root,key)) System.out.println(key+" is in the tree!!!");
        else System.out.println(key+" is not in the tree###");
    }

    private boolean findData(Node1 root, Integer key) {
        if(root!=null) {
            if (root.data == key) return true;
            else if (key < root.data) return findData(root.left, key);
            else return findData(root.right, key);
        }
        return false;
    }

    public static void main(String[] args) {
        MyBinarySearchTree1 tree1= new MyBinarySearchTree1();
        tree1.insert(77);
        tree1.insert(38);
        tree1.insert(89);
        tree1.insert(46);
        tree1.insert(32);
        tree1.insert(99);
        tree1.insert(87);
        tree1.insert(55);
        tree1.insert(17);
        tree1.insert(66);
        tree1.inorder();
        int key=89;
        int key1=33;
        int key2=32;
        int key3=99;
        int key4=87;
        System.out.println();

        tree1.find(key);
        tree1.find(key1);
        tree1.find(key2);
        tree1.find(key3);
        tree1.find(key4);



    }

}
class Node1{
    Integer data;
    Node1 left,right;

    public Node1(Integer item){
        data=item;
    }
}
