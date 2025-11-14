package com.paremal.sheebu.data_structure.tree;


class Nod{
    Integer key;
    Nod left,right;

    public Nod(Integer key) {
        this.key = key;
    }
}
public class BinaryTree1 {
    Nod root;

    public BinaryTree1() {

    }
    void insert( Integer data){
        root= insertData(root,data);
    }

    private Nod insertData(Nod root, Integer data) {
        if(root==null){
            root= new Nod(data);
        }
        else{
            if(root.key>data){
                root.left=insertData(root.left,data);
            }
            if(root.key<data){
                root.right=insertData(root.right,data);
            }

        }
        return root;
    }
    void inOrder(){
        inOrderData(root);
    }

    private void inOrderData(Nod root) {
        if(root!=null){
            inOrderData(root.left);
            System.out.println(root.key);
            inOrderData(root.right);
        }
    }

    public static void main(String[] args) {
        // Insert some nodes
        BinaryTree1 tree= new BinaryTree1();

        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
        tree.inOrder();
    }

}
