package collections;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayVsLinked {
    public static void main(String[] args) {
        //Тест скорости работы array и linked lists
        ArrayList<Integer> arrayList = new ArrayList<>();
        LinkedList<Integer> linkedList = new LinkedList<>();
        //заполняем
        for (int i = 0; i < 100000; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }
        //ЧТЕНИЕ - ArrayList быстрее
        long ArrayT0 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(5000);
        }
        System.out.println("Чтение 100.000 элементов типа int:\n");
        System.out.println("Время работы ArrayList: " + (System.currentTimeMillis() - ArrayT0) + " мс.");

        long LinkedT0 = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(5000);
        }
        System.out.println("Время работы LinkedList: " + (System.currentTimeMillis() - LinkedT0) + " мс.");

        //ЗАПИСЬ  - LinkedList быстрее
        long ArrayT = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, i);
        }
        System.out.println("\nЗапись 100.000 элементов типа int:\n");
        System.out.println("Время работы ArrayList: " + (System.currentTimeMillis() - ArrayT) + " мс.");

        long LinkedT = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, i);
        }
        System.out.println("Время работы LinkedList: " + (System.currentTimeMillis() - LinkedT) + " мс.");
    }
}

