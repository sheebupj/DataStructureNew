package com.paremal.sheebu.data_structure.tree.pr;


public class BinaryTree2 {
    Node2 root;

    public BinaryTree2() {
        root = null;
    }

    void insert(int key) {
        root = insertData(root, key);
    }

    private Node2 insertData(Node2 root, int key) {
        if (root == null) {
            root = new Node2(key);
        } else if (key > root.key) {
            root.right = insertData(root.right, key);
        } else if (key < root.key) {
            root.left = insertData(root.left, key);
        }
        return root;
    }

    public void inOrder() {
        inOrderData(root);

    }

    private void inOrderData(Node2 root) {
        if (root != null) {
            inOrderData(root.left);
            System.out.print(root.key + " ");
            inOrderData(root.right);
        }
    }

    public Integer findMin() {
        return findMinData(root);
    }

    private Integer findMinData(Node2 root) {
        if (root == null) throw new IllegalStateException("Empty tree");
        else if (root.left == null) return root.key;
        else return findMinData(root.left);
    }

    public Integer findMax() {
        return findMaxData(root);
    }

    private Integer findMaxData(Node2 root) {
        if (root == null) throw new IllegalStateException("Empty tree");
        else if (root.right == null) return root.key;
        else return findMinData(root.right);
    }

    public boolean search(Integer data) {
        return searchData(root, data);
    }

    private boolean searchData(Node2 root, Integer data) {
        if (root != null) {
            if (root.key == data) {
                return true;
            } else if (data < root.key) {
                return searchData(root.left, data);
            } else if (data > root.key) {
                return searchData(root.right, data);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        BinaryTree2 tree = new BinaryTree2();

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
        tree.inOrder();
        System.out.println("min:" + tree.findMin());
        System.out.println("max:" + tree.findMax());
        System.out.println(tree.search(52) + "," + tree.search(50)
                + "," + tree.search(50)
                + "," + tree.search(70)
                + "," + tree.search(80));
    }

}

class Node2 {
    int key;
    Node2 left, right;

    public Node2(int key) {
        this.key = key;
        left = right = null;
    }
}
