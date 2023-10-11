package org.example;

import org.junit.Test;

import static org.junit.Assert.*;

public class ContainerTest {

    @Test
    public void length() {
        Container<Integer> container = new Container<>();
        for (int i = 0; i < 10; i++) {
            container.add_last(i);
        }
        int actual = container.length();
        int expected = 10;
        assertEquals(expected, actual);
    }

    @Test
    public void index_of() {
        Container<Integer> container = new Container<>();
        for (int i = 0; i < 10; i++) {
            container.add_last(i);
        }
        int actual = container.index_of(5);
        int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void equals() {
        Container<Integer> container = new Container<>();
        Container<Integer> container1 = new Container<>();
        for (int i = 0; i < 10; i++) {
            container.add_last(i);
        }
        for (int i = 0; i < 10; i++) {
            container1.add_last(i);
        }
        boolean actual = container.equals(container1);
        boolean expected = true;
        assertEquals(expected, actual);
    }
}