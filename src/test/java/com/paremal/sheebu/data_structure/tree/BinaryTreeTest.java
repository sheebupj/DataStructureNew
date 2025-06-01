package com.paremal.sheebu.data_structure.tree;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeTest {
    BinaryTree tree;

    @Before
    public void setup() {
        tree = new BinaryTree();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
    }

    @Test
    public void testCollect() {
        List<Integer> clist = tree.collect();
        assertEquals(Arrays.asList(20, 30, 40, 50, 60, 70, 80), clist);
    }

    @Test
    public void testInsert() {
        assertFalse(tree.search(33));
        tree.insert(33);
        assertTrue(tree.search(33));

    }
    @Test
    public void testSerch() {
        assertFalse(tree.search(33));
        tree.insert(33);
        assertTrue(tree.search(33));

    }
    @Test
    public void testFindMin() {
        assertEquals(20,tree.findMin());
        tree.insert(10);
        assertEquals(10,tree.findMin());
    }
    @Test
    public void testFindMax() {
        assertEquals(80,tree.findMax());
        tree.insert(100);
        assertEquals(100,tree.findMax());

    }
}
