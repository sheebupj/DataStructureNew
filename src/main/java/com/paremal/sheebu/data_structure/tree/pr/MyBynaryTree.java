package com.paremal.sheebu.data_structure.tree.pr;


class Node{
    int key;
    Node left,right;
    public Node(int item){
        key=item;
        left=right=null;
    }
}
public class MyBynaryTree {
    Node root;
    public MyBynaryTree(){
        root=null;
    }

    public void insert(int key){
        root=insertData(root,key);
    }

    private Node insertData(Node root, int key) {
        if(root==null){
            root= new Node(key);
            return root;
        }

        if(key<root.key)
            root.left=insertData(root.left,key);
        else if(key> root.key)
            root.right=insertData(root.right,key);

        return root;
    }
    public  void inorder(){inOrderData(root);}

    private void inOrderData(Node root) {
        if(root!=null){
            inOrderData(root.left);
            System.out.print(root.key+" ");
            inOrderData(root.right);
        }

    }
    public boolean search(int key){
        return searchData(root,key);

    }

    private boolean searchData(Node root, int key) {
        if(root==null ) return false;
        if(root.key==key) return true;
        if(key< root.key) return searchData(root.left,key);
        else return searchData(root.right,key);
    }
    public int findMax(){return findMaxData(root);}

    private int findMaxData(Node root) {
        if(root==null) throw new IllegalStateException();
       return root.right==null ?  root.key: findMaxData(root.right);
    }
    public int findMin(){return findMinData(root);}

    private int findMinData(Node root) {
        return root.left==null ?  root.key: findMaxData(root.left);
    }

    public static void main(String[] args) {
        MyBynaryTree tree = new MyBynaryTree();

        // Insert some nodes
        tree.insert(20);
        tree.insert(30);
        tree.insert(50);
        tree.insert(40);
        tree.insert(70);
        tree.insert(51);
        tree.insert(81);
        tree.insert(60);
        tree.insert(89);
        tree.inorder();
        int searchkey=60;
        System.out.println();
        if(tree.search(searchkey)) System.out.println(searchkey+" is in the tree");
        else System.out.println( searchkey+" is not in the tree");
        System.out.println("max=" +tree.findMax());
        System.out.println("Min"+tree.findMin());


    }
}
