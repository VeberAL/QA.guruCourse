package collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class DequeOperations {
    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();
        int value = 20;
        deque.add(1);
        deque.add(4);
        deque.add(6);
        System.out.println("Исходная коллекция: " + deque);
        //добавить элементы в начало очереди
        addFirstDeque(deque);
        //добавить элементы в конец очереди
        addLastDeque(deque);
        //удалить элемент с начала очереди
        deleteFirstDeque(deque);
        //удалить элемент с конца очереди
        deleteLastDeque(deque);
        //получить значение первого элемента с начала очереди
        getFirstDeque(deque);
        //проверить наличие заданного элемента в очереди
        searchDeque(deque, value);

    }

    private static void addFirstDeque(Deque<Integer> deque) {
        for (int i : deque)
            deque.addFirst(i);
        System.out.println("\nЭлементы 1, 4, 6 добавлены в начало очереди коллекции.\nРезультат: " + deque);
    }

    private static void addLastDeque(Deque<Integer> deque) {
        int i = 7;
        System.out.print("\nЭлементы ");
        do {
            deque.addLast(i * 2);
            System.out.print(i * 2 + " ");
            i++;
        } while (i < 15);
        System.out.println("добавлены в конец очереди коллекции.\nРезультат: " + deque);
    }

    private static void deleteFirstDeque(Deque<Integer> deque) {
        deque.pollFirst();
        System.out.println("\nПервый элемент из начала очереди коллекции был удалён.\nРезультат: " + deque);
    }

    private static void deleteLastDeque(Deque<Integer> deque) {
        deque.removeLast();
        System.out.println("\nПервый элемент из конца очереди коллекции был удалён.\nРезультат: " + deque);
    }

    private static void getFirstDeque(Deque<Integer> deque) {
        System.out.println("\nЗначение первого элемента из начала очереди коллекции '" + deque.peekFirst() + "'.");
    }

    private static void searchDeque(Deque<Integer> deque, Integer value) {
        if (deque.contains(value)) {
            System.out.println("\nИскомый элемент со значением '" + value + "' найден в очереди коллекции.");
        }
    }
}
