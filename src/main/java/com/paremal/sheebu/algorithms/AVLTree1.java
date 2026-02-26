package com.paremal.sheebu.algorithms;

public class AVLTree1 {

    class Node{
        Node left,right;
        int key,height;
        Node (int key){
            this.key=key;
            height=1;
        }
    }

    Node root;

    int height(Node node){
        if(node==null) return 0;
        return node.height;
    }

    int max(int a,int b){
        return a>b ? a:b;
    }
    int getBalance(Node node){
        if (node==null) return 0;
        return height(node.left) -height(node.right);
    }
    Node rightRotate(Node y){
        Node x=y.left;
        Node t=x.right;

        x.right=y;
        y.left=t;

        y.height=max(height(y.left),height(y.right))+1;
        x.height=max(height(x.left),height(x.right))+1;

        return x;

    }

    Node leftRotate(Node x){
        Node y=x.right;
        Node t=y.left;

        y.left=x;
        x.right=t;

        x.height=max(height(x.left),height(x.right))+1;
        y.height=max(height(y.left),height(y.right))+1;
        return  y;
    }


}
