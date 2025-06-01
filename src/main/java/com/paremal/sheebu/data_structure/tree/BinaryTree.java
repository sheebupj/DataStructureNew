package com.paremal.sheebu.data_structure.tree;

import java.util.ArrayList;
import java.util.List;

// Node Class
class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

// BinaryTree Class
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // Method to insert a new node with given key
    public void insert(int key) {
        root = insertData(root, key);
    }

    // A Dataursive function to insert a new key in BST
    private Node insertData(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertData(root.left, key);
        else if (key > root.key)
            root.right = insertData(root.right, key);

        // return the (unchanged) node pointer
        return root;
    }
    List<Integer> collect(){
        List<Integer> collectorList=new ArrayList<>();
        return collectDataFromTree(root,collectorList);
    }

    private List<Integer> collectDataFromTree(Node node, List<Integer> collectorList) {
        if(node!=null){
            collectorList=collectDataFromTree(node.left,collectorList);
            collectorList.add(node.key);
            collectorList=collectDataFromTree(node.right,collectorList);
        }
        return collectorList;
    }

    // Method to print the tree inorder
    public void inorder() {
        inorderData(root);
    }

    // A utility function to do inorder traversal of BST
    private void inorderData(Node root) {
        if (root != null) {
            inorderData(root.left);
            System.out.print(root.key + " ");
            inorderData(root.right);
        }
    }

    // Method to search for a key in the tree
    public boolean search(int key) {
        return searchData(root, key);
    }

    // A utility function to search for a key in BST
    private boolean searchData(Node root, int key) {
        if (root == null)
            return false;

        if (root.key == key)
            return true;

        if (key < root.key)
            return searchData(root.left, key);
        else
            return searchData(root.right, key);
    }

    // Method to find the minimum value in the tree
    public int findMin() {
        return findMinData(root);
    }

    // A utility function to find the minimum value in BST
    private int findMinData(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.left == null)
            return root.key;

        return findMinData(root.left);
    }

    // Method to find the maximum value in the tree
    public int findMax() {
        return findMaxData(root);
    }

    // A utility function to find the maximum value in BST
    private int findMaxData(Node root) {
        if (root == null)
            throw new IllegalStateException("Tree is empty");

        if (root.right == null)
            return root.key;

        return findMaxData(root.right);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Insert some nodes
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Print inorder traversal of the tree
        System.out.println("Inorder traversal:");
        tree.inorder();
        // Output: 20 30 40 50 60 70 80

        // Search for a key
        int searchKey = 40;
        if (tree.search(searchKey))
            System.out.println("\nKey " + searchKey + " found in the tree.");
        else
            System.out.println("\nKey " + searchKey + " not found in the tree.");

        // Find minimum and maximum values
        System.out.println("Minimum value in the tree: " + tree.findMin());
        System.out.println("Maximum value in the tree: " + tree.findMax());
    }
}
