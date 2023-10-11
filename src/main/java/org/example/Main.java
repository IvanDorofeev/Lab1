package org.example;

public class Main {
    public static void main(String[] args) {
        Container<Integer> list = new Container<Integer>();
        System.out.println("Длина списка: " + list.length());
        for (int i = 0; i < 10; i++) {
            list.add_begin(i);
        }
        Container<Integer> list1 = new Container<Integer>();
        for (int i = 0; i < 10; i++) {
            list1.add_begin(i);
        }
        System.out.println("Оба списка идентичны: " + list.equals(list1));
        System.out.println("длина 1-го: " + list.length());
        int a = list.pop(5);
        System.out.println("Длина 1-го после удаления: " + list.length());
        System.out.println("Удаленный элемент: " + a + "\nсписок: ");
        list.print();
        System.out.println("1-ый список после удаления: " + list);
        list.add_last(8);
        System.out.println("Индекс 8-ки: " + list.index_of(8));
    }
}