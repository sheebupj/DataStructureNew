package com.paremal.sheebu.data_structure.linkedList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class LinkedListRecursiveTest {
    private LinkedListRecursive list;

    @Before
    public  void setUp(){
        list= new LinkedListRecursive();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

    }
    @Test
    public void testList(){
        Assert.assertEquals(10,list.get(0));
        Assert.assertEquals(40,list.get(3));
    }
    @Test
    public void testInsertPosition() {
        list.insertAtPositon(3, 33);
        Assert.assertEquals(50, list.get(5));
    }
    @Test
    public void testAdd(){
        list.add(60);
        Assert.assertEquals(60,list.get(5));
        list.add(70);
        Assert.assertEquals(70,list.get(6));
        list.add(80);
        Assert.assertEquals(80,list.get(7));
        list.add(90);
        Assert.assertEquals(90,list.get(8));
    }
    @Test
    public void testCollect(){
        Assert.assertEquals(Arrays.asList(50,40,30,20,10),list.collect());
    }

}
