package com.example.administrator.mytemplateapplication.tools.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

/**
 * com.example.administrator.mytemplateapplication.network.utils
 * Created by kingj on 2020/4/10 0010.
 */
@RunWith(JUnit4.class)
public class BinarySearchTreeTest {

    @Test
    public void BinarySearchTree_getChildCount_isCorrect() {
        BinarySearchTree tree = new BinarySearchTree();
        tree.put(6, "B");
        tree.put(1, "G");
        tree.put(3, "E");
        tree.put(2, "F");
        tree.put(5, "C");
        tree.put(4, "D");
        tree.put(7, "A");
        assertEquals(0, tree.getChildCount(2));
        assertEquals(6, tree.getChildCount(6));
        assertEquals(3, tree.getChildCount(3));
    }

}
