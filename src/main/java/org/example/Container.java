package org.example;

import java.util.Objects;

public class Container<T> {
    Node head = new Node();
    Node tail = new Node();

    protected class Node {
        Node next = null;
        Node prev = null;
        T data = null;

        public Node getNext() {
            return next;
        }
        public Node getPrev() {
            return prev;
        }
        public T getData() {
            return data;
        }

        public void setNext(Node next) {
            this.next = next;
        }
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        public void setData(T data) {
            this.data = data;
        }
    }

    public Container () {
        this.head.setNext(tail);
        this.head.setPrev(null);
        this.tail.setNext(null);
        this.tail.setPrev(head);
    }

    public int length()  {
        Node cur = head;
        int count = 0;
        while ((cur = cur.getNext()) != tail) {
            count += 1;
        }
        return count;
    }

    public void add_begin(T x) {
        Node ins = new Node();
        ins.setNext(this.head.getNext());
        ins.setPrev(this.head);
        this.head.getNext().setPrev(ins);
        this.head.setNext(ins);
        ins.setData(x);
    }

    public void add_last(T x) {
        Node ins = new Node();
        ins.setNext(this.tail);
        ins.setPrev(this.tail.getPrev());
        this.tail.getPrev().setNext(ins);
        this.tail.setPrev(ins);
        ins.setData(x);
    }

    public void add_after_index(T x, int i)  {
        Node cur = this.head;
        int index = -1;
        while (index != i && cur.getNext().getNext() != null) {
            index += 1;
            cur = cur.getNext();
        }
        Node ins = new Node();
        ins.setPrev(cur.getPrev());
        ins.setNext(cur.getNext());
        cur.getNext().setPrev(ins);
        cur.setNext(ins);
        ins.setData(x);
    }

    public Node get(int i) {
        if (this.length() == 0) {
            return null;
        }
        Node cur = this.head.getNext();
        int index = 0;
        while (index != i && cur.getNext().getNext() != null) {
            index += 1;
            cur = cur.getNext();
        }
        return cur;
    }

    public T pop(int i) {
        if (this.length() == 0) {
            return null;
        }
        Node cur = this.head.getNext();
        int index = 0;
        while (index != i && cur.getNext().getNext() != null) {
            index += 1;
            cur = cur.getNext();
        }
        cur.getPrev().setNext(cur.getNext());
        cur.getNext().setPrev(cur.getPrev());
        T x = cur.getData();
        return x;
    }

    public void print(){
        Node cur = this.head;
        while ((cur = cur.getNext()) != this.tail) {
            System.out.print(cur.getData());
            System.out.print(' ');
        }
        System.out.print("\n");
    }

    public int index_of(T x) {
        if (this.length() == 0) {
            return -1;
        }
        Node cur = this.head.getNext();
        int index = 0;
        while (cur.getData() != x && cur.getNext().getNext() != null) {
            index += 1;
            cur = cur.getNext();
        }
        if (cur.getData() == x) {
            return index;
        }
        else {
            return -1;
        }
    }

    @Override
    public String toString() {
        String str = "Container { ";
        Node cur = this.head;
        while ((cur = cur.getNext()) != this.tail) {
            str += cur.getData() + " ";
        }
        return str + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Container<?> container = (Container<?>) o;
        int len = this.length();
        if (container.length() != len) return false;
        Node cur = this.get(0);
        Container<?>.Node cur_container = container.get(0);
        boolean flag = true;
        for (int i = 0; i < len && flag; i++) {
            flag = Objects.equals(cur.getData(), cur_container.getData());
        }
        return flag;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tail);
    }
}
