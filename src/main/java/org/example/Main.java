package org.example;

public class Main {
    public static void main(String[] args) {
        Container<Integer> list = new Container<Integer>();
        System.out.println(list.length());
        for (int i = 0; i < 10; i++) {
            list.add_begin(i);
        }
        Container<Integer> list1 = new Container<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add_begin(i);
        }
        System.out.println(list.equals(list1));
        System.out.println(list.length());
        int a = list.pop(5);
        System.out.println(list.length());
        System.out.println(a);
        list.print();
        System.out.println(list);
        list.add_last(8);
        System.out.println(list.index_of(8));
    }
}