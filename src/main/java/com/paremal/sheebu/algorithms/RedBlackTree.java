package com.paremal.sheebu.algorithms;

// Node structure
class Node {
    int data;
    Node parent;
    Node left;
    Node right;
    boolean color; // true for RED, false for BLACK

    public Node(int data) {
        this.data = data;
    }
}

public class RedBlackTree {
    private Node root;
    private Node TNULL; // Sentinel node representing a "null" leaf

    // Constants for color
    private final boolean RED = true;
    private final boolean BLACK = false;

    public RedBlackTree() {
        TNULL = new Node(0);
        TNULL.color = BLACK;
        TNULL.left = null;
        TNULL.right = null;
        root = TNULL;
    }

    // --- Rotations (Similar to AVL, but updating parents) ---

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;

        if (y.left != TNULL) {
            y.left.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }

        y.left = x;
        x.parent = y;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;

        if (y.right != TNULL) {
            y.right.parent = x;
        }

        y.parent = x.parent;

        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }

        y.right = x;
        x.parent = y;
    }

    // --- Insertion Logic ---

    public void insert(int key) {
        Node node = new Node(key);
        node.parent = null;
        node.data = key;
        node.left = TNULL;
        node.right = TNULL;
        node.color = RED; // New nodes are always RED

        Node y = null;
        Node x = this.root;

        // Standard BST Insert
        while (x != TNULL) {
            y = x;
            if (node.data < x.data) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            root = node;
        } else if (node.data < y.data) {
            y.left = node;
        } else {
            y.right = node;
        }

        if (node.parent == null) {
            node.color = BLACK;
            return;
        }

        if (node.parent.parent == null) {
            return;
        }

        // Fix the Red-Black Tree violations
        fixInsert(node);
    }

    // --- Rebalancing Logic (The Core) ---
    private void fixInsert(Node k) {
        Node u; // Uncle node

        // While parent is RED (Violation of Rule 3: No Double Red)
        while (k.parent.color == RED) {

            // If parent is a LEFT child
            if (k.parent == k.parent.parent.left) {
                u = k.parent.parent.right; // Uncle is right child

                // Case 1: Uncle is RED -> Recolor only
                if (u.color == RED) {
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent; // Move check up the tree
                }
                else {
                    // Case 2: Uncle is BLACK & k is Right child -> Left Rotate
                    if (k == k.parent.right) {
                        k = k.parent;
                        leftRotate(k);
                    }

                    // Case 3: Uncle is BLACK & k is Left child -> Right Rotate + Recolor
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    rightRotate(k.parent.parent);
                }
            }
            // If parent is a RIGHT child (Mirror of above)
            else {
                u = k.parent.parent.left; // Uncle is left child

                // Case 1: Uncle is RED
                if (u.color == RED) {
                    u.color = BLACK;
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    k = k.parent.parent;
                } else {
                    // Case 2: Uncle is BLACK & k is Left child
                    if (k == k.parent.left) {
                        k = k.parent;
                        rightRotate(k);
                    }
                    // Case 3: Uncle is BLACK & k is Right child
                    k.parent.color = BLACK;
                    k.parent.parent.color = RED;
                    leftRotate(k.parent.parent);
                }
            }
            if (k == root) break;
        }
        root.color = BLACK; // Fix Rule 2: Root must be black
    }

    // Helper to print In-Order
    public void printTree() {
        printInOrder(this.root);
    }

    private void printInOrder(Node node) {
        if (node != TNULL) {
            printInOrder(node.left);
            String c = node.color == RED ? "RED" : "BLACK";
            System.out.println(node.data + " (" + c + ")");
            printInOrder(node.right);
        }
    }

    public static void main(String[] args) {
        RedBlackTree bst = new RedBlackTree();
        bst.insert(55);
        bst.insert(40);
        bst.insert(65);
        bst.insert(60);
        bst.insert(75);
        bst.insert(57);

        bst.printTree();
    }
}
